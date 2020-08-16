package com.snake.implimetations.ui.profile;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.snake.implimetations.data.DataManager;
import com.snake.implimetations.data.model.api_request.DataRequest;
import com.snake.implimetations.data.model.db.CommentsTable;
import com.snake.implimetations.rx.SchedulerProvider;
import com.snake.implimetations.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProfileViewModel extends BaseViewModel<IProfileNavigator> {
    MutableLiveData<List<CommentsTable>> localDbResponse = new MutableLiveData<>();
    MutableLiveData<Throwable> errorResponse = new MutableLiveData<>();
    public ObservableField<String> comment = new ObservableField<>("");
    public ObservableField<String> image_url = new ObservableField<>("");
    private String TAG = this.getClass().getSimpleName();

    //
    public ProfileViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onClickComment() {
        Log.d(TAG, "onClickComment: ");
        if(!comment.get().isEmpty()) {
            getCompositeDisposable().add(getDataManager().insertComment(new CommentsTable(comment.get(), image_url.get()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(aBoolean -> {
                        Log.d(TAG, "onClickComment: " + aBoolean.booleanValue());
                        getNavigator().hideKeyboard();
                        if (aBoolean.booleanValue() == true) {
                            getLocalData();
                        }
                    }, throwable -> {
                        Log.d(TAG, "onClickComment: error");
                        errorResponse.setValue(throwable);
                    }));
        }else{
            getNavigator().showError("Comment filed should not be empty");
        }
    }

    @BindingAdapter({"bind:image"})
    public static void loadImage(ImageView view, String imageUrl) {
        Log.d("ProfileViewModel", "loadImage: " + imageUrl);
        if (imageUrl != null) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .into(view);
        } else {
            Log.d("MainViewModel", "loadImage: ");
        }
    }

    public void getLocalData() {
        Log.d(TAG, "getLocalData: ");
        getCompositeDisposable().add(getDataManager().getAllCommentsFromImage(image_url.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commentTable -> localDbResponse.setValue(commentTable),
                        throwable -> errorResponse.setValue(throwable)));
    }

    public void deleteFromDb(int position) {
        getCompositeDisposable().add(getDataManager().delete(position)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                    Log.d(TAG, "onClickComment: " + aBoolean.booleanValue());
                    if (aBoolean.booleanValue() == true) {
                        getLocalData();
                    }
                }, throwable -> {
                    Log.d(TAG, "onClickComment: error");
                    errorResponse.setValue(throwable);
                }));
    }
}
