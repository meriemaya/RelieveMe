package com.e.releiveme.startActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.releiveme.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends WearableActivity {

    private ImageView qrImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrImageView = (ImageView) findViewById(R.id.qr_view);
        // generate QR Code

        generateQrCode(qrImageView);
        // Enables Always-on
        setAmbientEnabled();

    }
    protected void generateQrCode(ImageView v){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        String userId="12345" ;

        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(userId, BarcodeFormat.QR_CODE,500,500);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            v.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
