package com.ydxiaoyuan.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ydxiaoyuan.common.select_dish.Left;
import com.ydxiaoyuan.common.select_dish.Right;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by xdkj on 2016/8/1.
 */
public class ChooseDishesActivity extends SupportActivity {
    int FIRST = 0;
    int SECOND = 1;
    int THIRD = 2;
    SupportActivity[] mFragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dishes);
        if (savedInstanceState == null) {
            mFragments[FIRST] = Left.newInstance();
            mFragments[SECOND] = Right.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]);
        } else {
            // 这里库已经做了Fragment恢复工作，不需要额外的处理
            // 这里我们需要拿到mFragments的引用，用下面的方法查找更方便些，
            // 也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些)
            mFragments[FIRST] = findFragment(Left.class);
            mFragments[SECOND] = findFragment(Right.class);
        }
        //showHideFragment(needShowFragment, needHideFragment);
    }
}
