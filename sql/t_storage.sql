drop table if exists `t_storage`;
create table `t_storage` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(11) DEFAULT NULL COMMENT "产品ID",
  `total` INT(11) DEFAULT NULL COMMENT "总库存",
  `used` INT(11) DEFAULT NULL COMMENT "已用库存",
  `residue` INT(11) DEFAULT NULL COMMENT "剩余库存" ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
