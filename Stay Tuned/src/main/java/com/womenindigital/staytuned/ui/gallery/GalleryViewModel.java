package com.womenindigital.staytuned.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("শনিবার ১৭ মার্চ ২০১৮ এক মহামানবের ৯৮তম জন্মদিন। স্বাধীন বাংলার রূপকার, হাজার বছরের সর্বশ্রেষ্ঠ বাঙালি, স্বাধীন বাংলার স্থপতি ও জাতির জনক বঙ্গবন্ধু শেখ মুজিবুর রহমান। বিশ্বের আপামর মুক্তিকামী জনতার কণ্ঠস্বর শেখ মুজিবুর রহমান।\n" +
//                "জন্ম:\n" +
//                "১৯২০ সালের ১৭ই মার্চ বর্তমান গোপালগঞ্জ জেলার টুঙ্গিপাড়া গ্রামে। বাবা শেখ লুৎফর রহমান এবং মা সায়েরা খাতুনের চার কন্যা ও দুই পুত্রের মধ্যে তৃতীয়।\n" +
//                "\n" +
//                "শিক্ষা জীবন:\n" +
//                "১৯২৭- সালে গিমাডাঙ্গা প্রাইমারি স্কুলে পড়াশুনা শুরু।\n" +
//                "১৯২৯- সালে গোপালগঞ্জ পাবলিক স্কুলে তৃতীয় শ্রেণিতে এবং পরে স্থানীয় মিশনারি স্কুলে ভর্তি হন।\n" +
//                "১৯৩৪- সালে বেরিবেরি রোগে আক্রান্ত হয়ে লেখাপড়ায় সাময়িক বিরতি এবং ১৯৩৭ সালে পুনরায় ভর্তি হন।\n" +
//                "১৯৪২- সালে এন্ট্রান্স (S.S.C) পাশ করে কলকাতা ইসলামিয়া কলেজে ভর্তি হন।\n" +
//                "১৯৪৭- এ এই কলেজ থেকে বি.এ পাশ করেন।\n" +
//                "১৯৪৮- এ ঢাকা বিশ্ববিদ্যালয়ে আইন বিভাগে ভর্তি হন।\n" +
//                "১৯৪৯- সালে বিশ্ববিদ্যালয়ের চতুর্থ শ্রেণির কর্মচারীদের আন্দোলনে নেতৃত্ব দিলে বিশ্ববিদ্যালয় কর্তৃপক্ষ তাঁকে জরিমানা করে। তিনি এ আদেশ ঘৃণাভরে প্রত্যাখ্যান বিশ্ববিদ্যালয় থেকে বহিস্কৃত হন।\n" +
//                "\n" +
//                "ব্যক্তি জীবন:\n" +
//                "১৮ বছর বয়সে বেগম ফজিলাতুন্নেছার সাথে বিবাহ বন্ধনে আবদ্ধ হন। তাঁর দুই কন্যা শেখ হাসিনা ও শেখ রেহানা এবং তিন পুত্র শেখ জামাল, শেখ কামাল ও শেখ রাসেল।\n" +
//                "\n" +
//                "রাজনীতি:\n" +
//                "১৯৩৯- সালে ছাত্রলীগের জেলা ও প্রাদেশিক কাউন্সিলর হন।\n" +
//                "১৯৪০- সালে ফরিদপুর জেলা ছাত্রলীগের সহ-সভাপতি হন।\n" +
//                "১৯৪২- সালে মুসলিম লীগের জেলা প্রতিনিধি হিসেবে সিরাজগঞ্জ সম্মেলনে যোগদান করেন।\n" +
//                "১৯৪৩- সালে মুসলিম লীগের কাউন্সিলর হিসাবে All India Muslim League Council-এ যোগদান করেন।\n" +
//                "১৯৪৫- সালে ইসলামিয়া কলেজ ছাত্র সংসদের জি.এস নির্বাচিত হন।\n" +
//                "১৯৪৮- সালের ৪ জানুয়ারি মুসলিম ছাত্রলীগ প্রতিষ্ঠা করেন।\n" +
//                "১৯৪৮- সালের ২৩ ফেব্রুয়ারি প্রধানমন্ত্রী খাজা নাজিম উদ্দিন আইন পরিষদে পূর্ব পাকিস্তানের জনগণ উর্দুকে রাষ্ট্রভাষা হিসেবে মেনে নেবে বলে ঘোষণা দিলে তাৎক্ষণিকভাবে বঙ্গবন্ধু এর প্রতিবাদ জানান। ভাষা আন্দোলনের শুরুটা হয়েছিল এই প্রতিবাদ থেকেই।\n" +
//                "১৯৪৯- সালে জেলে থাকা অবস্থায় ২৩ জুন পূর্ব পাকিস্তান আওয়ামী লীগের যুগ্ম-সম্পাদক নির্বাচিত হন।\n" +
//                "১৯৫৩- সালের ৯ জুলাই পূর্ব পাকিস্তান আওয়ামী মুসলিম লীগের সাধারণ সম্পাদক নির্বাচিত হন।\n" +
//                "১৯৫৪- সালের ১০ মার্চ সাধারণ নির্বাচনে গোপালগঞ্জ আসন থেকে নির্বাচিত হন এবং ১৫ মে প্রাদেশিক সরকারের কৃষি ও বনমন্ত্রীর দায়িত্ব লাভ করেন।\n" +
//                "১৯৫৫- সালের ৫ জুন গণপরিষদের সদস্য নির্বাচিত হন। ২১ অক্টোবর আওয়ামী মুসলিম লীগের নাম পরিবর্তন করে আওয়ামী লীগ রাখা হয় এবং তিনি পুনরায় দলের সাধারণ সম্পাদক নির্বাচিত হন।\n" +
//                "১৯৫৬- সালে কোয়ালিশন সরকারের শিল্প, বাণিজ্য, শ্রম, দুর্নীতি দমন ও ভিলেজ এইড মন্ত্রী হন।\n" +
//                "১৯৬৬- সালের ১ মার্চ আওয়ামী লীগের সভাপতি নির্বাচিত হন।\n" +
//                "১৯৬৬- সালের ৫ ও ৬ ফেব্রুয়ারি লাহোরে অনুষ্ঠিত বিরোধী রাজনৈতিক দলগুলোর এক সম্মেলনে আওয়ামী লীগের পক্ষ থেকে শেখ মুজিবুর রহমান পূর্ব পাকিস্তানের স্বায়ত্তশাসন প্রতিষ্ঠার লক্ষ্যে “৬ দফা দাবি” পেশ করেন।\n" +
//                "১৯৬৯- সালের ২৩ ফেব্রুয়ারি বঙ্গবন্ধু উপাধি লাভ করেন।\n" +
//                "১৯৭০- সালের ৬ জানুয়ারি পুনরায় আওয়ামী লীগের সভাপতি নির্বাচিত হন এবং পাকিস্তান জাতীয় পরিষদ নির্বাচনে নিরঙ্কুশ সংখ্যা গরিষ্ঠতা লাভ।\n" +
//                "১৯৭১- সালের ২৬শে মার্চ বাংলাদেশের স্বাধীনতা ঘোষণা, হানাদার বাহিনীর হাতে গ্রেফতার।\n" +
//                "১৯৭২- সালের ১০ জানুয়ারি পাকিস্তান কারাগার থেকে স্বাধীন বাংলায় প্রত্যাবর্তন। ১২ জানুয়ারি গণপ্রজাতন্ত্রী বাংলাদেশ সরকারের প্রধানমন্ত্রীর দায়িত্ব গ্রহণ করেন।\n" +
//                "১৯৭৫- সালের ২৫ জানুয়ারি দেশে রাষ্ট্রপতি শাসিত ব্যবস্থা প্রবর্তনের ফলে রাষ্ট্রপতির দায়িত্ব গ্রহণ করেন বঙ্গবন্ধু শেখ মুজিবুর রহমান।\n" +
//                "\n" +
//                "মৃত্যু:\n" +
//                "১৯৭৫- সালের ১৫ই আগস্ট ভোরে এই মহামানব তাঁর নিজ বাসভবনে নিহত হন।");
    }

    public LiveData<String> getText() {
        return mText;
    }
}