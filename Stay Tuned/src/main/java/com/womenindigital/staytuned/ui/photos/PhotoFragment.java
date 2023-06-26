package com.womenindigital.staytuned.ui.photos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.womenindigital.staytuned.Model.Photo;
import com.womenindigital.staytuned.R;
import com.womenindigital.staytuned.ui.ApiFiles.ApiClient;
import com.womenindigital.staytuned.ui.ApiFiles.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoFragment extends Fragment {

    // Some items to add to the GRID
    private GridView photoGrid;
    private PhotoAdapter photoAdapter;

    private int mPhotoSize, mPhotoSpacing;
    private ApiInterface apiInterface;

    public List<Photo> pictures;
    //private PhotoAdapter adapter;

    private PhotoViewModel mViewModel;

    public static PhotoFragment newInstance() {
        return new PhotoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.photo_fragment, container, false);
        photoGrid = root.findViewById(R.id.photoGrid);
        // get the photo size and spacing
        mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
        mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);

        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            // fetch data
            fetchPhoto("users","");
            photoAdapter= new PhotoAdapter(root.getContext(), pictures);
        } else {
            // display error
        }
        // get the view tree observer of the grid and set the height and numcols dynamically
        photoGrid.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (photoAdapter.getNumColumns() == 0) {
                    final int numColumns = (int) Math.floor(photoGrid.getWidth() / (mPhotoSize + mPhotoSpacing));
                    if (numColumns > 0) {
                        final int columnWidth = (photoGrid.getWidth() / numColumns) - mPhotoSpacing;
                        photoAdapter.setNumColumns(numColumns);
                        photoAdapter.setItemHeight(columnWidth);

                    }
                }
            }
        });
        photoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Log.d("TAG","CLICKED");
                Intent photoGridActivity = new Intent(getActivity(), PhotoSingleActivity.class);
                // passing array index
                //photoGridActivity.putExtra("album",1);
                photoGridActivity.putExtra("id", position);
                startActivity(photoGridActivity);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        //end
        return root;
    }
    public void fetchPhoto(String type, String key){

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Photo>> call = apiInterface.getPhoto(type, key);
        call.enqueue(new Callback<List<Photo>>() {

            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                //progressBar.setVisibility(View.GONE);
                pictures = response.body();
                photoAdapter = new PhotoAdapter(getContext(), pictures);
                photoGrid.setAdapter(photoAdapter);
                photoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                //progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error\n"+t.toString(), Toast.LENGTH_LONG).show();

            }



        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = new ViewModelProvider(this).get(PhotoViewModel.class);
        // TODO: Use the ViewModel
    }

}




// ///////// ImageAdapter class /////////////////
class PhotoAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private int mItemHeight = 0;
    private int mNumColumns = 0;
    private RelativeLayout.LayoutParams mImageViewLayoutParams;
    private Context mContext;
    private List<Photo> pics;

    public PhotoAdapter(Context c, List<Photo> p) {
        mContext = c;
        pics = p;
        mInflater = LayoutInflater.from(c);
        mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    //        public PhotoAdapter(Context context) {
//            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT);
//        }
    public int getCount() {
        return pics.size();
        //return 5;

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
        final Photo contact = pics.get(position);
        final String i=contact.getId();
        //holder.phone.setText(contacts.get(position).getName());


        if (view == null)
            view = mInflater.inflate(R.layout.single_photo_grid, null);

        ImageView cover = (ImageView) view.findViewById(R.id.cover);
        //TextView title = (TextView) view.findViewById(R.id.title);

        cover.setLayoutParams(mImageViewLayoutParams);

        // Check the height matches our calculated column width
        if (cover.getLayoutParams().height != mItemHeight) {
            cover.setLayoutParams(mImageViewLayoutParams);
        }
        //cover.setImageResource(photos[position % photos.length]);

        Picasso.get()
                .load("http://dynamichubscom.ipage.com/wid_bongobondhu/photo/photo" + i + ".png")

                .into(cover);

        //title.setText(CONTENT[position % CONTENT.length]);

        return view;
    }
}

