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
 * Use the {@link RegisterFragment#} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor

    }

    Button button;
    String fullName;
    String emailText;
    String phoneNumber;
    String passwordText;
    String confPassText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,
                container, false);

        EditText name = (EditText) view.findViewById(R.id.et_name);
        EditText email = (EditText) view.findViewById(R.id.et_email);
        EditText phone = (EditText) view.findViewById(R.id.phone_Num);
        EditText password = (EditText) view.findViewById(R.id.et_password);
        EditText confirmPassword = (EditText) view.findViewById(R.id.et_repassword);

        fullName = name.getText().toString();
        emailText = email.getText().toString();
        phoneNumber = phone.getText().toString();
        passwordText = password.getText().toString();
        confPassText = confirmPassword.getText().toString();

        button = (Button) view.findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (fullName.equals("")){

//                    Toast toast = Toast.makeText(getContext(), "Full Name Can't be Empty!", Toast.LENGTH_SHORT);
//                    toast.show();
                }else if (emailText.equals("")){

//                    Toast.makeText(getContext(), "Email cannot be null!", Toast.LENGTH_SHORT).show();
                }else if (phoneNumber.equals("")){

//                    Toast.makeText(getContext(), "Email cannot be null!", Toast.LENGTH_SHORT).show();
                } else if (passwordText.equals("")) {

//                    Toast.makeText(getContext(), "Email cannot be null!", Toast.LENGTH_SHORT).show();

                } else if (confPassText.equals("")) {

//                    Toast.makeText(getContext(), "Confirm password cannot be null!", Toast.LENGTH_SHORT).show();
                } else if (!passwordText.equals(confPassText)) {

//                    Toast.makeText(getContext(), "Password and Confirm password have to match!", Toast.LENGTH_SHORT).show();

                }else {


                }

                Intent goToLoginIntent = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginIntent);
            }
        });
        return view;
    }



    public View getTexts( View view){


        return view;
    }

}