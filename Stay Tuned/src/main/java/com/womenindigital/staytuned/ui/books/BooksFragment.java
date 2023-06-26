package com.womenindigital.staytuned.ui.books;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.womenindigital.staytuned.BookOpenerActivity;
import com.womenindigital.staytuned.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksFragment extends Fragment implements AdapterView.OnItemClickListener{

    private BooksViewModel mViewModel;
    private  View view;
    private ListView bookList;
    // Initializing a new String Array
    String[] fruits = new String[] {
            "অসমাপ্ত আত্মজীবনী", "কারাগারের রোজনামচা - শেখ মুজিবুর রহমান","আমার দেখা নয়াচীন",
            "শেখ মুজিব আমার পিতা","শেখ মুজিবের ছেলেবেলা"
    };

    // Create a List from String Array elements
    final List fruits_list = new ArrayList(Arrays.asList(fruits));

    public static BooksFragment newInstance() {
        return new BooksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_books, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
        // TODO: Use the ViewModel
        bookList = view.findViewById(R.id.bookList);
        //coffeeList.setAdapter(new ArrayAdapter<String>(this, R.layout.listrow, R.id.textView2, coffeeChoices));
        // Create an ArrayAdapter from List
        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter(getContext(), R.layout.list_item, R.id.textView, fruits_list){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);
                if(position %2 == 1)
                {
                    // Set a background color for ListView regular row/item
                    view.setBackgroundColor(Color.parseColor("#bd856c"));
                    view.setAlpha((float) 0.74);
                }
                else
                {
                    // Set the background color for alternate row/item
                    view.setBackgroundColor(Color.parseColor("#b66e4f"));
                    view.setAlpha((float) 0.84);
                }
                return view;
            }
        };

        // DataBind ListView with items from ArrayAdapter
        bookList.setAdapter(arrayAdapter);
        bookList.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getActivity(), "Item: " + mess[position]+position, Toast.LENGTH_SHORT).show();
        Intent pdfOpenerActivity = new Intent(getActivity(), BookOpenerActivity.class);
        pdfOpenerActivity.putExtra("position",position);
        startActivity(pdfOpenerActivity);
        ((Activity) getActivity()).overridePendingTransition(0,0);
    }

}



