package com.tpanda.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetRequest extends ActionSupport{

    public void setRequest(String msg,Object o){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute(msg,o);
    }

    public void setSession(String msg,Object o){
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute(msg,o);
    }

    public Object getSession(String msg){
        return ServletActionContext.getRequest().getSession().getAttribute(msg);
    }
}
