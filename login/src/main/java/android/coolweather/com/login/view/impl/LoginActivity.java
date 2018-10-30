package android.coolweather.com.login.view.impl;

import android.app.Activity;
import android.coolweather.com.login.R;
import android.coolweather.com.login.presenter.LoginPresenter;
import android.coolweather.com.login.presenter.impl.LoginPresenterImpl;
import android.coolweather.com.login.view.LoginView;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements LoginView{
    private EditText et_account;
    private EditText et_password;
    private CheckBox checkBox_password;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        presenter=new LoginPresenterImpl();
        presenter.attachView(this);
    }

    private void initView() {
        et_account=findViewById(R.id.et_account);
        et_password=findViewById(R.id.et_password);
        checkBox_password=findViewById(R.id.checkBox_password);

    }

    public void login(View v){
        String account=et_account.getText().toString().trim();
        String password=et_password.getText().toString().trim();
        presenter.login(account,password,checkBox_password.isChecked());
    }

    @Override
    public void loginFail(String msg) {
        Toast.makeText(this,"登陆失败："+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(this);
    }
}
