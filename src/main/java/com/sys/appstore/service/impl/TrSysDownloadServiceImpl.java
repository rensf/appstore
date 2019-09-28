package com.sys.appstore.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.appstore.entity.TdSysApp;
import com.sys.appstore.entity.TrSysDownload;
import com.sys.appstore.mapper.TdSysAppMapper;
import com.sys.appstore.mapper.TrSysDownloadMapper;
import com.sys.appstore.service.ITrSysDownloadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.appstore.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rensf
 * @since 2019-05-14
 */
@Service
@Transactional
public class TrSysDownloadServiceImpl extends ServiceImpl<TrSysDownloadMapper, TrSysDownload> implements ITrSysDownloadService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TrSysDownloadMapper trSysDownloadMapper;
    @Autowired
    private TdSysAppMapper tdSysAppMapper;

    @Override
    public IPage selectAppDownload() {
        return null;
    }

    @Override
    public Integer downloadApp(TdSysApp tdSysApp) throws Exception {

        //判断该App是否存在
        TdSysApp tdSysApp1 = tdSysAppMapper.selectById(tdSysApp.getAppid());
        if(tdSysApp1 == null || tdSysApp1.equals("")) {
            throw new Exception("该app已下架！");
        }
        //修改App下载量
        tdSysApp1.setAppdown(tdSysApp.getAppdown()+1);
        tdSysAppMapper.updateById(tdSysApp1);
        //关联App和用户
        TrSysDownload trSysDownload = new TrSysDownload();
        trSysDownload.setDownloadid(IDGenerator.idGenerator());
        trSysDownload.setDownloadtime(LocalDateTime.now());
        return trSysDownloadMapper.insert(trSysDownload);
    }
}
