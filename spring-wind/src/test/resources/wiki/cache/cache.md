
# Cache 使用方法


> 注解 @Cacheable、@CachePut、@CacheEvict 注释介绍

```
@Cacheable 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
@CachePut 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用
@CachEvict 主要针对方法配置，能够根据一定的条件对缓存进行清空

基本原理：一句话介绍就是Spring AOP的动态代理技术。 如果读者对Spring AOP不熟悉的话，可以去看看官方文档
```


# Redis 说明

> MAVEN 依赖 jars

```
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-redis</artifactId>
    <version>1.7.1.RELEASE</version>
</dependency>
<dependency>
	<groupId>redis.clients</groupId>
	<artifactId>jedis</artifactId>
	<version>2.8.1</version>
</dependency>
```


> 注入 RedisTemplate 直接调用方式

```
@Autowired
//支持该注解 @Qualifier("stringRedisTemplate")
private RedisTemplate<String, String> redisTemplate;	
```


