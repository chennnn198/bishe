package com.pearadmin.coderH.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 站点配置对象 hui_web
 *
 * @author coderH
 * @date 2023-03-26
 */
@Data
public class HuiWeb {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String descinfo;

    /**
     * 网站地址
     */
    private String url;

    /**
     * 状态
     */
    private Integer zt;

    private String user;


}
