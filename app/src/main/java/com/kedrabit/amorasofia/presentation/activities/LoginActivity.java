package com.kedrabit.amorasofia.presentation.activities;

import android.os.Bundle;

import com.kedrabit.amorasofia.R;
import com.kedrabit.amorasofia.core.BaseActivity;
import com.kedrabit.amorasofia.presentation.fragments.LoginFragment;
import com.kedrabit.amorasofia.utils.ActivityUtils;


public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);

        LoginFragment fragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = LoginFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }

        // Create the presenter
        //new LoginPresenter(fragment,this);
    }


}
