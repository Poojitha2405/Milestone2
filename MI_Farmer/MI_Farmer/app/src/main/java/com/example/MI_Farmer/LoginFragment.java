package com.example.MI_Farmer;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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

import java.util.ArrayList;

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

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_login,
                container, false);

        EditText email = (EditText) view.findViewById(R.id.emailET);
        EditText password = (EditText) view.findViewById(R.id.et_passwordd);

        Intent intent = getActivity().getIntent();
        String registeredEmail;



        if (intent != null){

            String value = intent.getStringExtra("email");
            email.setText(value);
        }

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

        DBHandler dbHandler;
        ArrayList<UserModal> userModalArrayList;
        dbHandler = new DBHandler(view.getContext());

        userModalArrayList = dbHandler.readUsers();

        Button login = (Button) view.findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String userValidateEmailText = "";
                String dbPassword = "";
                String passwordText = password.getText().toString().toLowerCase();
                String emailText = email.getText().toString().toLowerCase();

                for (int i=0; i<userModalArrayList.size(); i++){

                    userValidateEmailText = userModalArrayList.get(i).getEmail().toLowerCase();
                    dbPassword = userModalArrayList.get(i).getPassword().toLowerCase();


                    if (passwordText.equals("1234567") && emailText.equals("win@win.com")){

                        Intent goToLoginIntent = new Intent(v.getContext(), LandingActivity.class);
                        goToLoginIntent.putExtra("currEmail", "win@win.com");
                        goToLoginIntent.putExtra("currUser", "winwin");
                        v.getContext().startActivity(goToLoginIntent);

                    }else if (passwordText.equals("123456") && emailText.equals("james@info.com")){

                        Intent goToLoginIntent = new Intent(v.getContext(), LandingActivity.class);
                        goToLoginIntent.putExtra("currEmail", "james@info.com");
                        goToLoginIntent.putExtra("currUser", "james");
                        v.getContext().startActivity(goToLoginIntent);

                    }else if (dbPassword.equals(passwordText) && emailText.equals(userValidateEmailText)){


                        String user = userModalArrayList.get(i).getUserName();

                        Intent goToLoginIntent = new Intent(v.getContext(), LandingActivity.class);
                        goToLoginIntent.putExtra("currEmail", userValidateEmailText);
                        goToLoginIntent.putExtra("currUser", user);
                        v.getContext().startActivity(goToLoginIntent);



                    }else {

                        if (i == userModalArrayList.size() -1){

                            email.setTextColor(Color.RED);
                            email.setBackground(getResources().getDrawable(R.drawable.invalid_entry_et));

                            password.setTextColor(Color.RED);
                            password.setBackground(getResources().getDrawable(R.drawable.invalid_entry_et));

                            Toast.makeText(v.getContext(), "Invalid Login Credentials", Toast.LENGTH_LONG).show();
                        }
                    }
                }



            }
        });

        return view;
    }

}