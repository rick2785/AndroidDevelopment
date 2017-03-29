package dev.hrabowskie.viewpageranimation;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rickeyhrabowskie on 3/29/17.
 */

public class ViewPagerAdapter extends PagerAdapter {
    Activity activity;
    List<PlatformData> data;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Activity activity, List<PlatformData> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.viewpager_item,container,false);

        ImageView imageView = (ImageView)itemView.findViewById(R.id.imageView);
        TextView txtView = (TextView)itemView.findViewById(R.id.txtView);

        //Set image and text
        imageView.setBackgroundResource(data.get(position).getImageId());
        txtView.setText(data.get(position).getName());

        //Add View to container
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}
