package com.pearadmin.coderH.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 */
public class SessionUtil {

    public static final String SESSION_USER = "loginUser";

    public static SessionUser getSessionUser(HttpServletRequest request) {
        SessionUser sessionUser = new SessionUser();
        Object obj = request.getSession().getAttribute(SessionUtil.SESSION_USER);
        if (null != obj) {
            sessionUser = (SessionUser) obj;
        }
        return sessionUser;
    }

    public static boolean checkLogin(HttpServletRequest request) {
        Object obj = request.getSession().getAttribute(SessionUtil.SESSION_USER);
        return null != obj;
    }


}
