package com.example.teamprojectyear3;

/*

        Code From: https://www.youtube.com/watch?v=i_GuZ_6ZRJM&t=261s

 */


public class EmployerRequirements {
    private String employerId;
    private String degreeName;
    private String degreeType;
    private String degreeLevel;
    private String area;


    public EmployerRequirements(){

    }



    public EmployerRequirements(String employerId, String degreeName, String degreeType,
                                String degreeLevel, String area){
        this.employerId = employerId;
        this.degreeName = degreeName;
        this.degreeType = degreeType;
        this.degreeLevel = degreeLevel;
        this.area = area;
    }




    //Set methods
    public String getEmployerId() {
        return employerId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public String getArea() {
        return area;
    }
}
