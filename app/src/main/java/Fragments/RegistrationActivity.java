package Fragments;


import android.content.Context;
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

import com.e.softwaricaassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationActivity extends Fragment implements View.OnClickListener {
    private EditText etUsername, etPassword;
    private Button btnRegistration;


    public RegistrationActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_registration, container, false);

        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        etUsername = view.findViewById(R.id.etUserName);
        etPassword = view.findViewById(R.id.etPassword);
        btnRegistration = view.findViewById(R.id.btnRegistration);

        btnRegistration.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        if (!validate()) {
            return;
        }
        SignUp();

    }

    private void SignUp() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserName", etUsername.getText().toString());
        editor.putString("Password", etPassword.getText().toString());
        editor.commit();

        Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_SHORT).show();
    }

    public Boolean validate() {
        boolean isValid = true;
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError("Please Enter Username");
            etUsername.requestFocus();
            isValid = false;
        } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Please Enter Password");
            etPassword.requestFocus();
            isValid = false;

        }
        return isValid;
    }
}
