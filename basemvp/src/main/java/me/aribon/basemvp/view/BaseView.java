package me.aribon.basemvp.view;

import me.aribon.basemvp.exception.NotAttachedViewException;

/**
 * Created on 19/03/2016
 *
 * @author Anthony
 */
public interface BaseView {

    void preparePresenter() throws NotAttachedViewException;

}
