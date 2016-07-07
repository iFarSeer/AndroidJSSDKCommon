# AndroidJSSDKCommon


AndroidJSSDKCommon是基于native和js通讯协议AndroidJSSDKCore实现的通用模块。

## 使用方式


* Toast提示

```javascript
ITOMIX.Common.toast(JSON.stringify({'content':'toast提示'}), function(params){});
```
 
 
* Activity方式打开新页面

```javascript
ITOMIX.Common.openPage(JSON.stringify({'url':'file:///android_asset/newActivityPage.html'}), function(){});
```
 
* 关闭当前页面

```javascript
ITOMIX.Common.closePage(JSON.stringify({}), function(){});
```
  
* 返回上一页

```javascript
ITOMIX.Common.goBack(JSON.stringify({}), function(params){});
```
