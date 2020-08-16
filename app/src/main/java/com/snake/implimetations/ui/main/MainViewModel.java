package com.snake.implimetations.ui.main;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.snake.implimetations.R;
import com.snake.implimetations.data.DataManager;
import com.snake.implimetations.data.model.api.Base;
import com.snake.implimetations.data.model.api_request.DataRequest;
import com.snake.implimetations.rx.SchedulerProvider;
import com.snake.implimetations.ui.base.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel<IMainNavigator> {
    private String TAG = this.getClass().getSimpleName();

    MutableLiveData<Base> dataResponse = new MutableLiveData<>();
    MutableLiveData<Throwable> errorResponse = new MutableLiveData<>();
    public ObservableField<String> search = new ObservableField<>("");

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getListFromServer(String search) {
        Log.d(TAG, "getUserListFromServer: " + search);
        getCompositeDisposable().add(getDataManager().getDataApiCall(new DataRequest(search))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataResponse::setValue, throwable -> errorResponse.setValue(throwable)));
    }

    public void onClickSearch() {
        if (!search.get().isEmpty()) {
            getNavigator().showProgress(R.string.loading);
            getListFromServer(search.get());
        } else {

            getNavigator().showError("Search filed should not be empty");
        }
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Log.d("IMP", "loadImage: "+imageUrl);
        if (imageUrl != null) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .into(view);
        } else {
            Log.d("MainViewModel", "loadImage: ");
//            getNavigator().showError("No Images found for this Key");
        }
    }
}
