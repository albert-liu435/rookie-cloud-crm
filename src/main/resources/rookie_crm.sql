--淘宝SPI相关的信息
drop table if exists rookie_crm.taobao_spi;

CREATE TABLE rookie_crm.taobao_spi
(
    id          int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一自增ID',
    server_url  varchar(50) COMMENT '连接url',
    shop_code   varchar(50) COMMENT '店铺code',
    app_key     varchar(50) COMMENT 'appkey',
    app_secret  varchar(50) COMMENT 'appSecret',
    session_key varchar(100) COMMENT 'sessionKey',
    app_type    varchar(100) COMMENT '应用类型',
    create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='淘宝SPI的key等设置信息';


drop table if exists rookie_crm.tb_fans;

CREATE TABLE rookie_crm.tb_fans (
                                    id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一自增ID',
                                    member_id  int(11)  COMMENT '粉丝对应的会员ID',
                                    ouid varchar(50)  COMMENT '阿里ouid',
                                    omid varchar(50)  COMMENT '阿里omid',
                                    nick_name varchar(50)  COMMENT '昵称',
                                    phone varchar(50)  COMMENT '明文手机号',
                                    mix_phone varchar(50)  COMMENT '加密手机号',
                                    open_id varchar(100)  COMMENT 'unionid',
                                    union_id varchar(100)  COMMENT 'openid',
                                    type varchar(10)  COMMENT '粉丝类型',
                                    create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='会员粉丝信息';



drop table if exists rookie_crm.tb_member;

CREATE TABLE rookie_crm.tb_member (
                                      id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一自增ID',
                                      name varchar(50)  COMMENT '会员姓名',
                                      phone varchar(50)  COMMENT '手机号',
                                      birthday varchar(50)  COMMENT '生日',
                                      sex varchar(50)  COMMENT '性别',
                                      email varchar(50)  COMMENT '邮箱',

                                      point  int(11)  COMMENT '积分',
                                      reg_channel varchar(100)  COMMENT '注册渠道',

                                      level_id varchar(10)  COMMENT '会员等级ID',
                                      brand varchar(10)  COMMENT '品牌会员等级ID',
                                      create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='会员信息表';