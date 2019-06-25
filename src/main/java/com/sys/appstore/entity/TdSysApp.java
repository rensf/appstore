package com.sys.appstore.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class TdSysApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String appid;

    /**
     * app名称
     */
    private String appname;

    /**
     * app类型
     */
    private String apptype;

    /**
     * app大小
     */
    private BigDecimal appsize;

    /**
     * app描述
     */
    private String appdetail;

    /**
     * app图标
     */
    private String appicon;

    /**
     * app图片
     */
    private String picture1;

    /**
     * app图片
     */
    private String picture2;

    /**
     * app图片
     */
    private String picture3;

    /**
     * app图片
     */
    private String picture4;

    /**
     * app图片
     */
    private String picture5;

    /**
     * app下载量
     */
    private Integer appdown;

    /**
     * 上传时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;

    /**
     * 生效标志
     */
    private Integer flag = 1;
}
