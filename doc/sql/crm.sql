-- crm.r_fans definition

CREATE TABLE `r_fans` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `phone` varchar(15) DEFAULT NULL,
                          `nick_name` varchar(20) DEFAULT NULL,
                          `ouid` varchar(50) DEFAULT NULL,
                          `omid` varchar(50) DEFAULT NULL,
                          `open_id` varchar(50) DEFAULT NULL,
                          `union_id` varchar(50) DEFAULT NULL,
                          `f_type` varchar(3) DEFAULT NULL,
                          `reg_channel` varchar(10) DEFAULT NULL,
                          `user_id` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='粉丝表';
