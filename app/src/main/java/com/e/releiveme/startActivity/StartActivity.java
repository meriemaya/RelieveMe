package com.e.releiveme.startActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.e.releiveme.R;
import com.e.releiveme.homeActivity.HomeActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.UUID;

public class StartActivity extends FragmentActivity{

    private ImageView qrImageView;
    ViewModel  viewModel ;
    public static final String USER_KEY ="userId";
    public static final String SHARED_NAME="userData";
    public static final String USER_NAME ="userName";
    public static final String USER_BIRTH_DATE ="userBirth";
    String userName;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        sharedPreferences = this.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
        qrImageView = (ImageView) findViewById(R.id.qr_view);
        viewModel =new ViewModel(this);
        // generate QR Code

        generateQrCode(qrImageView);

        qrImageView.setOnClickListener(view ->{
             onUserReady();
        }

        );
        // Enables Always-on
        initObservers();
    }

    private void initObservers() {

        viewModel.loaded.observe(this, (data->{

            if(data){
                goHome();
            }else {
                Toast.makeText(this,"Veuillez patienter que votre compte soit crée",Toast.LENGTH_LONG);
            }
        }));
    }

    protected void generateQrCode(ImageView v){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        userName =sharedPreferences.getString(USER_NAME,null);
        if(userName !=null){
           onUserReady();
        }else{
            userName = UUID.randomUUID().toString();
            sharedPreferences.edit().putString(USER_KEY, userName).commit();

            try{
                BitMatrix bitMatrix = multiFormatWriter.encode(userName, BarcodeFormat.QR_CODE,500,500);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                v.setImageBitmap(bitmap);
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }

    public void onUserReady() {
       viewModel.requestProfile("99b5e75a-f807-4be4-bebb-da2ed7d24bef");
    }

    public void goHome(){
        Intent homeIntent = new Intent(this, HomeActivity.class);
        StartActivity.this.startActivity(homeIntent);
        StartActivity.this.finish();
    }

}