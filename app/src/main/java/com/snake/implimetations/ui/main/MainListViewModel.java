package com.snake.implimetations.ui.main;

import android.app.Application;
import android.database.Observable;
import android.widget.ImageView;


import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;

import com.bumptech.glide.Glide;
import com.snake.implimetations.R;
import com.snake.implimetations.data.DataManager;
import com.snake.implimetations.data.model.api.Base;
import com.snake.implimetations.data.model.api.Data;
import com.snake.implimetations.rx.SchedulerProvider;
import com.snake.implimetations.ui.base.BaseApplicationViewModel;

public class MainListViewModel extends BaseApplicationViewModel<IMainNavigator> {
    ObservableArrayList<Data> usersItemList = new ObservableArrayList<>();

    MainListViewModel(Application application, DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(application,dataManager,schedulerProvider);
    }

}
