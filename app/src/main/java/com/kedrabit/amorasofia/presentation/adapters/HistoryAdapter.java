package com.kedrabit.amorasofia.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kedrabit.amorasofia.R;
import com.kedrabit.amorasofia.core.LoaderAdapter;
import com.kedrabit.amorasofia.data.entity.QuestionEntity;
import com.kedrabit.amorasofia.presentation.adapters.listeners.OnClickListListener;
import com.kedrabit.amorasofia.presentation.presenters.commons.QuestionItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by katherine on 15/05/17.
 */

public class HistoryAdapter extends LoaderAdapter<QuestionEntity> implements OnClickListListener {


    private Context context;
    private QuestionItem questionItem;

    public HistoryAdapter(ArrayList<QuestionEntity> placesEntities, Context context, QuestionItem questionItem) {
        super(context);
        setItems(placesEntities);
        this.context = context;
        this.questionItem = questionItem;
    }

    public HistoryAdapter(ArrayList<QuestionEntity> orderEntities, Context context) {
        super(context);
        setItems(orderEntities);
        this.context = context;

    }

    public ArrayList<QuestionEntity> getItems() {
        return (ArrayList<QuestionEntity>) getmItems();
    }

    @Override
    public long getYourItemId(int position) {
        return getmItems().get(position).getId();
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(root, this);
    }

    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        QuestionEntity questionEntity = getItems().get(position);
        ((ViewHolder) holder).tvUsuario.setText(questionEntity.getUsuario());
        ((ViewHolder) holder).tvCurso.setText(questionEntity.getCurso());
    }

    @Override
    public void onClick(int position) {

        QuestionEntity questionEntity = getItems().get(position);
        questionItem.clickItem(questionEntity);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_Pregunta)
        ImageView ivPregunta;
        @BindView(R.id.tv_Usuario)
        TextView tvUsuario;
        @BindView(R.id.tv_Curso)
        TextView tvCurso;
        @BindView(R.id.linearLayout1)
        LinearLayout linearLayout1;
        private OnClickListListener onClickListListener;

        ViewHolder(View itemView, OnClickListListener onClickListListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onClickListListener = onClickListListener;
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListListener.onClick(getAdapterPosition());
        }
    }
}
