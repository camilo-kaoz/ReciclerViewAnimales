package com.desafiolatam.recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String animalName;
    private String animalURL;

    private ImageView image;
    private TextView textViewName;


    public DetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalName = getArguments().getString(ARG_PARAM1);
            animalURL = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_detail, container, false);


        initializeView(view);

       textViewName.setText(animalName);
        Glide.with(getContext())
                .load(animalURL)
                .centerCrop()
                .into(image);

        return view;

    }

  private void initializeView(View view){

        textViewName = view.findViewById(R.id.textViewDetails);
        image = view.findViewById(R.id.imageViewFragment);
  }

}