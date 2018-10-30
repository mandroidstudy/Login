package android.coolweather.com.login.presenter;

import android.coolweather.com.login.view.LoginView;

/**
 * Author:Mao
 * Time:2018/10/30  15:25
 * Description:LoginPresenter
 */
public interface LoginPresenter extends BasePresenter<LoginView> {
    /*
    * @param account 账号
    * @param password 密码
    * @param isChecked 是否记住密码 true 记住
    * */
    void login(String account,String password,boolean isChecked);
    //保存账户密码
    void saveAccountAndPassword(String account,String password);
    //清除账户密码
    void clearPassword(String account);
}
