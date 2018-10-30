package android.coolweather.com.login.presenter.impl;

import android.coolweather.com.login.model.User;
import android.coolweather.com.login.net.RetrofitService;
import android.coolweather.com.login.net.UserApi;
import android.coolweather.com.login.presenter.LoginPresenter;
import android.coolweather.com.login.view.LoginView;
import android.text.TextUtils;
import android.util.Log;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author:Mao
 * Time:2018/10/30  15:28
 * Description:LoginPresenterImpl
 */
public class LoginPresenterImpl implements LoginPresenter {
    private LoginView mView;
    private Subscription subscription;
    private boolean isRememberPassword;
    @Override
    public void login(String account,String password,boolean isChecked) {
        if (checkParameterNotNull(account,password)){
            this.isRememberPassword=isChecked;
           loginByNet(account,password);
        }
        else {
            mView.loginFail("账户或密码不能为空");
        }
    }

    @Override
    public void saveAccountAndPassword(String account, String password) {
        Log.d("MVE","记住密码");
    }

    @Override
    public void clearPassword(String account) {
        Log.d("MVE","清除密码");
    }


    private boolean checkParameterNotNull(String account, String password) {
        if (TextUtils.isEmpty(account)||TextUtils.isEmpty(password)){
            return false;
        }
        return true;
    }

    @Override
    public void attachView(LoginView v) {
        mView=v;
    }

    @Override
    public void detachView(LoginView v) {
        mView=null;
        if (isSubscribed()){
            subscription.unsubscribe();
        }
    }

    private boolean isSubscribed() {
        return subscription!=null&&!subscription.isUnsubscribed();
    }

    private void loginByNet(final String account, final String password) {
        subscription=RetrofitService.retrofit().create(UserApi.class)
                .login()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        mView.loginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MVE","登陆失败");
                        mView.loginFail(e.getMessage().toString());
                    }

                    @Override
                    public void onNext(User user) {
                        if (isRememberPassword){
                            saveAccountAndPassword(account,password);
                        }else {
                            clearPassword(account);
                        }
                    }
                });
    }
}
