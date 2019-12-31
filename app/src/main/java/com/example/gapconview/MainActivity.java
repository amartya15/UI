package com.example.gapconview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ImageView iv;
    private static final int pic_id = 123;
    ImageView click_image_id;
    EditText etcname,etrdate,etcno,etcdate,etdoccumentno,etrmaterial,etquantity,etcustomerpono,etrollpackingtype,ettotalrollweight,etrllvalue,ettransport,etlrno;
    Spinner etcode;

    DatePickerDialog datePickerDialog;
    TextView date,newdate;
    int year,month,dayofmonth;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click_image_id = findViewById(R.id.click_image);
        etcname=findViewById(R.id.etcname);
       etcode=findViewById(R.id.etcode);
       etcode.setOnItemSelectedListener(this);
        etcustomerpono=findViewById(R.id.etcopono);
        etrollpackingtype=findViewById(R.id.etrolltype);
        ettotalrollweight=findViewById(R.id.ettotalweight);
        etrllvalue=findViewById(R.id.etrollvalue);
        ettransport=findViewById(R.id.ettransporter);
        etlrno=findViewById(R.id.etlrno);


        etcno=findViewById(R.id.etchalanno);
        etcdate=findViewById(R.id.etchalandate);
        etdoccumentno=findViewById(R.id.etdocumentno);
        etrmaterial=findViewById(R.id.recievedmaterial);
        etquantity=findViewById(R.id.etquantity);
        date =findViewById(R.id.date);
        newdate =findViewById(R.id.newdate);
       LinearLayout constraintLayout = findViewById(R.id.layout);
       AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
      animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

    }

    public void camera(View view) {


        // Camera_open button is for open the camera
        // and add the setOnClickListener in this button




                // Create the camera_intent ACTION_IMAGE_CAPTURE
                // it will open the camera for capture the image
                Intent camera_intent
                        = new Intent(MediaStore
                        .ACTION_IMAGE_CAPTURE);

                // Start the activity with camera_intent,
                // and request pic id
                startActivityForResult(camera_intent, pic_id);

            }



    // This method will help to retrieve the image
  /*  protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            // BitMap is data structure of image file
            // which stor the image in memory
            Bitmap photo = (Bitmap) data.getExtras()
                    .get("data");

            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
        }
    }*/
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bm=(Bitmap) data.getExtras().get("data");
        click_image_id.setImageBitmap(bm);
    }


    public void date(View view) {
        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        dayofmonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        date.setText(day + "/" + (month +1) + "/" + year);
                    }
                },year,month,dayofmonth);
        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,adapterView.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void newdate(View view) {
        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        dayofmonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        newdate.setText(day + "/" + (month +1) + "/" + year);
                    }
                },year,month,dayofmonth);
        datePickerDialog.show();
    }

    public void submit(View view) {

        Toast.makeText(this,"Thank you...\nYour data is saved",Toast.LENGTH_SHORT).show();

    }
}




