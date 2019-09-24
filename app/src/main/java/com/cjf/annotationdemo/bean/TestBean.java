package com.cjf.annotationdemo.bean;

import com.cjf.annotationdemo.annotation.FieldID;
import com.cjf.annotationdemo.annotation.Name;


public class TestBean {

    private String testName;

    private int testAge;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestAge() {
        return testAge;
    }

    public void setTestAge(int testAge) {
        this.testAge = testAge;
    }
}
