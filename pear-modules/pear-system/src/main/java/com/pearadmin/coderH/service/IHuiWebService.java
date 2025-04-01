package com.pearadmin.coderH.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.coderH.domain.HuiWeb;

/**
 * 站点配置Service接口
 *
 * @author coderH
 * @date 2023-03-26
 */
public interface IHuiWebService {
    /**
     * 查询站点配置
     *
     * @param id 站点配置ID
     * @return 站点配置
     */
        HuiWeb selectHuiWebById(Long id);


    /**
     * 查询站点配置
     * @param ${classsName} 站点配置
     * @param pageDomain
     * @return 站点配置 分页集合
     * */
    PageInfo<HuiWeb> selectHuiWebPage(HuiWeb huiWeb, PageDomain pageDomain);

    /**
     * 查询站点配置列表
     *
     * @param huiWeb 站点配置
     * @return 站点配置集合
     */
    List<HuiWeb> selectHuiWebList(HuiWeb huiWeb);

    /**
     * 新增站点配置
     *
     * @param huiWeb 站点配置
     * @return 结果
     */
    int insertHuiWeb(HuiWeb huiWeb);

    /**
     * 修改站点配置
     *
     * @param huiWeb 站点配置
     * @return 结果
     */
    int updateHuiWeb(HuiWeb huiWeb);

    /**
     * 批量删除站点配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteHuiWebByIds(String[] ids);

    /**
     * 删除站点配置信息
     *
     * @param id 站点配置ID
     * @return 结果
     */
    int deleteHuiWebById(Long id);

}
