package com.sys.appstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.annotation.CheckToken;
import com.sys.appstore.common.Result;
import com.sys.appstore.entity.TdSysUser;
import com.sys.appstore.service.ITdSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @CheckToken
    @RequestMapping("/queryUser")
    public Result queryUser(@RequestBody JSONObject param) throws Exception {
        Result<IPage<TdSysUser>> result = new Result<>();
        result.setResult(tdSysUserService.selectUserByPage(param));
        return result;
    }
}

