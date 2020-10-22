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