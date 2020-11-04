### 配置中心服务端和客户端加入rabbitMQ消息总线

设计思想：

* 利用消息总线触发一个客户端bus-refresh，而刷新所有客户端的配置。
* 利用消息总线触发一个服务端ConfigServer的bus-refresh端点，而刷新所有客户端的配置。

第二种架构显然更加适合，第一种架构不合适原因如下：

* 打破了微服务的职责单一性，因为微服务本身是业务模块，它本不应该承担配置刷新的职责。
* 破坏了微服务各节点的对等性。
* 有一定的局限性。微服务在迁移时，要实现自动刷新，需增加更多的修改。

步骤：

* 给cloud-config-server-center配置中心服务端添加消息总线支持（改pom,yml）
* 给cloud-config-client-center-9860客户端添加消息总线支持（改pom,yml）
* 给cloud-config-client-center-9861客户端添加消息总线支持（改pom,yml）


测试：springcloud-config仓库修改配置文件，手动运行命令
```
curl -X POST "http://localhost:9850/actuator/bus-refresh"
```
效果：一次修改，广播通知，处处生效。

### spring-cloud-starter-stream-rabbit
注意：不同的组是可以消费的，同一个组内会发生竞争关系，只有其中一个可以消费。

### nacos配置中心dataId完整格式如下：
```
${prefix}-${spring.profile.active}.${file-extension}
```
prefix默认为spring.application.name的值，也可以通过spring.cloud.nacos.config.prefix来配置。注意：当spring.profile.active为空时，对应的连接符-也将不存在，dataId的拼接格式变成${prefix}.${file.extension}。

### SpirngCloud Alibaba Seata 分布式事务解决方案
1.0版本之后conf文件夹下面没有db_store.sql、db_undo_log.sql文件，因此在sql文件夹下面已经放了。
* Transaction Coordinator (TC)： 事务协调器，维护全局事务的运行状态，负责协调并驱动全局事务的提交或回滚。
* Transaction Manager (TM)： 控制全局事务的边界，负责开启一个全局事务，并最终发起全局提交或全局回滚的决议。
* Resource Manager (RM)： 控制分支事务，负责分支注册、状态汇报，并接收事务协调器的指令，驱动分支（本地）事务的提交和回滚。

其中，TM是一个分布式事务的发起者和终结者（@GlobalTransactional），TC负责维护分布式事务的运行状态（seata服务器），而RM则负责本地事务的运行（事务参与方）
