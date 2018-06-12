package com.xuanzilan.springMVC.bean;

public class School {
    private String sname;
    private String addr;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "School{" +
                "sname='" + sname + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
