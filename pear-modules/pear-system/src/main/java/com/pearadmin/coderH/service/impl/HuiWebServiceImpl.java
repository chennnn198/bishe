package com.pearadmin.coderH.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.coderH.mapper.HuiWebMapper;
import com.pearadmin.coderH.domain.HuiWeb;
import com.pearadmin.coderH.service.IHuiWebService;

/**
 * 站点配置Service业务层处理
 *
 * @author coderH
 * @date 2023-03-26
 */
@Service
public class HuiWebServiceImpl implements IHuiWebService {
    @Autowired
    private HuiWebMapper huiWebMapper;

    /**
     * 查询站点配置
     *
     * @param id 站点配置ID
     * @return 站点配置
     */
    @Override
    public HuiWeb selectHuiWebById(Long id) {
        return huiWebMapper.selectHuiWebById(id);
    }

    /**
     * 查询站点配置列表
     *
     * @param huiWeb 站点配置
     * @return 站点配置
     */
    @Override
    public List<HuiWeb> selectHuiWebList(HuiWeb huiWeb) {
        return huiWebMapper.selectHuiWebList(huiWeb);
    }

    /**
     * 查询站点配置
     * @param huiWeb 站点配置
     * @param pageDomain
     * @return 站点配置 分页集合
     * */
    @Override
    public PageInfo<HuiWeb> selectHuiWebPage(HuiWeb huiWeb, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<HuiWeb> data = huiWebMapper.selectHuiWebList(huiWeb);
        return new PageInfo<>(data);
    }

    /**
     * 新增站点配置
     *
     * @param huiWeb 站点配置
     * @return 结果
     */

    @Override
    public int insertHuiWeb(HuiWeb huiWeb) {
        return huiWebMapper.insertHuiWeb(huiWeb);
    }

    /**
     * 修改站点配置
     *
     * @param huiWeb 站点配置
     * @return 结果
     */
    @Override
    public int updateHuiWeb(HuiWeb huiWeb) {
        return huiWebMapper.updateHuiWeb(huiWeb);
    }

    /**
     * 删除站点配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHuiWebByIds(String[] ids) {
        return huiWebMapper.deleteHuiWebByIds(ids);
    }

    /**
     * 删除站点配置信息
     *
     * @param id 站点配置ID
     * @return 结果
     */
    @Override
    public int deleteHuiWebById(Long id) {
        return huiWebMapper.deleteHuiWebById(id);
    }
}
