package dev.hrabowskie.multianimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnAnim;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnim = (Button)findViewById(R.id.btnAnimation);
        imgView = (ImageView)findViewById(R.id.imageView);

        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(imgView,"scaleX",0.5f,1f).setDuration(1000);
//                animatorX.start();
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(imgView,"scaleY",0.5f,1f).setDuration(1000);
//                animatorY.start();
                // Multi Animation
                AnimatorSet animSet = new AnimatorSet();
//                animSet.playTogether(animatorX,animatorY);
                animSet.playSequentially(animatorX,animatorY);
                animSet.setDuration(2000);
                animSet.start();
            }
        });
    }
}
