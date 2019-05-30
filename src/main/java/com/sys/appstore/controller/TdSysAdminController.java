package com.sys.appstore.controller;


import com.alibaba.fastjson.JSON;
import com.sys.appstore.entity.TdSysAdmin;
import com.sys.appstore.service.ITdSysAdminService;
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

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody TdSysAdmin tdSysAdmin) throws Exception {
        return JSON.toJSONString(tdSysAdminService.login(tdSysAdmin));
    }


}

