package dev.hrabowskie.viewpageranimation;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import dev.hrabowskie.viewpageranimation.transformer.FadeTransformer;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter adapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(MainActivity.this,getData());
        pager.setAdapter(adapter);
        pager.setPageTransformer(true,new FadeTransformer());
    }

    private List<PlatformData> getData() {
        List<PlatformData> lstResult = new ArrayList<>();
        PlatformData data = new PlatformData();
        data.name = "Android";
        data.imageId = R.drawable.android;
        lstResult.add(data);

        data = new PlatformData();
        data.name = "iOS";
        data.imageId = R.drawable.ios;
        lstResult.add(data);

        data = new PlatformData();
        data.name = "UWP";
        data.imageId = R.drawable.win10;
        lstResult.add(data);

        return lstResult;
    }
}
