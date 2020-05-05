package com.bw.movie.mvp.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.band.RegisteredBand;
import com.bw.movie.band.SendOutEmailCodeBase;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.IContractRegister;
import com.bw.movie.mvp.presenter.PresenterRegister;
import com.bw.movie.util.EncryptUtil;
import com.bw.movie.util.MyRexUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistersActivity extends BaseActivity<PresenterRegister> implements IContractRegister.IView {


    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pwb)
    EditText pwb;
    @BindView(R.id.r_email)
    EditText rEmail;
    @BindView(R.id.r_syz)
    EditText rSyz;
    @BindView(R.id.r_f_email)
    Button rFEmail;
    @BindView(R.id.zc)
    Button zc;

    @Override
    protected PresenterRegister initPresenter() {
        return new PresenterRegister();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_registers;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onSuccess(RegisteredBand bead) {
        Toast.makeText(this, ""+bead.getMessage(), Toast.LENGTH_SHORT).show();
        String status = bead.getStatus();
        if ("0000".equals(status)){

            finish();
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessEmail(SendOutEmailCodeBase bead) {
        String status = bead.getStatus();
        if ("0000".equals(status)){
            Toast.makeText(this, ""+bead.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, ""+bead.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureEmail(Throwable throwable) {
        Toast.makeText(this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }



    @OnClick({R.id.r_f_email, R.id.zc})
    public void onViewClicked(View view) {
        String srEmail = rEmail.getText().toString();
        String nam = name.getText().toString();
        String pw = pwb.getText().toString();
        String yzm = rSyz.getText().toString();

        switch (view.getId()) {
            case R.id.r_f_email:
                boolean b = MyRexUtils.checkEmail(srEmail);
                if (b==true){

                    mPresenter.onDateEmail(srEmail);
                }else {
                    Toast.makeText(this, "电子邮件格式xxx", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.zc:
                String encrypt = EncryptUtil.encrypt(pw);
                mPresenter.onDate(nam,encrypt , srEmail, yzm);

                break;
        }
    }
}
