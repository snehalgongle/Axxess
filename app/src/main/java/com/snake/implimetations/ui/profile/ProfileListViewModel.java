package com.snake.implimetations.ui.profile;

import android.app.Application;

import androidx.databinding.ObservableArrayList;

import com.snake.implimetations.data.DataManager;
import com.snake.implimetations.data.model.api.Data;
import com.snake.implimetations.data.model.db.CommentsTable;
import com.snake.implimetations.rx.SchedulerProvider;
import com.snake.implimetations.ui.base.BaseApplicationViewModel;
import com.snake.implimetations.ui.main.IMainNavigator;

public class ProfileListViewModel extends BaseApplicationViewModel<IMainNavigator> {
    ObservableArrayList<CommentsTable> commentList = new ObservableArrayList<>();

    public ProfileListViewModel(Application application, DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(application, dataManager, schedulerProvider);
    }
}
