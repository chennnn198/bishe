package com.pearadmin.common.tools;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * sql注入处理工具类
 */
@Slf4j
public class SqlInjectionUtil {
    /**
     * sign 用于表字典加签的盐值【SQL漏洞】
     * （上线修改值 20200501，同步修改前端的盐值）
     */
    private final static String TABLE_DICT_SIGN_SALT = "20200501";
    private final static String XSS_STR = "'|and |exec |insert |select |delete |update |drop |count |chr |mid |master |truncate |char |declare |;|or |+|,";
    private final static String[] XSS_ARR = XSS_STR.split("\\|");

    /**
     * 针对表字典进行额外的sign签名校验（增加安全机制）
     *
     * @param dictCode:
     * @param sign:
     * @param request:
     */
    public static void checkDictTableSign(String dictCode, String sign, HttpServletRequest request) {
        //表字典SQL注入漏洞,签名校验
        String accessToken = request.getHeader("X-Access-Token");
        String signStr = dictCode + SqlInjectionUtil.TABLE_DICT_SIGN_SALT + accessToken;
        String javaSign = SecureUtil.md5().digestHex(signStr.getBytes());
        if (!javaSign.equals(sign)) {
            log.error("表字典，SQL注入漏洞签名校验失败 ：" + sign + "!=" + javaSign + ",dictCode=" + dictCode);
            throw new RuntimeException("无权限访问！");
        }
        log.info(" 表字典，SQL注入漏洞签名校验成功！sign=" + sign + ",dictCode=" + dictCode);
    }


    /**
     * sql注入过滤处理，遇到注入关键字抛异常
     *
     * @param value sql语句
     */
    public static void filterContent(String value) {
        specialFilterContent(value, XSS_STR);
    }

    /**
     * sql注入过滤处理，遇到注入关键字抛异常
     *
     * @param values sql语句
     */
    public static void filterContent(String[] values) {

        for (String value : values) {
            if (value == null || "".equals(value)) {
                return;
            }
            // 统一转为小写
            value = value.toLowerCase();
            for (String s : XSS_ARR) {
                if (value.contains(s)) {
                    log.error("请注意，存在SQL注入关键词---> {}", s);
                    log.error("请注意，值可能存在SQL注入风险!---> {}", value);
                    throw new RuntimeException("请注意，值可能存在SQL注入风险!--->" + value);
                }
            }
        }
    }

    /**
     * @param value sql语句
     *
     * @特殊方法(不通用) 仅用于字典条件SQL参数，注入过滤
     */

    public static void specialFilterContent(String value) {
        String specialXssStr = " exec | insert | select | delete | update | drop | count | chr | mid | master | truncate | char | declare |;|+|";
        specialFilterContent(value, specialXssStr);
    }


    /**
     * @param value sql语句
     *
     * @特殊方法(不通用) 仅用于Online报表SQL解析，注入过滤
     */
    @Deprecated
    public static void specialFilterContentForOnlineReport(String value) {
        String specialXssStr = " exec | insert | delete | update | drop | chr | mid | master | truncate | char | declare |";
        specialFilterContent(value, specialXssStr);
    }

    private static void specialFilterContent(String value, String specialXssStr) {
        String[] xssArr = specialXssStr.split("\\|");
        specialFilterContent(value, xssArr);
    }

    private static void specialFilterContent(String value, String[] xssArr) {
        if (value == null || "".equals(value)) {
            return;
        }
        // 统一转为小写
        value = value.toLowerCase();
        for (String s : xssArr) {
            if (value.contains(s) || value.startsWith(s.trim())) {
                log.error("请注意，存在SQL注入关键词---> {}", s);
                log.error("请注意，值可能存在SQL注入风险!---> {}", value);
                throw new RuntimeException("请注意，值可能存在SQL注入风险!--->" + value);
            }
        }
    }

}
