# cloud-2020
cloud微服务，[相关笔记](https://github.com/chenjun1127/cloud-2020/blob/master/notes.md)

相关端口及服务：
* [7001](http://localhost:7001/) eureka集群一
* [7002](http://localhost:7002/) eureka集群二
* [6000](http://localhost:6000/) order消费者订单服务（cloud-consumer-order）
* [6001](http://localhost:6001/) order消费者订单服务（cloud-consumer-openfeign-order）
* [6002](http://localhost:6002/) order消费者订单服务（cloud-consumer-openfeign-hystrix-order）
* [8001](http://localhost:8001/) payment提供者支付服务（cloud-provider-payment）
* [8002](http://localhost:8002/) payment提供者支付服务（cloud-provider-hystrix-payment）
* [9527](http://localhost:9527/) 网关服务（cloud-gateway）
* [9850](http://localhost:9850/) 配置中心服务端（cloud-config-server-center）
* [9860](http://localhost:9860/) 配置中心客户端一（cloud-config-client-center-9860）
* [9861](http://localhost:9861/) 配置中心客户端二（cloud-config-client-center-9861）
* [8801](http://localhost:8801/) SpringCloud-Stream整合RabbitMQ提供者（cloud-stream-rabbitmq-provider-8801）
* [8802](http://localhost:8802/) SpringCloud-Stream整合RabbitMQ消费者一（cloud-stream-rabbitmq-consumer-8802）
* [8803](http://localhost:8803/) SpringCloud-Stream整合RabbitMQ消费者二（cloud-stream-rabbitmq-consumer-8803）
* [6004](http://localhost:6004/) nacos服务消费者（cloud-alibaba-consumer-order）
* [6005](http://localhost:6005/) nacos服务消费者（cloud-alibaba-consumer-sentinel-order）
* [9001](http://localhost:9001/) nacos服务提供者一（cloud-alibaba-provider-payment）
* [9002](http://localhost:9002/) nacos服务提供者二（cloud-alibaba-provider-payment）
* [3750](http://localhost:3750/) nacos配置中心服务（cloud-alibaba-nacos-config）
* [8401](http://localhost:8401/) alibaba-sentinel服务（cloud-alibaba-sentinel-server）
