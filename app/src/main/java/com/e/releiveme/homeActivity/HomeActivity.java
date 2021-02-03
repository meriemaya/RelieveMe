package com.e.releiveme.homeActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.wear.ambient.AmbientModeSupport;

import com.e.releiveme.Models.SimpleFragmentPageAdapter;
import com.e.releiveme.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class HomeActivity extends FragmentActivity implements AmbientModeSupport.AmbientCallbackProvider {

    private ImageView qrImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find the view pager that will
        // allow the user to swipe
        // between fragments
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        // Create an adapter that
        // knows which fragment should
        // be shown on each page
        SimpleFragmentPageAdapter adapter = new SimpleFragmentPageAdapter(getSupportFragmentManager());

        // Set the adapter onto
        // the view pager
        viewPager.setAdapter(adapter);

        //qrImageView = (ImageView) findViewById(R.id.qr_view);
        // generate QR Code

        //generateQrCode(qrImageView);
        // Enables Always-on
        //setAmbientEnabled();

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

    @Override
    public AmbientModeSupport.AmbientCallback getAmbientCallback() {
        return null;
    }
}
