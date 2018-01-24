package com.gt.parking.lot.common.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gt.api.bean.sign.SignBean;
import com.gt.api.bean.sign.SignEnum;
import com.gt.api.util.sign.SignUtils;
import com.gt.parking.lot.common.dto.ResponseDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * API——项目过滤器
 * 针对其他项目调用
 * Created by psr on 2017/9/13 0013.
 */
public class ApiFilter implements Filter {

    private static Logger logger = Logger.getLogger(ApiFilter.class);

    @Value("${gt.parking.lot.signKey}")
    private String logSignKey;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("application/json; charset=utf-8");

        logger.debug("api filter");

        // 获取header中的签名
        String signStr = ((HttpServletRequest) servletRequest).getHeader("sign");
        // 解析签名
        SignBean signBean = JSON.parseObject(signStr, SignBean.class);
        // 返回签名验证信息
        String code = SignUtils.decSign(logSignKey, signBean, null);
        logger.debug(code);
        if (SignEnum.TIME_OUT.getCode().equals(code)) {
            // 超过指定时间
            servletResponse.getWriter().append(JSONObject.toJSONString(ResponseDTO.createBySignErrorMessage("请求超过指定时间")));
            return;
        } else if (SignEnum.SIGN_ERROR.getCode().equals(code)) {
            // 签名验证错误
            servletResponse.getWriter().append(JSONObject.toJSONString(ResponseDTO.createBySignErrorMessage("签名验证错误，请检查签名信息")));
            return;
        } else if (SignEnum.SERVER_ERROR.getCode().equals(code)) {
            // 签名系统错误
            servletResponse.getWriter().append(JSONObject.toJSONString(ResponseDTO.createBySignErrorMessage("系统错误，请检查传入参数")));
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
