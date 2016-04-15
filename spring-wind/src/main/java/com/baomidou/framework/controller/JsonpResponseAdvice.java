/*--------------------------------------------------------------------------
 *  Copyright (c) 2009-2020, dennisit.pu All rights reserved. 
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
 * Author: dennisit.pu (dennisit@163.com)
 *--------------------------------------------------------------------------
*/
package com.baomidou.framework.controller;

import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * <p>
 *     ×Ô¶¯jsonp
 * </p>
 * created on 2016/1/13
 * @author dennisit.pu
 * @version 1.0
 */
@ControllerAdvice
public class JsonpResponseAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpResponseAdvice() {
        super("callback");
    }

    @Override
    protected MediaType getContentType(MediaType contentType, ServerHttpRequest request, ServerHttpResponse response) {
        return new MediaType("application", "javascript", contentType.getCharSet());
    }
}
