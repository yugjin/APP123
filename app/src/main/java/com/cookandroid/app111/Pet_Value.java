package com.cookandroid.app111;

import java.io.Serializable;

class Pet_Value implements Serializable {
    String mName = "";
    String mAddr = "";
    String mThumb = "";
    String _gps_lng = "";
    String _gps_lat = "";
    String mEtc_str = "";

    Pet_Value(){}

    Pet_Value(String _str){

        mName = "이름";
        mAddr = "위치";
        mEtc_str = "특징";

    }

    Pet_Value(String _name, String _loc, String _etc, String _img){
        mName = _name;
        mAddr = _loc;
        mEtc_str = _etc;
        mThumb = _img;
    }

}
