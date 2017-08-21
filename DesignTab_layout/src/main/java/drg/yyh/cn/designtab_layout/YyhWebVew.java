package drg.yyh.cn.designtab_layout;

/**
 * Created by Administrator on 2017/8/21/021.
 */
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebSettings;

import  com.tencent.smtt.sdk.WebView;

import java.util.Map;

/**
 * 解决Android WebView不同机型的兼容问题，用法同原生WebView一致。
 * 注意包名引用：import com.tencent.smtt.sdk.WebView;
 * 主要使用TBS（腾讯浏览服务）X5内核。
 *
 */
import drg.yyh.cn.designtab_layout.utils.GetToast;
import drg.yyh.cn.designtab_layout.utils.NetUtil;

public class YyhWebVew extends   WebView{
    private Context context;

    /**
     * 是否加载网络的url
     * @param context
     */
    public boolean isLoadNetUrl = true;
    public   com.tencent.smtt.sdk.WebSettings wSet =  null;
    public YyhWebVew(Context context) {
        super(context);
        initWebViewData(context);
    }

    public YyhWebVew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initWebViewData(context);
    }

    public YyhWebVew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initWebViewData(context);
    }

    public YyhWebVew(Context context, AttributeSet attributeSet, int i, boolean b) {
        super(context, attributeSet, i, b);
        initWebViewData(context);
    }

    public YyhWebVew(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean b) {
        super(context, attributeSet, i, map, b);
        initWebViewData(context);
    }

    /**
     * 初始化一些必要的参数
     * @param context
     * @return
     */
    public YyhWebVew initWebViewData(Context context){
         this.context = context;
        getSettings().setJavaScriptEnabled(true);
        wSet = getSettings();
        wSet.setJavaScriptCanOpenWindowsAutomatically(true);
        wSet.setAllowFileAccess(true);
        wSet.setSupportZoom(true);
        wSet.setDisplayZoomControls(false);
        wSet.setDomStorageEnabled(true);
        wSet.setDatabaseEnabled(true);
        //自适应屏幕
        wSet.setLayoutAlgorithm(com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wSet.setLoadWithOverviewMode(true);
        wSet.setUseWideViewPort(true);
        //设置支持缩放
        wSet.setBuiltInZoomControls(true);
        //设置支持加载图片
        wSet.setBlockNetworkImage(false);
        //设置支持缓存
        wSet.setAppCacheEnabled(true);
        //设置缓存模式为默认
        wSet.setCacheMode(WebSettings.LOAD_DEFAULT);
        //设置扩大比例的缩放
        wSet.setUseWideViewPort(true);
        //设置默认的编码格式
        wSet.setDefaultTextEncodingName("UTF-8");
        //设置文件支持
        wSet.setAllowFileAccess(true);
        clearCache(true);
        //对特殊版本做一些处理
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            wSet.setAllowUniversalAccessFromFileURLs(true);
            wSet.setAllowFileAccessFromFileURLs(true);
        }
        return this;
    }


    public YyhWebVew loadLoaclUrl(String url){
        //加载url
        try {
            if (NetUtil.isNetworkAvailable(context)) {

                if (!isLoadNetUrl) {//加载本地的Url
                    //wb_comment_webview.loadData(URLEncoder.encode(url, "utf-8"), "text/html",  "utf-8");
                    loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
                } else {//加载网络的url
                    if (!TextUtils.isEmpty(url)) {
                        loadUrl(url);
                    }
                }
            } else {//无网的话进行提示
                GetToast.useString(context,getResources().getString(R.string.l_loading_connect_err));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    /**
     * 是否清楚缓存
     * 默认为 true
     */
    public YyhWebVew clarWebView(boolean isClearCache){
        clearCache(isClearCache);
        return this;
    }
    /**
     * 是否加载网络的url
     * 默认为 true
     */
    public YyhWebVew isLoadLocal(boolean isLoadNetUrl){
        this.isLoadNetUrl = isLoadNetUrl;
        return this;
    }
     /**
     *自适应屏幕
     * 默认为 true
     */
//    public YyhWebVew isLoadLocal(boolean isLoadNetUrl){
//        //设置支持加载图片
//       // wSet.setBlockNetworkImage(false);
//        if(isLoadNetUrl){
//            wSet.setLayoutAlgorithm(wSet.LayoutAlgorithm.SINGLE_COLUMN);
//        }else{
//            wSet.setLayoutAlgorithm(wSet.LayoutAlgorithm.SINGLE_COLUMN);
//        }
//        return this;
//    }

    /**
     * 监听返回键
     * @param keyCode
     * @param event
     * @param activity
     * @return
     */
    public   boolean onBack(int keyCode, KeyEvent event, Activity activity){
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            if (canGoBack()) {
                goBack(); // goBack()表示返回WebView的上一页面
                return true;
            } else {
                activity.finish();
                return true;
            }
        }
        return false;
    }
}
