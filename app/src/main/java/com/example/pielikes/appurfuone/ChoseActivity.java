package com.example.pielikes.appurfuone;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class ChoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);
    }

    public void ClickOnB(View view) {
        Intent intent = new Intent(ChoseActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    public void ClickOnM(View view) {
        Intent intent = new Intent(ChoseActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
