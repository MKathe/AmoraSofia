package com.kedrabit.amorasofia.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kedrabit.amorasofia.core.BaseActivity;
import com.kedrabit.amorasofia.data.local.SessionManager;

/**
 * Created by katherine on 10/05/17.
 */

public class LoadActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.acticity_loader);
        if (savedInstanceState == null)
            initialProcess();
    }

    private void initialProcess() {
        SessionManager mSessionManager = new SessionManager(getApplicationContext());
        if(mSessionManager.isLogin()){

            next(this,null, HistoryActivity.class, true);
        }else{
            next(this,null, LoginActivity.class, true);
        }
    }
}
