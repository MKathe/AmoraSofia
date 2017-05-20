package com.kedrabit.amorasofia.presentation.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.kedrabit.amorasofia.data.entity.QuestionEntity;
import com.kedrabit.amorasofia.data.local.SessionManager;
import com.kedrabit.amorasofia.presentation.contracts.MainContract;

import java.util.ArrayList;

/**
 * Created by manu on 08/08/16.
 */
public class ExamplePresenter implements MainContract.Presenter{

    private final MainContract.View mView;
    private final SessionManager mSessionManager;
    private String next;
    private boolean mFirstLoad = false;


    public ExamplePresenter(@NonNull MainContract.View view,
                            Context context) {
        this.mView = view;
        this.mSessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }


    @Override
    public void start() {

    }



}
