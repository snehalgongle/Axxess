package com.snake.implimetations.ui.main;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;


import com.snake.implimetations.AppUtils;
import com.snake.implimetations.BR;
import com.snake.implimetations.R;
import com.snake.implimetations.adapter.BaseRecyclerAdapter;
import com.snake.implimetations.adapter.OnDataBindCallback;
import com.snake.implimetations.data.model.api.Base;
import com.snake.implimetations.data.model.api.Data;
import com.snake.implimetations.databinding.ActivityMainBinding;
import com.snake.implimetations.databinding.UserListItemBinding;
import com.snake.implimetations.ui.base.BaseActivity;
import com.snake.implimetations.ui.profile.ProfileActivity;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import static com.snake.implimetations.AppConstants.IMAGE_URL;
import static com.snake.implimetations.AppConstants.POSITION;
import static com.snake.implimetations.AppConstants.SEARCH_KEY;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements IMainNavigator, OnDataBindCallback<UserListItemBinding>, AdapterView.OnItemSelectedListener {

    private String TAG = this.getClass().getSimpleName();
    private RecyclerView recyclerView;
    private ImageView imageView;

    @Inject
    MainViewModel mainViewModel;

    @Inject
    MainListViewModel mainListViewModel;

    ActivityMainBinding activityMainBinding;
    BaseRecyclerAdapter<Base, UserListItemBinding> adapter;
    int pageNumber = 1;
    private String search;

    @Override
    public int getBindingVariable() {
        return BR.mainViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = getViewDataBinding();

        mainViewModel.setNavigator(this);
        setUpRecycleView();
//        if (isNetworkConnected()) {
//        }
        recyclerView = findViewById(R.id.recycleView);
        imageView = findViewById(R.id.noData);

        getIntentExtra();

        observerResponse();
        getViewDataBinding().getRoot();
    }


    private void getIntentExtra() {
        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            search = extras.getString(SEARCH_KEY);
            if (search != null) {
                Log.d(TAG, "getIntentExtra: " + search);
                mainViewModel.getListFromServer(search);
            } else {
                imageView.setVisibility(View.VISIBLE);
            }
        } else {
            imageView.setVisibility(View.VISIBLE);
        }
    }

    private void setUpRecycleView() {

        getViewDataBinding().recycleView.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new BaseRecyclerAdapter(R.layout.user_list_item,
                com.snake.implimetations.BR.data, mainListViewModel.usersItemList,
                null,
                this);
        getViewDataBinding().recycleView.setAdapter(adapter);

        adapter.setScrolllistener(getViewDataBinding().recycleView);
        adapter.setOnLoadMoreListener(() -> {
        });
    }

    private void observerResponse() {
        mainViewModel.dataResponse.observe(this, data -> {
            mainListViewModel.usersItemList.clear();
            hideKeyboard();
            mainListViewModel.usersItemList.addAll(data.getData());
            adapter.notifyDataSetChanged();
            hideProgessDialog();
            imageView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        });
        mainViewModel.errorResponse.observe(this, this::handleApiError);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(View view, int position, UserListItemBinding userListItemBinding) {
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        if (!mainViewModel.search.get().equals("")) {
            bundle.putString(SEARCH_KEY, mainViewModel.search.get());
        } else {
            bundle.putString(SEARCH_KEY, search);
        }
        bundle.putString(IMAGE_URL, mainListViewModel.usersItemList.get(position).getImages().get(0).getLink());
//        bundle.putString(USER_NAME, mainListViewModel.usersItemList.get(position).getLogin());
        goTo(ProfileActivity.class, bundle);
    }

    @Override
    public void onItemLongClick(View view, int position, UserListItemBinding userListItemBinding) {

    }

    @Override
    public void onDataBind(UserListItemBinding userListItemBinding, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {

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
    public void showError(String value) {
        showToastString(value);
    }

    @Override
    public void showProgress(int value) {
        showProgressDialog(value);
    }

    @Override
    public void hideProgress(int value) {
        hideProgessDialog();
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
////        savedInstanceState.putString(QUESTION, mTestViewModel.getQuestion());
//        super.onSaveInstanceState(outState);
//    }
}
