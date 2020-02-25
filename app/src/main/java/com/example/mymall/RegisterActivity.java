package com.example.mymall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

public class RegisterActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    public static boolean onResetPassFragment = false;
    public static boolean onRegisterFragment = false;

//    public static boolean setSignUpFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        frameLayout = findViewById(R.id.register_FrameLayout);

//        if (setSignUpFragment){
//            setSignUpFragment = false;
//            setDefaulFragment(new SignUpFragment());
//        }else {
//            setDefaulFragment(new SignInFragment());
//        }

        setDefaulFragment(new SignInFragment());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (onResetPassFragment){
                onResetPassFragment = false;
                setFragment(new SignInFragment());

                return false;
            }else if (onRegisterFragment){
                onRegisterFragment = false;
                setFragment(new SignInFragment());

                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    private void setDefaulFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_frome_right);
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}
