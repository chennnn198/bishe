package com.pearadmin.coderH.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.coderH.domain.HuiScan;

/**
 * 扫描结果Service接口
 *
 * @author coderH
 * @date 2023-03-26
 */
public interface IHuiScanService {
    /**
     * 查询扫描结果
     *
     * @param id 扫描结果ID
     * @return 扫描结果
     */
        HuiScan selectHuiScanById(Long id);


    /**
     * 查询扫描结果
     * @param ${classsName} 扫描结果
     * @param pageDomain
     * @return 扫描结果 分页集合
     * */
    PageInfo<HuiScan> selectHuiScanPage(HuiScan huiScan, PageDomain pageDomain);

    /**
     * 查询扫描结果列表
     *
     * @param huiScan 扫描结果
     * @return 扫描结果集合
     */
    List<HuiScan> selectHuiScanList(HuiScan huiScan);

    /**
     * 新增扫描结果
     *
     * @param huiScan 扫描结果
     * @return 结果
     */
    int insertHuiScan(HuiScan huiScan);

    /**
     * 修改扫描结果
     *
     * @param huiScan 扫描结果
     * @return 结果
     */
    int updateHuiScan(HuiScan huiScan);

    /**
     * 批量删除扫描结果
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteHuiScanByIds(String[] ids);

    /**
     * 删除扫描结果信息
     *
     * @param id 扫描结果ID
     * @return 结果
     */
    int deleteHuiScanById(Long id);

}
