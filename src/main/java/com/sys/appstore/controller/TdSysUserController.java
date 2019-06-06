package com.sys.appstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.appstore.entity.TdSysUser;
import com.sys.appstore.service.ITdSysUserService;
import com.sys.appstore.utils.GetRequestJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/queryUser")
    @ResponseBody
    public String queryUser(@RequestBody JSONObject param) throws Exception {
        return JSONObject.toJSONString(tdSysUserService.selectUserByPage(param));
    }
}

