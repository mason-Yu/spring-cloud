package com.my.springcloud.utils;

import java.io.Serializable;

public class RespBody implements Serializable {

  /** serialVersionUID long */
  private static final long serialVersionUID = -1965817463440121331L;

  public boolean success;
  public Object data;

  public static RespBody succeed(Object data) {
    return new RespBody(true, data);
  }

  public static RespBody failed(Object data) {
    return new RespBody(false, data);
  }

  public RespBody(boolean success) {
    this.success = success;
  }

  public RespBody(boolean success, Object data) {
    this.success = success;
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
