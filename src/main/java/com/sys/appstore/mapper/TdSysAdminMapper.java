package com.sys.appstore.mapper;

import com.sys.appstore.entity.TdSysAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@Repository
public interface TdSysAdminMapper extends BaseMapper<TdSysAdmin> {

    @Select("select * from td_sys_admin where adminname = #{adminname} and flag = 1")
    TdSysAdmin selectAdminByName(String adminname);

}
