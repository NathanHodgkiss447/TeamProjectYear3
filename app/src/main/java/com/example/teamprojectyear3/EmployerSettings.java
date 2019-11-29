package com.example.teamprojectyear3;

/*

        Code From: https://www.youtube.com/watch?v=i_GuZ_6ZRJM&t=261s

 */

public class EmployerSettings {
    private String settingID;
    private String settingName;
    private String settingCompany;
    private String settingTitle;
    private String settingEmail;

    public EmployerSettings(){

    }

    public EmployerSettings(String settingID, String settingName, String settingCompany, String settingTitle, String settingEmail) {
        this.settingID = settingID;
        this.settingName = settingName;
        this.settingCompany = settingCompany;
        this.settingTitle = settingTitle;
        this.settingEmail = settingEmail;
    }

    //Get and Set methods
    public String getSettingID() {
        return settingID;
    }

    public String getSettingName() {
        return settingName;
    }

    public String getSettingCompany() {
        return settingCompany;
    }

    public String getSettingTitle() {
        return settingTitle;
    }

    public String getSettingEmail() {
        return settingEmail;
    }



}
