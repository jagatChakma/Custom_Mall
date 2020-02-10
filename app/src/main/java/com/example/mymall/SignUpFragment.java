package com.example.mymall;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    private TextView signInLink;
    private FrameLayout parentFrameLayout;

    private EditText email, fullName, passWord, confirmPassword;
    private Button signUpButton;

    private FirebaseAuth fAuth;
    private FirebaseFirestore firebaseFirestore;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        signInLink = view.findViewById(R.id.signin_link);
        parentFrameLayout = getActivity().findViewById(R.id.register_FrameLayout);

        email = view.findViewById(R.id.reg_user_email);
        fullName = view.findViewById(R.id.reg_fullname);
        passWord = view.findViewById(R.id.reg_password);
        confirmPassword = view.findViewById(R.id.reg_con_password);

        signUpButton = view.findViewById(R.id.register_button);

        fAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                checkEmailAndPassword();
            }
        });
    }

//    private void createAccount() {
//        String reg_email = email.getText().toString();
//        String reg_fullName = fullName.getText().toString();
//        String reg_pass = passWord.getText().toString();
//        String reg_con_pass = confirmPassword.getText().toString();
//
//        if (TextUtils.isEmpty(reg_email)){
//            Toast.makeText(getActivity(), "Email fild is empty", Toast.LENGTH_SHORT).show();
//        }if (TextUtils.isEmpty(reg_fullName)){
//            Toast.makeText(getActivity(), "Name fild is empty", Toast.LENGTH_SHORT).show();
//        }if (TextUtils.isEmpty(reg_pass)){
//            Toast.makeText(getActivity(), "Password fild is empty", Toast.LENGTH_SHORT).show();
//        }if (TextUtils.isEmpty(reg_con_pass)){
//            Toast.makeText(getActivity(), "Conprame your pass", Toast.LENGTH_SHORT).show();
//        }if (!(reg_pass == reg_con_pass)){
//            Toast.makeText(getActivity(), "Password not match", Toast.LENGTH_SHORT).show();
//        }else{
//            lodingBar.setTitle("Create account");
//            lodingBar.setMessage("Please wate.....");
//            lodingBar.setCanceledOnTouchOutside(false);
//            lodingBar.show();
//        }
//    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_frome_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void checkInput() {
        if (!TextUtils.isEmpty(email.getText())){
            if (!TextUtils.isEmpty(fullName.getText())){
                if (!TextUtils.isEmpty(passWord.getText()) && passWord.length() >= 8){
                    if (!TextUtils.isEmpty(confirmPassword.getText())){
                        signUpButton.setEnabled(true);
                    }else{
                        signUpButton.setEnabled(false);
                    }
                }else {
                    signUpButton.setEnabled(false);
                }
            }else {
                signUpButton.setEnabled(false);
            }
        }else {
            signUpButton.setEnabled(false);
        }
    }

    private void checkEmailAndPassword() {
        if (email.getText().toString().matches(emailPattern)){
            if (passWord.getText().toString().equals(confirmPassword.getText().toString())){

                signUpButton.setEnabled(false);

                fAuth.createUserWithEmailAndPassword(email.getText().toString(), passWord.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Map<Object,String> userData = new HashMap<>();
                            userData.put("fullname", fullName.getText().toString());
                            firebaseFirestore.collection("USERS").add(userData)
                                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentReference> task) {
                                            if (task.isSuccessful()){
                                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                                startActivity(intent);
                                                getActivity().finish();
                                            }else {
                                                signUpButton.setEnabled(false);

                                                String error = task.getException().getMessage();
                                                Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }else {
                            signUpButton.setEnabled(false);

                            String error = task.getException().getMessage();
                            Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else {
                confirmPassword.setError("Password doesn't matched!");
            }
        }else {
            email.setError("Invalid email!");
        }
    }

}
