package com.sys.appstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.annotation.CheckToken;
import com.sys.appstore.common.Result;
import com.sys.appstore.config.MyPropsConfig;
import com.sys.appstore.entity.TdSysUser;
import com.sys.appstore.service.ITdSysUserService;
import com.sys.appstore.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/td-sys-user")
public class TdSysUserController {

    @Autowired
    private ITdSysUserService tdSysUserService;
    @Autowired
    private MyPropsConfig myProps;

    @CheckToken
    @RequestMapping("/queryUser")
    public Result queryUser(@RequestBody JSONObject param) throws Exception {
        Result<IPage<TdSysUser>> result = new Result<>();
        result.setResult(tdSysUserService.selectUserByPage(param));
        return result;
    }

    @RequestMapping("/previewHeadurl/{filename}")
    public void previewAppImage(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        String filepath = myProps.getFilepath() + filename;
        FileUtil.checkFile(filepath, response);
    }
}

