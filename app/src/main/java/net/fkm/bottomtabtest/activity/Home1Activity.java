package net.fkm.bottomtabtest.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import net.fkm.bottomtabtest.R;
import net.fkm.bottomtabtest.fragment.HomeFragment;
import net.fkm.bottomtabtest.fragment.MessageFragment;
import net.fkm.bottomtabtest.fragment.MineFragment;
import net.fkm.bottomtabtest.utils.ToastUtil;


public class Home1Activity extends BaseActivity implements View.OnClickListener {

    public static Home1Activity instance;

    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private Fragment mCommonFragmentOne;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private ImageView mHomeView;
    private TextView home_text_view;
    private ImageView mMessageView;
    private TextView message_text_view;
    private ImageView mMineView;
    private TextView mine_text_view;

    private long exitTime = 0;

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_home1_layout;
    }

    @Override
    protected void initView() {

        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (ImageView) findViewById(R.id.home_image_view);
        home_text_view = (TextView) findViewById(R.id.home_text_view);
        mMessageView = (ImageView) findViewById(R.id.message_image_view);
        message_text_view = (TextView) findViewById(R.id.message_text_view);
        mMineView = (ImageView) findViewById(R.id.mine_image_view);
        mine_text_view = (TextView) findViewById(R.id.mine_text_view);

        mHomeView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_home_selected));
        home_text_view.setTextColor(getResources().getColor(R.color.comui_tab_selected));

        mHomeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();

    }

    @Override
    protected void initData() {

    }

    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.home_layout_view:
                labelSelection(0);
                break;
            case R.id.message_layout_view:
                labelSelection(1);
                break;
            case R.id.mine_layout_view:
                labelSelection(2);
                break;
            default:
                break;
        }
    }

    public void labelSelection(int position) {

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (position) {
            case 0:
                mHomeView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_home_selected));
                home_text_view.setTextColor(getResources().getColor(R.color.comui_tab_selected));
                mMessageView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_message));
                message_text_view.setTextColor(getResources().getColor(R.color.comui_tab));
                mMineView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_person));
                mine_text_view.setTextColor(getResources().getColor(R.color.comui_tab));
                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    mCurrent = mHomeFragment;
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case 1:
                mMessageView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_message_selected));
                message_text_view.setTextColor(getResources().getColor(R.color.comui_tab_selected));
                mHomeView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_home));
                home_text_view.setTextColor(getResources().getColor(R.color.comui_tab));
                mMineView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_person));
                mine_text_view.setTextColor(getResources().getColor(R.color.comui_tab));
                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, mMessageFragment);
                } else {
                    mCurrent = mMessageFragment;
                    fragmentTransaction.show(mMessageFragment);
                }
                break;
            case 2:
                mMineView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_person_selected));
                mine_text_view.setTextColor(getResources().getColor(R.color.comui_tab_selected));
                mHomeView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_home));
                home_text_view.setTextColor(getResources().getColor(R.color.comui_tab));
                mMessageView.setImageDrawable(getResources().getDrawable(R.drawable.comui_tab_message));
                message_text_view.setTextColor(getResources().getColor(R.color.comui_tab));
                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    mCurrent = mMineFragment;
                    fragmentTransaction.show(mMineFragment);
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.showToast("再按一次退出应用");
                exitTime = System.currentTimeMillis();
            } else {
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                startActivity(intent);
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
