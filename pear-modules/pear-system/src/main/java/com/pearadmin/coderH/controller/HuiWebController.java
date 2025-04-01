package com.pearadmin.coderH.controller;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageInfo;
import com.pearadmin.coderH.domain.HuiScan;
import com.pearadmin.coderH.domain.HuiWeb;
import com.pearadmin.coderH.service.IHuiScanService;
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
import com.pearadmin.coderH.service.IHuiWebService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 站点配置Controller
 *
 * @author coderH
 * @date 2023-03-26
 */
@RestController
@RequestMapping("/coderH/web")
public class HuiWebController extends BaseController {

    private String prefix = "coderH/web";

    @Autowired
    private IHuiWebService huiWebService;

    @Autowired
    private IHuiScanService scanService;

    @GetMapping("/main")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询站点配置列表
     */
    @ResponseBody
    @GetMapping("/data")
    public ResultTable list(@ModelAttribute HuiWeb huiWeb, PageDomain pageDomain) {
        SysUser sysUser = (SysUser) SecurityUtil.currentUser();
        if (!sysUser.getUsername().equals("admin")) {
            huiWeb.setUser(sysUser.getUsername());
        }
        PageInfo<HuiWeb> pageInfo = huiWebService.selectHuiWebPage(huiWeb, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增站点配置
     */
    @GetMapping("/add")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存站点配置
     */
    @ResponseBody
    @PostMapping("/save")
    public Result save(@RequestBody HuiWeb huiWeb) {
        SysUser sysUser = (SysUser) SecurityUtil.currentUser();
        huiWeb.setUser(sysUser.getUsername());
        return decide(huiWebService.insertHuiWeb(huiWeb));
    }

    /**
     * 修改站点配置
     */
    @GetMapping("/edit")
    public ModelAndView edit(Long id, ModelMap mmap) {
        HuiWeb huiWeb = huiWebService.selectHuiWebById(id);
        mmap.put("huiWeb", huiWeb);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存站点配置
     */
    @ResponseBody
    @PutMapping("/update")
    public Result update(@RequestBody HuiWeb huiWeb) {
        return decide(huiWebService.updateHuiWeb(huiWeb));
    }

    /**
     * 删除站点配置
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    public Result batchRemove(String ids) {
        return decide(huiWebService.deleteHuiWebByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable("id") Long id) {
        return decide(huiWebService.deleteHuiWebById(id));
    }

    @ResponseBody
    @GetMapping("/doScan/{webid}")
    public Result doScan(@PathVariable("webid") Long id) {
        SysUser sysUser = (SysUser) SecurityUtil.currentUser();
        HuiWeb huiWeb = huiWebService.selectHuiWebById(id);
        huiWeb.setZt(1);
        huiWebService.updateHuiWeb(huiWeb);
        String url = huiWeb.getUrl();
        List<String> str1 = Arrays.asList("/admin", "/login", "/testDo", "/getList", "/getUserInfo", "/takeSome", "/Go", "/down", "/up", "/stttt");
        List<String> str2 = Arrays.asList("/index", "/gofrm", "/jxjfi", "/yhfa", "/ojge", "/ooo", ";/qdads", "/tododdd", "/takokg", "/mkola");
        List<String> str3 = Arrays.asList("/guama", "/play", "/game", "/rufa", "/gutea", "/gkamgsdf", "/ijkfai", "/dnfuyhf", "/eufhyua", "/mnuhvbu");
        int maxCount = RandomUtil.randomInt(10, 21);
        for (int i = 0; i < maxCount; i++) {
            HuiScan scan = new HuiScan();
            int times = RandomUtil.randomInt(1, 4);
            String scanUrl = url;
            switch (times) {
                case 1:
                    scanUrl += str1.get(RandomUtil.randomInt(0, 10));
                    break;
                case 2:
                    scanUrl += str1.get(RandomUtil.randomInt(0, 10)) + str2.get(RandomUtil.randomInt(0, 10));
                    break;
                case 3:
                    scanUrl += str1.get(RandomUtil.randomInt(0, 10)) + str2.get(RandomUtil.randomInt(0, 10)) + str3.get(RandomUtil.randomInt(0, 10));
                    break;
            }
            scan.setUrl(scanUrl);
            scan.setWebid(huiWeb.getId().toString());
            scan.setWebname(huiWeb.getName());
            scan.setLeaktype((long) RandomUtil.randomInt(1, 6));
            scan.setLeaklvl((long) RandomUtil.randomInt(0, 3));
            scan.setUser(sysUser.getUsername());
            scanService.insertHuiScan(scan);
        }
        return Result.success(id);
    }

}
