package com.cjf.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.cjf.annotationdemo.bean.TestBean;
import com.cjf.annotationdemo.util.AnnotationUtil;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestBean testBean = new TestBean();
        testBean.setTestName("张三");
        testBean.setTestAge(16);
        printTestBeanInfo(testBean);
    }

    private <T> void printTestBeanInfo(T testBean) {
        AnnotationUtil<T> annotationUtil = new AnnotationUtil<>(testBean);
        String className = annotationUtil.getClassName();
        Map<String, String> fieldsNameAndType = new HashMap<>();
        Map<String, String> fieldNameAndValue = new HashMap<>();
        fieldsNameAndType = annotationUtil.getFieldsNameAndType();
        try {
            fieldNameAndValue = annotationUtil.getFieldNameAndValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String classInfo = "ClassName: " + className + "\n" +
                "fieldsNameAndType" + fieldsNameAndType.toString() + "\n" +
                "fieldNameAndValue" + fieldNameAndValue.toString() + "\n";
        Log.e(TAG, classInfo);
    }
}
