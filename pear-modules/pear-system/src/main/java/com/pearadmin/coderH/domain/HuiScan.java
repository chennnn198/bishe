package com.pearadmin.coderH.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

import java.util.Date;

/**
 * 扫描结果对象 hui_scan
 *
 * @author coderH
 * @date 2023-03-26
 */
@Data
public class HuiScan {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 站点id
     */
    private String webid;

    /**
     * 站点名称
     */
    private String webname;

    /**
     * 地址
     */
    private String url;

    /**
     * 漏洞类型
     */
    private Long leaktype;

    /**
     * 漏洞级别 0轻1中2高
     */
    private Long leaklvl;

    private Date scantime;
    private String user;

}
