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

package com.farseer.jssdk.common.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.farseer.jssdk.JSSDK;
import com.farseer.jssdk.JSWebView;

public class MainActivity extends AppCompatActivity {

    JSSDK jssdk = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSWebView jsWebView = (JSWebView) findViewById(R.id.jsWebView);

        jssdk = new JSSDK(this, jsWebView);
        jssdk.register();

//        String html = AssetsTool.getText(this, moduleName + ".html");
//        jssdk.loadData(html, "text/html", "utf-8");
        jssdk.loadUrl("file:///android_asset/common.html");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        jssdk.unregister();
    }
}
