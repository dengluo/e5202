package com.yijiu.e520.util;

/**
 * Created by k41 on 2017/12/19.
 */

public class OrderStateUtils {
    public static String orderState(Integer state){
        if (state == 0) {
            return "未支付";
        } else if(state == 5){
            return "支付中";
        } else if (state == 10) {
            return "已支付";
        } else if(state == 20){
            return "已出库";
        } else if(state == 30){
            return "已发货";
        } else if(state == 40){
            return "已送达";
        } else if(state == 50){
            return "确认收货";
        } else if(state == 60){
            return "已结算";
        } else if(state == 70){
            return "关闭";
        }
        return null;
    }
}
