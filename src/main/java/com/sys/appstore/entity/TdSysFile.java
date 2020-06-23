package com.sys.appstore.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author rensf
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TdSysFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件ID
     */
    private String fileid;

    /**
     * 文件名
     */
    private String filename;

    /**
     * 上传时间
     */
    private LocalDateTime createtime;

    /**
     * 上传人
     */
    private String creatorid;

    /**
     * 生效标志
     */
    private Integer flag;


}
