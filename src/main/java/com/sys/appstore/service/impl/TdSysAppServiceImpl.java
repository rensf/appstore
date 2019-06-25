package com.sys.appstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.appstore.entity.TdSysApp;
import com.sys.appstore.mapper.TdSysAppMapper;
import com.sys.appstore.service.ITdSysAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.appstore.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@Service
@Transactional
public class TdSysAppServiceImpl extends ServiceImpl<TdSysAppMapper, TdSysApp> implements ITdSysAppService {

    @Autowired
    private TdSysAppMapper tdSysAppMapper;

    @Override
    public IPage<TdSysApp> selectAppByPage(JSONObject param) {
        QueryWrapper<TdSysApp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flag", 1);
        queryWrapper.like(param.getString("appname") != null, "appname", param.getString("appname"));
        queryWrapper.eq(param.getString("apptype") != null, "apptype", param.getString("apptype"));
        Page page = new Page(param.getLong("current"), param.getLong("size"));
        IPage<TdSysApp> result = tdSysAppMapper.selectPage(page, queryWrapper);
        return result;
    }

    @Override
    public Integer addApp(TdSysApp tdSysApp) {
        tdSysApp.setAppid(IDGenerator.idGenerator());
        tdSysApp.setCreatetime(LocalDateTime.now());
        return tdSysAppMapper.insert(tdSysApp);
    }

    @Override
    public Integer delApp(TdSysApp tdSysApp) throws Exception {
        tdSysApp.setFlag(0);
        return tdSysAppMapper.updateById(tdSysApp);
    }
}
