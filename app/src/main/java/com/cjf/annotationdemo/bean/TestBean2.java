package com.cjf.annotationdemo.bean;

import com.cjf.annotationdemo.annotation.FieldID;
import com.cjf.annotationdemo.annotation.Name;

@SuppressWarnings("unused")
@Name("TestBean2_Rename")
public class TestBean2 {

    //注解中只有value时，value可以省略
    @FieldID(value = "length_Rename")
    private Double length;
    private Double width;

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
