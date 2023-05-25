CREATE TABLE rookie_crm.taobao_spi (
                                       id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一自增ID',
                                       server_url varchar(50) NOT NULL COMMENT '连接url',
                                       shop_code varchar(50) NOT NULL COMMENT '店铺code',
                                       app_secret varchar(50) NOT NULL COMMENT 'appSecret',
                                       session_key varchar(100) NOT NULL COMMENT 'sessionKey',
                                       create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                       PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='淘宝SPI的key等设置信息';