/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.framework.cache.guava;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;
import com.google.common.cache.CacheBuilder;

/**
 * <p>
 * Guava 缓存处理工厂类
 * </p>
 * 
 * @author hubin
 * @Date 2016-04-13
 */
public class GuavaCacheFactoryBean implements FactoryBean<GuavaCache>, BeanNameAware, InitializingBean {

	/**
	 * 缓存名称
	 */
	private String name;

	/**
	 * 是否允许空值
	 */
	private boolean allowNullValues = true;

	/**
	 * 最大缓存容量
	 */
	private Long maximumSize;

	/**
	 * 当缓存项在指定的时间段内没有被读或写就会被回收。这种回收策略类似于基于容量回收策略；
	 */
	private Long expireAfterAccessInSeconds;

	/**
	 * 当缓存项在指定的时间段内没有更新就会被回收。如果我们认为缓存数据在一段时间后数据不再可用，那么可以使用该种策略
	 */
	private Long expireAfterWriteInSeconds;


	/**
	 * 具体缓存实现
	 */
	private GuavaCache cache;


	@Override
	public void afterPropertiesSet() {
		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
		if ( maximumSize != null ) {
			builder.maximumSize(maximumSize);
		}
		if ( expireAfterAccessInSeconds != null ) {
			builder.expireAfterAccess(expireAfterAccessInSeconds, TimeUnit.SECONDS);
		}
		if ( expireAfterWriteInSeconds != null ) {
			builder.expireAfterWrite(expireAfterWriteInSeconds, TimeUnit.SECONDS);
		}

		com.google.common.cache.Cache<Object, Object> guavaCache = builder.build();
		this.cache = new GuavaCache(this.name, guavaCache, this.allowNullValues);
	}


	public void setAllowNullValues( boolean allowNullValues ) {
		this.allowNullValues = allowNullValues;
	}


	@Override
	public void setBeanName( String beanName ) {
		if ( !StringUtils.hasLength(this.name) ) {
			setName(beanName);
		}
	}


	@Override
	public GuavaCache getObject() {
		return this.cache;
	}


	@Override
	public Class<?> getObjectType() {
		return GuavaCache.class;
	}


	@Override
	public boolean isSingleton() {
		return true;
	}


	public Long getMaximumSize() {
		return maximumSize;
	}


	public void setMaximumSize( Long maximumSize ) {
		this.maximumSize = maximumSize;
	}


	public Long getExpireAfterAccessInSeconds() {
		return expireAfterAccessInSeconds;
	}


	public void setExpireAfterAccessInSeconds( Long expireAfterAccessInSeconds ) {
		this.expireAfterAccessInSeconds = expireAfterAccessInSeconds;
	}


	public Long getExpireAfterWriteInSeconds() {
		return expireAfterWriteInSeconds;
	}


	public void setExpireAfterWriteInSeconds( Long expireAfterWriteInSeconds ) {
		this.expireAfterWriteInSeconds = expireAfterWriteInSeconds;
	}


	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	public boolean isAllowNullValues() {
		return allowNullValues;
	}
}
