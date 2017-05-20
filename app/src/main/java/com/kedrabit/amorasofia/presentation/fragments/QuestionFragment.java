package com.kedrabit.amorasofia.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kedrabit.amorasofia.R;
import com.kedrabit.amorasofia.core.BaseFragment;
import com.kedrabit.amorasofia.presentation.contracts.QuestionContract;


/**
 * Created by katherine on 20/05/17.
 */

public class QuestionFragment extends BaseFragment implements QuestionContract.View{
    private LinearLayoutManager mLayoutManager;
    private QuestionContract.Presenter mPresenter;
    //private ProgressDialogCustom mProgressDialogCustom;

    public QuestionFragment() {
        // Requires empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        //mPresenter.start();
        //mPresenter.getPlaces();
    }

    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_history, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Ingresando...");
    }

    @Override
    public void getResponse() {

    }

    @Override
    public void setPresenter(QuestionContract.Presenter presenter) {

    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }
}
