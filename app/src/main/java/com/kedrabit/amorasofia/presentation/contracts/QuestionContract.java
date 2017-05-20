package com.kedrabit.amorasofia.presentation.contracts;

import com.kedrabit.amorasofia.core.BasePresenter;
import com.kedrabit.amorasofia.core.BaseView;

/**
 * Created by katherine on 20/05/17.
 */

public interface QuestionContract {
    interface View extends BaseView<Presenter> {
        void getResponse();
    }

    interface Presenter extends BasePresenter {
        void sendResponse();
    }
}
