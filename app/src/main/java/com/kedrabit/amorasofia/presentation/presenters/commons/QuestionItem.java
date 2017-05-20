package com.kedrabit.amorasofia.presentation.presenters.commons;

import com.kedrabit.amorasofia.data.entity.QuestionEntity;

/**
 * Created by katherine on 24/04/17.
 */

public interface QuestionItem {

    void clickItem(QuestionEntity placesEntity);

    void deleteItem(QuestionEntity placesEntity, int position);
}
