package com.pearadmin.coderH.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.coderH.domain.HuiScan;
import com.pearadmin.common.tools.SecurityUtil;
import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.pearadmin.coderH.service.IHuiScanService;

/**
 * 扫描结果Controller
 *
 * @author coderH
 * @date 2023-03-26
 */
@RestController
@RequestMapping("/coderH/scan")
public class HuiScanController extends BaseController {

    private String prefix = "coderH/scan";

    @Autowired
    private IHuiScanService huiScanService;

    @GetMapping("/main")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询扫描结果列表
     */
    @ResponseBody
    @GetMapping("/data")
    public ResultTable list(@ModelAttribute HuiScan huiScan, PageDomain pageDomain) {
        SysUser sysUser = (SysUser) SecurityUtil.currentUser();
        if (!sysUser.getUsername().equals("admin")) {
            huiScan.setUser(sysUser.getUsername());
        }
        PageInfo<HuiScan> pageInfo = huiScanService.selectHuiScanPage(huiScan, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增扫描结果
     */
    @GetMapping("/add")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存扫描结果
     */
    @ResponseBody
    @PostMapping("/save")
    public Result save(@RequestBody HuiScan huiScan) {
        return decide(huiScanService.insertHuiScan(huiScan));
    }

    /**
     * 修改扫描结果
     */
    @GetMapping("/edit")
    public ModelAndView edit(Long id, ModelMap mmap) {
        HuiScan huiScan = huiScanService.selectHuiScanById(id);
        mmap.put("huiScan", huiScan);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存扫描结果
     */
    @ResponseBody
    @PutMapping("/update")
    public Result update(@RequestBody HuiScan huiScan) {
        return decide(huiScanService.updateHuiScan(huiScan));
    }

    /**
     * 删除扫描结果
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    public Result batchRemove(String ids) {
        return decide(huiScanService.deleteHuiScanByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable("id") Long id) {
        return decide(huiScanService.deleteHuiScanById(id));
    }




}
