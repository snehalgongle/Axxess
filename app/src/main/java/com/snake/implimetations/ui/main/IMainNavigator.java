package com.snake.implimetations.ui.main;

import com.snake.implimetations.ui.base.BaseNavigator;

public interface IMainNavigator extends BaseNavigator {
    void showError(String value);

    void showProgress(int value);

    void hideProgress(int value);
}
