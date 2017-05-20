package com.kedrabit.amorasofia.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.kedrabit.amorasofia.R;
import com.kedrabit.amorasofia.core.BaseFragment;
import com.kedrabit.amorasofia.data.entity.QuestionEntity;
import com.kedrabit.amorasofia.presentation.contracts.AddQuestionContract;
import com.kedrabit.amorasofia.presentation.contracts.AnswerContract;
import com.kedrabit.amorasofia.presentation.contracts.NoAnswerContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by katherine on 20/05/17.
 */

public class NoAnswerFragment extends BaseFragment implements NoAnswerContract.View {
    @BindView(R.id.et_question)
    EditText etQuestion;
    @BindView(R.id.btn_camera)
    Button btnCamera;
    @BindView(R.id.iv_question)
    ImageView ivQuestion;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.btn_add_question)
    Button btnAddQuestion;
    Unbinder unbinder;
    //private HistoryAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private AddQuestionContract.Presenter mPresenter;
    //private ProgressDialogCustom mProgressDialogCustom;

    public NoAnswerFragment() {
        // Requires empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        //mPresenter.start();
        //mPresenter.getPlaces();
    }

    public static NoAnswerFragment newInstance() {
        return new NoAnswerFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_history, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Ingresando...");
    }

    @Override
    public void setPresenter(NoAnswerContract.Presenter presenter) {

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getQuestions(ArrayList<QuestionEntity> list) {

    }
}
