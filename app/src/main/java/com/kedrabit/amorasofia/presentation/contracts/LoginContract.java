package com.kedrabit.amorasofia.presentation.contracts;


import com.kedrabit.amorasofia.core.BasePresenter;
import com.kedrabit.amorasofia.core.BaseView;

/**
 * Created by katherine on 3/05/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void loginSucessful();
        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void loginUser(String username, String password);

    }
}
