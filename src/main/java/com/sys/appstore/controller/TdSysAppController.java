package com.sys.appstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.sys.appstore.config.MyPropsConfig;
import com.sys.appstore.entity.TdSysApp;
import com.sys.appstore.service.ITdSysAppService;
import com.sys.appstore.utils.IDGenerator;
import com.sys.appstore.utils.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadAppicon(@RequestParam("file") MultipartFile file) throws IOException {
        return UploadFileUtil.uploadFile(file, myProps.getFilepath());
    }

}

