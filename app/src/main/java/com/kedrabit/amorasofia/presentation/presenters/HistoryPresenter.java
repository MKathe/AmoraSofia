package com.kedrabit.amorasofia.presentation.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.kedrabit.amorasofia.data.entity.QuestionEntity;
import com.kedrabit.amorasofia.data.local.SessionManager;
import com.kedrabit.amorasofia.presentation.contracts.HistoryContract;
import com.kedrabit.amorasofia.presentation.contracts.MainContract;
import com.kedrabit.amorasofia.presentation.contracts.QuestionContract;
import com.kedrabit.amorasofia.presentation.presenters.commons.QuestionItem;

import java.util.ArrayList;

/**
 * Created by katherine on 20/05/17.
 */

public class HistoryPresenter implements HistoryContract.Presenter, QuestionItem {

    private final HistoryContract.View mView;
    private final SessionManager mSessionManager;
    private String next;
    private boolean mFirstLoad = false;
    private Context mContext;


    public HistoryPresenter(HistoryContract.View mView,
                            Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
        this.mSessionManager = new SessionManager(mContext);
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        ArrayList<QuestionEntity> list = new ArrayList<>();

                list.add(new QuestionEntity(1,"rcaballero","Filosofia","¿Qué significa la palabra griega logos?","captura1.jpg",null,false));
        list.add(new QuestionEntity(2,"mkcaillahua","Aritmetica","¿Cuál es el resultado del siguiente problema?","captura2.jpg",null,false));
        list.add(new QuestionEntity(3,"jaarce","Biologia","¿A quién se le conoce como el padre de la Micro anatomía?","captura3.jpg",null,false));
        list.add(new QuestionEntity(4,"ealata","Psicologia","¿En qué año se crea el primer laboratorio de Psicología?","captura4.jpg",null,false));
        list.add(new QuestionEntity(5,"joseperez","Fisica","¿Cual es el resultado del siguiente problema?","captura5.jpg",null,false));
        list.add(new QuestionEntity(6,"respinoza","Quimica","¿Cual es el resultado del siguiente problema?","captura6.jpg",null,false));
        list.add(new QuestionEntity(7,"jsoto","Algebra","¿Cual es el resultado del siguiente problema?","captura7.jpg",null,false));
         mView.getQuestions(list);
    }

    @Override
    public void loadOrdersFromPage(int page) {

    }

    @Override
    public void loadfromNextPage() {

    }

    @Override
    public void getPlaces() {

    }

    @Override
    public void clickItem(QuestionEntity placesEntity) {

    }

    @Override
    public void deleteItem(QuestionEntity placesEntity, int position) {

    }
}
