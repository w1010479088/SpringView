package com.liaoinstan.springview.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * header/footer核心接口
 */
public interface DragHandler {
    View getView(LayoutInflater inflater, ViewGroup viewGroup);

    int getDragLimitHeight(View rootView);

    int getDragMaxHeight(View rootView);

    int getDragSpringHeight(View rootView);

    /**
     * 即将开始拖拽时的回调，可进行初始化操作
     */
    void onPreDrag(View rootView);

    /**
     * 手指拖动控件过程中的回调，用户可以根据拖动的距离添加拖动过程动画
     *
     * @param dy 拖动距离，下拉为+，上拉为-
     */
    void onDropAnim(View rootView, int dy);

    /**
     * 手指拖动控件过程中每次抵达临界点时的回调，用户可以根据手指方向设置临界动画
     *
     * @param upORdown 是上拉还是下拉 true(上)，false(下)
     */
    void onLimitDes(View rootView, boolean upORdown);

    /**
     * 拉动超过临界点后松开时回调
     */
    void onStartAnim();

    /**
     * 头(尾)已经全部弹回时回调
     */
    void onFinishAnim();

    /**
     * 收场动画执行时间
     */
    int getEndingAnimTime();

    /**
     * 收场动画回弹高度
     */
    int getEndingAnimHeight(View rootView);

    /**
     * 收场动画开始执行
     */
    void onEndingAnimStart();

    /**
     * 收场动画结束执行
     */
    void onEndingAnimEnd();
}
