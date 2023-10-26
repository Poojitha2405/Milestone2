package com.example.MI_Farmer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mi_farmer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,
                container, false);

        EditText email = (EditText) view.findViewById(R.id.et_emaill);
        EditText password = (EditText) view.findViewById(R.id.et_passwordd);

        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        Button login = (Button) view.findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent goToLoginIntent = new Intent(v.getContext(), LandingActivity.class);
                    v.getContext().startActivity(goToLoginIntent);
            }
        });

        return view;
    }

}