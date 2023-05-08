package com.example.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertFragment newInstance(String param1, String param2) {
        InsertFragment fragment = new InsertFragment();
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

    EditText nameTxtEdit;
    EditText prizeTxtEdit;
    Button addButton;
    Button backButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        MainActivity ma = (MainActivity)getActivity();

        nameTxtEdit = view.findViewById(R.id.nameTxtEdit);
        prizeTxtEdit = view.findViewById(R.id.prizeTxtEdit);

        addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTxtEdit.getText().toString();
                String prize = prizeTxtEdit.getText().toString();

                if (name.isEmpty() || prize.isEmpty()) {
                    //Toast.makeText(InsertFragment.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                ma.dbHandler.addProduct(name,prize);

                //Toast.makeText(view.this, "Course has been added.", Toast.LENGTH_SHORT).show();

                nameTxtEdit.setText("");
                prizeTxtEdit.setText("");
            }
        });

        backButton = view.findViewById(R.id.backInsertButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager;
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView,
                                MainFragment.class, null).commit();
            }
        });



        return view;
    }
}