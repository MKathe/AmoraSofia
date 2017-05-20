package com.kedrabit.amorasofia.presentation.contracts;

import com.kedrabit.amorasofia.core.BasePresenter;
import com.kedrabit.amorasofia.core.BaseView;

/**
 * Especifica el contrato entre la vista y el presentador para logueo
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {


        boolean isActive();
    }

    interface Presenter extends BasePresenter {


    }
}
