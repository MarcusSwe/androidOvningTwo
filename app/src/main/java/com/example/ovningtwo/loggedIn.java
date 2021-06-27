package com.example.ovningtwo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link loggedIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loggedIn extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ItemViewModelString omegaString;

    private TextView userLoggedIn;

    public loggedIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loggedIn.
     */
    // TODO: Rename and change types and number of parameters
    public static loggedIn newInstance(String param1, String param2) {
        loggedIn fragment = new loggedIn();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View fragmentview = inflater.inflate(R.layout.fragment_logged_in, container, false);
        userLoggedIn = fragmentview.findViewById(R.id.fragmentUsername);


        //  -- Detta fungerar, låt stå..
        omegaString = new ViewModelProvider(requireActivity()).get(ItemViewModelString.class);
        omegaString.getSelectedItem().observe(getViewLifecycleOwner(), text -> {
            userLoggedIn.setText(text);
        });



        // Inflate the layout for this fragment
        return fragmentview;
    }

    public void setTextFragment(String text){
         userLoggedIn.setText(text);
    }

    public String getTextFragment(){
        return (String) userLoggedIn.getText();
    }

}