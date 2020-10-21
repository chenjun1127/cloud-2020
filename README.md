# cloud-2020
cloud微服务

相关端口及服务：
* [7001](http://localhost:7001/) eureka集群1
* [7002](http://localhost:7002/) eureka集群2
* [6000](http://localhost:6000/) order消费者订单服务（cloud-consumer-order）
* [6001](http://localhost:6001/) order消费者订单服务（cloud-consumer-openfeign-order）
* [6002](http://localhost:6002/) order消费者订单服务（cloud-consumer-openfeign-hystrix-order）
* [8001](http://localhost:8001/) payment提供者支付服务（cloud-provider-payment）
* [8002](http://localhost:8002/) payment提供者支付服务（cloud-provider-hystrix-payment）
* [9527](http://localhost:9527/) 网关服务（cloud-gateway）