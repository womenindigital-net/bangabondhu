package com.womenindigital.staytuned.ui.picture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.womenindigital.staytuned.R;
import com.womenindigital.staytuned.SinglePhotoActivity;

public class PicturesFragment extends Fragment {

    // Some items to add to the GRID
    public static int[] photos= new int[]{
            R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4,
            R.drawable.photo5, R.drawable.photo6, R.drawable.photo7, R.drawable.photo8,
            R.drawable.photo9, R.drawable.photo10, R.drawable.photo11,R.drawable.photo12, R.drawable.photo13,
            R.drawable.photo14, R.drawable.photo15, R.drawable.photo16,
            R.drawable.photo17, R.drawable.photo18, R.drawable.photo19, R.drawable.photo20,
            R.drawable.photo21,R.drawable.photo22,
            R.drawable.photo23, R.drawable.photo24, R.drawable.photo25};
    private PicturesViewModel mViewModel;
    private GridView photoGrid;
    private PhotoAdapter photoAdapter;

    private int mPhotoSize, mPhotoSpacing;

    public static PicturesFragment newInstance() {
        return new PicturesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_picture, container, false);
        photoGrid = root.findViewById(R.id.photoGrid);


        // get the photo size and spacing
        mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
        mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);


        //start sent image to full screen

        // initialize image adapter
        photoAdapter= new PhotoAdapter(root.getContext());

        /**
         * On Click event for Single Gridview Item
         * */
        photoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent photoGridActivity = new Intent(getActivity(), SinglePhotoActivity.class);
                // passing array index
                photoGridActivity.putExtra("album",1);
                photoGridActivity.putExtra("id", position);
                startActivity(photoGridActivity);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        //end sent image to full screen

        // set image adapter to the GridView
        photoGrid.setAdapter(photoAdapter); // uses the view to get the context instead of getActivity().


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




        return root;
    }

    // ///////// ImageAdapter class /////////////////
    public class PhotoAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private int mItemHeight = 0;
        private int mNumColumns = 0;
        private RelativeLayout.LayoutParams mImageViewLayoutParams;
        private Context mContext;


        public PhotoAdapter(Context c) {
            mContext = c;
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
            return photos.length;

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
                view = mInflater.inflate(R.layout.single_photo_grid, null);

            ImageView cover = (ImageView) view.findViewById(R.id.cover);
            //TextView title = (TextView) view.findViewById(R.id.title);

            cover.setLayoutParams(mImageViewLayoutParams);

            // Check the height matches our calculated column width
            if (cover.getLayoutParams().height != mItemHeight) {
                cover.setLayoutParams(mImageViewLayoutParams);
            }
            cover.setImageResource(photos[position % photos.length]);

            //title.setText(CONTENT[position % CONTENT.length]);

            return view;
        }
    }




}