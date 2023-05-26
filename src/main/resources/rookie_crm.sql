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