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
public class TdSysApptype implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String apptypeid;

    /**
     * 种类名称
     */
    private String apptype;


}
