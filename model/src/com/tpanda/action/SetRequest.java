package com.tpanda.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.http.HttpRequest;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/9/1.
 */
public class SetRequest extends ActionSupport{

    public void setRequest(String msg,Object o){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute(msg,o);
    }
}
