package com.liaoinstan.demospring.demo10;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.liaoinstan.demospring.R;
import com.liaoinstan.springview.meituanheader.MeituanFooter;
import com.liaoinstan.springview.meituanheader.MeituanHeader;
import com.liaoinstan.springview.widget.OnFreshListener;
import com.liaoinstan.springview.widget.SpringView;
import com.liaoinstan.springview.widget.Type;

public class Demo10Activity extends AppCompatActivity {

    private SpringView springView;

    //下拉过程动画
    private int[] pullAnimSrcs = new int[]{R.drawable.mt_pull, R.drawable.mt_pull01, R.drawable.mt_pull02, R.drawable.mt_pull03, R.drawable.mt_pull04, R.drawable.mt_pull05};
    //刷新中动画
    private int[] refreshAnimSrcs = new int[]{R.drawable.mt_refreshing01, R.drawable.mt_refreshing02, R.drawable.mt_refreshing03, R.drawable.mt_refreshing04, R.drawable.mt_refreshing05, R.drawable.mt_refreshing06};
    //加载更多底部动画
    private int[] loadingAnimSrcs = new int[]{R.drawable.mt_loading01, R.drawable.mt_loading02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo10);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        springView = findViewById(R.id.springview);
        springView.setType(Type.DRAG);
        springView.setListener(new OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(() -> springView.onFinishFreshAndLoad(), 2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(() -> springView.onFinishFreshAndLoad(), 2000);
            }
        });
        springView.setHeader(new MeituanHeader(this, pullAnimSrcs, refreshAnimSrcs));
        springView.setFooter(new MeituanFooter(this, loadingAnimSrcs));
    }
}
