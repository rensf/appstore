package com.sys.appstore.entity;

import java.time.LocalDateTime;
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
public class TrSysComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String commentid;

    private String appid;

    private String userid;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 评价
     */
    private String comment;

    /**
     * 评价时间
     */
    private LocalDateTime commenttime;

    /**
     * 生效标志
     */
    private Integer flag = 1;
}
