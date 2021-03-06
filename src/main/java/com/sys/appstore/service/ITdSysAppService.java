package com.sys.appstore.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.entity.TdSysApp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
public interface ITdSysAppService extends IService<TdSysApp> {
    IPage<TdSysApp> selectAppByPage(JSONObject param) throws Exception;
    Integer addApp(TdSysApp tdSysApp) throws Exception;
    Integer delApp(TdSysApp tdSysApp) throws Exception;
}
