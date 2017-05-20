package com.kedrabit.amorasofia.presentation.contracts;

import com.kedrabit.amorasofia.core.BasePresenter;
import com.kedrabit.amorasofia.core.BaseView;

/**
 * Created by katherine on 20/05/17.
 */

public interface AddQuestionContract {
    interface View extends BaseView<Presenter> {
        void getQuestion();
    }

    interface Presenter extends BasePresenter {
        void sendQuestion(String token, int id);
    }
}
