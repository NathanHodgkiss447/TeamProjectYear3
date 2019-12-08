package com.example.teamprojectyear3;

public class Graduation {

String FPCHS;
String maleGrad;
String femaleGrad;

    public Graduation(String FPCHS, String maleGrad, String femaleGrad) {
        this.FPCHS = FPCHS;
        this.maleGrad = maleGrad;
        this.femaleGrad = femaleGrad;
    }


    public String getFPCHS() {
        return FPCHS;
    }

    public void setFPCHS(String FPCHS) {
        this.FPCHS = FPCHS;
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
