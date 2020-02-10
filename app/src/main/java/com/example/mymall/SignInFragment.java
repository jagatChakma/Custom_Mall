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

import static com.example.mymall.RegisterActivity.onRegisterFragment;
import static com.example.mymall.RegisterActivity.onResetPassFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {
    private TextView signUpLink;
    private FrameLayout parentFrameLayout;

    private EditText email, passWord;
    private TextView skipAccountCreation, forgotPass;
    private Button logInBtn;

    private FirebaseAuth fireAuth;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";


    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        signUpLink = view.findViewById(R.id.signup_link);
        parentFrameLayout = getActivity().findViewById(R.id.register_FrameLayout);

        skipAccountCreation = view.findViewById(R.id.skipSection);
        email = view.findViewById(R.id.user_email);
        passWord = view.findViewById(R.id.user_password);
        forgotPass = view.findViewById(R.id.forgot_password);
        logInBtn = view.findViewById(R.id.login_button);

        fireAuth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterFragment = true;
                setFragment(new SignUpFragment());
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetPassFragment = true;
                setFragment(new ResetPasswordFragment());
            }
        });

        skipAccountCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
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
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassWord();
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_frome_left);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(email.getText())){
            if (!TextUtils.isEmpty(passWord.getText()) && passWord.length() >= 8){
                logInBtn.setEnabled(true);
            }else {
                logInBtn.setEnabled(false);
            }
        }else {
            logInBtn.setEnabled(false);
        }
    }

    private void checkEmailAndPassWord() {
        if (email.getText().toString().matches(emailPattern)){
            //...............................
            if (passWord.length() >= 8){
                //  progressBar show
                logInBtn.setEnabled(false);//...........
                fireAuth.signInWithEmailAndPassword(email.getText().toString(), passWord.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    //progressbar not show/ desable
                                    mainIntent();
                                }else {
                                    // progressbar not show
                                    String erron = task.getException().getMessage();
                                    Toast.makeText(getActivity(), erron, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }else {
                Toast.makeText(getActivity(), "Incorrect password", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(), "Incorrect email address", Toast.LENGTH_SHORT).show();
        }
    }

    private void mainIntent() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
