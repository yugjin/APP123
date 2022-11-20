package com.cookandroid.app111;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

 public class Pet_Main_Activity extends AppCompatActivity {

    ArrayList<Pet_Value> mArray_value = new ArrayList<>();

     RecyclerView mRecyclerView;


     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_main_layout);

        Button imageButton = (Button) findViewById(R.id.pet_add_btn);
        Intent i = getIntent();

        String strName = i.getStringExtra("strName");
        String strLoc = i.getStringExtra("strLoc");
        String strEtc = i.getStringExtra("strEtc");
        Toast.makeText(getApplicationContext(), strName + " " + strLoc + " " + strEtc, Toast.LENGTH_LONG).show();


//        Button pet_add_btn2;
//        EditText sub_et_name, sub_et_loc, sub_et_etc;
//        MyRecyclerAdapter adapter;



//            sub_et_name = findViewById(R.id.sub_et_name);
//            sub_et_loc = findViewById(R.id.sub_et_loc);
//            sub_et_etc = findViewById(R.id.sub_et_etc);
//            pet_add_btn2 = findViewById(R.id.btn_add);
//
//            RecyclerView recyclerView = findViewById(R.id.recyclerview);
//
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(linearLayoutManager);
//
//            adapter = new MyRecyclerAdapter();
//            recyclerView.setAdapter(adapter);
//
//            pet_add_btn2.setOnClickListener(v -> {
//                Data data = new Data(sub_et_name.getText().toString(), sub_et_loc.getText().toString(), sub_et_etc.getText().toString());
//                adapter.addItem(data);
//            });




        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
         mRecyclerView = findViewById(R.id.recyclerView);
         mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        SimpleTextAdapter adapter = new SimpleTextAdapter();
         mRecyclerView.setAdapter(adapter);

        Button _searchBtn = findViewById(R.id.pet_main_btn_search);
        _searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }


     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);

         if( resultCode == RESULT_OK){
             if( requestCode == 100){
                 Pet_Value _temp = (Pet_Value) data.getSerializableExtra("_petInfo") ;
                 mArray_value.add(_temp);

                 mRecyclerView.getAdapter().notifyDataSetChanged();

             }
         }
     }



     class Item_Click implements View.OnClickListener{
         @Override
         public void onClick(View view) {
             Intent t = new Intent(Pet_Main_Activity.this, MainActivity.class);
             startActivity(t);
         }
     }


     Item_Click mItemClick = new Item_Click();

     public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {


        // 아이템 뷰를 저장하는 뷰홀더 클래스.
        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView _imgThumb ;


            TextView mTv_name ;
            TextView mTv_loc ;
            TextView mTv_etc ;


            ViewHolder(View itemView) {
                super(itemView) ;
                Log.i("-del ", "33");
                _imgThumb = itemView.findViewById(R.id.row_img);
                mTv_name = itemView.findViewById(R.id.row_tv_name);
                mTv_loc = itemView.findViewById(R.id.row_tv_loc);
                mTv_etc = itemView.findViewById(R.id.row_tv_etc);

                itemView.setOnClickListener( mItemClick );

            }
        }


        // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
        @Override
        public SimpleTextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.i("-del ", "1111");
            Context context = parent.getContext() ;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

            View view = inflater.inflate(R.layout.pet_main_layout_row, parent, false) ;
            SimpleTextAdapter.ViewHolder vh = new SimpleTextAdapter.ViewHolder(view) ;

            return vh ;
        }

        // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
        @Override
        public void onBindViewHolder(SimpleTextAdapter.ViewHolder holder, int position) {
            Log.i("-del ", "222");
            Pet_Value _pet = mArray_value.get(position) ;

            holder.mTv_name.setText( _pet.mName);
            holder.mTv_loc.setText( _pet.mAddr);
            holder.mTv_etc.setText( _pet.mEtc_str);

            Glide.with(Pet_Main_Activity.this )
                    .load( _pet.mThumb)
                    .thumbnail(0.1f)
                    .into( holder._imgThumb);
        }

        // getItemCount() - 전체 데이터 갯수 리턴.
        @Override
        public int getItemCount() {
            return mArray_value.size() ;
        }
    }
}
