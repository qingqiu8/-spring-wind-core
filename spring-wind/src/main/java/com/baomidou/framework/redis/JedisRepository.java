package com.baomidou.framework.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import redis.clients.jedis.DebugParams;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.BinaryClient.LIST_POSITION;

public interface JedisRepository{
	
	public Long append(String key, String value);
	
	public String getKey(JedisKeyEnum jedisKeyEnum);
	
	public String getKey(JedisKeyEnum jedisKeyEnum, String suffix);
	
	@Deprecated
	public String auth(String password);
	
	@Deprecated
	public String bgrewriteaof();
	
	@Deprecated
	public String bgsave();
	
	public Long bitcount(String key);
	
	public Long bitcount(String key, long start, long end);
	
	public List<String> blpop(int timeout, String key);
	
	@Deprecated
	public List<String> blpop(String arg);
	
	public List<String> brpop(int timeout, String key);
	
	@Deprecated
	public List<String> brpop(String arg);
	
	public void close();
	
	@Deprecated
	public String configResetStat();
	
	@Deprecated
	public Long dbSize();
	
	@Deprecated
	public String debug(DebugParams params);
	
	public Long decr(String key);
	
	public Long decrBy(String key, long integer);
	
	public Long del(String key);
	
	public String echo(String string);
	
	public boolean equals(Object obj);
	
	public Boolean exists(String key);
	
	public Long expire(String key, int seconds);
	
	public Long expireAt(String key, long unixTime);
	
	@Deprecated
	public String flushAll();
	
	@Deprecated
	public String flushDB();
	
	public String get(String key);
	
	public Boolean getbit(String key, long offset);
	
	public Map<String, JedisPool> getClusterNodes();
	
	@Deprecated
	public Long getDB();
	
	public String getrange(String key, long startOffset, long endOffset);
	
	public String getSet(String key, String value);
	
	public int hashCode();
	
	public Long hdel(String key, String... field);
	
	public Boolean hexists(String key, String field);
	
	public String hget(String key, String field);
	
	public Map<String, String> hgetAll(String key);
	
	public Long hincrBy(String key, String field, long value);
	
	public Set<String> hkeys(String key);
	
	public Long hlen(String key);
	
	public List<String> hmget(String key, String... fields);
	
	public String hmset(String key, Map<String, String> hash);
	
	@Deprecated
	public ScanResult<Entry<String, String>> hscan(String key, int cursor);
	
	public ScanResult<Entry<String, String>> hscan(String key, String cursor);
	
	public Long hset(String key, String field, String value);
	
	public Long hsetnx(String key, String field, String value);
	
	public List<String> hvals(String key);
	
	public Long incr(String key);
	
	public Long incrBy(String key, long integer);
	
	public Double incrByFloat(String key, double value);
	
	@Deprecated
	public String info();
	
	@Deprecated
	public String info(String section);
	
	@Deprecated
	public Long lastsave();
	
	public String lindex(String key, long index);
	
	public Long linsert(String key, LIST_POSITION where, String pivot, String value);
	
	public Long llen(String key);
	
	public String lpop(String key);
	
	public Long lpush(String key, String... string);
	
	public Long lpushx(String key, String... string);
	
	public List<String> lrange(String key, long start, long end);
	
	public Long lrem(String key, long count, String value);
	
	public String lset(String key, long index, String value);
	
	public String ltrim(String key, long start, long end);
	
	public Long move(String key, int dbIndex);
	
	public Long persist(String key);
	
	public Long pexpire(String key, long milliseconds);
	
	public Long pexpireAt(String key, long millisecondsTimestamp);
	
	public Long pfadd(String key, String... elements);
	
	public long pfcount(String key);
	
	@Deprecated
	public String ping();
	
	@Deprecated
	public String quit();
	
	public String rpop(String key);
	
	public Long rpush(String key, String... string);
	
	public Long rpushx(String key, String... string);
	
	public Long sadd(String key, String... member);
	
	@Deprecated
	public String save();
	
	public Long scard(String key);
	
	@Deprecated
	public String select(int index);
	
	public String set(String key, String value);
	
	public String set(String key, String value, String nxxx, String expx, long time);
	
	public Boolean setbit(String key, long offset, boolean value);
	
	public Boolean setbit(String key, long offset, String value);
	
	public String setex(String key, int seconds, String value);
	
	public Long setnx(String key, String value);
	
	public Long setrange(String key, long offset, String value);
	
	@Deprecated
	public String shutdown();
	
	public Boolean sismember(String key, String member);
	
	@Deprecated
	public String slaveof(String host, int port);
	
	@Deprecated
	public String slaveofNoOne();
	
	public Set<String> smembers(String key);
	
	public List<String> sort(String key);
	
	public List<String> sort(String key, SortingParams sortingParameters);
	
	public String spop(String key);
	
	public Set<String> spop(String key, long count);
	
	public String srandmember(String key);
	
	public List<String> srandmember(String key, int count);
	
	public Long srem(String key, String... member);
	
	@Deprecated
	public ScanResult<String> sscan(String key, int cursor);
	
	public ScanResult<String> sscan(String key, String cursor);
	
	public Long strlen(String key);
	
	public String substr(String key, int start, int end);
	
	public String toString();
	
	public Long ttl(String key);
	
	public String type(String key);
	
	@Deprecated
	public Long waitReplicas(int replicas, long timeout);
	
	public Long zadd(String key, double score, String member);
	
	public Long zadd(String key, Map<String, Double> scoreMembers);
	
	public Long zcard(String key);
	
	public Long zcount(String key, double min, double max);
	
	public Long zcount(String key, String min, String max);
	
	public Double zincrby(String key, double score, String member);
	
	public Long zlexcount(String key, String min, String max);
	
	public Set<String> zrange(String key, long start, long end);
	
	public Set<String> zrangeByLex(String key, String min, String max, int offset, int count);
	
	public Set<String> zrangeByLex(String key, String min, String max);
	
	public Set<String> zrangeByScore(String key, double min, double max);
	
	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count);
	
	public Set<String> zrangeByScore(String key, String min, String max);
	
	public Set<String> zrangeByScore(String key, String min, String max, int offset, int count);
	
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max);
	
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count);
	
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max);
	
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count);
	
	public Set<Tuple> zrangeWithScores(String key, long start, long end);
	
	public Long zrank(String key, String member);
	
	public Long zrem(String key, String... member);
	
	public Long zremrangeByLex(String key, String min, String max);
	
	public Long zremrangeByRank(String key, long start, long end);
	
	public Long zremrangeByScore(String key, double start, double end);
	
	public Long zremrangeByScore(String key, String start, String end);
	
	public Set<String> zrevrange(String key, long start, long end);
	
	public Set<String> zrevrangeByLex(String key, String max, String min);
	
	public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count);
	
	public Set<String> zrevrangeByScore(String key, double max, double min);
	
	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count);
	
	public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count);
	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min);
	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count);
	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min);
	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count);
	
	public Set<Tuple> zrevrangeWithScores(String key, long start, long end);
	
	public Long zrevrank(String key, String member);
	
	@Deprecated
	public ScanResult<Tuple> zscan(String key, int cursor);
	
	public ScanResult<Tuple> zscan(String key, String cursor);
	
	public Double zscore(String key, String member);
	
}
