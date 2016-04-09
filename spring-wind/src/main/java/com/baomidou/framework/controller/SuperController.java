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
package com.baomidou.framework.controller;

import com.baomidou.framework.exception.WebException;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.SSOToken;

/**
 * <p>
 * Controller 基础类（支持 kisso）
 * </p>
 * 
 * @author hubin
 * @Date 2016-03-15
 */
public class SuperController extends SupportController {

	/**
	 * 用户ID
	 */
	protected Long getCurrentUserId() {
		return getSSOToken().getId();
	}

	/**
	 * 返回登录 Token
	 */
	protected SSOToken getSSOToken() {
		SSOToken tk = SSOHelper.attrToken(request);
		if (tk == null) {
			throw new WebException("-1", "The user does not exist, please relogin.");
		}
		return tk;
	}

}
