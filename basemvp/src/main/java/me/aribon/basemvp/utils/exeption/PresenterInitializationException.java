package me.aribon.basemvp.utils.exeption;

/**
 * @Author: aribon
 * @Date: 25/03/2018
 */

public class PresenterInitializationException extends IllegalStateException {

  public PresenterInitializationException() {
  }

  public PresenterInitializationException(String detailMessage) {
    super(detailMessage);
  }
}
