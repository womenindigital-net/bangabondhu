package com.womenindigital.staytuned;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GridQuoteActivity extends AppCompatActivity {


    private GridView photoGrid;
    private int mPhotoSize, mPhotoSpacing;
    private ImageAdapter imageAdapter;
    private Intent i;
    int year;

    // Some items to add to the GRID
    //70
    static final String[] Q_seventy = {
            "ছয়দফা মুসলিম হিন্দু খৃস্টান বৌদ্ধদের নিয়ে গঠিত বাঙালি জাতির স্বকীয় মহিমায় আত্মপ্রকাশ আর নির্ভরশীলতা অর্জনের চাবিকাঠি।",
            "কারও প্রতি বিদ্বেষ নয়, সকলের প্রতি বন্ধুত্ব-এই নীতির ভিত্তিতে বিশ্বের সকল রাষ্ট্রের সাথে, বিশেষ করে প্রতিবেশী রাষ্ট্রসমূহের সাথে আমারা শান্তিপূর্ণ সহাবস্থানে বিশ্বাসী।",
            "কোন জাতি কোন দিনিই আত্মাহুতি না দিয়ে মুক্তি ও ন্যায় বিচার পায়নি।",
            "লেবেলসর্বস্ব ইসলামে আমরা বিশ্বাসী নই। আমরা বিশ্বাসী ইনসাফের ইসলামে। আমাদের ইসলাম হযরত রাসূলে করিম (সা.)- এর ইসলাম, যে ইসলাম জগদ্বাসীকে শিক্ষা দিয়েছে ন্যায় ও সুবিচারের অমোঘ মন্ত্র।",
            "কায়েমি স্বার্থসম্পন্ন মহলের হাত থেকে দেশবাসীর স্বার্থ ও অধিকার ছিনিয়ে আনতে শক্তি আমর চাই-ই চাই। সে শক্তি যোগাতে পারেন কেবল মাত্র আপনারাই।"};
    static final String[] d_seventy = {
            "নভেম্বর ১৯৭০\nসাধারণ নির্বাচনের আগে প্রদত্ত বেতার ভাষণ",
            "১৯৭০\nসাধারণ নির্বাচন উপলক্ষ্যে বেতার ও টেলিভিশনে প্রদত্ত ভাষণ",
            "২৮ নভেম্বর ১৯৭০\nআওয়ামীলীগের সভাপতি হিসেবে বেতার ও টেলিভিশনে বক্তৃতা",
            "নভেম্বর ১৯৭০ \nসাধারণ নির্বাচনের আগে বেতার ও টেলিভিষনে দেওয়া ভাষণ",
            "৬ ডেসেম্বর ১৯৭০\nনির্বাচনের প্রাক্কালে দেশবাসীর উদ্দেশে ভাষণ।"};
    static final String[] D_seventy = {
            "নভেম্বর ১৯৭০", "১৯৭০",
            "২৮ নভেম্বর ১৯৭০",
            "নভেম্বর ১৯৭০","৬ ডেসেম্বর ১৯৭০"};
    static final int[] I_seventy = { R.drawable.skitch1,R.drawable.skitch2,R.drawable.skitch3,R.drawable.skitch4,R.drawable.skitch5};

    //71
    static final String[] Q_seventyOne = {
            "মুক্তিকামী মানুষ, বিশ্বের সবখানে যারা প্রাণপণ লড়াই করে যাচ্ছেন মুক্তির জন্য আমাদের সংগ্রামকেও তাদের নিজেদের বলে গণ্য করা উচিত।",
            "গান গাইতে হবে এই বাংলার মাটির, বাংলার গণমানুষের। তবেই গড়ে উঠবে গণমানুষের স্বীকৃতি।",
            "বাংলা দেশের মুক্তির স্পৃহাকে স্তব্ধ করা যাবে না।",
            "শক্তির সাহায্যে যারা শাসনের চক্রান্ত করে তাদের বিরুদ্ধে দৃঢ়কল্প ও সংঘবদ্ধ জনশক্তি কেমন করে মুক্তির দুর্জয় দুর্গ গড়ে তোলে- আমাদের জনগণ তা প্রমাণ করেছে।",
            "মুক্তি অর্জনে বাংলার মানুষ অটল থাকবে।",
            "রক্ত যখন দিয়েছি রক্ত আরও দেব। এদেশের মানুষকে মুক্ত করে ছাড়ব, ইনশাল্লাহ। এবারের সংগ্রাম আমাদের মুক্তির সংগ্রাম, এবারের সংগ্রাম স্বাধীনতার সংগ্রাম। ",
            "আমার শক্তি এটাই যে আমি আমার জনগণকে ভালোবাসি। আর আমার দুর্বলাত, আমি এদের প্রাণের চেয়েও বেশি ভালোবাসি।",
            "যতদিন পর্যন্ত বাংলা থাকবে, বাংলার আকাশ থাকবে, বাংলার মাটি থাকবে, বাংলার মানুষ বেঁচে থাকবে, ততদিন পর্যন্ত একুশের শহীদদের কথা কেউ ভুলতে পারবে না।",
            "আমি প্রধানমন্ত্রিত্ব চাই না, দেশের মানুষের অধিকার চাই।",
            "মুক্তির লক্ষ্যে না পৌঁছা পর্যন্ত আমাদের সংগ্রাম নবতর উদ্দীপন নিয়ে অব্যাহত থাকবে।",
            "প্রয়োজনবোধে শিল্পীদের বিপ্লবের গান গাইতে হবে।",
            "আমার মৃত্যু হলেও আমি আপাদের সাথে বেইমানি করতে পারব না। রক্ত দিয়ে হলেও আমি আপনাদের ঋণ শোধ করব।"};
    static final String[] d_seventyOne = {
            "১৫ মার্চ ১৯৭১\nদৈনিক পূর্বদেশ",
            "২৪ জানুয়ারি ১৯৭১\nসঙ্গীত শিল্পীদের সংবর্ধনার জবাবে",
            "১৫ মার্চ ১৯৭১\nদৈনিক পূর্বদেশ",
            "২৫ মার্চ ১৯৭১\nদৈনিক পূর্বদেশ",
            "১১ মার্চ ১৯৭১\nদৈনিক সংবাদ",
            "৭ মার্চ ১৯৭১\nরেসকোর্স  ময়দানে প্রদত্ত ঐতিহাসিক ভাষণ",
            "১১ জানুয়ারী ১৯৭১",
            "২১ এ ফ্রেব্রুয়ারী ১৯৭১",
            "৭ মার্চ ১৯৭১ \nরেসকোর্স ময়দানে প্রদত্ব ঐতিহাসিক ভাষণ",
            "১৫ মার্চ ১৯৭১\nদৈনিক পূর্বদেশ",
            "২৪ জানুয়ারী ১৯৭১\nসঙ্গীত শিল্পীদের সংবর্ধনার জবাবে",
            "৩ মার্চ ১৯৭১\nপল্টন ময়দানে প্রদত্ব ভাষণ"};
    static final String[] D_seventyOne = {
            "১৫ মার্চ ১৯৭১","২৪ জানুয়ারি ১৯৭১",
            "১৫ মার্চ ১৯৭১","২৫ মার্চ ১৯৭১",
            "১১ মার্চ ১৯৭১","৭ মার্চ ১৯৭১",
            "১১ জানুয়ারী ১৯৭১","২১ এ ফ্রেব্রুয়ারী ১৯৭১",
            "৭ মার্চ ১৯৭১ ","১৫ মার্চ ১৯৭১",
            "২৪ জানুয়ারী ১৯৭১","৩ মার্চ ১৯৭১"};
    static final int[] I_seventyOne = {  R.drawable.black_2, R.drawable.black_7, R.drawable.black_3,
            R.drawable.black_4, R.drawable.black_5,R.drawable.black_6,R.drawable.black_1, R.drawable.black_8,
            R.drawable.black_9,R.drawable.black_10, R.drawable.black_11,R.drawable.black_2};
    //72
    static final String[] Q_seventyTwo = {
            "ফাঁসির মঞ্চে যাওয়ার সময় আমি বলব আমি বাঙালি, বাংলার আমার দেশ বাংলা আমার ভাষা। জয় বাংলা।",
            "স্বাধীনতা ভোগ করার অধিকার তারই আছে যে স্বাধীনতার মর্যাদা রক্ষা করতে জানে।",
            "তোমার ধর্ম তেমার কাছে, আমার ধর্ম আমার কাছে-এটাই হলো ধর্মনিরপেক্ষ রাষ্ট্র। বাংলাদেশ তাই থাকবে; তাই আমি আশা করি।",
            "ধর্ম অতি পবিত্র জিনিস। পবিত্র ধর্মকে রাজনৈতিক হাতিয়ার হিসাবে ব্যবহার করা চলবে না।",
            "শ্মশান বাংলাকে আমরা সোনার বাংলায় গড়ে তুলতে চাই। যে বাংলায় আগামী দিনের মায়েরা হাসবে, শিশুরা খেলবে আমরা শোষণমুক্ত সমাজ গড়ে তুলব।",
            "আমরা জাতিয়তাবাদ শোষিতের জাতীয়তাবাদ, যার নেতৃত্বে রয়েছে কৃষক, শ্রমিক, ছাত্র ও বুদ্ধিজীবি শ্রেণীর সমন্বয়ে গঠিত আওয়ামী লীগ।",
            "সাড়ে সাত কোটি বাঙালি আমার শক্তির উৎস।",
            "আন্তর্জাতিক শান্তি ও সংহতি সুদৃঢ় করা আমাদের সংবিধানের অন্যতম অনুশাসন।",
            "একচেটিয়া পুঁজিবাদ, সামন্তবাদ, সাম্রাজ্যবাদ, উপনিবেশবাদ ও নয়া-উপনিবেশবাদ এবং আমলাতন্ত্রবাদ ও জঙ্গিবাদ উগ্র ও সংকীর্ণ জাতিয়তাবাদরে মূল শক্তি।",
            "একটি শান্তিপূর্ণ সহাবস্থানে আমরা বিশ্বাস করি – আমরা যুদ্ধে বিশ্বাস করি না।",
            "ভিক্ষা করে কোন জাতি বাঁচতে পারে না। নিজের স্বাবলম্বী হতে হবে।",
            "দেশ গড়ার কাজে কেউ আমাদের সাহায্য করতে চাইলে তা আমরা গ্রহণ করব। কিন্তু সে সাহয্য অবশ্যই হতে হবে নিষ্কন্টক, শর্তহীন।",
            "ভবিষ্যৎ বংশধররা যদি সমাজতন্ত্র,গণতন্ত্র জাতীয়তাবাদ এবং ধর্মনিরপেক্ষতার ভিত্তিতে শোষণহীন সমাজ প্রতিষ্ঠা করতে পারে, তাহলে আমার জীবন স্বার্থক হবে।",
            "শৃঙ্খলা ফিরে না আসলে কোনো জাতি বড় হতে পারে না। সততা ফিরে না আসলে কোনো জাতি বড় হতে পারেনা।",
            "আমি চাই কাজ। আমি চাই আমার চিন্তাধারার বাস্তব রূপায়ণ। আমি চাই শোষণমুক্ত গণতান্ত্রিক বাংলাদেশ।",
            "আমি কোনো দিন বিশ্বাস করি না, আমাদের বাংলাদেশের মানুষও বিশ্বাস করে না যে, বন্দুকের নলই শক্তির উৎস। আমরা বিশ্বাস করি জনগণই হলো শক্তির উৎস।",
            "একটি নতুন বিশ্ব গড়ে তোলার স্বপ্নে আমরা বিভোর। একটি সামাজিক বিপ্লব সফল করার প্রতিশ্রুতিতে আমরা অটল। আমাদের সমস্ত নীতি, আমাদের সমস্ত কর্মপ্রচেষ্টা এ কাজে নিয়োজিত হবে।",
            "যে সব লোক পাকিস্তানি সৈন্যদের সমর্থন করেছে, আমাদের লোকদের হত্যা করতে সাহায্য করেছে, তাদের ক্ষমা করা হবে না। সঠিক বিচারের মাধ্যমে তাদের শাস্তি দেয়া হবে।",
            "যে জাতি একবার জেগে ওঠে, যে জাতি মুক্তিপাগল, যে জাতি স্বাধীনতাকে ভালোবাসে, সে জাতিকে বন্দুক-কামান দিয়ে দাবায়ে রাখা যায় না।",
            "আমদের শিক্ষা হবে গণমুখী শিক্ষা।",
            "বাংলার সভ্যতা, বাঙালি জাতি এ নিয়ে হলো বাঙালি জাতীয়তাবাদ। বাংলার বুকে বাঙালি জাতীয়তাবাদ থাকবে।",
            "যে জাতি রক্ত দিয়ে স্বাধীনতা এনেছে, সে জাতি কারও কাছে মাথা নত করতে জানে না।",
            "অস্ত্রের যুদ্ধ শেষ হয়েছে। এবার মুক্তির সংগ্রাম কে দেশ গড়ার সংগ্রামে রূপান্তরিত করতে হবে। মুক্তির সংগ্রামের চেয়ে দেশ গড়ার সংগ্রাম কঠিন।",
            "আমি জানতাম, আমাদের সংগঠনের শক্তি আছে। আমি একটি শক্তিশালী সংগঠনকে জীবন ব্যাপি গড়ে তুলেছিলাম। জনগন তার ভিত্তি। আমি জানতাম, তাঁরা শেষ পর্যন্ত লড়াই করবে।",
            "এই রাষ্ট্রের মানুষ হবে বাঙ্গালি। তাদের মূল মন্ত্র সবার উপরে মানুষ সত্য, তাহার উপরে নাই।",
            "রাজনৈতিক উদ্দেশ্য হাসিলের জন্য ধর্মকে বাংলার বুকে ব্যবহার করতে দেওয়া যাবে না।",
            "যে চারটা স্তম্বের উপর বাংলার স্বধীনতা আন্দোলন হয়েছে সেই চারটা স্তম্ভের উপরেই বাংলার স্বাধীনতা চলাবে - জাতীয়তাবাদ, গনতন্ত্র, সমাজতন্ত্র এবং ধর্মনিরপেক্ষ রাষ্ট্র।",
            "স্বাধীনতা মানে মানুষ – মুক্ত দেশের মুক্ত মানুষ। তারা সসম্মানে ইজ্জতের সঙ্গে বাস করবে এবং তারা মানুষের মতো বাস করবে।",
            "দুনিয়ার যেখানেই মজলুম মানুষ সাম্রাজ্যবাদের বিরুদ্ধে সংগ্রাম করবে, আমরা নিশ্চই তার পাশে গিয়ে দাড়াব।",
            "নেতৃত্ব আসে সংগ্রামের প্রতিক্রিয়ার মাধ্যমে। কেউ আকস্মিকভাবে একদিনে নেতা হতে পারে না।",
            "যে জাতি আইনশৃক্ষলা রক্ষা করতে জানে না সে জাতি কোন দিন বড় হতে পারে না।",
            "আমরা সাহয্য চাই, কিন্তু স্বাধীনতা বিক্রি করে সাহায্য চাই না।",
            "স্বাধীনতা লাভ করা যেমন কঠিন স্বধীনতা রক্ষা করাও তেমন কঠিন।",
            "রাজনৈতিক স্বাধীনতার সঙ্গে সঙ্গে অর্থনৈতিক স্বাধীনতাও দরকার।",
            "আমরা জাতীয় সার্বভৌমত্ব এবং সব জাতির সমমর্যাদা নীতিতে আগ্রহী।",
            "সমৃদ্ধির পথে কোন সংক্ষিপ্ত রাস্তা নেই।",
            "কৃষকের সঙ্গে সংশ্লিষ্ট থেকে আমি জানি শোষণ কাকে বলে।",
            "আমার দেশ স্বাধীন হয়েছে। আমার পতাকা আজ দুনিয়ার আকাশে ওড়ে। আজ আমি বলতে পারি বাঙালি একটি জাতি। আজ আমি বলতে পারি বাংলার মাটি আমার মাটি।",
            "আমার বিশ্বাস মানুষ মৃত্যু বরণ করবে সাহসের সঙ্গে।",
            "সাম্প্রদায়িকতাবাদ নির্মূল করার রণকৌশল হিসাবেই আমি জাতিয়তাবাদী দর্শণ অনুসরণ করেছি। এই মতবাদ কার্যকর হলে, আমার বিশ্বাস, বাংলাদেশ ভাবীকালের মানুষ ক্রমে ক্রমে জাতীয়তাবাদের গণ্ডি পার হয়ে উত্তীর্ণ হবে বিশ্বমানবতাবদী উদার দৃষ্টিভঙ্গিতে।"};

    static final String[] d_seventyTwo = {
            "১০ জানুয়ারি ১৯৭২\nসোহরাওয়ার্দী উদ্যানে জাতির উদ্দেশে প্রদত্ত ভাষণ",
            "১৬ জুলাই ১৯৭২\nঢাকা সাংবাদিক ইউনিয়নের বার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "২৬ জুন ১৯৭২\nমাইজদিতে প্রদত্ত ভাষণ",
            "৪ নভেম্বর ১৯৭২\nজাতীয় সংসদে ভাষণ",
            "২৬ মার্চ ১৯৭২\nজাতির উদ্দেশে বেতার ও টেলিভিশনে প্রদত্ত ভাষণ",
            "মুজিববাদ, খোন্দকার মোহম্মদ ইলিয়াস, ১৯৭২",
            "৩০ মার্চ ১৯৭২\nচট্টগ্রামের জনসভায় বক্তৃতা",
            "১০ অক্টোবর ১৯৭২\nবিশ্ব শান্তি পরিষদে জুলিও কুরি শান্তি পুরষ্কার গ্রহণের প্রাক্কালে প্রদত্ত ভাষণ",
            "মুজিববাদ, খোন্দকার মোহাম্মদ ইলিয়াস, ১৯৭২",
            "৯ এপ্রিল ১৯৭২\nছাত্র ইউনিয়নের ত্রয়োদশ কাউন্সিলে দেওয়া ভাষণ",
            "২৬ ডিসেম্বর ১৯৭২\nযাশোর স্টেডিয়ামে দেওয়া ভাষণ",
            "২৬ মার্চ ১৯৭২\nজাতির উদ্দেশে বেতার ও টেলিভিশনে প্রদত্ত ভাষণ",
            "৪ নভেম্বর ১৯৭২ \nজাতীয় সংসদে ভাষণ",
            "৯ অক্টোবর ১৯৭২\nঢাকার পিজি হাসপাতালে দেওয়া ভাষণ",
            "মুজিববাদ, খোন্দকার মোহাম্মদ ইলিয়াস, ১৯৭২",
            "২০ নভেম্বর ১৯৭২ \nঢাকায় দেওয়া ভাষণ",
            "২৬ মার্চ ১৯৭২\nজাতীয়করণের নীতি ঘোষণা উপলক্ষে বেতার ও টেলিভিশনে প্রদত্ত ভাষণ",
            "১০ জানুয়ারি ১৯৭২\nসোহরাওয়ার্দী উদ্যানে জাতির উদ্দেশে প্রদত্ত ভাষণ",
            "৫ ফেব্রুয়ারি ১৯৭২\nকলকাতায় রাষ্ট্রীয় সফরে ভাষণ",
            "৯ এপ্রিল ১৯৭২\nছাত্র ইউনিয়নের ত্রয়োদশ কাউন্সিলে দেওয়া ভাষণ",
            "৭ জুন ১৯৭২\nসোহরাওয়ার্দী উদ্যানে প্রদত্ত ভাষণ",
            "২৬ জুন ১৯৭২\nমাইজদিতে পদত্ত ভাষণ",
            "৩০ জানুয়ারি ১৯৭২\nঢাকা স্টেডিয়ামে মুক্তিবাহিনীর অস্ত্র সমর্পণ অনুষ্ঠানে বক্তৃতা",
            "১৯৭২ ডেভিট ফ্রস্টের সঙ্গে সাক্ষাৎকার",
            "২৪ জানুয়ারী ১৯৭২\nটাঙ্গাইলের জনসভায় প্রদত্ত ভাষণ",
            "১১ এপ্রিল ১৯৭২\nগণপরিষদ অধিবেষনে বিশেষ অধিকার প্রসঙ্গে",
            "৯ এপ্রিল ১৯৭২\nছাত্র ইউনিয়নের ত্রয়োদশ কাউন্সিলে দেওয়া ভাষণ।",
            "১৬ জানুয়ারী ১৯৭২ \nপ্রেসিডেন্ট ভবনে বাস্তুহারাদের উদ্দেশ্যে ভাষণ",
            "৯ এপ্রিল ১৯৭২ \nআওয়ামী লীগের কাউন্সিলে দেওয়া বক্তৃতা",
            "১৯৭২\nডেভিড ফ্রস্টের সঙ্গে সাক্ষাৎকার",
            "২৬ জুলাই ১৯৭২\nআদমজীনগরে দেওয়া ভাষণ",
            "২৪ জানুয়ারী ১৯৭২\nটাঙ্গাইলে জনসভায় প্রতত্ব ভাষণ",
            "৩০ জানুয়ারী ১৯৭২\nঢাকা স্টেডিয়ামে মুক্তিবাহিনীর অস্ত্রসমর্পণ অনুষ্ঠানে বক্তৃতা",
            "২৬ মার্চ ১৯৭২ \nজাতীয় মহিলা ক্রীড়া সংস্থা আয়োজিত অনুষ্ঠানে প্রদত্ব ভাষণ",
            "২৬ মার্চ ১৯৭২ \nজাতির উদ্দেশে বেতার ও টেলিভিশনে প্রদত্ব ভাষণ",
            "৩০ এপ্রিল ১৯৭২\nমে দিবস উপলক্ষে প্রদত্ব ভাষণ",
            "মুজিববাদ, খোন্দকার মোহাম্মদ ইলিয়াস, ১৯৭২",
            "৭ জুন ১৯৭২\nসেহরাওয়ার্দী উদ্যানে প্রদত্ত ভাষণ",
            "১৯৭২\nডেভিড ফ্রস্টের সঙ্গে সাক্ষাৎকার",
            "মুজিববাদ, খোন্দকার মোহম্মদ ইলিয়াস, ১৯৭২"};
    static final String[] D_seventyTwo = {
            "১০ জানুয়ারি ১৯৭২", "১৬ জুলাই ১৯৭২",
            "২৬ জুন ১৯৭২", "৪ নভেম্বর ১৯৭২",
            "২৬ মার্চ ১৯৭২", " ১৯৭২",
            "৩০ মার্চ ১৯৭২", "১০ অক্টোবর ১৯৭২",
            "১৯৭২", "৯ এপ্রিল ১৯৭২",
            "২৬ ডিসেম্বর ১৯৭২", "২৬ মার্চ ১৯৭২",
            "৪ নভেম্বর ১৯৭২", "৯ অক্টোবর ১৯৭২",
            " ১৯৭২", "২০ নভেম্বর ১৯৭২",
            "২৬ মার্চ ১৯৭২","১০ জানুয়ারি ১৯৭২",
            "৫ ফেব্রুয়ারি ১৯৭২","৯ এপ্রিল ১৯৭২",
            "৭ জুন ১৯৭২", "২৬ জুন ১৯৭২",
            "৩০ জানুয়ারি ১৯৭২","১৯৭২",
            "২৪ জানুয়ারী ১৯৭২", "১১ এপ্রিল ১৯৭২",
            "৯ এপ্রিল ১৯৭২", "১৬ জানুয়ারী ১৯৭২",
            "৯ এপ্রিল ১৯৭২","১৯৭২",
            "২৬ জুলাই ১৯৭২","২৪ জানুয়ারী ১৯৭২",
            "২৪ জানুয়ারী ১৯৭২","২৬ মার্চ ১৯৭২ ",
            "২৬ মার্চ ১৯৭২","৩০ এপ্রিল ১৯৭২",
            "১৯৭২","৭ জুন ১৯৭২",
            "১৯৭২","১৯৭২"};
    static final int[] I_seventyTwo = { R.drawable.mujib_6, R.drawable.mujib_7, R.drawable.mujib_8,
            R.drawable.mujib_9, R.drawable.mujib_10,R.drawable.mujib_11,R.drawable.mujib_12, R.drawable.mujib_13,
            R.drawable.mujib_14,R.drawable.mujib_15, R.drawable.mujib_16,R.drawable.mujib_17,R.drawable.mujib_18,
            R.drawable.mujib_19,R.drawable.mujib_20,R.drawable.mujib_21,R.drawable.mujib_8,R.drawable.mujib_11,
            R.drawable.mujib_16,R.drawable.mujib_20,R.drawable.mujib_7,R.drawable.mujib_9,R.drawable.mujib_10,
            R.drawable.mujib_11,R.drawable.mujib_12,R.drawable.mujib_13,R.drawable.mujib_14,R.drawable.mujib_15,
            R.drawable.mujib_16,R.drawable.mujib_17,R.drawable.mujib_18,R.drawable.mujib_19,R.drawable.mujib_20,
            R.drawable.mujib_21,R.drawable.mujib_6,R.drawable.mujib_7,R.drawable.mujib_8,R.drawable.mujib_9,
            R.drawable.mujib_10,R.drawable.mujib_11};

    //73
    static final String[] Q_seventyThree = {
            "মানব ইতিহাসের শেষ দিনটি পর্যন্ত স্বাধীন ও সার্বভৌম বাংলাদেশের পতাকা বিশ্বের মানচিত্রে সমুন্নত থাকবে।",
            "সরকারের সিদ্ধান্ত গ্রহণই জনগণের ভাগ্য নির্ধারণ করে।",
            "মানুষকে ভালোবাসতে শেখো, দেশের মানুষকে ভালোবাস। এই ভালোবাসার মধ্যে কোন স্বার্থ রেখো না।",
            "শোষকের স্থান সোনার বাংলার মাটিতে নাই।",
            "স্বাধীনতার স্বপ্ন দেখেছিলাম; আজ স্বাধীনতা পেয়েছি। সোনার বাংলার স্বপ্ন দেখেছি; সোনার বাংলা দেখে আমি মরতে চাই।",
            "আমরা বিশ্বশান্তিতে বিশ্বাস করি । আমরা কো-এক্সিসটেন্সে বিশ্বাস করি।",
            "মানুষ চায় কী জীবনে? কেউ চায় অর্থ, কেউ চায় শক্তি, কেউ চায় সম্পদ, কেউ চায় মানুষের ভালোবাসা। আমি চাই মানুষের ভালোবাসা।",
            "এই স্বাধীনতা আমার কাছে সেদিনই প্রকৃত স্বাধীনতা হয়ে উঠবে, যেদিন বাংলাদেশে কৃষক, মজুর ও দুঃখী মানুষের সকল দুঃখের অবসান হবে।",
            "বাংলা আমার ভাষা। বাংলার মাটি আমার মাটি ।বাংলার কৃষ্টি, বাংলার সভ্যতা আমার। আমি বাঙ্গালি জাতীয়তাবাদে বিশ্বাস করি।",
            "ইতিহাসের শেষ দিনটি পর্যন্ত স্বাধীন বাংলার পতাকা সমুন্নত থাকবে।",
            "উনিশত একাত্তর সালের ষোলই ডিসেম্বর আমাদের স্বাধীনতা সংগ্রামের সমাপ্তি। এই একই দিনে আমাদের দেশগড়ার সংগ্রাম শুরু।"};
    static final String[] d_seventyThree = {
            "২১ ফেব্রুয়ারি ১৯৭৩\nদৈনিক ইত্তেফাক",
            "সেপ্টেম্বর ১৯৭৩\nকম্পুচিয়ার রাষ্ট্রপ্রধান প্রিন্স নরোদম সামদেদ সিহানুকের সঙ্গে কথোপকথন, জোটনিরপেক্ষ সম্মেলন, আলজিয়ার্স",
            "২৬ ফেব্রুয়ারি ১৯৭৩\nসিরাজগঞ্জের জনসভায় প্রদত্ত ভাষণ",
            "১৮ মার্চ ১৯৭৩\nসোহরাওয়ার্দী উদ্যানে দেওয়া ভাষণ",
            "মার্চ ১৯৭৩\nসোহরাওয়ার্দী উদ্যানে দেওয়া ভাষণ",
            "১৮ মার্চ ১৯৭৩\nসোহরাওয়ার্দী উদ্যানে দেওয়া ভাষণ",
            "২৫ ফেব্রুয়ারি ১৯৭৩\nনীলফামারিতে দেওয়া ভাষণ",
            "১৫ ডিসেম্বর ১৯৭৩\nবিজয় দিবস উপলক্ষ্যে জাতির উদ্দেশে প্রদত্ত ভাষণ",
            "১৮ ফ্রেব্রুয়রি ১৯৭৩\nচাঁদপুরে দেওয়া ভাষণ",
            "২১ ফেব্রুয়ারি ১৯৭৩\nদৈনিক ইত্তেফাক",
            "১৫ ডিসেম্বর ১৯৭৩\nবিজয় দিবস উপলক্ষে জাতির উদ্দেশে প্রদত্ত ভাষণ"};
    static final String[] D_seventyThree = {
            "২১ ফেব্রুয়ারি ১৯৭৩",
            "সেপ্টেম্বর ১৯৭৩", "২৬ ফেব্রুয়ারি ১৯৭৩",
            "১৮ মার্চ ১৯৭৩", "মার্চ ১৯৭৩",
            "১৮ মার্চ ১৯৭৩", "২৫ ফেব্রুয়ারি ১৯৭৩",
            "১৫ ডিসেম্বর ১৯৭৩", "১৮ ফ্রেব্রুয়রি ১৯৭৩",
            "২১ ফেব্রুয়ারি ১৯৭৩","১৫ ডিসেম্বর ১৯৭৩"};
    static final int[] I_seventyThree = {  R.drawable.blue_1, R.drawable.blue_2, R.drawable.blue_3,
            R.drawable.blue_4, R.drawable.blue_5,R.drawable.blue_6,R.drawable.blue_7, R.drawable.blue_8,
            R.drawable.blue_9,R.drawable.blue_10, R.drawable.blue_11};


    //74
    static final String[] Q_seventyFour = {
            "১৯৪৭ সালের পূর্বে আমরা যারা স্বধীনতা সংগ্রামে যোগদান করেছিলাম তখন আমাদের স্বপ্ন ছিল আমরা র্স্বাধীন হবো। কিন্তু সাতচল্লিশ সালেই আমরা বুঝতে পেরেছিলাম যে আমরা নতুন করে পরাধীনতার শৃঙ্খলে আবদ্ধ হয়েছি।",
            "বাংলায় সম্পদ আছে। বাংলায় সম্পদ বাংলার মানুষ, বাংলার সোনার মাটি।",
            "যাদের আদর্শ নাই, যাদের নীতি নাই, যারা দুর্নীতিবাজ, যারা দেশকে ভালোবাসে না, তারা যদি প্রতিষ্ঠান থেকে বের হয়ে যায়, তাতে প্রতিষ্ঠান দূর্বল হয় না, প্রতিষ্ঠান শক্তিশালি হয়।",
            "জনগণের ঐক্যবদ্ধ ও সম্মিলিত প্রচেষ্টার মাধ্যমেই আমরা আমাদের নির্দিষ্ট লক্ষ্যে পৌঁছাতে সক্ষম হতে পারি, গড়ে তুলতে পারি উন্নততর ভবিষ্যৎ।",
            "রাজনৈতিক প্রতিষ্ঠানের প্রথম প্রয়োজন সঠিক নেতৃত্বের। সঠিক নেতৃত্ব ছাড়া রাজনৈতিক প্রতিষ্ঠান চলতে পারে না।",
            "সাম্রাজ্যবাদী শক্তি যখন শোষণ করতে চায় তখন তারা আঘাত করে শিক্ষা ও সংস্কৃতির উপর, ভাষার উপর। তাকে ধ্বংস করতে না পারলে শোষণ করা সহজ হয়ে ওঠে না।",
            "সমাজতন্ত্র, গ্রগতি আর সাম্প্রদায়িকতা পাশাপাশি চলতে পারে না।",
            "আত্মনির্ভরশীলতাই আমাদরে লক্ষ্য। জনগণের ঐক্যবদ্ধ উদ্যোগই আমাদের নির্ধারিত কর্মধারা।",
            "যেখানে মানুষ শোষিত, যেখানে মানুষ অত্যাচারিত, যেখানে মানুষ দুঃখী, যেখানে মানুষ সাম্রাজ্যবাদীর দ্বারা নির্যাতিত, আমরা বাংলার মানুষ সেই দুঃখী মানুষের সাথে আছি এবং থাকবো।",
            "বিশ্বের সকল সম্পদ ও কারিগরি জ্ঞানের সুষ্ঠু বন্টনের দ্বারা এমন কল্যাণের দ্বার খুলে দেওয়া যাবে, যেখানে প্রত্যেক মানুষ সুখী ও সম্মানজনক জীবনের নূন্যতম নিশ্চয়তা লাভ করবে।",
            "মানব জাতির অস্তিত্ব রক্ষার জন্য শান্তি একান্ত দরকার। ন্যায় নীতির উপর প্রতিষ্ঠিত না হলে শান্তি কখনও স্থায়ী হতে পারেনা।",
            "একটি সুষ্ঠু জাতি গঠনে শিল্প, কৃষি, যোগাযোগ ব্যবস্থা বা অন্যান্য সংস্কৃতির যেমন উন্নয়ন প্রয়োজন, তেমনি প্রয়োজন চিন্তা ও চেতনার ক্ষেত্রে বৈপ্লবিক পরিবর্তন সাধন করা।",
            "এমন এক বিশ্বব্যবস্থা গঠনে বাঙালি জাতি উৎসর্গীকৃত, যে ব্যবস্থায় সকল মানুষের শান্তি ও ন্যায়বিচার লাভের আকঙ্খা প্রতিফলিত হবে।",
            "জনগণকে ছাড়া জনগণকে সংঘবদ্ধ না করে, জনগণকে আন্দোলনমুখী না করে এবং পরিষ্কার আদর্শ সামনে না রেখে কোনরকম গণআন্দোলন হতে পারেনা।",
            "বিশ্বে স্বাধীনতা লাভকারী জাতিগুলোর মধ্যে আমরা এদিক থেকে গর্ব করতে পারি যে আমাদের স্বাধীনতা আন্দোলনে রাজনৈতিক ও সংস্কৃতিক সংগ্রাম হাতে হাত ধরে অগ্রসর হয়েছে।",
            "রাজনৈতিক প্রতিষ্ঠানের চারটি জিনিসের প্রয়োজন এবং তা হচ্ছে, নেতৃত্ব, মেনিফেস্টো বা আদর্শ, নিঃস্বার্থ কর্মী এবং সংগঠন।",
            "সোনার বাংলা গড়তে হলে সোনার মানুষ চাই।",
            "স্বধীন জাতি হিসাবে বিশ্বের দরবারে মাথা উঁচু করে দাঁড়াতে হলে আমাদের ভাষা, সাহিত্য, সংস্কৃতি ও ঐতিয্যের মর্যাদাকে দেশে ও বিদেশে প্রতিষ্ঠিত করতে হবে।",
            "জনগণ থেকে বিচ্ছিন্ন হয়ে কোনো দিন কোনো মহৎ সাহিত্য বা উন্নত শিল্পকর্ম সৃষ্টি হতে পারে না।",
            "আমরা তাকাবো এমন এক পৃথিবীর দিকে, যেখানে বিজ্ঞান ও কারিগরি জ্ঞানের বিস্ময়কর অগ্রগতির যুগে মানুষের  সৃষ্টিক্ষমতা ও বিরাট সাফল্য আমাদের জন্য এক শঙ্কামুক্ত উন্নত ভবিষ্যৎ গঠনে সক্ষম।",
            "ত্যাগ স্বীকার না করে কোন জাতি কোন দিন বড় হতে পারে না।",
            "আমাদের সাহিত্য-সংস্কৃতি যেন শুধু শহরের পাকা দালানে আবদ্ধ না হয়ে থাকে বাংলাদেশের গ্রাম গ্রামান্তরের কোটি কোটি মানুষের প্রাণের স্পন্দনেও যেন তাতে প্রতিফলিত হয়।"};
    static final String[] d_seventyFour = {
            "১৮ জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগের দ্বিবার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "৪ ফেব্রুয়ারি ১৯৭৪\nযুবলীগের প্রথম জাতীয় কংগ্রেসে দেওয়া ভাষণ",
            "১৮ জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগের দ্বিবার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "২৫ সেপ্টেম্বর ১৯৭৪\nজাতিসংঘে প্রদত্ত ভাষণ",
            "১৮ জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগের দ্বিবার্ষিক অদিবেশনে প্রদত্ত ভাষণ",
            "১৮ জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগের দ্বিবার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "১৮ জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগের দ্বিবার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "২৫ শে সেপ্টেম্বর ১৯৭৪\nজাতিসংঘে প্রদত্ত ভাষণ",
            "১৮ ই জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগ দ্বিবার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "২৫ সেপ্টেম্বর ১৯৭৪\nজাতিসংঘে প্রদত্ত ভাষণ",
            "২৫ ডিসেম্বর ১৯৭৪\nজাতিসংঘে প্রদত্ত ভাষণ",
            "১৪ ফেব্রুয়ারি ১৯৭৪\nবাংলা একাডেমিতে দেওয়া ভাষণ",
            "২৫ সেপ্টেম্বর ১৯৭৪\nজাতিসংঘে প্রদত্ত ভাষণ",
            "১৮ জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগের দ্বিবার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "১৪ ফেব্রুয়ারি ১৯৭৪\nবাংলা একাডেমি দেওয়া ভাষণ",
            "১৮ জানুয়ারি ১৯৭৪\nবাংলাদেশ আওয়ামী লীগের দ্বিবার্ষিক অধিবেশনে প্রদত্ত ভাষণ",
            "১৫ ই ডিসেম্বর ১৯৭৪\nবিজয় দিবস উপলক্ষ্যে জাতির উদ্দেশে প্রদত্ত ভাষণ",
            "১৪ ফ্রেব্রুয়ারি ১৯৭৪ \nবাংলা একাডেমিতে দেওয়া ভাষণ",
            "১৪ ফেব্রুয়ারি ১৯৭৪ \nবাংলা একাডেমিতে দেওয়া ভাষণ",
            "২৫ সেপ্টেম্বর ১৯৭৪\nজাতিসংঘে প্রদত্ব ভাষণ",
            "১০ ডিসেম্বর ১৯৭৪\nনৌবাহিনীর উদ্দেশে ভাষণ",
            "১৪ ফ্রেব্রুয়ারি ১৯৭৪\nবাংলা একাডেমিতে দেওয়া ভাষণ"};
    static final String[] D_seventyFour = {
            "১৮ জানুয়ারি ১৯৭৪", "৪ ফেব্রুয়ারি ১৯৭৪",
            "১৮ জানুয়ারি ১৯৭৪", "২৫ সেপ্টেম্বর ১৯৭৪",
            "১৮ জানুয়ারি ১৯৭৪", "১৮ জানুয়ারি ১৯৭৪",
            "১৮ জানুয়ারি ১৯৭৪", "২৫ শে সেপ্টেম্বর ১৯৭৪",
            "১৮ ই জানুয়ারি ১৯৭৪", "২৫ সেপ্টেম্বর ১৯৭৪",
            "২৫ ডিসেম্বর ১৯৭৪", "১৪ ফেব্রুয়ারি ১৯৭৪",
            "২৫ সেপ্টেম্বর ১৯৭৪", "১৮ জানুয়ারি ১৯৭৪",
            "১৪ ফেব্রুয়ারি ১৯৭৪", "১৮ জানুয়ারি ১৯৭৪",
            "১৫ ই ডিসেম্বর ১৯৭৪", "১৪ ফ্রেব্রুয়ারি ১৯৭৪ ",
            "১৪ ফেব্রুয়ারি ১৯৭৪ ","২৫ সেপ্টেম্বর ১৯৭৪",
            "১০ ডিসেম্বর ১৯৭৪","১৪ ফ্রেব্রুয়ারি ১৯৭৪"};
    static final int[] I_seventyFour = { R.drawable.mujib_16,R.drawable.mujib_20,R.drawable.mujib_7,R.drawable.mujib_9,R.drawable.mujib_10,
            R.drawable.mujib_11,R.drawable.mujib_12,R.drawable.mujib_13,R.drawable.mujib_14,R.drawable.mujib_15,
            R.drawable.mujib_16,R.drawable.mujib_17,R.drawable.mujib_18,R.drawable.mujib_19,R.drawable.mujib_20,
            R.drawable.mujib_21,R.drawable.mujib_6,R.drawable.mujib_7,R.drawable.mujib_8,R.drawable.mujib_9,
            R.drawable.mujib_10,R.drawable.mujib_11};

    //75
    static final String[] Q_seventyFive = {
            "কোন জায়গা থেকে হায়ার করে এনে, ইম্পোর্ট করে এনে কোনো ‘ইজম’ চলে না। এদেশ কেন কোন দেশেই চলে না।",
            "বাঙালি জাতি যে প্রাণ, যে অনুপ্রেরণা নিয়ে স্বাধীনতা সংগ্রাম করেছিল, সেই প্রাণ, সেই অনুপ্রেরণা, সেই মতবাদ নিয়ে অগ্রসর হতে হবে।",
            "আমাদের আত্মসমালোচনার প্রয়োজন,আমাদের আত্মসংযমের প্রয়োজন, আমাদের আত্মশুদ্ধির প্রয়োজন।",
            "আমার মাটির সঙ্গে, আমার মানুষের সঙ্গে, আমার কালচারের সঙ্গে, আমার ব্যাকগ্রাউন্ডের সঙ্গে, আমার ইতিহাসের সঙ্গে যুক্ত করেই আমার ইকোনমিক্ সিস্টেম গড়তে হবে।",
            "কোনো দেশে কোনো যুগে বিপ্লবের পরে বা সশস্ত্র বিপ্লবের মাধ্যমে ক্ষমতা দখল করে এভাবে মানুষকে সম্পূর্ণ অধিকার এবং অন্যান্য সুযোগ-সুবিধা দেওয়া হয়নি। আমরা দিয়েছিলাম। তার প্রমান আমাদের সংবিধান।",
            "দেশের ভাগ্য ও ভবিষ্যৎ ছাত্রসমাজের উপর নির্ভর করে।"};
    static final String[] d_seventyFive = {
            "১৯ জুন ১৯৭৫\nবাংলাদেশ কৃষক শ্রমিক আওয়ামী লীগের কেন্দ্রীয় কমিটির প্রথম বৈঠকে ভাষণ",
            "২৫ জানুয়ারি ১৯৭৫\nজাতীয় সংসদে ভাষণ",
            "২৫ জানুয়ারি ১৯৭৫\nজাতিয় সংসদে ভাষণ",
            "১৯ জুন ১৯৭৫\nবাংলাদেশ কৃষক শ্রমিক আওয়ামী লীগের কেন্দ্রিয় কমিটির প্রথম বৈঠকে ভাষণ",
            "২৫ জানুয়ারী ১৯৭৫\nজাতীয় সংসদের অধিবেশনে",
            "১১ জুন ১৯৭৫ \nদৈনিক ইত্তেফাক"};
    static final String[] D_seventyFive = {
            "১৯ জুন ১৯৭৫", "২৫ জানুয়ারি ১৯৭৫",
            "২৫ জানুয়ারি ১৯৭৫", "১৯ জুন ১৯৭৫",
            "২৫ জানুয়ারী ১৯৭৫", "১১ জুন ১৯৭৫"};
    static final int[] I_seventyFive = {  R.drawable.skitch1,R.drawable.skitch2,R.drawable.skitch3,
            R.drawable.skitch4,R.drawable.skitch5, R.drawable.skitch1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_quote);

        // get the photo size and spacing
        mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
        mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);

        // initialize image adapter
        imageAdapter = new ImageAdapter();
        photoGrid = (GridView) findViewById(R.id.albumGrid);
        i = getIntent();

        // Selected image id
        year = i.getExtras().getInt("year");
        Log.d("TAG","ID"+year+" ");

        //start sent image to full screen

        /*** On Click event for Single Gridview Item**/
        photoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), SingleQuoteActivity.class);
               // Intent r= new Intent(getApplicationContext(), SingleQuoteRActivity.class);
                // passing array index

                i.putExtra("section",0);
                i.putExtra("year",year);
                i.putExtra("id", position);
                startActivity(i);
//                if(year == 72){
//                    r.putExtra("year",year);
//                    r.putExtra("id", position);
//                    startActivity(r);
//                }else {
//                    i.putExtra("year",year);
//                    i.putExtra("id", position);
//                    startActivity(i);
//                }
            }
        });
        //end sent image to full screen
        // set image adapter to the GridView
        photoGrid.setAdapter(imageAdapter);
        // get the view tree observer of the grid and set the height and numcols dynamically
        photoGrid.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (imageAdapter.getNumColumns() == 0) {
                    final int numColumns = (int) Math.floor(photoGrid.getWidth() / (mPhotoSize + mPhotoSpacing));
                    if (numColumns > 0) {
                        final int columnWidth = (photoGrid.getWidth() / numColumns) - mPhotoSpacing;
                        imageAdapter.setNumColumns(numColumns);
                        imageAdapter.setItemHeight(columnWidth);
                    }
                }
            }
        });
    }

    /////////// ImageAdapter class /////////////////
    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private int mItemHeight = 0;
        private int mNumColumns = 0;
        private RelativeLayout.LayoutParams mImageViewLayoutParams;

        public ImageAdapter() {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
        }

        public int getCount() {
            if(year == 70){
                return D_seventy.length;
            }else if(year==71){
                return D_seventyOne.length;
            }else if(year==72){
                return D_seventyTwo.length;
            }else if(year==73){
                return D_seventyThree.length;
            }else if(year==74){
                return D_seventyFour.length;
            }else if(year==75){
                return D_seventyFive.length;
            }else{
                return D_seventyOne.length;
            }
        }

        // set numcols
        public void setNumColumns(int numColumns) {
            mNumColumns = numColumns;
        }

        public int getNumColumns() {
            return mNumColumns;
        }

        // set photo item height
        public void setItemHeight(int height) {
            if (height == mItemHeight) {
                return;
            }
            mItemHeight = height;
            mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mItemHeight);
            notifyDataSetChanged();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {

            if (view == null)
                view = mInflater.inflate(R.layout.single_quote_grid, null);

            ImageView cover = (ImageView) view.findViewById(R.id.cover);
            TextView title = (TextView) view.findViewById(R.id.title);

            cover.setLayoutParams(mImageViewLayoutParams);

            // Check the height matches our calculated column width
            if (cover.getLayoutParams().height != mItemHeight) {
                cover.setLayoutParams(mImageViewLayoutParams);
            }
            if(year == 70){
                cover.setImageResource(I_seventy[position % I_seventy.length]);
                title.setText(D_seventy[position % D_seventy.length]);
            }
            else if(year==71){
                cover.setImageResource(I_seventyOne[position % I_seventyOne.length]);
                title.setText(D_seventyOne[position % D_seventyOne.length]);
            }
            else if(year==72){
                cover.setImageResource(I_seventyTwo[position % I_seventyTwo.length]);
                title.setText(D_seventyTwo[position % D_seventyTwo.length]);
            }
            else if(year==73){
                cover.setImageResource(I_seventyThree[position % I_seventyThree.length]);
                title.setText(D_seventyThree[position % D_seventyThree.length]);
            }
            else if(year==74){
                cover.setImageResource(I_seventyFour[position % I_seventyFour.length]);
                title.setText(D_seventyFour[position % D_seventyFour.length]);
            }
            else if(year==75){
                cover.setImageResource(I_seventyFive[position % I_seventyFive.length]);
                title.setText(D_seventyFive[position % D_seventyFive.length]);
            }

//            cover.setImageResource(ICONS[position % ICONS.length]);
//            title.setText(CONTENT[position % CONTENT.length]);

            return view;
        }
    }

}