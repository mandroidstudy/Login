package android.coolweather.com.login.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:Mao
 * Time:2018/10/30  15:32
 * Description:RetrofitService
 */
public class RetrofitService {
    private static String BASE_URL="https://api.androidhive.info/volley/";
    private static Retrofit instance;
    private RetrofitService(){}
    public static Retrofit retrofit(){
         if (instance==null){
             synchronized (RetrofitService.class){
                 if (instance==null){
                     instance=new Retrofit.Builder()
                             .baseUrl(BASE_URL)
                             .addConverterFactory(GsonConverterFactory.create())
                             .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                             .build();
                 }
             }
         }
        return instance;
    }
}
