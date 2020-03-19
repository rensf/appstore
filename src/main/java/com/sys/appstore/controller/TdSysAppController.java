package com.sys.appstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.annotation.CheckToken;
import com.sys.appstore.common.Result;
import com.sys.appstore.config.MyPropsConfig;
import com.sys.appstore.entity.TdSysApp;
import com.sys.appstore.service.ITdSysAppService;
import com.sys.appstore.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/td-sys-app")
public class TdSysAppController {

    @Autowired
    private ITdSysAppService tdSysAppService;
    @Autowired
    private MyPropsConfig myProps;

    @CheckToken
    @RequestMapping("/queryApp")
    public Result queryApp(@RequestBody JSONObject param) throws Exception {
        Result<IPage<TdSysApp>> result = new Result<>();
        result.setResult(tdSysAppService.selectAppByPage(param));
        return result;
    }

    @CheckToken
    @RequestMapping("/uploadApp")
    public String uploadApp(@RequestParam("file") MultipartFile file) throws IOException {
        return FileUtil.uploadFile(file, myProps.getFilepath());
    }

    @RequestMapping("/previewAppImage/{filename}")
    public void previewAppImage(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        String filepath = myProps.getFilepath() + filename;
        FileUtil.checkFile(filepath, response);
    }

    @CheckToken
    @RequestMapping("/addApp")
    public String addApp(@RequestBody TdSysApp tdSysApp) throws Exception {
        return JSONObject.toJSONString(tdSysAppService.addApp(tdSysApp));
    }

    @CheckToken
    @RequestMapping("/delApp")
    public String delApp(@RequestBody TdSysApp tdSysApp) throws Exception {
        return JSONObject.toJSONString(tdSysAppService.delApp(tdSysApp));
    }
}

