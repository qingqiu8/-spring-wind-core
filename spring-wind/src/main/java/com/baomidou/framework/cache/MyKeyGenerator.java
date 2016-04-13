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
package com.baomidou.framework.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

/**
 * <p>
 * 自定义缓存主键生成规则
 * </p>
 * 
 * @author hubin
 * @Date 2016-04-13
 */
public class MyKeyGenerator implements KeyGenerator {

	@Override
	public Object generate( Object target, Method method, Object... params ) {
		if ( params.length == 0 ) {
			return target.getClass().getName() + "." + method.getName();
		}
		if ( params.length == 1 ) {
			Object param = params[0];
			if ( param != null && !param.getClass().isArray() ) {
				return target.getClass().getName() + "." + method.getName() + param;
			}
		}
		return target.getClass().getName() + "." + method.getName();
	}

}
