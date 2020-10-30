drop table if exists `t_order`;
create table `t_order` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(11) DEFAULT NULL COMMENT "用户ID",
  `product_id` BIGINT(11) DEFAULT NULL COMMENT "产品ID",
  `count` INT(11) DEFAULT NULL COMMENT "数量",
  `money` DECIMAL(11,0) DEFAULT NULL COMMENT "金额" ,
  `status` INT(1) DEFAULT NULL COMMENT "订单状态，0,创建中,1已完成" ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
