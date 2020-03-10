package app.example.roomdatabase;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Attribute implements Serializable {
    @SerializedName("el_id") public String el_id;
    @SerializedName("el_vendor") public String el_vendor;
    @SerializedName("el_floor_list") public String el_floor_list;
    @SerializedName("desc") public String desc;
    @SerializedName("tel") public String tel;

    public String getEl_id() {
        return el_id;
    }

    public void setEl_id(String el_id) {
        this.el_id = el_id;
    }

    public String getEl_vendor() {
        return el_vendor;
    }

    public void setEl_vendor(String el_vendor) {
        this.el_vendor = el_vendor;
    }

    public String getEl_floor_list() {
        return el_floor_list;
    }

    public void setEl_floor_list(String el_floor_list) {
        this.el_floor_list = el_floor_list;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
