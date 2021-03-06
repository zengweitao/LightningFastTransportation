package com.shandian.lu.NetWork;

import com.example.mynewslayoutlib.Bean.NewBanJiaListBean;
import com.example.mynewslayoutlib.Bean.NewEditBaoJiaResultBean;
import com.example.mynewslayoutlib.Bean.NewBaoJiaListBean;
import com.example.mynewslayoutlib.Bean.NewHuoYuanDetailOtherBean;
import com.example.mynewslayoutlib.Bean.NewCheYuanDetailBean;
import com.example.mynewslayoutlib.Bean.NewCheYuanListBean;
import com.example.mynewslayoutlib.Bean.NewDingJinPayBean;
import com.example.mynewslayoutlib.Bean.NewHuoYuanDetailBean;
import com.example.mynewslayoutlib.Bean.NewHuoYuanDetailOtherV2Bean;
import com.example.mynewslayoutlib.Bean.NewHuoYuanDetailSelfBean;
import com.example.mynewslayoutlib.Bean.NewHuoYuanListBean;
import com.example.mynewslayoutlib.Bean.NewHuoZhuTongYiBean;
import com.example.mynewslayoutlib.Bean.NewLaHuoBean;
import com.example.mynewslayoutlib.Bean.NewOrderCancelBean;
import com.example.mynewslayoutlib.Bean.NewWeiKuanPayBean;
import com.example.mynewslayoutlib.Bean.NewYiBaoJiaBean;
import com.example.mynewslayoutlib.Bean.NewWoDeCheYuanBean;
import com.example.mynewslayoutlib.Bean.NewWoDeCheYuanDeleteBean;
import com.example.mynewslayoutlib.Bean.NewWoDeHuoYuanBean;
import com.example.mynewslayoutlib.Bean.NewWoDeHuoYuanDeleteBean;
import com.shandian.lu.NetWork.BaseFile.BaseNetWork;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;

/**
 * Created by az on 2017/4/26.
 */

public class NewCheHuoListNetWork extends BaseNetWork {

    protected  final NetService service = getRetrofit().create(NetService.class);
    private interface NetService{
        //设缓存有效期为1天
        final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
        //查询缓存的Cache-Control设置，使用缓存
        final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
        //查询网络的Cache-Control设置。不使用缓存
        final String CACHE_CONTROL_NETWORK = "max-age=0";

        /*货源列表*/
        @GET("index.php/app/chyuan/huoyuan")
        Observable<NewHuoYuanListBean> getHuoListFromNet(@Query("type_name") String type_name, @Query("lat") String lat, @Query("lng") String lng, @Query("p") String p);
        /*货源列表*/
        /*货源列表2*/
        @GET("index.php/app/chyuan/huoyuan")
        Observable<NewHuoYuanListBean> getHuoList2FromNet(@Query("type_name") String type_name, @Query("lat") String lat, @Query("lng") String lng, @Query("p") String p, @Query("cfsheng") String cfsheng, @Query("cfshi") String cfshi, @Query("cfqu") String cfqu, @Query("dasheng") String dasheng, @Query("dashi") String dashi, @Query("daqu") String daqu);
        /*货源列表2*/
        /*货源详情*/
        @GET("index.php/app/chyuan/huoyuanxq")
        Observable<NewHuoYuanDetailBean> getHuoYuanDetailFromNet(@Query("hyid") String hyid);
        /*货源详情*/
        /*货源详情2*/
        @GET("index.php/app/chyuan/huoyuanxq")
        Observable<NewHuoYuanDetailOtherBean> getHuoYuanDetail2FromNet(@Query("hyid") String hyid, @Query("czid") String czid);
        /*货源详情2*/

        /*货源详情查看自己*/
        @GET("index.php/app/chyuan/huoyuanxq")
        Observable<NewHuoYuanDetailSelfBean> getHuoYuanDetailSelfV2FromNet(@Query("hyid") String hyid, @Query("login_id") String login_id);
        /*货源详情查看自己*/
        /*货源详情查看别人*/
        @GET("index.php/app/chyuan/huoyuanxq")
        Observable<NewHuoYuanDetailOtherV2Bean> getHuoYuanDetailOtherV2FromNet(@Query("hyid") String hyid, @Query("login_id") String login_id);
        /*货源详情查看别人*/





        /*我的货源*/
        @FormUrlEncoded
        @POST("index.php/App/chyuan/wodehuoyuan")
        Observable<NewWoDeHuoYuanBean> getWoDeHuoYuanFromNet(@FieldMap Map<String,String> paramMap);
        /*我的货源*/
        /*货源删除*/
        @FormUrlEncoded
        @POST("index.php/app/baojia/huoyuandel")
        Observable<NewWoDeHuoYuanDeleteBean> deleteWoDeHuoYuanToNet(@FieldMap Map<String,String> paramMap);
        /*货源删除*/
        /*车源删除*/
        @FormUrlEncoded
        @POST("index.php/app/baojia/cheyuandel")
        Observable<NewWoDeCheYuanDeleteBean> deleteWoDeCheYuanToNet(@FieldMap Map<String,String> paramMap);
        /*车源删除*/

        /*车找货报价*/
        @FormUrlEncoded
        @POST("index.php/app/baojia/czbaojia")
        Observable<NewEditBaoJiaResultBean> editBaoJiaToNet(@FieldMap Map<String,String> paramMap);
        /*车找货报价*/
        /*货主报价*/
        @FormUrlEncoded
        @POST("index.php/app/baojia/hzbaojia")
        Observable<NewEditBaoJiaResultBean> editHuoZhuBaoJiaToNet(@FieldMap Map<String,String> paramMap);
        /*货主报价*/

        /*车源列表*/
        @GET("index.php/app/chyuan/cheyuan")
        Observable<NewCheYuanListBean> getCheListFromNet(@Query("type_name") String type_name, @Query("lat") String lat, @Query("lng") String lng, @Query("p") String p);
        /*车源列表*/
        /*车源列表2*/
        @GET("index.php/app/chyuan/cheyuan")
        Observable<NewCheYuanListBean> getCheListV2FromNet(@Query("type_name") String type_name, @Query("lat") String lat, @Query("lng") String lng, @Query("p") String p, @Query("cfsheng") String cfsheng, @Query("cfshi") String cfshi, @Query("cfqu") String cfqu, @Query("dasheng") String dasheng, @Query("dashi") String dashi, @Query("daqu") String daqu, @Query("car_type") String car_type, @Query("car_lange") String car_lange);
        /*车源列表2*/
        /*搬家列表*/
        @GET("index.php/app/chyuan/cheyuan")
        Observable<NewBanJiaListBean> getBanJiaListFromNet(@Query("type_name") String type_name, @Query("lat") String lat, @Query("lng") String lng, @Query("p") String p, @Query("cfsheng") String cfsheng, @Query("cfshi") String cfshi, @Query("cfqu") String cfqu, @Query("dasheng") String dasheng, @Query("dashi") String dashi, @Query("daqu") String daqu, @Query("car_type") String car_type, @Query("car_lange") String car_lange);
        /*搬家列表*/
        /*车源详情*/
        @GET("index.php/app/chyuan/cheyuanxq")
        Observable<NewCheYuanDetailBean> getCheYuanDetailFromNet(@Query("cyid") String cyid);
        /*车源详情*/

        /*我的车源车源列表*/
        @FormUrlEncoded
        @POST("index.php/App/chyuan/wodecheyuan")
        Observable<NewWoDeCheYuanBean> getWoDeCheYuanCheYuanLieBiaoFromNet(@FieldMap Map<String,String> paramMap);
        /*我的车源车源列表*/
        /*我的车源已报价*/
        @FormUrlEncoded
        @POST("index.php/app/chyuan/wodebaojia")
        Observable<NewYiBaoJiaBean> getWoDeCheYuanYiBaoJiaFromNet(@FieldMap Map<String,String> paramMap);
        /*我的车源已报价*/

       /*报价列表*/
        //GET请求
        @GET("index.php/app/chyuan/huoyuanbaojia")
        Observable<NewBaoJiaListBean> getBaoJiaListFromNet(@Query("hyid") String hyid);
       /*报价列表*/
       /*取消报价订单*/
        //GET请求
        @FormUrlEncoded
        @POST("index.php/app/baojia/dingdanquxiao")
        Observable<NewOrderCancelBean> cancelBaoJiaOrderToNet(@FieldMap Map<String,String> paramMap);
       /*取消报价订单*/
        /*货主同意*/
       @FormUrlEncoded
       @POST("index.php/app/baojia/huozhutongyi")
       Observable<NewHuoZhuTongYiBean> huoZhuAgreeSubmitToNet(@FieldMap Map<String,String> paramMap);
        /*货主同意*/
        /*获取支付定金金额*/
       @FormUrlEncoded
       @POST("index.php/app/baojia/dingjin")
       Observable<NewDingJinPayBean> getDingJinFromNet(@FieldMap Map<String,String> paramMap);
        /*获取支付定金金额*/
        /*获取尾款金额*/
       @FormUrlEncoded
       @POST("index.php/app/baojia/weikuan")
       Observable<NewWeiKuanPayBean> getWeiKuanFromNet(@FieldMap Map<String,String> paramMap);
        /*获取尾款金额*/
        /*货物接走*/
       @FormUrlEncoded
       @POST("index.php/app/baojia/huowujiezou")
       Observable<NewLaHuoBean> huoWuJieZouFinishToNet(@FieldMap Map<String,String> paramMap);
        /*货物接走*/
        /*货物送达*/
       @FormUrlEncoded
       @POST("index.php/app/baojia/huowusongda")
       Observable<NewLaHuoBean> huoWuSongDaToNet(@FieldMap Map<String,String> paramMap);
        /*货物送达*/
    }

    /*public  void releaseZhuanXianWuLiuToNet(Map<String , Object> usermaps,String img1,String img2,String img3,String img4,String img5,String img6,String img7,String img8,Observer<CarSourceBean> observer){*/
    /*public  void releaseZhuanXianWuLiuToNet(Map<String , Object> usermaps, MultipartBody.Part img1, MultipartBody.Part img2, MultipartBody.Part img3, MultipartBody.Part img4, MultipartBody.Part img5, MultipartBody.Part img6, MultipartBody.Part img7, MultipartBody.Part img8,Observer<CarSourceBean> observer){*/



    public  void getHuoListFromNet(String type_name, String lat, String lng, String p,Observer<NewHuoYuanListBean> observer){
        setSubscribe(service.getHuoListFromNet(type_name,lat,lng,p),observer);
    }
    public  void getHuoList2FromNet(String type_name, String lat, String lng,String p, String cfsheng,String cfshi,String cfqu,String dasheng,String dashi,String daqu,Observer<NewHuoYuanListBean> observer){
        setSubscribe(service.getHuoList2FromNet(type_name,lat,lng,p,cfsheng,cfshi,cfqu,dasheng,dashi,daqu),observer);
    }
    public  void getCheListFromNet(String type_name, String lat, String lng, String p,Observer<NewCheYuanListBean> observer){
        setSubscribe(service.getCheListFromNet(type_name,lat,lng,p),observer);
    }

    public  void getCheListV2FromNet(String type_name, String lat, String lng,String p, String cfsheng,String cfshi,String cfqu,String dasheng,String dashi,String daqu, String car_type, String car_lange,Observer<NewCheYuanListBean> observer){
        setSubscribe(service.getCheListV2FromNet(type_name,lat,lng,p,cfsheng,cfshi,cfqu,dasheng,dashi,daqu,car_type,car_lange),observer);
    }
    public  void getBanJiaListFromNet(String type_name, String lat, String lng,String p, String cfsheng,String cfshi,String cfqu,String dasheng,String dashi,String daqu, String car_type, String car_lange,Observer<NewBanJiaListBean> observer){
        setSubscribe(service.getBanJiaListFromNet(type_name,lat,lng,p,cfsheng,cfshi,cfqu,dasheng,dashi,daqu,car_type,car_lange),observer);
    }
    public  void editBaoJiaToNet(Map<String,String> paramMap,Observer<NewEditBaoJiaResultBean> observer){
        setSubscribe(service.editBaoJiaToNet(paramMap),observer);
    }
    public  void editHuoZhuBaoJiaToNet(Map<String,String> paramMap,Observer<NewEditBaoJiaResultBean> observer){
        setSubscribe(service.editHuoZhuBaoJiaToNet(paramMap),observer);
    }
    public  void getCheYuanDetailFromNet(String cyid,Observer<NewCheYuanDetailBean> observer){
        setSubscribe(service.getCheYuanDetailFromNet(cyid),observer);
    }

    public  void getWoDeCheYuanCheYuanLieBiaoFromNet(Map<String,String> paramMap,Observer<NewWoDeCheYuanBean> observer){
        setSubscribe(service.getWoDeCheYuanCheYuanLieBiaoFromNet(paramMap),observer);
    }
    public  void getWoDeCheYuanYiBaoJiaFromNet(Map<String,String> paramMap,Observer<NewYiBaoJiaBean> observer){
        setSubscribe(service.getWoDeCheYuanYiBaoJiaFromNet(paramMap),observer);
    }
    public  void getHuoYuanDetailFromNet(String hyid,Observer<NewHuoYuanDetailBean> observer){
        setSubscribe(service.getHuoYuanDetailFromNet(hyid),observer);
    }
    public  void getHuoYuanDetail2FromNet(String hyid,String czid,Observer<NewHuoYuanDetailOtherBean> observer){
        setSubscribe(service.getHuoYuanDetail2FromNet(hyid,czid),observer);
    }
    public  void getHuoYuanDetailSelfV2FromNet(String hyid,String login_id,Observer<NewHuoYuanDetailSelfBean> observer){
        setSubscribe(service.getHuoYuanDetailSelfV2FromNet(hyid,login_id),observer);
    }
    public  void getHuoYuanDetailOtherV2FromNet(String hyid,String login_id,Observer<NewHuoYuanDetailOtherV2Bean> observer){
        setSubscribe(service.getHuoYuanDetailOtherV2FromNet(hyid,login_id),observer);
    }
    public  void getWoDeHuoYuanFromNet(Map<String,String> paramMap,Observer<NewWoDeHuoYuanBean> observer){
        setSubscribe(service.getWoDeHuoYuanFromNet(paramMap),observer);
    }
    public  void deleteWoDeHuoYuanToNet(Map<String,String> paramMap,Observer<NewWoDeHuoYuanDeleteBean> observer){
        setSubscribe(service.deleteWoDeHuoYuanToNet(paramMap),observer);
    }
    public  void deleteWoDeCheYuanToNet(Map<String,String> paramMap,Observer<NewWoDeCheYuanDeleteBean> observer){
        setSubscribe(service.deleteWoDeCheYuanToNet(paramMap),observer);
    }
    public  void getBaoJiaListFromNet(String hyid,Observer<NewBaoJiaListBean> observer){
        setSubscribe(service.getBaoJiaListFromNet(hyid),observer);
    }

    public  void huoZhuAgreeSubmitToNet(Map<String,String> paramMap,Observer<NewHuoZhuTongYiBean> observer){
        setSubscribe(service.huoZhuAgreeSubmitToNet(paramMap),observer);
    }
    public  void getDingJinFromNet(Map<String,String> paramMap,Observer<NewDingJinPayBean> observer){
        setSubscribe(service.getDingJinFromNet(paramMap),observer);
    }
    public  void getWeiKuanFromNet(Map<String,String> paramMap,Observer<NewWeiKuanPayBean> observer){
        setSubscribe(service.getWeiKuanFromNet(paramMap),observer);
    }
    public  void huoWuJieZouFinishToNet(Map<String,String> paramMap,Observer<NewLaHuoBean> observer){
        setSubscribe(service.huoWuJieZouFinishToNet(paramMap),observer);
    }
    public  void huoWuSongDaToNet(Map<String,String> paramMap,Observer<NewLaHuoBean> observer){
        setSubscribe(service.huoWuSongDaToNet(paramMap),observer);
    }
    public  void cancelBaoJiaOrderToNet(Map<String,String> paramMap,Observer<NewOrderCancelBean> observer){
        setSubscribe(service.cancelBaoJiaOrderToNet(paramMap),observer);
    }
}
