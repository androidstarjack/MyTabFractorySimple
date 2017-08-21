package drg.yyh.cn.designtab_layout.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;

public class NetUtil {

    public static boolean checkNetworkInfo(Context c) {
        ConnectivityManager conMan = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        State mobile = null;
        try {
            mobile = conMan.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        } catch (Exception e) {

        }
        // wifi
        State wifi = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();

        // 如果3G网络和wifi网络都未连接，且不是处于正在连接状态 则进入Network Setting界面 由用户配置网络连接
        if (mobile == State.CONNECTED || wifi == State.CONNECTED) return true;
        // if (mobile == State.CONNECTING || wifi == State.CONNECTING)
        // return true;
        //		 GetToast.useString(c, "sorry，网络不通，请检查网络后重试~");
        //		 Toast.makeText(c, "sorry，网络不通，请检查网络后重试~", Toast.LENGTH_SHORT);
        return true;

        // c.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));//
        // 进入无线网络配置界面
        // startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
        // //进入手机中的wifi网络设置界面
    }

    
    /**
     * 检测网络是否可用
     * 
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            //do something 
            //能联网 
            return true;
        } else {
            //do something 
            //不能联网 
            return false;
        }
    }
    

    public static final int NETTYPE_WIFI = 0x01;
    public static final int NETTYPE_CMWAP = 0x02;
    public static final int NETTYPE_CMNET = 0x03;

    /**
     * 获取当前网络类型
     * 
     * @return 0：没有网络 1：WIFI网络 2：WAP网络 3：NET网络
     */
    public int getNetworkType(Context context) {
        int netType = 0;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            String extraInfo = networkInfo.getExtraInfo();
            if (!TextUtils.isEmpty(extraInfo)) {
                if (extraInfo.toLowerCase().equals("cmnet")) {
                    netType = NETTYPE_CMNET;
                } else {
                    netType = NETTYPE_CMWAP;
                }
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            netType = NETTYPE_WIFI;
        }
        return netType;
    }
}
