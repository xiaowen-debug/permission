package com.xiaowen.common;

import com.xiaowen.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author wen.he
 * @Date 2020/10/12 10:08
 *
 * 全局异常处理
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

    String url = request.getRequestURL().toString();
    ModelAndView mv;
    String defaultMsg = "System error";

    // .json--json请求, .page--页面请求
    if (url.endsWith(".json")) {
      if (e instanceof PermissionException) {
        JsonData result = JsonData.fail(e.getMessage());
        mv = new ModelAndView("jsonView", result.toMap());
      } else {
        log.error("unknow json exception, url:" + url);
        JsonData result = JsonData.fail(defaultMsg);
        mv = new ModelAndView("jsonView", result.toMap());
      }
    } else if (url.endsWith(".page")) {
      log.error("unknow page exception, url:" + url);
      JsonData result = JsonData.fail(defaultMsg);
      mv = new ModelAndView("exception", result.toMap());
    } else {
      log.error("unknow exception, url:" + url);
      JsonData result = JsonData.fail(defaultMsg);
      mv = new ModelAndView("jsonView", result.toMap());
    }

    return mv;
  }
}
