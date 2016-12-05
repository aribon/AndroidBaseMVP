package me.aribon.basemvp.exeption;

/**
 * Created by aribon from Insign Mobility
 * on 28/11/2016
 */
public class NotAttachedViewException extends IllegalStateException {

    private static final long serialVersionUID = 2796067092743774732L;

    public NotAttachedViewException() {

    }

    public NotAttachedViewException(String detailMessage) {
        super(detailMessage);
    }
}
