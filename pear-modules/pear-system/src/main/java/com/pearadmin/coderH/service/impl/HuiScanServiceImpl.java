package com.pearadmin.coderH.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.coderH.mapper.HuiScanMapper;
import com.pearadmin.coderH.domain.HuiScan;
import com.pearadmin.coderH.service.IHuiScanService;

/**
 * 扫描结果Service业务层处理
 *
 * @author coderH
 * @date 2023-03-26
 */
@Service
public class HuiScanServiceImpl implements IHuiScanService {
    @Autowired
    private HuiScanMapper huiScanMapper;

    /**
     * 查询扫描结果
     *
     * @param id 扫描结果ID
     * @return 扫描结果
     */
    @Override
    public HuiScan selectHuiScanById(Long id) {
        return huiScanMapper.selectHuiScanById(id);
    }

    /**
     * 查询扫描结果列表
     *
     * @param huiScan 扫描结果
     * @return 扫描结果
     */
    @Override
    public List<HuiScan> selectHuiScanList(HuiScan huiScan) {
        return huiScanMapper.selectHuiScanList(huiScan);
    }

    /**
     * 查询扫描结果
     * @param huiScan 扫描结果
     * @param pageDomain
     * @return 扫描结果 分页集合
     * */
    @Override
    public PageInfo<HuiScan> selectHuiScanPage(HuiScan huiScan, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<HuiScan> data = huiScanMapper.selectHuiScanList(huiScan);
        return new PageInfo<>(data);
    }

    /**
     * 新增扫描结果
     *
     * @param huiScan 扫描结果
     * @return 结果
     */

    @Override
    public int insertHuiScan(HuiScan huiScan) {
        return huiScanMapper.insertHuiScan(huiScan);
    }

    /**
     * 修改扫描结果
     *
     * @param huiScan 扫描结果
     * @return 结果
     */
    @Override
    public int updateHuiScan(HuiScan huiScan) {
        return huiScanMapper.updateHuiScan(huiScan);
    }

    /**
     * 删除扫描结果对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHuiScanByIds(String[] ids) {
        return huiScanMapper.deleteHuiScanByIds(ids);
    }

    /**
     * 删除扫描结果信息
     *
     * @param id 扫描结果ID
     * @return 结果
     */
    @Override
    public int deleteHuiScanById(Long id) {
        return huiScanMapper.deleteHuiScanById(id);
    }
}
