package com.kedrabit.amorasofia.presentation.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kedrabit.amorasofia.R;
import com.kedrabit.amorasofia.core.BaseActivity;
import com.kedrabit.amorasofia.data.entity.UserEntity;
import com.kedrabit.amorasofia.data.local.SessionManager;
import com.kedrabit.amorasofia.presentation.fragments.HistoryFragment;
import com.kedrabit.amorasofia.utils.ActivityUtils;

/**
 * Created by katherine on 20/05/17.
 */

public class HistoryActivity extends BaseActivity {
    DrawerLayout mDrawer;
    NavigationView navigationView;
    SessionManager mSessionManager;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    public TextView tv_username;
    public TextView tv_email;
    public UserEntity mUser;
    private HistoryFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSessionManager = new SessionManager(this);

        /**
         *Setup the DrawerLayout and NavigationView
         */
        mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation);


        /**
         * Setup click events on the Navigation View Items.
         */

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("¿A qué paises te gustaría viajar?");

        setupDrawerContent(navigationView);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                    /* host Activity */
                mDrawer,                    /* DrawerLayout object */
                toolbar,
                R.string.app_name,  /* "open drawer" description for accessibility */
                R.string.app_name  /* "close drawer" description for accessibility */
        );
        mDrawerToggle.syncState();
        mDrawer.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
        View header = navigationView.getHeaderView(0);

        tv_username = (TextView) header.findViewById(R.id.tv_fullnanme);
        tv_email = (TextView) header.findViewById(R.id.tv_email);

        initHeader();

        fragment = (HistoryFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = HistoryFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }
       // new CountriesPresenter(fragment, this);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        menuItem.setChecked(false);
                        menuItem.setCheckable(false);

                        switch (menuItem.getItemId()) {
                            case R.id.action_answer:
                                //next(OrdersActivity.this,null, OrderPreviousActivity.class, false);
                                break;
                            case R.id.action_noanswer:
                                // next(OrdersActivity.this,null, ListMenuActivity.class, false);
                                break;
                            case R.id.action_singout:
                                CloseSession();
                                break;

                            default:

                                break;
                        }
                        menuItem.setChecked(false);
                        //  mDrawer.closeDrawers();
                        return true;
                    }
                });
    }

    private void CloseSession() {
        mSessionManager.closeSession();
        newActivityClearPreview(this, null, LoginActivity.class);

    }


    public void initHeader() {

        mUser = mSessionManager.getUserEntity();
        if (mUser != null) {

            tv_username.setText(mUser.getFullName());
            System.out.println("NOMBRE "+mUser.getFullName());
            tv_email.setText(mUser.getEmail());

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (Activity.RESULT_OK == resultCode)
            if (200 == requestCode) {
                initHeader();
            }
    }

    @Override
    public void onBackPressed() {
        if (this.mDrawer.isDrawerOpen(GravityCompat.START)) {
            this.mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
