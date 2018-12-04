package com.example.roymoria.movies;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ScreenSlidePageFragment extends Fragment {

    //You don't need to have a listener because none of your actions needs to be known/accessed outside of the fragment
    private OnFragmentInteractionListener mListener;
    
    //Place the views declerations here
    //for exapmle ImageView posterImage;
    
    
    //Here you will have your movie object: Movie movieObject

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    
    //You don't need to split the object into primitive types just pass the Movie object and then just use it as a variable
    public static ScreenSlidePageFragment newInstance(int imageResourceIdLarge, int imageResourceId, int movieId) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        //this.movieObject = movieObject;
        Bundle args = new Bundle();
        args.putString("image", String.valueOf(imageResourceId));
        args.putString("imageLarge", String.valueOf(imageResourceIdLarge));
        args.putInt("title",movieId); //Missing space after comma
        fragment.setArguments(args);
        return fragment;
    }

    
    //You need to use this function just if you want to perform an action only at creation so you can remove it
    @Override
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        //You don't need to cast it as a ViewGroup because you are not using any of it's options
        // View rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false); would be better in this case
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        
        //Put all of your findViewById's in one section
        ImageView imageTop = rootView.findViewById(R.id.TopIV);
        ImageView imageCenter = rootView.findViewById(R.id.centerIV);
        
        Bundle args = getArguments();
        Resources res = getResources();
        String[] movie = res.getStringArray(args.getInt("title"));
        int imageId = Integer.parseInt(args.getString("image",""));
        imageCenter.setImageResource(imageId);
        int imageIdLarge = Integer.parseInt(args.getString("imageLarge",""));
        imageTop.setImageResource(imageIdLarge);
        TextView title = rootView.findViewById(R.id.title);
        title.setText(movie[0]);
        TextView context = rootView.findViewById(R.id.intro);;
        context.setText(movie[1]);
        TextView release = rootView.findViewById(R.id.released);
        release.setText(movie[3]);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    // There is no neet to have this method you can just call button.setOnClickListener() //button can be received with findViewById
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    
    
    
    //As I wrote in the top you don't need it
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
