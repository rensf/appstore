SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `td_sys_admin`;
CREATE TABLE `td_sys_admin`
(
    `adminid`   varchar(50) NOT NULL COMMENT '管理员ID',
    `adminname` varchar(50) NULL COMMENT '管理员名',
    `password`  varchar(50) NULL COMMENT '密码',
    `telno`     varchar(50) NULL COMMENT '手机号',
    `email`     varchar(50) NULL COMMENT '邮箱',
    `flag`      int(2)      NOT NULL DEFAULT 1 COMMENT '生效标志',
    PRIMARY KEY (`adminid`) USING BTREE
) ENGINE = InnoDB;

INSERT INTO `td_sys_admin` (`adminid`, `adminname`, `password`)
VALUES ('1', 'admin', 'c62abcd390cc6920d3cb9a63e0cb9084');

DROP TABLE IF EXISTS `td_sys_app`;
CREATE TABLE `td_sys_app`
(
    `appid`      varchar(50)    NOT NULL COMMENT 'APPID',
    `appname`    varchar(50)    NULL COMMENT 'APP名称',
    `apptype`    varchar(50)    NULL COMMENT 'APP类型',
    `appsize`    decimal(10, 3) NULL COMMENT 'APP大小',
    `appdetail`  longtext       NULL COMMENT 'APP描述',
    `appicon`    varchar(255)   NULL COMMENT 'APP图标',
    `picture1`   varchar(255)   NULL COMMENT 'APP图片',
    `picture2`   varchar(255)   NULL COMMENT 'APP图片',
    `picture3`   varchar(255)   NULL COMMENT 'APP图片',
    `picture4`   varchar(255)   NULL COMMENT 'APP图片',
    `picture5`   varchar(255)   NULL COMMENT 'APP图片',
    `appdown`    int(10)        NULL COMMENT 'APP下载量',
    `createtime` datetime       NULL COMMENT '上传时间',
    `creatorid`  varchar(50)    NOT NULL COMMENT '上传人',
    `flag`       int(2)         NOT NULL DEFAULT 1 COMMENT '生效标志',
    PRIMARY KEY (`appid`) USING BTREE
) ENGINE = InnoDB;

INSERT INTO `td_sys_app` (`appid`, `appname`, `apptype`, `appdetail`, `appicon`, `picture1`, `picture2`, `picture3`,
                          `picture4`, `picture5`, `createtime`, `creatorid`)
VALUES ('1', '神奇宝贝', '图鉴', '神奇宝贝图鉴——汇聚了所有已出现神奇宝贝的详细信息！', 'pokemon.png', '', '', '', '', '', NOW(), '1'),
       ('2', '育婴宝', '幼儿', '精准满足中国年轻父母知识获取、交流交友、记录成长、消费购物的四大核心需求，从而培养健康、友爱、智慧、勇敢的宝宝们!', 'baby.png', '', '', '', '', '', NOW(),
        '1'),
       ('3', '作业消消乐', '游戏', '趣味十足，操作简单，老少皆宜，玩法丰富！', 'homework.png', '', '', '', '', '', NOW(), '1'),
       ('4', '咖妃', '餐饮', '用每一杯咖啡传递独特的咖妃！', 'coffee.png', '', '', '', '', '', NOW(), '1');

DROP TABLE IF EXISTS `td_sys_user`;
CREATE TABLE `td_sys_user`
(
    `userid`     varchar(50) NOT NULL COMMENT '用户ID',
    `username`   varchar(50) NULL COMMENT '用户名',
    `password`   varchar(50) NULL COMMENT '密码',
    `telno`      varchar(50) NULL COMMENT '手机号',
    `email`      varchar(50) NULL COMMENT '邮箱',
    `createtime` datetime    NULL COMMENT '注册时间',
    `flag`       int(2)      NOT NULL DEFAULT 1 COMMENT '生效标志',
    PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `tr_sys_comment`;
CREATE TABLE `tr_sys_comment`
(
    `commentid`   varchar(50) NOT NULL COMMENT '评价ID',
    `appid`       varchar(50) NULL COMMENT 'APPID',
    `userid`      varchar(50) NULL COMMENT '用户ID',
    `level`       int(3)      NULL COMMENT '等级',
    `comment`     longtext    NULL COMMENT '评价',
    `commenttime` datetime    NULL COMMENT '评价时间',
    `flag`        int(2)      NOT NULL DEFAULT 1 COMMENT '生效标志',
    PRIMARY KEY (`commentid`) USING BTREE
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `tr_sys_download`;
CREATE TABLE `tr_sys_download`
(
    `downloadid` varchar(50) NOT NULL COMMENT '下载ID',
    `appid`      varchar(50) NULL COMMENT 'APPID',
    `userid`     varchar(50) NULL COMMENT '用户ID',
    `downtime`   datetime    NULL COMMENT '下载时间',
    `flag`       int(2)      NOT NULL DEFAULT 1 COMMENT '生效标志',
    PRIMARY KEY (`downloadid`) USING BTREE
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `td_sys_file`;
CREATE TABLE `td_sys_file`
(
    `fileid`     varchar(50) NOT NULL COMMENT '文件ID',
    `filename`   varchar(50) NOT NULL COMMENT '文件名',
    `createtime` datetime    NULL COMMENT '上传时间',
    `creatorid`  varchar(50) NOT NULL COMMENT '上传人',
    `flag`       int(2)      NOT NULL DEFAULT 1 COMMENT '生效标志',
    PRIMARY KEY (`fileid`) USING BTREE
) ENGINE = InnoDB;

INSERT INTO `td_sys_file` (fileid, filename, createtime, creatorid)
VALUES ('1', 'pokemon.png', NOW(), '1'),
       ('2', 'baby.png', NOW(), '1'),
       ('3', 'homework.png', NOW(), '1'),
       ('4', 'coffee.png', NOW(), '1');

SET FOREIGN_KEY_CHECKS = 1;
