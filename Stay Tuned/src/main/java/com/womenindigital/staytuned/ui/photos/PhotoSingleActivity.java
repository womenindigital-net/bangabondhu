package com.womenindigital.staytuned.ui.photos;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;
import com.womenindigital.staytuned.Model.Photo;
import com.womenindigital.staytuned.R;
import com.womenindigital.staytuned.ui.ApiFiles.ApiClient;
import com.womenindigital.staytuned.ui.ApiFiles.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoSingleActivity extends AppCompatActivity {
    //private int album;
    private Intent i;
    private ApiInterface apiInterface;
    ViewPager viewPager;
    ImagePagerAdapter adapter;
    public List<Photo> pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_photo);
        // get intent data
        i = getIntent();
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        // Selected image id
        int position = i.getExtras().getInt("id");
        //album = i.getExtras().getInt("album");
        Log.d("TAG","ID"+position+" ");

        if (isOnline()){
            fetchPhotoWithCaption("users","",position);
        }
        else {
            Toast.makeText(PhotoSingleActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void fetchPhotoWithCaption(String type, String key,int id){

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Photo>> call = apiInterface.getPhoto(type, key);
        call.enqueue(new Callback<List<Photo>>() {

            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                //progressBar.setVisibility(View.GONE);
                pictures = response.body();
                adapter =  new ImagePagerAdapter(PhotoSingleActivity.this,pictures);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(id);
                Log.d("test", String.valueOf(id));
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                //progressBar.setVisibility(View.GONE);
                Toast.makeText(PhotoSingleActivity.this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();

            }



        });
    }

    private class ImagePagerAdapter extends PagerAdapter {
        private Context context;
        private List<Photo> pics;
        private LayoutInflater layoutInflater;
        //int[] icon = PicturesFragment.photos;
//        private String[] stringArray = new String[] {
//                " শেখ মুজিবুর রহমান, একজন তরুণ ফুটবল খেলোয়াড়। বাম দিক থেকে তৃতীয় সারি তৃতীয় (১৯৪০)",
//                "শেখ মুজিব কলকাতার ইসলামিয়া কলেজ (বর্তমানে মাওলানা আজাদ কলেজ) পড়ার সময় বাকের সরকারী ছাত্রাবাসের ২৪ নং ঘরে থাকতেন (১৯৪৬)। তাঁর স্মৃতি স্মরণে রাখতে তাঁর ঘরটি যাদুঘরে রূপান্তরিত হয়েছে।",
//                "শেখ মুজিবুর রহমান, তরুণ ছাত্রনেতা (পিছনে দাঁড়িয়ে), মহাত্মা গান্ধী এবং হুসেন-শহীদ সোহরাওয়ার্দী সাথে কলকাতায়। হিন্দু-মুসলিম সাম্প্রদায়িক দাঙ্গার বিরুদ্ধে মহাত্মা গান্ধীর প্রতিবাদের সমর্থন করার জন্য তারা সেখানে ছিল (১৯৪৭)",
//                "শেখ মুজিব তার সহকর্মী শওকত আলীকে হাসপাতালে নিয়ে যাচ্ছিলেন, যিনি সচিবালয়ের সামনে পুলিশ আক্রমণে আহত হয়েছিলেন, বাংলাকে পাকিস্তানের অন্যতম রাষ্ট্রভাষা হিসাবে দাবি করার বিক্ষোভ চলাকালীন (১৯৪৮)",
//                "ঢাকা কেন্দ্রীয় কারাগার থেকে মুক্তিলাভের পর শেখ মুজিবুর রহমানের পথে তার পিতা শেখ লুৎফর রহমান, শামসুল হক, ইয়ার মোহাম্মদ খান ও অন্যদের দ্বারা অনুষঙ্গী আওয়ামী লীগ কর্মী সভায় যোগ দিতে (২৬ জুন, ১৯৪ঌ)",
//                "শেখ মুজিব তার রাজনৈতিক পরামর্শদাতা হুসেইন শহীদ সোহরাওয়ার্দী এর সাথে (১৯৪ঌ)",
//                "শেখ মুজিবুর রহমান তার রাজনৈতিক স্বদেশিদের সাথে (১৯৫২)",
//                "পাকিস্তানের জনপ্রিয় জননেতা শেখ মুজিবুর রহমান ১৯৫২ সালের ২-১২ অক্টোবরে চীনের বেইজিংয়ে অনুষ্ঠিত এশিয়া ও প্রশান্ত মহাসাগরীয় রিম শান্তি সম্মেলনে যোগ দিয়েছেন",
//                "শেখ মুজিবুর রহমান এবং তার সহকারী রাজনৈতিক নেতারা ভাষা আন্দোলনের শহীদদের স্মরণে রাস্তায় নামাজ পড়ছেন (২১ ফেব্রুয়ারি, ১৯৫৩)",
//                "শেখ মুজিবুর রহমান আরমানিটোলা ময়দানে (মাঠ) (আওয়ামী লীগ, ১৯৫৩) আওয়ামী মুসলিম লীগ আয়োজিত জনসভায় ভাষণ দিচ্ছেন",
//                "তাদের নির্বাচনী প্রচারের অংশ হিসাবে শেখ মুজিবুর রহমান এবং হুসেন মায়ান শহীদ সোহরাওয়ার্দী নৌকায় করে রাজশাহীতে ভ্রমণ করছেন (১৯৫৪)",
//                "মুখ্যমন্ত্রী শের-ই-বাংলা এ.কে. ফজলুল হক যুক্তফ্রন্টের ঐতিহাসিক বিজয়ের পরপরই বঙ্গবন্ধু শেখ মুজিবুর রহমানকে মন্ত্রিপরিষদের অন্যতম সদস্য হিসাবে শপথ প্রদান (১৫ মে, ১৯৫৪)",
//                "যুক্তফ্রন্টের মন্ত্রিসভার সদস্যরা - বাম থেকে নীচের সারিতে খায়রাত হোসেন, শেখ মুজিবুর রহমান, শের-ই-বাংলা এ.কে. ফজলুল হক, আতাউর রহমান খান, শরৎচন্দ্র মজুমদার, মাহমুদ আলী। ডান দিক থেকে শীর্ষ সারিতে এম মনসুর আলী, ধীরেন্দ্রনাথ দত্ত, মশিউর রহমান, মনোরঞ্জন ধর এবং আবদুর রহমান খান (১৯৫৪)।",
//                "শেখ মুজিবুর রহমান তার রাজনৈতিক পরামর্শদাতা এবং তত্কালীন পাকিস্তানের প্রধানমন্ত্রী হুসেইন শহীদ সোহরাওয়ার্দীর সাথে (১৯৫৬)",
//                "আওয়ামী লীগের সাধারণ সম্পাদক শেখ মুজিবুর রহমান চীনের প্রধানমন্ত্রী চৌ এনলাইয়ের (ঝো এনালাই) ঢাকায় দর্শন সময় স্বাগত বক্তব্য পাঠ করেছেন।। পাকিস্তানের প্রধানমন্ত্রী হুসেইন শহীদ সুহুরওয়ার্দী উপস্থিত ছিলেন (ফেব্রুয়ারি ২৬, ১৯৫৬)",
//                "শেখ মুজিবুর রহমান টাঙ্গাইলের কাগমারীতে আফ্রো-এশীয় সাংস্কৃতিক সম্মেলনে অংশ নিচ্ছেন, মাওলানা ভাসানী, হুসেন মায়ান শহীদ সোহরাওয়ার্দী এবং তোফাজ্জল হোসেন মানিক মিয়াকে নিয়ে (১৯৫৭ সালের ফেব্রুয়ারি)",
//                "শেখ মুজিবুর রহমান পূর্ব পাকিস্তানের গভর্নর শের-ই-বাংলা এ.কে. ফজলুল হক এবং মুখ্যমন্ত্রী আতাউর রহমান খান (৭ জুন, ১৯৫৭)",
//                "মুখ্যমন্ত্রী আতাউর রহমান খান এবং মন্ত্রী শেখ মুজিবুর রহমান ভারতের রাষ্ট্রপতি রাজেন্দ্র প্রসাদের সাথে ভারতের নয়াদিল্লি, আনুষ্ঠানিক সফরে (১৯৫৭)",
//                "শেখ মুজিবুর রহমান মাও তু তুং (মাও সেতুং), রাষ্ট্রপ্রধান এবং চীনের কমিউনিস্ট পার্টির চেয়ারম্যানের সাথে (অক্টোবর, ১৯৫৭)",
//                "শেখ মুজিবুর রহমান কারাগার থেকে হুসেইন শহীদ সোহরাওয়ার্দীকে মুক্তি দেওয়ার পরে আইয়ুব খানের স্বৈরাচারী শাসনের নিন্দা জানিয়ে একটি সমাবেশে জ্বলন্ত বক্তব্য দিচ্ছিলেন (১০ সেপ্টেম্বর, ১৯৬২)",
//                "শেখ মুজিবুর রহমান পাকিস্তানি সামরিক স্বৈরশাসক আইয়ুব খান কর্তৃক আরোপিত Elective Bodies’ Disqualification Order (EBDO) এর প্রতিবাদে বৈঠকে বক্তব্য রাখছিলেন (১৯৬২) ",
//                "ভাষা শহীদদের স্মরণে শোক র\u200C্যালির সময় শেখ মুজিবুর রহমান মাওলানা আবদুল হামিদ খান ভাসানী, মহিউদ্দিন আহমেদ এবং তাজউদ্দীন আহমদের সাথে (ফেব্রুয়ারী ২১, ১৯৬৪)",
//                "বিশেষ ট্রাইব্যুনাল যাওয়ার পথে শেখ মুজিবুর রহমান ঢাকা সেনানিবাসে সেট আপ আগরতলা ষড়যন্ত্র মামলার চেষ্টা (১৯৬৯)",
//                "বঙ্গবন্ধু শেখ মুজিব আগরতলা ষড়যন্ত্র মামলা প্রত্যাহার ও কারাগার থেকে মুক্তি পাওয়ার পরে তার কন্যা শেখ হাসিনার সাথে হাসি হাসতে দেখেন। তাদের সাথে রয়েছেন তাঁর স্ত্রী শেখ ফজিলাতুন্নেছা মুজিব ও ছেলে শেখ কামাল (১৯৬৯)",
//                "বঙ্গবন্ধু শেখ মুজিবুর রহমান এবং তাঁর পরিবার সফররত ভারতের প্রধানমন্ত্রী ইন্দিরা গান্ধীর সাথে (১৮ মার্চ, ১৯৭২)"};

        //public ImagePagerAdapter(Context context) {
//            this.context = context;
//        }

        public ImagePagerAdapter(Context context, List<Photo> pics) {
            this.context = context;
            this.pics = pics;
        }

        @Override
        public int getCount() {
            return pics.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            final Photo contact = pics.get(position);
            final String i=contact.getId();

            LayoutInflater inflater = LayoutInflater.from(context);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.activity_image_with_text,container,false);


            ImageView imageView = (ImageView) layout.findViewById(R.id.image);
            //TextView textView=(TextView)layout.findViewById(R.id.caption);


            Context context = PhotoSingleActivity.this;
            //ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//            int totalHeight = layout.getHeight();
//            int totalWidth = (layout.getWidth() - 20);
            //Log.d("TAG", totalHeight +"  "+totalWidth);
//            URL newurl = null;
//            try {
//                newurl = new URL("http://dynamichubscom.ipage.com/wid_bongobondhu/photo/photo" + i + ".png");
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            Bitmap mIcon_val = null;
//            try {
//                mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            imageView.setImageBitmap(mIcon_val);
            Picasso.get()
                    .load("http://dynamichubscom.ipage.com/wid_bongobondhu/photo/photo" + i + ".png")
                    //.resize(600,400)
                    .into(imageView);
            //imageView.setImageResource(icon[position]);

            TextView txt=(TextView) layout.findViewById(R.id.caption);
            //txt.setText(stringArray[position]);

            ((ViewPager) container).addView(layout, 0);
            Log.d("test2", String.valueOf(position));
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            ((ViewPager) container).removeView((LinearLayout) object);

        }
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}

