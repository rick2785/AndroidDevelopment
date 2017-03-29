package dev.hrabowskie.loadimageurl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    String url = "http://www.1080x1920wallpapers.com/1080x1920-backgrounds/1080x1920-wallpapers-2/1080x1920-HD-wallpapers-samsung-htc-android-smartphone-3508vnkr6-1080P.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        loadImageFromUrl(url);
    }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher) // optional
        .error(R.mipmap.ic_launcher) // if error
        .into(imageView,new com.squareup.picasso.Callback(){

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }
}
