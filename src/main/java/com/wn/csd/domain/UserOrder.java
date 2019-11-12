package com.wn.csd.domain;

/**
 * @author weining
 * @date 2019/11/12 10:46
 */
public class UserOrder {
    private int id;
    private double oprice;
    private String cname;
    private String getcity;
    private String backcity;
    private String ostatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOprice() {
        return oprice;
    }

    public void setOprice(double oprice) {
        this.oprice = oprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGetcity() {
        return getcity;
    }

    public void setGetcity(String getcity) {
        this.getcity = getcity;
    }

    public String getBackcity() {
        return backcity;
    }

    public void setBackcity(String backcity) {
        this.backcity = backcity;
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", oprice=" + oprice +
                ", cname='" + cname + '\'' +
                ", getcity='" + getcity + '\'' +
                ", backcity='" + backcity + '\'' +
                ", ostatus='" + ostatus + '\'' +
                '}';
    }
}
