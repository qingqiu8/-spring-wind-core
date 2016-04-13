
# Cache 使用方法

> MAVEN 依赖 jars

```
<dependency>
	<groupId>com.google.guava</groupId>
	<artifactId>guava</artifactId>
	<version>19.0</version>
</dependency>
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


> 注解  @Cacheable 和  @CacheEvict 说明

```
@Cacheable 添加缓存

@CacheEvict 清理缓存
```


> 注入 RedisTemplate 直接调用方式

```
@Autowired
//支持该注解 @Qualifier("stringRedisTemplate")
private RedisTemplate<String, String> redisTemplate;	
```


> Ehcache spring 配置，查看 app-ehcache.xml ， ehcache.xml 文件  





