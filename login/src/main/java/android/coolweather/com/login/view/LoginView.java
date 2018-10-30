package android.coolweather.com.login.view;

/**
 * Created by Mao on 2018/10/30.
 */
//LoginActivity特有的UI逻辑
public interface LoginView extends BaseView {
    void loginFail(String msg);
    void loginSuccess();
}
