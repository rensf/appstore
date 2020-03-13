package com.sys.appstore.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sys.appstore.common.Result;
import com.sys.appstore.entity.TdSysAdmin;
import com.sys.appstore.service.ITdSysAdminService;
import com.sys.appstore.utils.RedisUtil;
import com.sys.appstore.utils.TokenUtil;
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
@RequestMapping("/td-sys-admin")
public class TdSysAdminController {

    @Autowired
    private ITdSysAdminService tdSysAdminService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/login")
    public Result login(@RequestBody TdSysAdmin tdSysAdmin) throws Exception {
        Result<JSONObject> result = new Result<>();

        TdSysAdmin admin = tdSysAdminService.login(tdSysAdmin);
        String token = TokenUtil.sign(admin.getAdminname(), admin.getPassword());
        redisUtil.set(token, token, TokenUtil.EXPIRE_TIME / 1000);

        JSONObject obj = new JSONObject();
        obj.put("adminid", admin.getAdminid());
        obj.put("adminname", admin.getAdminname());
        obj.put("telno", admin.getTelno());
        obj.put("email", admin.getEmail());
        obj.put("token", token);

        result.setResult(obj);

        return result;
    }

}

