package com.womenindigital.staytuned;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import static com.womenindigital.staytuned.GridQuoteActivity.Q_seventy;
import static com.womenindigital.staytuned.GridQuoteActivity.Q_seventyFive;
import static com.womenindigital.staytuned.GridQuoteActivity.Q_seventyFour;
import static com.womenindigital.staytuned.GridQuoteActivity.Q_seventyOne;
import static com.womenindigital.staytuned.GridQuoteActivity.Q_seventyThree;
import static com.womenindigital.staytuned.GridQuoteActivity.Q_seventyTwo;
import static com.womenindigital.staytuned.GridQuoteActivity.d_seventy;
import static com.womenindigital.staytuned.GridQuoteActivity.d_seventyFive;
import static com.womenindigital.staytuned.GridQuoteActivity.d_seventyFour;
import static com.womenindigital.staytuned.GridQuoteActivity.d_seventyOne;
import static com.womenindigital.staytuned.GridQuoteActivity.d_seventyThree;
import static com.womenindigital.staytuned.GridQuoteActivity.d_seventyTwo;

public class SingleQuoteActivity extends AppCompatActivity {
    TextView quote,date;
    ImageView bellowImage;
    ViewPager viewPager;
    ImagePagerAdapter adapter;
    int pos,year;
    ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_photo);

//        quote = findViewById(R.id.quote);
//        date = findViewById(R.id.date);
//        bellowImage = findViewById(R.id.bellowImage);
        // get intent data
        Intent i = getIntent();

        // Selected image id
        pos = i.getExtras().getInt("id");
        year = i.getExtras().getInt("year");
        Log.d("tag", "id: "+String.valueOf(pos)+"section: "+String.valueOf(year));

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ImagePagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);


    }
    private class ImagePagerAdapter extends PagerAdapter {
        private Context context;
        private LayoutInflater layoutInflater;
        int[] icon0 = GridQuoteActivity.I_seventy;
        int[] icon1 = GridQuoteActivity.I_seventyOne;
        int[] icon2 = GridQuoteActivity.I_seventyTwo;
        int[] icon3 = GridQuoteActivity.I_seventyThree;
        int[] icon4 = GridQuoteActivity.I_seventyFour;
        int[] icon5 = GridQuoteActivity.I_seventyFive;
        private String[] quote0 = Q_seventy;
        private String[] quote1 = Q_seventyOne;
        private String[] quote2 = Q_seventyTwo;
        private String[] quote3 = Q_seventyThree;
        private String[] quote4 = Q_seventyFour;
        private String[] quote5 = Q_seventyFive;

        private String[] q0 = d_seventy;
        private String[] q1 = d_seventyOne;
        private String[] q2 = d_seventyTwo;
        private String[] q3 = d_seventyThree;
        private String[] q4 = d_seventyFour;
        private String[] q5 = d_seventyFive;

        public ImagePagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            if(year == 70){
                return quote0.length;
            } else if(year == 71){
                return quote1.length;
            } else if(year == 72){
                return quote2.length;
            } else if(year == 73){
                return quote3.length;
            } else if(year == 74){
                return quote4.length;
            } else{
                return quote5.length;
            }
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {

            LayoutInflater inflater = LayoutInflater.from(context);
            if(year == 70 || year == 75){
                layout = (ViewGroup) inflater.inflate(R.layout.activity_single_quote,container,false);

            } else if(year == 71 && (position == 2 || position == 7 || position == 4 || position == 6 || position == 9)){
                layout = (ViewGroup) inflater.inflate(R.layout.activity_single_quote_r_border,container,false);

            } else if(year == 71 && (position == 0 || position == 1 || position == 3 || position == 5 || position == 8
                    || position == 10 || position == 11)){
                layout = (ViewGroup) inflater.inflate(R.layout.activity_single_quote_three ,container,false);

            } else if(year == 73 && (position == 1 || position == 3 || position == 4 || position == 6 || position == 8)){
                layout = (ViewGroup) inflater.inflate(R.layout.activity_single_quote_r_border,container,false);

            } else if(year == 73 && (position == 0 || position == 2 || position == 5 || position == 7 || position == 9
                    || position == 10 || position == 11)){
                layout = (ViewGroup) inflater.inflate(R.layout.activity_single_quote_three ,container,false);

            }
            else {
                layout = (ViewGroup) inflater.inflate(R.layout.activity_single_quote_r,container,false);

            }


            //ImageView imageView = (ImageView) layout.findViewById(R.id.image);
            quote = layout.findViewById(R.id.quote);
            date = layout.findViewById(R.id.date);
            bellowImage = layout.findViewById(R.id.bellowImage);
            //TextView textView=(TextView)layout.findViewById(R.id.caption);


            Context context = SingleQuoteActivity.this;
            //ImageView imageView = new ImageView(context);
            bellowImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);



           // TextView txt=(TextView) layout.findViewById(R.id.caption);
           // txt.setText(stringArray[position]);
            if(year == 70){
                quote.setText(quote0[position]);
                date.setText(q0[position]);
                bellowImage.setImageResource(icon0[position]);
            }
            else if(year == 71){
                quote.setText(quote1[position]);
                date.setText(q1[position]);
                bellowImage.setImageResource(icon1[position]);
            }
            else if( year == 72){
                quote.setText(quote2[position]);
                date.setText(q2[position]);
                bellowImage.setImageResource(icon2[position]);
            }
            else if( year == 73) {
                quote.setText(quote3[position]);
                date.setText(q3[position]);
                bellowImage.setImageResource(icon3[position]);
            }
            else if( year == 74) {
                quote.setText(quote4[position]);
                date.setText(q4[position]);
                bellowImage.setImageResource(icon4[position]);
            }
            else if( year == 75) {
                quote.setText(quote5[position]);
                date.setText(q5[position]);
                bellowImage.setImageResource(icon5[position]);
            }


            ((ViewPager) container).addView(layout, 0);
            Log.d("test2", String.valueOf(position));
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            ((ViewPager) container).removeView((RelativeLayout) object);

        }
    }
}