package site.lyun.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestExceptionResolve implements HandlerExceptionResolver{
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object o, Exception e) {
        System.out.print(o.toString());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error.jsp");
        return mav;
    }
}
