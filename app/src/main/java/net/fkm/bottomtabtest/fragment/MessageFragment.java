package net.fkm.bottomtabtest.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.fkm.bottomtabtest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MessageFragment extends BaseFragment {

    public static final String BUNDLE_TITLE = "title";

    private View mContentView;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_message_layout, container, false);
        initView();
        return mContentView;
    }

    private void initView() {
        unbinder = ButterKnife.bind(this, mContentView);
    }

    @OnClick({})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public static MessageFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}