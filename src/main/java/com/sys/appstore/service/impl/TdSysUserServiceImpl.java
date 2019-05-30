package com.sys.appstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.appstore.entity.TdSysUser;
import com.sys.appstore.mapper.TdSysUserMapper;
import com.sys.appstore.service.ITdSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class TdSysUserServiceImpl extends ServiceImpl<TdSysUserMapper, TdSysUser> implements ITdSysUserService {

    @Autowired
    private TdSysUserMapper tdSysUserMapper;

    @Override
    public IPage<TdSysUser> selectUser(JSONObject param) {
        QueryWrapper<TdSysUser> QUERY_WRAPPER = new QueryWrapper<>();
        QUERY_WRAPPER.eq("flag", "1");
        QUERY_WRAPPER.like(param.getString("username") != null, "username", param.getString("username"));
        QUERY_WRAPPER.eq(param.getString("telno") != null, "telno", param.getString("telno"));
        Page page = new Page(param.getLong("current"), param.getLong("size"));
        IPage<TdSysUser> result = tdSysUserMapper.selectPage(page, QUERY_WRAPPER);
        return result;
    }
}
