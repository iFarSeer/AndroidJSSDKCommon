/*
 *    Copyright 2016 ifarseer
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.farseer.jssdk.common.event;

import android.text.TextUtils;
import com.farseer.jssdk.JSEvent;
import com.farseer.tool.JsonTool;
import com.farseer.tool.LogTool;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

/**
 * class description
 *
 * @author zhaosc
 * @version 1.0.0
 * @since 16/6/27
 */
public class OpenPageEvent extends JSEvent {

    private Request request;

    public OpenPageEvent(String module, String function) {
        super(module, function);
    }

    public Request getRequest() {
        return request;
    }

    @Override
    public void processData(String json) {
        log(json);
        request = JsonTool.fromJsonString(json, new TypeToken<Request>() {
        }.getType());
        if (request == null || !request.check()) {
            LogTool.error(String.format("openPage 's params of the module named %s are not support", getModule()));
        }
    }

    public static class Request {
        @SerializedName("url")
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean check() {
            if (!TextUtils.isEmpty(url)) {
                return true;
            }
            return false;
        }
    }
}
