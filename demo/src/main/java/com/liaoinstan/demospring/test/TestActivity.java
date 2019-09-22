package com.liaoinstan.demospring.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.liaoinstan.demospring.R;
import com.liaoinstan.springview.widget.Give;
import com.liaoinstan.springview.widget.OnFreshListener;
import com.liaoinstan.springview.widget.SpringView;
import com.liaoinstan.springview.widget.Type;

public class TestActivity extends Activity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    private SpringView springView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ((RadioGroup) findViewById(R.id.group_type)).setOnCheckedChangeListener(this);
        ((RadioGroup) findViewById(R.id.group_give)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.check_enableheader)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.check_enableFooter)).setOnCheckedChangeListener(this);


        springView = findViewById(R.id.my);
        springView.setListener(new OnFreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(TestActivity.this, "onRefresh", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(() -> springView.onFinishFreshAndLoad(), 1000);
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(TestActivity.this, "onLoadmore", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(() -> springView.onFinishFreshAndLoad(), 1000);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.overlap:
                springView.setType(Type.OVERLAP);
                break;
            case R.id.follow:
                springView.setType(Type.FOLLOW);
                break;
            case R.id.drag:
                springView.setType(Type.DRAG);
                break;
            case R.id.both:
                springView.setGive(Give.BOTH);
                break;
            case R.id.top:
                springView.setGive(Give.TOP);
                break;
            case R.id.bottom:
                springView.setGive(Give.BOTTOM);
                break;
            case R.id.none:
                springView.setGive(Give.NONE);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.check_enableheader:
                springView.setEnableHeader(!isChecked);
                break;
            case R.id.check_enableFooter:
                springView.setEnableFooter(!isChecked);
                break;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_callfresh:
                springView.callFresh();
                break;
        }
    }
}

