package ctci.water.iotconfig.controller.interceptor;

import com.alibaba.fastjson.JSONObject;
import ctci.water.iotconfig.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
拦截器 实现token拦截器,统一处理token失效机制，可以将跨域写在prehand函数的开始也可以在WebMvcConfigurationSupport类中注册
@auth JenterMei
 */
@Component
public class AuthTokenInterceptor implements HandlerInterceptor {

    @Autowired
    TokenService tokenService;

    private static Logger logger = LoggerFactory.getLogger(AuthTokenInterceptor.class);
    /*
     * 请求执行前执行
     */
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        //crossDomain(request, response);
        JSONObject res = new JSONObject();
        String token = request.getHeader("token");
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        if (token==null || token.equals("")){
            logger.info("Your token is null or blank");
            res.put("status",550);
            res.put("message","token缺失，无法验证");
            res.put("data",null);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain; charset=utf-8");
            dealErrorReturn(response,res);
            return false;
        }
        if (!tokenService.checkTokenExprie(token)){
            logger.info("Your token is invalid or not exits");
            res.put("status",550);
            res.put("message","token缺失，无法验证");
            res.put("data",null);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain; charset=utf-8");
            dealErrorReturn(response,res);
            return false;
        }
        tokenService.updateTokenExpriedTime(token);
        return true;
    }

    /*
     * 请求结束执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception{

    }

    /*
     * 视图渲染完成后执行
     */
    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception{

    }

    public void dealErrorReturn(HttpServletResponse httpServletResponse, JSONObject obj){
        String json = obj.toJSONString();
        PrintWriter writer = null;

        try {
            writer = httpServletResponse.getWriter();
            writer.print(json);

        } catch (IOException ex) {
            logger.error("response error",ex);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    //拦截器跨域请求配置
    public void crossDomain(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "token,Origin, X-Requested-With, Content-Type, Accept");
    }
}