package com.finalproject.flavourfeed.Pages;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.finalproject.flavourfeed.R;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsPage extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);
        mAuth = FirebaseAuth.getInstance();
        ImageView icnSettingsBack = findViewById(R.id.btnBack);
        LinearLayout lnkChangeEmail = findViewById(R.id.lnkChangeEmail);
        LinearLayout lnkChangePassword = findViewById(R.id.lnkChangePasword);
        LinearLayout lnkDeleteAccount = findViewById(R.id.lnkDeleteAccount);
        LinearLayout lnkTheme = findViewById(R.id.lnkTheme);
        LinearLayout lnkLogOut = findViewById(R.id.lnkLogOut);

        icnSettingsBack.setOnClickListener(v -> SettingsPage.super.onBackPressed());

        lnkChangeEmail.setOnClickListener(v -> goTo(ChangeEmailPage.class));
        lnkChangePassword.setOnClickListener(v -> goTo(ChangePasswordPage.class));
        lnkDeleteAccount.setOnClickListener(v -> goTo(DeleteAccountPage.class));
        lnkTheme.setOnClickListener(v -> goTo(ThemePage.class));
        lnkLogOut.setOnClickListener(v -> {
            mAuth.signOut();
            goTo(LogInPage.class);
        });

    }

    public void goTo(Class<?> destinationClass) {
        startActivity(new Intent(getApplicationContext(), destinationClass));
    }
}