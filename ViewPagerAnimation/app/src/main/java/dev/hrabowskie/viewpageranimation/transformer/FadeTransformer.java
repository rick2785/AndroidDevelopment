package dev.hrabowskie.viewpageranimation.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by rickeyhrabowskie on 3/29/17.
 */

public class FadeTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        page.setTranslationX(page.getWidth()*-position);

        if(position<= -1 || position >= 1)
            page.setAlpha(0);
        else if(position == 0)
            page.setAlpha(1);
        else
            page.setAlpha(1-Math.abs(position));
    }
}
