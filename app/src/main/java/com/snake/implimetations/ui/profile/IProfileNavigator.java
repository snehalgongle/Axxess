package com.snake.implimetations.ui.profile;

import com.snake.implimetations.ui.base.BaseNavigator;

public interface IProfileNavigator extends BaseNavigator {
    void hideKeyboard();
    void showError(String value);
}
