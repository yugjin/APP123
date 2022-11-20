package com.cookandroid.app111;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import gun0912.tedimagepicker.builder.TedImagePicker;
import gun0912.tedimagepicker.builder.listener.OnSelectedListener;

public class SubActivity extends AppCompatActivity {
    EditText sub_et_name;
    EditText sub_et_loc;
    EditText sub_et_etc;
    Button btn;

    ImageView mImg;

    Uri mImg_Uri;


    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            setImage_View();
        }
    };

    void setImage_View(){
        Glide.with(this)
                .load( mImg_Uri.toString())
                .thumbnail(0.1f)
                .into( mImg);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_input_layout);

        btn = (Button) findViewById(R.id.pet_add_btn2);
        sub_et_name = findViewById(R.id.sub_et_name);
        sub_et_loc = findViewById(R.id.sub_et_loc);
        sub_et_etc = findViewById(R.id.sub_et_etc);
        mImg =  findViewById(R.id.row_img);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String strName = sub_et_name.getText().toString();
                String strLoc = sub_et_loc.getText().toString();
                String strEtc = sub_et_etc.getText().toString();

                if(mImg_Uri == null ){
                    Toast.makeText(SubActivity.this, "이미지를 선택하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                /**   Pet_Value(String _name, String _loc, String _etc, String _img){  */
                Pet_Value _temp = new Pet_Value( strName, strLoc, strEtc, mImg_Uri.toString() );
                Intent t = new Intent();
                t.putExtra("_petInfo", _temp);
                setResult(RESULT_OK, t);
                finish();


            }
        });

        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takcPicture();
            }
        });
    }



    void takcPicture(){
        TedImagePicker.with(this)
                .start(new OnSelectedListener() {
                    @Override
                    public void onSelected(@NotNull Uri uri) {
                        mImg_Uri = uri;
                        mHandler.sendEmptyMessage(0);
                    }
                });
    }


}
