package com.kedrabit.amorasofia.presentation.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.kedrabit.amorasofia.R;
import com.kedrabit.amorasofia.core.BaseActivity;
import com.kedrabit.amorasofia.presentation.fragments.AddQuestionFragment;
import com.kedrabit.amorasofia.presentation.fragments.AnswerFragment;
import com.kedrabit.amorasofia.presentation.fragments.NoAnswerFragment;
import com.kedrabit.amorasofia.utils.ActivityUtils;

/**
 * Created by katherine on 20/05/17.
 */

public class AnswerActivity extends BaseActivity {
    private Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Preguntas resueltas");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        AnswerFragment fragment = (AnswerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = AnswerFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }

        // Create the presenter
        //new ListMenuPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
