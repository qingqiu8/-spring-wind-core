package com.baomidou.framework.redis;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * <li>@ClassName: JedisClusterFactory
 * <li>@Description: 工厂
 * <li>@author 方承
 * <li>@date 2016年1月16日
 * <li>
 */
public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {

//	private GenericObjectPoolConfig genericObjectPoolConfig;
	private JedisCluster jedisCluster;
	private int connectionTimeout = 2000;
	private int soTimeout = 3000;
	private int maxRedirections = 5;
	private Set<String> jedisClusterNodes;
	private String password;
	
	public void afterPropertiesSet() throws Exception {
		if (jedisClusterNodes == null || jedisClusterNodes.size() == 0) {
			throw new NullPointerException("jedisClusterNodes is null.");
		}
		Set<HostAndPort> haps = new HashSet<HostAndPort>();
		for (String node : jedisClusterNodes) {
			String[] arr = node.split(":");
			if (arr.length != 2) {
				throw new ParseException("node address error !", node.length() - 1);
			}
			haps.add(new HostAndPort(arr[0], Integer.valueOf(arr[1])));
		}
//		jedisCluster = new JedisCluster(haps, connectionTimeout,maxRedirections
//				, genericObjectPoolConfig);
	}

	public JedisCluster getObject() throws Exception {
		return jedisCluster;
	}

	public Class<?> getObjectType() {
		return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
	}

	public boolean isSingleton() {
		return true;
	}

//	public GenericObjectPoolConfig getGenericObjectPoolConfig() {
//		return genericObjectPoolConfig;
//	}
//
//	public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
//		this.genericObjectPoolConfig = genericObjectPoolConfig;
//	}

	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getSoTimeout() {
		return soTimeout;
	}

	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

	public int getMaxRedirections() {
		return maxRedirections;
	}

	public void setMaxRedirections(int maxRedirections) {
		this.maxRedirections = maxRedirections;
	}

	public Set<String> getJedisClusterNodes() {
		return jedisClusterNodes;
	}

	public void setJedisClusterNodes(Set<String> jedisClusterNodes) {
		this.jedisClusterNodes = jedisClusterNodes;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}