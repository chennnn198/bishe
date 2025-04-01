package com.pearadmin.coderH.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.coderH.domain.HuiScan;

/**
 * 扫描结果Mapper接口
 *
 * @author coderH
 * @date 2023-03-26
 */
@Mapper
public interface HuiScanMapper {
    /**
     * 查询扫描结果
     *
     * @param id 扫描结果ID
     * @return 扫描结果
     */
        HuiScan selectHuiScanById(Long id);

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
     * 删除扫描结果
     *
     * @param id 扫描结果ID
     * @return 结果
     */
    int deleteHuiScanById(Long id);

    /**
     * 批量删除扫描结果
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteHuiScanByIds(String[] ids);

}
