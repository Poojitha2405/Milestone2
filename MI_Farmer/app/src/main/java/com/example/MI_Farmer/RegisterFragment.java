package com.example.MI_Farmer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mi_farmer.R;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor

    }

    DBHandler dbHandler;

    Button button;
    String fullNameText;
    String emailText;
    String phoneNumberText;
    String passwordText;
    String confPassText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register,
                container, false);

        dbHandler = new DBHandler(view.getContext());

        EditText name = (EditText) view.findViewById(R.id.et_name);
        EditText email = (EditText) view.findViewById(R.id.et_email);
        EditText phone = (EditText) view.findViewById(R.id.phone_Num);
        EditText password = (EditText) view.findViewById(R.id.et_password);
        EditText confirmPassword = (EditText) view.findViewById(R.id.et_repassword);


        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



                String nameText = name.getText().toString();
                if (nameText.length() > 4) {

                    name.setTextColor(Color.GREEN);
                    name.setBackground(getResources().getDrawable(R.drawable.valid_entry_input));
                } else {
                    name.setTextColor(Color.RED);
                    name.setBackground(getResources().getDrawable(R.drawable.invalid_entry_et));
                }

            }
        });


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



                String emailText = email.getText().toString();
                if (!emailText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {

                    email.setTextColor(Color.GREEN);
                    email.setBackground(getResources().getDrawable(R.drawable.valid_entry_input));
                } else {
                    email.setTextColor(Color.RED);
                    email.setBackground(getResources().getDrawable(R.drawable.invalid_entry_et));
                }

            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



                String phoneText = phone.getText().toString();
                if (phoneText.length() > 9) {

                    phone.setTextColor(Color.GREEN);
                    phone.setBackground(getResources().getDrawable(R.drawable.valid_entry_input));
                } else {
                    phone.setTextColor(Color.RED);
                    phone.setBackground(getResources().getDrawable(R.drawable.invalid_entry_et));
                }

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



                String passwordText = password.getText().toString();
                if (passwordText.length() > 5) {

                    password.setTextColor(Color.GREEN);
                    password.setBackground(getResources().getDrawable(R.drawable.valid_entry_input));
                } else {
                    password.setTextColor(Color.RED);
                    password.setBackground(getResources().getDrawable(R.drawable.invalid_entry_et));
                }

            }
        });

        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



                String confirmPasswordText = confirmPassword.getText().toString();
                String passwordText = password.getText().toString();
                if (confirmPasswordText.equals(passwordText)) {

                    confirmPassword.setTextColor(Color.GREEN);
                    confirmPassword.setBackground(getResources().getDrawable(R.drawable.valid_entry_input));
                } else {

                    confirmPassword.setTextColor(Color.RED);
                    confirmPassword.setBackground(getResources().getDrawable(R.drawable.invalid_entry_et));
                }

            }
        });

        button = (Button) view.findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fullNameText = name.getText().toString();
                emailText = email.getText().toString();
                phoneNumberText = phone.getText().toString();
                passwordText = password.getText().toString();
                confPassText = confirmPassword.getText().toString();

                if (!fullNameText.equals("")) {
                    if (!emailText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                        if (phoneNumberText.length() > 9) {
                            if (passwordText.length() > 4) {
                                if (passwordText.equals(confPassText)) {

                                    Date currentTime = Calendar.getInstance().getTime();

                                    String dateString = String.valueOf(currentTime);

                                    dbHandler.addNewUser(fullNameText, emailText, phoneNumberText, passwordText, "dateString");
                                    Toast.makeText(v.getContext(), "User added.", Toast.LENGTH_SHORT).show();
                                    Intent goToLoginIntent = new Intent(v.getContext(), LoginActivity.class);
                                    goToLoginIntent.putExtra("email", emailText);
                                    v.getContext().startActivity(goToLoginIntent);


                                } else {

                                    Toast.makeText(v.getContext(), "Passwords don't match!", Toast.LENGTH_LONG).show();

                                }

                            }else {

                                Toast.makeText(v.getContext(), "Password is too weak!", Toast.LENGTH_LONG).show();
                            }

                        }else {

                            Toast.makeText(v.getContext(), "Phone number is too short!", Toast.LENGTH_LONG).show();
                        }

                    }else {

                        Toast.makeText(v.getContext(), "Invalid Email", Toast.LENGTH_LONG).show();
                    }

                }else {

                    Toast.makeText(v.getContext(), "Name cannot be empty!", Toast.LENGTH_LONG).show();
                }
            }



        });
        return view;
    }



    public View getTexts( View view){


        return view;
    }

}