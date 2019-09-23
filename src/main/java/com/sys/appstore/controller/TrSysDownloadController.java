package com.sys.appstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.sys.appstore.entity.TdSysApp;
import com.sys.appstore.service.ITrSysDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/tr-sys-download")
public class TrSysDownloadController {

    @Autowired
    private ITrSysDownloadService trSysDownloadService;

    @RequestMapping("/download")
    @ResponseBody
    public String downloadApp(@RequestBody TdSysApp tdSysApp) {
        return JSONObject.toJSONString(trSysDownloadService.downloadApp(tdSysApp));
    }



}

