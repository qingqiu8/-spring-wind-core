package com.baomidou.framework.redis;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.DebugParams;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

@SuppressWarnings("deprecation")
public class JedisRepositoryImpl implements JedisRepository {

	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String getKey(JedisKeyEnum jedisKeyEnum) {
		return jedisKeyEnum.name();
	}

	@Override
	public String getKey(JedisKeyEnum jedisKeyEnum, String suffix) {
		if (jedisKeyEnum != null) {
			String key = jedisKeyEnum.name();
			if (!StringUtils.isEmpty(suffix)) {
				key += ":" + suffix;
			}
			return key;
		}
		return null;
	}

	@Override
	public Long append(String key, String value) {
		return jedisCluster.append(key, value);
	}

	@Override
	public String auth(String password) {
		return jedisCluster.auth(password);
	}

	@Override
	public String bgrewriteaof() {
		return jedisCluster.bgrewriteaof();
	}

	@Override
	public String bgsave() {
		return jedisCluster.bgsave();
	}

	@Override
	public Long bitcount(String key) {
		return jedisCluster.bitcount(key);
	}

	@Override
	public Long bitcount(String key, long start, long end) {
		return jedisCluster.bitcount(key, start, end);
	}

	@Override
	public List<String> blpop(int timeout, String key) {
		return jedisCluster.blpop(timeout, key);
	}

	@Override
	public List<String> blpop(String arg) {
		return jedisCluster.blpop(arg);
	}

	@Override
	public List<String> brpop(int timeout, String key) {
		return jedisCluster.brpop(timeout, key);
	}

	@Override
	public List<String> brpop(String arg) {
		return jedisCluster.brpop(arg);
	}

	@Override
	public void close() {
//		jedisCluster.close();
	}

	@Override
	public String configResetStat() {
		return jedisCluster.configResetStat();
	}

	@Override
	public Long dbSize() {
		return jedisCluster.dbSize();
	}

	@Override
	public String debug(DebugParams params) {
		return jedisCluster.debug(params);
	}

	@Override
	public Long decr(String key) {
		return jedisCluster.decr(key);
	}

	@Override
	public Long decrBy(String key, long integer) {
		return jedisCluster.decrBy(key, integer);
	}

	@Override
	public Long del(String key) {
		return jedisCluster.del(key);
	}

	@Override
	public String echo(String string) {

		return jedisCluster.echo(string);
	}

	@Override
	public boolean equals(Object obj) {
		return jedisCluster.equals(obj);
	}

	@Override
	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return jedisCluster.expire(key, seconds);
	}

	@Override
	public Long expireAt(String key, long unixTime) {
		return jedisCluster.expireAt(key, unixTime);
	}

	@Override
	public String flushAll() {
		return jedisCluster.flushAll();
	}

	@Override
	public String flushDB() {
		return jedisCluster.flushDB();
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Boolean getbit(String key, long offset) {
		return jedisCluster.getbit(key, offset);
	}

	@Override
	public Map<String, JedisPool> getClusterNodes() {
		return jedisCluster.getClusterNodes();
	}

	@Override
	public Long getDB() {
		return jedisCluster.getDB();
	}

	@Override
	public String getrange(String key, long startOffset, long endOffset) {
		return jedisCluster.getrange(key, startOffset, endOffset);
	}

	@Override
	public String getSet(String key, String value) {
		return jedisCluster.getSet(key, value);
	}

	@Override
	public int hashCode() {
		return jedisCluster.hashCode();
	}

	@Override
	public Long hdel(String key, String... field) {
		return jedisCluster.hdel(key, field);
	}

	@Override
	public Boolean hexists(String key, String field) {
		return jedisCluster.hexists(key, field);
	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}

	@Override
	public Map<String, String> hgetAll(String key) {
		return jedisCluster.hgetAll(key);
	}

	@Override
	public Long hincrBy(String key, String field, long value) {
		return jedisCluster.hincrBy(key, field, value);
	}

	@Override
	public Set<String> hkeys(String key) {
		return jedisCluster.hkeys(key);
	}

	@Override
	public Long hlen(String key) {
		return jedisCluster.hlen(key);
	}

	@Override
	public List<String> hmget(String key, String... fields) {
		return jedisCluster.hmget(key, fields);
	}

	@Override
	public String hmset(String key, Map<String, String> hash) {
		return jedisCluster.hmset(key, hash);
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, int cursor) {
		return jedisCluster.hscan(key, cursor);
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, String cursor) {
		return jedisCluster.hscan(key, cursor);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	@Override
	public Long hsetnx(String key, String field, String value) {
		return jedisCluster.hsetnx(key, field, value);
	}

	@Override
	public List<String> hvals(String key) {
		return jedisCluster.hvals(key);
	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public Long incrBy(String key, long integer) {
		return jedisCluster.incrBy(key, integer);
	}

	@Override
	public Double incrByFloat(String key, double value) {
		return jedisCluster.incrByFloat(key, value);
	}

	@Override
	public String info() {
		return jedisCluster.info();
	}

	@Override
	public String info(String section) {
		return jedisCluster.info(section);
	}

	@Override
	public Long lastsave() {
		return jedisCluster.lastsave();
	}

	@Override
	public String lindex(String key, long index) {
		return jedisCluster.lindex(key, index);
	}

	@Override
	public Long linsert(String key, LIST_POSITION where, String pivot, String value) {
		return jedisCluster.linsert(key, where, pivot, value);
	}

	@Override
	public Long llen(String key) {
		return jedisCluster.llen(key);
	}

	@Override
	public String lpop(String key) {
		return jedisCluster.lpop(key);
	}

	@Override
	public Long lpush(String key, String... string) {
		return jedisCluster.lpush(key, string);
	}

	@Override
	public Long lpushx(String key, String... string) {
		return jedisCluster.lpushx(key, string);
	}

	@Override
	public List<String> lrange(String key, long start, long end) {
		return jedisCluster.lrange(key, start, end);
	}

	@Override
	public Long lrem(String key, long count, String value) {
		return jedisCluster.lrem(key, count, value);
	}

	@Override
	public String lset(String key, long index, String value) {
		return jedisCluster.lset(key, index, value);
	}

	@Override
	public String ltrim(String key, long start, long end) {
		return jedisCluster.ltrim(key, start, end);
	}

	@Override
	public Long move(String key, int dbIndex) {
		return jedisCluster.move(key, dbIndex);
	}

	@Override
	public Long persist(String key) {
		return jedisCluster.persist(key);
	}

	@Override
	public Long pexpire(String key, long milliseconds) {
		return jedisCluster.pexpire(key, milliseconds);
	}

	@Override
	public Long pexpireAt(String key, long millisecondsTimestamp) {
		return jedisCluster.pexpireAt(key, millisecondsTimestamp);
	}

	@Override
	public Long pfadd(String key, String... elements) {
		return jedisCluster.pfadd(key, elements);
	}

	@Override
	public long pfcount(String key) {
		return jedisCluster.pfcount(key);
	}

	@Override
	public String ping() {
		return jedisCluster.ping();
	}

	@Override
	public String quit() {
		return jedisCluster.quit();
	}

	@Override
	public String rpop(String key) {
		return jedisCluster.rpop(key);
	}

	@Override
	public Long rpush(String key, String... string) {
		return jedisCluster.rpush(key, string);
	}

	@Override
	public Long rpushx(String key, String... string) {
		return jedisCluster.rpushx(key, string);
	}

	@Override
	public Long sadd(String key, String... member) {
		return jedisCluster.sadd(key, member);
	}

	@Override
	public String save() {
		return jedisCluster.save();
	}

	@Override
	public Long scard(String key) {
		return jedisCluster.scard(key);
	}

	@Override
	public String select(int index) {
		return jedisCluster.select(index);
	}

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String set(String key, String value, String nxxx, String expx, long time) {
		return jedisCluster.set(key, value, nxxx, expx, time);
	}

	@Override
	public Boolean setbit(String key, long offset, boolean value) {
		return jedisCluster.setbit(key, offset, value);
	}

	@Override
	public Boolean setbit(String key, long offset, String value) {
		return jedisCluster.setbit(key, offset, value);
	}

	@Override
	public String setex(String key, int seconds, String value) {
		return jedisCluster.setex(key, seconds, value);
	}

	@Override
	public Long setnx(String key, String value) {
		return jedisCluster.setnx(key, value);
	}

	@Override
	public Long setrange(String key, long offset, String value) {
		return jedisCluster.setrange(key, offset, value);
	}

	@Override
	public String shutdown() {
		return jedisCluster.shutdown();
	}

	@Override
	public Boolean sismember(String key, String member) {
		return jedisCluster.sismember(key, member);
	}

	@Override
	public String slaveof(String host, int port) {
		return jedisCluster.slaveof(host, port);
	}

	@Override
	public String slaveofNoOne() {
		return jedisCluster.slaveofNoOne();
	}

	@Override
	public Set<String> smembers(String key) {
		return jedisCluster.smembers(key);
	}

	@Override
	public List<String> sort(String key) {
		return jedisCluster.sort(key);
	}

	@Override
	public List<String> sort(String key, SortingParams sortingParameters) {
		return jedisCluster.sort(key, sortingParameters);
	}

	@Override
	public String spop(String key) {
		return jedisCluster.spop(key);
	}

	@Override
	public Set<String> spop(String key, long count) {
		return jedisCluster.spop(key, count);
	}

	@Override
	public String srandmember(String key) {

		return jedisCluster.srandmember(key);
	}

	@Override
	public List<String> srandmember(String key, int count) {
		return jedisCluster.srandmember(key, count);
	}

	@Override
	public Long srem(String key, String... member) {
		return jedisCluster.srem(key, member);
	}

	@Override
	public ScanResult<String> sscan(String key, int cursor) {
		return jedisCluster.sscan(key, cursor);
	}

	@Override
	public ScanResult<String> sscan(String key, String cursor) {
		return jedisCluster.sscan(key, cursor);
	}

	@Override
	public Long strlen(String key) {
		return jedisCluster.strlen(key);
	}

	@Override
	public String substr(String key, int start, int end) {
		return jedisCluster.substr(key, start, end);
	}

	@Override
	public String toString() {
		return jedisCluster.toString();
	}

	@Override
	public Long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public String type(String key) {
		return jedisCluster.type(key);
	}

	@Override
	public Long waitReplicas(int replicas, long timeout) {
		return jedisCluster.waitReplicas(replicas, timeout);
	}

	@Override
	public Long zadd(String key, double score, String member) {
		return jedisCluster.zadd(key, score, member);
	}

	@Override
	public Long zadd(String key, Map<String, Double> scoreMembers) {
		return jedisCluster.zadd(key, scoreMembers);
	}

	@Override
	public Long zcard(String key) {
		return jedisCluster.zcard(key);
	}

	@Override
	public Long zcount(String key, double min, double max) {
		return jedisCluster.zcount(key, min, max);
	}

	@Override
	public Long zcount(String key, String min, String max) {
		return jedisCluster.zcount(key, min, max);
	}

	@Override
	public Double zincrby(String key, double score, String member) {
		return jedisCluster.zincrby(key, score, member);
	}

	@Override
	public Long zlexcount(String key, String min, String max) {
		return jedisCluster.zlexcount(key, min, max);
	}

	@Override
	public Set<String> zrange(String key, long start, long end) {
		return jedisCluster.zrange(key, start, end);
	}

	@Override
	public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
		return jedisCluster.zrangeByLex(key, min, max, offset, count);
	}

	@Override
	public Set<String> zrangeByLex(String key, String min, String max) {
		return jedisCluster.zrangeByLex(key, min, max);
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max) {
		return jedisCluster.zrangeByScore(key, min, max);
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
		return jedisCluster.zrangeByScore(key, min, max, offset, count);
	}

	@Override
	public Set<String> zrangeByScore(String key, String min, String max) {
		return jedisCluster.zrangeByScore(key, min, max);
	}

	@Override
	public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
		return jedisCluster.zrangeByScore(key, min, max, offset, count);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
		return jedisCluster.zrangeByScoreWithScores(key, min, max);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
		return jedisCluster.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
		return jedisCluster.zrangeByScoreWithScores(key, min, max);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
		return jedisCluster.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	@Override
	public Set<Tuple> zrangeWithScores(String key, long start, long end) {
		return jedisCluster.zrangeWithScores(key, start, end);
	}

	@Override
	public Long zrank(String key, String member) {
		return jedisCluster.zrank(key, member);
	}

	@Override
	public Long zrem(String key, String... member) {
		return jedisCluster.zrem(key, member);
	}

	@Override
	public Long zremrangeByLex(String key, String min, String max) {
		return jedisCluster.zremrangeByLex(key, min, max);
	}

	@Override
	public Long zremrangeByRank(String key, long start, long end) {
		return jedisCluster.zremrangeByRank(key, start, end);
	}

	@Override
	public Long zremrangeByScore(String key, double start, double end) {
		return jedisCluster.zremrangeByScore(key, start, end);
	}

	@Override
	public Long zremrangeByScore(String key, String start, String end) {
		return jedisCluster.zremrangeByScore(key, start, end);
	}

	@Override
	public Set<String> zrevrange(String key, long start, long end) {
		return jedisCluster.zrevrange(key, start, end);
	}

	@Override
	public Set<String> zrevrangeByLex(String key, String max, String min) {
		return jedisCluster.zrevrangeByLex(key, max, min);
	}

	@Override
	public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
		return jedisCluster.zrevrangeByLex(key, max, min, offset, count);
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min) {
		return jedisCluster.zrevrangeByScore(key, max, min);
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
		return jedisCluster.zrevrangeByScore(key, max, min, offset, count);
	}

	@Override
	public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
		return jedisCluster.zrevrangeByScore(key, max, min, offset, count);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
		return jedisCluster.zrevrangeByScoreWithScores(key, max, min);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
		return jedisCluster.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
		return jedisCluster.zrevrangeByScoreWithScores(key, max, min);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
		return jedisCluster.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	@Override
	public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
		return jedisCluster.zrevrangeWithScores(key, start, end);
	}

	@Override
	public Long zrevrank(String key, String member) {
		return jedisCluster.zrevrank(key, member);
	}

	@Override
	public ScanResult<Tuple> zscan(String key, int cursor) {
		return jedisCluster.zscan(key, cursor);
	}

	@Override
	public ScanResult<Tuple> zscan(String key, String cursor) {
		return jedisCluster.zscan(key, cursor);
	}

	@Override
	public Double zscore(String key, String member) {
		return jedisCluster.zscore(key, member);
	}

}
