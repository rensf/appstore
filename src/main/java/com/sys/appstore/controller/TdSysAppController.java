package com.sys.appstore.controller;


import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping("/queryApp")
    @ResponseBody
    public String queryApp(@RequestBody JSONObject param) throws Exception {
        return JSONObject.toJSONString(tdSysAppService.selectAppByPage(param));
    }

    @RequestMapping("/uploadApp")
    @ResponseBody
    public String uploadApp(@RequestParam("file") MultipartFile file) throws IOException {
        return FileUtil.uploadFile(file, myProps.getFilepath());
    }

    @RequestMapping("/previewAppImage/{filename}")
    @ResponseBody
    public void previewAppImage(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        String filepath = myProps.getFilepath() + filename;
        FileUtil.checkFile(filepath, response);
    }

    @RequestMapping("/addApp")
    @ResponseBody
    public String addApp(@RequestBody TdSysApp tdSysApp) throws Exception {
        return JSONObject.toJSONString(tdSysAppService.addApp(tdSysApp));
    }

    @RequestMapping("delApp")
    @ResponseBody
    public String delApp(@RequestBody TdSysApp tdSysApp) throws Exception {
        return null;
    }
}

