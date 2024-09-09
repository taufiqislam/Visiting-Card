package com.example.visitingcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void onCall(View view) {
        TextView phoneNumberTextView = findViewById(R.id.phoneNumber);
        String phoneNumber = phoneNumberTextView.getText().toString();
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }

    public void onEmail(View view) {
        TextView emailTextView = findViewById(R.id.emailAddress);
        String emailAddress = emailTextView.getText().toString();

        if (!emailAddress.isEmpty()) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822"); // Set the MIME type for email
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email body text here");

            startActivity(emailIntent);
        } else {
            Toast.makeText(MainActivity.this, "Email address is empty", Toast.LENGTH_SHORT).show();
        }
    }

    public void onGithub(View view) {
        String githubUrl = "https://github.com/taufiqislam"; // Replace with your GitHub profile URL
        Intent githubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
        startActivity(githubIntent);
    }

    public void onLinkedin(View view) {
        String linkedinUrl = "https://www.linkedin.com/in/taufiq-islam-6a1073238"; // Replace with your LinkedIn profile URL
        Intent linkedinIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl));
        startActivity(linkedinIntent);
    }
}