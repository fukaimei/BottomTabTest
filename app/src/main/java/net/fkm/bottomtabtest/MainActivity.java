package net.fkm.bottomtabtest;

import android.content.Intent;
import android.view.View;

import net.fkm.bottomtabtest.activity.BaseActivity;
import net.fkm.bottomtabtest.activity.Home1Activity;
import net.fkm.bottomtabtest.activity.Home2Activity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_layout;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_01, R.id.btn_02})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                startActivity(new Intent(this, Home1Activity.class));
                overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
                break;
            case R.id.btn_02:
                startActivity(new Intent(this, Home2Activity.class));
                overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
                break;
            default:
                break;
        }
    }

}
