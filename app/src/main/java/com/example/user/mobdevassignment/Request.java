package com.example.user.mobdevassignment;

public class Request {
    private String name;
    private String university;
    private String problem;
    private String phone;
    private String model;
    private String condition;
    private String caseID;
    private String repairman;


    public Request(){}

    public Request(String name, String university, String problem, String phone, String model, String condition, String repairman) {
        this.name = name;
        this.university = university;
        this.problem = problem;
        this.phone = phone;
        this.model = model;
        this.condition = condition;
        this.repairman = repairman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getRepairman() {
        return repairman;
    }

    public void setRepairman(String repairman) {
        this.repairman = repairman;
    }
}
