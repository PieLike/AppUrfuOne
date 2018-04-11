package com.example.pielikes.appurfuone;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class DirectionBI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.direction_bi);
        setTitle("Программа Подготовки");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String number = getIntent().getStringExtra("info");


        TextView name = (TextView) findViewById(R.id.textBI1_1);
        name.setText(this.getResources().
                getIdentifier("NAPR_name_"+number, "string", this.getPackageName()));

        TextView code = (TextView) findViewById(R.id.textBI1_2);
        code.setText(this.getResources().
                getIdentifier("NAPR_code_"+number, "string", this.getPackageName()));

                TextView level = (TextView) findViewById(R.id.textBI1_3);
        level.setText(this.getResources().
                getIdentifier("NAPR_level_"+number, "string", this.getPackageName()));

        TextView institute = (TextView) findViewById(R.id.textBI2_2);
        institute.setText(this.getResources().
                getIdentifier("NAPR_institute_"+number, "string", this.getPackageName()));

        TextView form = (TextView) findViewById(R.id.textBI3_2);
        form.setText(this.getResources().
                getIdentifier("NAPR_form_"+number, "string", this.getPackageName()));

        TextView testing = (TextView) findViewById(R.id.textBI4_2);
        testing.setText(this.getResources().
                getIdentifier("NAPR_testing_"+number, "string", this.getPackageName()));

        TextView passingScore = (TextView) findViewById(R.id.textBI4_5);
        passingScore.setText(this.getResources().
                getIdentifier("NAPR_passingScore_"+number, "string", this.getPackageName()));

        TextView plasesFT = (TextView) findViewById(R.id.textBI5_3);
        plasesFT.setText(this.getResources().
                getIdentifier("NAPR_plasesFT_"+number, "string", this.getPackageName()));

        TextView plasesPT = (TextView) findViewById(R.id.textBI5_6);
        plasesPT.setText(this.getResources().
                getIdentifier("NAPR_plasesPT_"+number, "string", this.getPackageName()));

        TextView description = (TextView) findViewById(R.id.textBI6_2);
        description.setText(this.getResources().
                getIdentifier("NAPR_description_"+number, "string", this.getPackageName()));


  //      Toast.makeText(DirectionBI.this, number ,Toast.LENGTH_SHORT).show();
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
        }

        return  super.onOptionsItemSelected(item);
    }
}
