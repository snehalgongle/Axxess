package com.snake.implimetations.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.snake.implimetations.AppUtils;
import com.snake.implimetations.BR;
import com.snake.implimetations.R;
import com.snake.implimetations.adapter.BaseRecyclerAdapter;
import com.snake.implimetations.adapter.OnDataBindCallback;
import com.snake.implimetations.data.model.api.Base;
import com.snake.implimetations.databinding.ActivityProfileBinding;
import com.snake.implimetations.databinding.CommentsItemBinding;
import com.snake.implimetations.databinding.UserListItemBinding;
import com.snake.implimetations.ui.base.BaseActivity;
import com.snake.implimetations.ui.main.MainActivity;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import static com.snake.implimetations.AppConstants.IMAGE_URL;
import static com.snake.implimetations.AppConstants.POSITION;
import static com.snake.implimetations.AppConstants.SEARCH_KEY;
import static com.snake.implimetations.AppConstants.USER_ID;
import static com.snake.implimetations.AppConstants.USER_NAME;

public class ProfileActivity extends BaseActivity<ActivityProfileBinding, ProfileViewModel> implements IProfileNavigator, OnDataBindCallback<CommentsItemBinding>, AdapterView.OnItemSelectedListener {

    @Inject
    ProfileViewModel profileViewModel;

    @Inject
    ProfileListViewModel listViewModel;

    ActivityProfileBinding activityProfileBinding;

    BaseRecyclerAdapter<Base, CommentsItemBinding> adapter;
    private int id;
    private String imageUrl;
    private String search;
    private String TAG = this.getClass().getSimpleName();

    @Override
    public int getBindingVariable() {
        return BR.profileViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public ProfileViewModel getViewModel() {
        return profileViewModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfileBinding = getViewDataBinding();
        profileViewModel.setNavigator(this);
        getIntentExtra();

        setUpRecycleView();

//        if (isNetworkConnected()) {
////            profileViewModel.getUserProfile(id, position,userName);
//        }
        profileViewModel.getLocalData();
        observerResponse();
        getViewDataBinding().getRoot();
    }


    private void setUpRecycleView() {

        getViewDataBinding().recycleView.setLayoutManager(new LinearLayoutManager(this));
        getViewDataBinding().recycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new BaseRecyclerAdapter(R.layout.comments_item,
                BR.comments, listViewModel.commentList,
                null,
                this);
        getViewDataBinding().recycleView.setAdapter(adapter);

        adapter.setScrolllistener(getViewDataBinding().recycleView);
        adapter.setOnLoadMoreListener(() -> {
        });
    }

    private void getIntentExtra() {
        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            id = extras.getInt(POSITION);
            imageUrl = extras.getString(IMAGE_URL);
            search=extras.getString(SEARCH_KEY);
            Log.d(TAG, "getIntentExtra: " + imageUrl);
            profileViewModel.image_url.set(imageUrl);
        }
    }

    private void observerResponse() {
        profileViewModel.localDbResponse.observe(this, commentsTables -> {
            Log.d(TAG, "observerResponse: " + listViewModel.commentList.size());
            listViewModel.commentList.clear();
            hideKeyboard();
            listViewModel.commentList.addAll(commentsTables);
            adapter.notifyDataSetChanged();
        });
        profileViewModel.errorResponse.observe(this, throwable -> handleApiError(throwable));
    }

    @Override
    public void onClickView(View var1) {

    }

    @Override
    public void goTo(@NotNull Class<?> clazz, Bundle mExtras) {
        AppUtils.NavigatTo(this, clazz, mExtras);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bundle bundle = new Bundle();
        bundle.putString(SEARCH_KEY,search);
        goTo(MainActivity.class, bundle);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(View view, int position, CommentsItemBinding commentsItemBinding) {
        profileViewModel.deleteFromDb(listViewModel.commentList.get(position).id);
    }

    @Override
    public void onItemLongClick(View view, int position, CommentsItemBinding commentsItemBinding) {

    }

    @Override
    public void onDataBind(CommentsItemBinding commentsItemBinding, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {

    }

    @Override
    public void showError(String value) {
        showToastString(value);
    }
}
