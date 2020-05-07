package com.bw.movie.mvp.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.band.LoginBand;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.IContractLogin;
import com.bw.movie.mvp.presenter.PresenterLogin;
import com.bw.movie.util.EncryptUtil;
import com.bw.movie.util.MyRexUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity<PresenterLogin> implements IContractLogin.IView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.forget_password)
    Button forgetPassword;
    @BindView(R.id.sign_up_now)
    TextView signUpNow;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.we_Chat)
    ImageButton weChat;


    @Override
    protected PresenterLogin initPresenter() {
        return new PresenterLogin();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_lgin;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onSuccess(LoginBand bead) {
        showDialog();
        if ("0000".equals(bead.getStatus())) {
            Toast.makeText(this, "" + bead.getMessage(), Toast.LENGTH_SHORT).show();
            LoginBand.ResultBean result = bead.getResult();
            String sessionId = result.getSessionId();
            int userId = result.getUserId();

            EventBus.getDefault().post(new MessageEvent(sessionId));
            EventBus.getDefault().post(new MessageEvent(userId));
            hideDialog();
            finish();
        }
        Toast.makeText(this, "" + bead.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    @OnClick({R.id.forget_password, R.id.sign_up_now, R.id.login, R.id.we_Chat})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.forget_password:
                break;
            case R.id.sign_up_now:
                BaseActivity.Intents.getIntents().Intent(this, RegistersActivity.class, Bundle.EMPTY);
                break;
            case R.id.login:

                String e = username.getText().toString();
                String mm = password.getText().toString();
                String jmm = EncryptUtil.encrypt(mm);
                boolean b = MyRexUtils.checkEmail(e);
                if (b==true){

                    Log.d("mm", "onViewClicked: "+jmm);
                    mPresenter.onDate(e, jmm);
                }else {
                    Toast.makeText(this, "电子邮件格式xxx", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.we_Chat:
                break;
        }
    }
    public class MessageEvent {
        public String sessionId;
        public int userId;

        public MessageEvent(String aName) {
            this.sessionId = aName;
        }

        public MessageEvent(int aName) {
            this.userId = aName;
        }
    }

}
