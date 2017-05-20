package com.kedrabit.amorasofia.presentation.contracts;


import com.kedrabit.amorasofia.core.BasePresenter;
import com.kedrabit.amorasofia.core.BaseView;
import com.kedrabit.amorasofia.data.entity.QuestionEntity;

import java.util.ArrayList;

/**
 * Created by katherine on 12/05/17.
 */

public interface HistoryContract {
    interface View extends BaseView<Presenter> {

        void getQuestions(ArrayList<QuestionEntity> list);
        void showClickDetail(QuestionEntity questionEntity);
        boolean isActive();



    }

    interface Presenter extends BasePresenter {

        void loadOrdersFromPage(int page);

        void loadfromNextPage();

        void getPlaces();

    }
}
