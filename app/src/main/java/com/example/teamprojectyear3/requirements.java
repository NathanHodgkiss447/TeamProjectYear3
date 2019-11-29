package com.example.teamprojectyear3;

public class requirements {

    private String area;
    private String degreeLevel;
    private String degreeName;
    private String degreeType;
    private String company;

    public requirements()
    {

    }
   public requirements(String area, String degreeLevel,String degreeName,String degreeType,String company) {
        this.area = area;
        this.degreeLevel = degreeLevel;
        this.degreeName = degreeName;
        this.degreeType = degreeType;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }
}
