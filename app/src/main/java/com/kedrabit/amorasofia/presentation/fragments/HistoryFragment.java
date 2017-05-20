package com.kedrabit.amorasofia.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kedrabit.amorasofia.R;
import com.kedrabit.amorasofia.core.BaseActivity;
import com.kedrabit.amorasofia.core.BaseFragment;
import com.kedrabit.amorasofia.core.ScrollChildSwipeRefreshLayout;
import com.kedrabit.amorasofia.data.entity.QuestionEntity;
import com.kedrabit.amorasofia.presentation.activities.AddQuestionActivity;
import com.kedrabit.amorasofia.presentation.activities.HistoryActivity;
import com.kedrabit.amorasofia.presentation.adapters.HistoryAdapter;
import com.kedrabit.amorasofia.presentation.contracts.HistoryContract;
import com.kedrabit.amorasofia.presentation.presenters.commons.QuestionItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by katherine on 20/05/17.
 */

public class HistoryFragment extends BaseFragment implements HistoryContract.View{

    @BindView(R.id.rv_select_place)
    RecyclerView rvSelectPlace;
    @BindView(R.id.noPlacesIcon)
    ImageView noPlacesIcon;
    @BindView(R.id.noPLacesMain)
    TextView noPLacesMain;
    @BindView(R.id.noPlaces)
    LinearLayout noPlaces;
    @BindView(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout refreshLayout;
    Unbinder unbinder;
    @BindView(R.id.add_question)
    FloatingActionButton addQuestion;
    private HistoryAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private HistoryContract.Presenter mPresenter;
    //private ProgressDialogCustom mProgressDialogCustom;

    public HistoryFragment() {
        // Requires empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        //mPresenter.getPlaces();
    }

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
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
        addQuestion.setVisibility(view.VISIBLE);
        mLayoutManager = new LinearLayoutManager(getContext());
        rvSelectPlace.setLayoutManager(mLayoutManager);

        mAdapter = new HistoryAdapter(new ArrayList<QuestionEntity>(), getContext(), (QuestionItem) mPresenter);
        rvSelectPlace.setAdapter(mAdapter);
    }


    @Override
    public void getQuestions(ArrayList<QuestionEntity> list) {
        mAdapter.setItems(list);
        mAdapter.notifyDataSetChanged();

       if (list != null) {
            noPlaces.setVisibility((list.size() > 0) ? View.GONE : View.VISIBLE);
        }

    }

    @Override
    public void showClickDetail(QuestionEntity questionEntity) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }


    @Override
    public void setPresenter(HistoryContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        final SwipeRefreshLayout srl =
                (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);

        // Make sure setRefreshing() is called after the layout is done with everything else.
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(active);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        ((BaseActivity) getActivity()).showMessage(message);
    }

    @Override
    public void showErrorMessage(String message) {
        ((BaseActivity) getActivity()).showMessageError(message);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();


    }

    @OnClick(R.id.add_question)
    public void onViewClicked() {
        nextActivity(getActivity(), null, AddQuestionActivity.class, false);

    }
}
