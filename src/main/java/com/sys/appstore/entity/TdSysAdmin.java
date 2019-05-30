package com.sys.appstore.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TdSysAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String adminid;

    /**
     * 管理员名
     */
    private String adminname;

    /**
     * 密码
     */
    private String password;


}
