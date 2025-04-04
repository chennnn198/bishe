package com.pearadmin.system.domain;

import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

/**
 * notice对象 sys_notice
 *
 */
@Data
public class SysNotice extends BaseDomain {
    /** 编号 */
    private String id;

    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

    /** 发送人 */
    private String sender;

    /** 发送人 */
    private String senderName;

    /** 接收者 */
    private String accept;

    /** 接收人 */
    private String acceptName;

    /** 类型 */
    private String type;

}
