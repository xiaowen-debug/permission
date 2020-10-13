package com.xiaowen.exception;

/**
 * @Author wen.he
 * @Date 2020/10/13 10:46
 */
public class PermissionException extends RuntimeException {

  public PermissionException() {
    super();
  }

  public PermissionException(String message) {
    super(message);
  }

  public PermissionException(String message, Throwable cause) {
    super(message, cause);
  }

  public PermissionException(Throwable cause) {
    super(cause);
  }

  protected PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
