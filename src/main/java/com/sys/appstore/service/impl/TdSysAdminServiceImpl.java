package com.sys.appstore.service.impl;

import com.sys.appstore.entity.TdSysAdmin;
import com.sys.appstore.mapper.TdSysAdminMapper;
import com.sys.appstore.service.ITdSysAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.appstore.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@Service
public class TdSysAdminServiceImpl extends ServiceImpl<TdSysAdminMapper, TdSysAdmin> implements ITdSysAdminService {

    @Autowired
    private TdSysAdminMapper tdSysAdminMapper;

    @Override
    public TdSysAdmin login(TdSysAdmin tdSysAdmin) throws Exception {
        TdSysAdmin admin = tdSysAdminMapper.selectAdminByName(tdSysAdmin.getAdminname());
        if (admin == null) {
            throw new Exception("此用户不存在！");
        }
        if (!admin.getPassword().equals(MD5Util.makePwd(tdSysAdmin.getAdminname(), tdSysAdmin.getPassword()))) {
            throw new Exception("用户名或密码不正确！");
        }
        return admin;
    }
}
