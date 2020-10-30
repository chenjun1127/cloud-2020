drop table if exists `t_account`;
create table `t_account` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(11) DEFAULT NULL COMMENT "用户ID",
  `total` DECIMAL(10,0) DEFAULT NULL COMMENT "总额度",
  `used` DECIMAL(10,0) DEFAULT NULL COMMENT "已用余额",
  `residue` DECIMAL(10,0) DEFAULT NULL COMMENT "剩余余额" ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
