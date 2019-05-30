package com.sys.appstore.service;

import com.sys.appstore.entity.TdSysAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
public interface ITdSysAdminService extends IService<TdSysAdmin> {

    TdSysAdmin login(TdSysAdmin tdSysAdmin) throws Exception;

}
