package android.coolweather.com.login.presenter;

import android.coolweather.com.login.view.BaseView;

/**
 * Created by Mao on 2018/10/30.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T v);
    void detachView(T v);
}
