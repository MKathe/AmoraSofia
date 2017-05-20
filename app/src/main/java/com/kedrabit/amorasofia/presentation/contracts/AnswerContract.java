package com.kedrabit.amorasofia.presentation.contracts;

import com.kedrabit.amorasofia.core.BasePresenter;
import com.kedrabit.amorasofia.core.BaseView;
import com.kedrabit.amorasofia.data.entity.QuestionEntity;

import java.util.ArrayList;

/**
 * Created by katherine on 20/05/17.
 */

public interface AnswerContract {
    interface View extends BaseView<Presenter> {
        void getQuestions(ArrayList<QuestionEntity> list);
    }

    interface Presenter extends BasePresenter {

    }
}
