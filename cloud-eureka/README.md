# cloud-eureka

## cap
Consistency, Availability, Partition tolerance

Partition tolerance, 分区容忍性，系统如果不能在时限内达到数据一致性，就意味着发生了分区的情况，
必须在C和A之间做出选择，要么数据不一致，要么不可用。

CA without P: 分区不是想不想的问题，而是始终会存在，CA基本是单机系统，比如单击数据库。

ap
1. 三级缓存同步
2. 从其他peer拉取注册表，peer，```int registryCount = this.registry.syncUp()```，
没有满足C的地方
3. P: 网络不好的情况下，还是可以拉取到注册表进行调用，服务还可以调用

网络不好是指多台server之间，服务挂了，或者抖动，server对其的剔除和保护机制，
那就是说每一台server不一致，C没有，保证P

## 自我保护剔除
1. 开关
2. 阈值

100 保护80，20挂了，1个抖动，不剔除这1个，调用会失败

## server源码
1. 剔除（本质也是下线）
2. 注册
3. 续约
4. 下线
5. 集群间同步
6. 拉取注册表
```java
// 不用改holder里面的，时间会频繁变
class 租约 {
    long 到期时间;
    long 续约时间;
    long 心跳时间;
    
    T 服务实例holder;
}
```

## 服务测算
20个服务 每个服务部署5个 eureka client: 100个
1分钟200
心跳 
日均几十万，对server而言