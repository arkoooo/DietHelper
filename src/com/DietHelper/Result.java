package com.DietHelper;
public class Result {
    private int id, patientId, firstResult, secondResult,thirdResult;
    private String date;
    private TypeOfResults typeOfResults;

    public Result(int id, int patientId, TypeOfResults typeOfResults) {
        this.id = id;
        this.patientId = patientId;
        this.typeOfResults = typeOfResults;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getSecondResult() {
        return secondResult;
    }

    public void setSecondResult(int secondResult) {
        this.secondResult = secondResult;
    }

    public int getThirdResult() {
        return thirdResult;
    }

    public void setThirdResult(int thirdResult) {
        this.thirdResult = thirdResult;
    }

    public TypeOfResults getTypeOfResults() {
        return typeOfResults;
    }
    public void setTypeOfResults(TypeOfResults typeOfResults) {
        this.typeOfResults = typeOfResults;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
enum TypeOfResults {
    INSULIN, GLYCEMIA
}