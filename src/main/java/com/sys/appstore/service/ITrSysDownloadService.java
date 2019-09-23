package com.sys.appstore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.entity.TdSysApp;
import com.sys.appstore.entity.TrSysDownload;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
public interface ITrSysDownloadService extends IService<TrSysDownload> {
    IPage selectAppDownload();
    Integer downloadApp(TdSysApp tdSysApp);
}
