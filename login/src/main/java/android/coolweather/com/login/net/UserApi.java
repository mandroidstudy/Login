package android.coolweather.com.login.net;

import android.coolweather.com.login.model.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author:Mao
 * Time:2018/10/30  15:37
 * Description:UserApi
 */
public interface UserApi {
    @GET("person_object.json")
    Observable<User> login();
}
