package com.example.teamprojectyear3;

public class Graduation {

String FCPHS;
String maleGrad;
String femaleGrad;

    public Graduation(String FCPHS, String maleGrad, String femaleGrad) {
        this.FCPHS = FCPHS;
        this.maleGrad = maleGrad;
        this.femaleGrad = femaleGrad;
    }


    public String getFCPHS() {
        return FCPHS;
    }

    public void setFCPHS(String FCPHS) {
        this.FCPHS = FCPHS;
    }

    public String getMaleGrad() {
        return maleGrad;
    }

    public void setMaleGrad(String maleGrad) {
        this.maleGrad = maleGrad;
    }

    public String getFemaleGrad() {
        return femaleGrad;
    }

    public void setFemaleGrad(String femaleGrad) {
        this.femaleGrad = femaleGrad;
    }
}
