package com.sys.appstore.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.entity.TdSysUser;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
public interface ITdSysUserService extends IService<TdSysUser> {
    IPage<TdSysUser> selectUser(JSONObject param) throws Exception;
}
