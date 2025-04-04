package com.pearadmin.system.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.constant.ControllerConstant;
import com.pearadmin.common.tools.SecurityUtil;
import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.system.domain.SysConfig;
import com.pearadmin.system.domain.SysUser;
import com.pearadmin.system.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * Describe: 系 统 配 置 控 制 器
 */
@RestController
@Api(tags = {"全局配置"})
@RequestMapping(ControllerConstant.API_SYSTEM_PREFIX + "config")
public class SysConfigController extends BaseController {

    /**
     * 基础路径
     */
    private final String MODULE_PATH = "system/config/";
    /**
     * 引入服务
     */
    @Resource
    private ISysConfigService sysConfigService;

    /**
     * Describe: 数据字典列表视图
     * Param: ModelAndView
     * Return: ModelAndView
     */
    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    /**
     * Describe: 数据字典列表数据
     * Param: sysConfig
     * Return: ResultTable
     */
    @GetMapping("data")
    public ResultTable data(SysConfig param, PageDomain pageDomain) {
        PageInfo<SysConfig> pageInfo = sysConfigService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * Describe: 数据字典类型新增视图
     * Param: sysConfig
     * Return: ModelAndView
     */
    @GetMapping("add")
    public ModelAndView add() {
        return jumpPage(MODULE_PATH + "add");
    }

    /**
     * Describe: 新增字典类型接口
     * Param: sysConfig
     * Return: ResultBean
     */
    @PostMapping("save")
    public Result save(@RequestBody SysConfig sysConfig) {
        sysConfig.setConfigId(SequenceUtil.makeStringId());
        sysConfig.setConfigType("custom");
        boolean result = sysConfigService.save(sysConfig);
        return decide(result);
    }

    /**
     * Describe: 数据字典类型修改视图
     * Param: sysConfig
     * Return: ModelAndView
     */
    @GetMapping("edit")
    @PreAuthorize("hasPermission('/system/config/edit','sys:config:edit')")
    public ModelAndView edit(Model model, String configId) {
        model.addAttribute("sysConfig", sysConfigService.getById(configId));
        return jumpPage(MODULE_PATH + "edit");
    }

    /**
     * Describe: 数据字典类型修改视图
     * Param: sysConfig
     * Return: ModelAndView
     */
    @PutMapping("update")
    @PreAuthorize("hasPermission('/system/config/edit','sys:config:edit')")
    public Result update(@RequestBody SysConfig sysConfig) {
        boolean result = sysConfigService.updateById(sysConfig);
        return decide(result);
    }

    /**
     * Describe: 数据字典删除
     * Param: sysConfig
     * Return: ModelAndView
     */
    @DeleteMapping("remove/{id}")
    @PreAuthorize("hasPermission('/system/config/remove','sys:config:remove')")
    public Result remove(@PathVariable("id") String id) {
        Boolean result = sysConfigService.remove(id);
        return decide(result);
    }

    /**
     * Describe: 系统配置批量删除接口
     * Param: ids
     * Return: Result
     */
    @DeleteMapping("batchRemove/{ids}")
    @ApiOperation(value = "批量删除系统配置数据")
    @PreAuthorize("hasPermission('/system/config/remove','sys:config:remove')")
    public Result batchRemove(@PathVariable String ids) {
        boolean result = sysConfigService.batchRemove(ids.split(","));
        return decide(result);
    }

}
