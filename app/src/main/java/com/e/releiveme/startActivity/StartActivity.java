package com.e.releiveme.startActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.releiveme.R;
import com.e.releiveme.ViewModels.AddUser;
import com.e.releiveme.homeActivity.HomeActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class StartActivity extends WearableActivity implements View.OnClickListener{

    private ImageView qrImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        qrImageView = (ImageView) findViewById(R.id.qr_view);
        // generate QR Code

        generateQrCode(qrImageView);

        qrImageView.setOnClickListener(this);
        // Enables Always-on
        setAmbientEnabled();

    }
    protected void generateQrCode(ImageView v){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        AddUser.setWatchUser();
        String userId=AddUser.getInstance().getWatchUserId() ;

        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(userId, BarcodeFormat.QR_CODE,500,500);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            v.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        StartActivity.this.startActivity(homeIntent);
        StartActivity.this.finish();

    }
}