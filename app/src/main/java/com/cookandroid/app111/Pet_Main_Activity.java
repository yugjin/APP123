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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

 public class Pet_Main_Activity extends AppCompatActivity {



    ArrayList<Pet_Value> mArray_value = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_main_layout );


        Button imageButton = (Button) findViewById(R.id.pet_add_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recyclerView ) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        SimpleTextAdapter adapter = new SimpleTextAdapter() ;
        recyclerView.setAdapter(adapter) ;

        Button _addBtn = findViewById(R.id.pet_main_btn_search);
        _addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }




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
        }

        // getItemCount() - 전체 데이터 갯수 리턴.
        @Override
        public int getItemCount() {
            return mArray_value.size() ;
        }
    }
}
