package Fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.softwaricaassignment.DashboardActivity;
import com.e.softwaricaassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginActivity extends Fragment implements View.OnClickListener {
    private Button btnLogin;
    private EditText etUserName, etPassword;

    public LoginActivity() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUserName = view.findViewById(R.id.etUserName);
        etPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View v) {
        if (!validate()) {
            return;
        }
        checkUser();


    }

    private void checkUser() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("UserName", "");
        String password = sharedPreferences.getString("Password", "");
        if (username.equals(etUserName.getText().toString()) && password.equals(etPassword.getText().toString())) {
            Intent intent = new Intent(getActivity(), DashboardActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getActivity(), "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }

    public Boolean validate() {
        boolean isValid = true;
        if (TextUtils.isEmpty(etUserName.getText().toString())) {
            etUserName.setError("Please Enter Username");
            etUserName.requestFocus();
            isValid = false;
        } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Please Enter Password");
            etPassword.requestFocus();
            isValid = false;

        }
        return isValid;

    }
}
