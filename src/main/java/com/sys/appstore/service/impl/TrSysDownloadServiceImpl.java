package com.sys.appstore.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.entity.TdSysApp;
import com.sys.appstore.entity.TrSysDownload;
import com.sys.appstore.mapper.TrSysDownloadMapper;
import com.sys.appstore.service.ITrSysDownloadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@Service
public class TrSysDownloadServiceImpl extends ServiceImpl<TrSysDownloadMapper, TrSysDownload> implements ITrSysDownloadService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TrSysDownloadMapper trSysDownloadMapper;

    @Override
    public IPage selectAppDownload() {
        return null;
    }

    @Override
    public Integer downloadApp(TdSysApp tdSysApp) {
        TrSysDownload trSysDownload = new TrSysDownload();
        trSysDownload.setDownloadtime(LocalDateTime.now());
        return trSysDownloadMapper.insert(trSysDownload);
    }
}
