package com.cookandroid.app111;

public class Item {
    String strName;
    String strLoc;
    String strEtc;

    public Item(String strName, String strLoc,String strEtc) {
        this.strName = strName;
        this.strLoc = strLoc;
        this.strEtc = strEtc;
    }
    public String getStrName() {
        return strName;
    }
    public String getStrLoc() {
        return strLoc;
    }
    public String getStrEtc() {
        return strEtc;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }
    public void setStrLoc(String strLoc) {
        this.strLoc = strLoc;
    }
    public void setStrEtc(String strEtc) {
        this.strEtc = strEtc;
    }
}
