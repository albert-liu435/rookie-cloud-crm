-- -- crm.r_fans definition
--
-- CREATE TABLE `r_fans` (
--                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
--                           `phone` varchar(15) DEFAULT NULL,
--                           `nick_name` varchar(20) DEFAULT NULL,
--                           `ouid` varchar(50) DEFAULT NULL,
--                           `omid` varchar(50) DEFAULT NULL,
--                           `open_id` varchar(50) DEFAULT NULL,
--                           `union_id` varchar(50) DEFAULT NULL,
--                           `f_type` varchar(3) DEFAULT NULL,
--                           `reg_channel` varchar(10) DEFAULT NULL,
--                           `user_id` bigint(20) DEFAULT NULL,
--                           PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='粉丝表';


CREATE TABLE crm.r_fans (
                                    id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一自增ID',
                                    user_id  int(11) DEFAULT NULL COMMENT '粉丝对应的会员ID',
                                    ouid varchar(50) DEFAULT NULL COMMENT '阿里ouid',
                                    omid varchar(50) DEFAULT NULL COMMENT '阿里omid',
                                    nick_name varchar(50) DEFAULT NULL COMMENT '昵称',
                                    phone varchar(50) DEFAULT NULL COMMENT '明文手机号',
                                    mix_phone varchar(50) DEFAULT NULL  COMMENT '加密手机号',
                                    open_id varchar(100) DEFAULT NULL  COMMENT 'unionid',
                                    union_id varchar(100) DEFAULT NULL COMMENT 'openid',
                                    f_type varchar(10)  DEFAULT NULL COMMENT '粉丝类型',
                                    reg_channel varchar(10) DEFAULT NULL,
                                    create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='会员粉丝信息';


CREATE TABLE crm.r_app (
                            id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一自增ID',
                            app_key  varchar(50) DEFAULT NULL COMMENT '应用系统key',
                            app_secret varchar(50) DEFAULT NULL COMMENT '应用secret',
                            app_token varchar(50) DEFAULT NULL COMMENT '应用token',
                            app_refreshtoken varchar(50) DEFAULT NULL COMMENT '应用refreshtoken',
                            brand varchar(50) DEFAULT NULL COMMENT '品牌',
                            token_expires_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'token过期时间',
                            refreshtoken_expires_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'refreshtoken过期时间',
                            create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='系统应用表';
ALTER TABLE crm.r_app ADD p_type VARCHAR(50);



CREATE TABLE crm.r_brand (
                            id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一自增ID',
                            brand_code  varchar(50) DEFAULT NULL COMMENT '品牌编码',
                            create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='品牌表';

