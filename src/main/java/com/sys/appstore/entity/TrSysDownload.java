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
public class TrSysDownload implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String downloadid;

    private String appid;

    private String userid;

    /**
     * 下载时间
     */
    private LocalDateTime downloadtime;

    /**
     * 生效标志
     */
    private Integer flag = 1;
}
