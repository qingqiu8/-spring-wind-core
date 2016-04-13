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

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * <p>
 * Guava 缓存服务
 * </p>
 * 
 * @author hubin
 * @Date 2016-04-13
 */
public class GuavaCache implements Cache {

	public GuavaCache( String name, com.google.common.cache.Cache<Object, Object> cache, boolean allowNullValues ) {
		this.name = name;
		this.cache = cache;
		this.allowNullValues = allowNullValues;
	}

	/**
	 * 缓存的具体实现
	 */
	private final com.google.common.cache.Cache<Object, Object> cache;

	/**
	 * 缓存名称
	 */
	private final String name;

	/**
	 * 是否允许为空
	 */
	private final boolean allowNullValues;


	public boolean isAllowNullValues() {
		return allowNullValues;
	}


	@Override
	public Object getNativeCache() {
		return this.cache;
	}


	@Override
	public ValueWrapper get( Object key ) {
		Object Value = cache.getIfPresent(key);
		return (Value != null ? new SimpleValueWrapper(Value) : null);
	}


	@Override
	public void put( Object key, Object value ) {
		cache.put(key, value);
	}


	@Override
	public void evict( Object key ) {
		cache.invalidate(key);
	}


	@Override
	public void clear() {
		cache.invalidateAll();
	}


	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public <T> T get( Object key, Class<T> type ) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ValueWrapper putIfAbsent( Object arg0, Object arg1 ) {
		// TODO Auto-generated method stub
		return null;
	}

}
