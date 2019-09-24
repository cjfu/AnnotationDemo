package com.cjf.annotationdemo.util;

import com.cjf.annotationdemo.annotation.FieldID;
import com.cjf.annotationdemo.annotation.Name;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationUtil<T> {

    private T testBean;

    public AnnotationUtil(T t) {
        testBean = t;
    }

    /**
     * 获取类注解的值
     * 若注解无值，则获取类名作为返回值
     *
     * @return 类名
     */
    public String getClassName() {
        Name name = testBean.getClass().getAnnotation(Name.class);
        String value;
        value = name != null ? name.value() : testBean.getClass().getSimpleName();
        return value;
    }

    /**
     * 获取属性名与值
     * 属性名：优先使用注解定义的名称，若注解未赋值，则使用属性自己的名称
     * 值：属性的值，用toString转为了String类型。
     *
     * @return 返回map类型，key为属性名，value为属性的值。
     * @throws IllegalAccessException field.get会抛出异常，返回上层处理
     */
    public Map<String, String> getFieldNameAndValue() throws IllegalAccessException {
        Field[] fields = testBean.getClass().getDeclaredFields();
        Map<String, String> nameAndValue = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            FieldID fieldID = field.getAnnotation(FieldID.class);
            String key = (fieldID != null) ? fieldID.value() : field.getName();
            Object o = field.get(testBean);
            String value = o != null ? o.toString() : null;
            nameAndValue.put(key, value);
        }
        return nameAndValue;
    }

    /**
     * 通过field获取属性名称
     * @param field Field
     * @return 属性名称
     */
    private String getFieldName(Field field) {
        field.setAccessible(true);
        FieldID fieldID = field.getAnnotation(FieldID.class);
        return (fieldID != null) ? fieldID.value() : field.getName();
    }

    /**
     * 通过field获取属性类型
     * @param field Field
     * @return 属性类型
     */
    private String getFieldType(Field field) {
        Class<?> fieldType = field.getType();
        String type = "unKnowType";
        if (fieldType == String.class) {
            type = "String";
        } else if (fieldType == Integer.class || fieldType == int.class) {
            type = "Integer";
        } else if (fieldType == Double.class || fieldType == double.class) {
            type = "Double";
        } else if (fieldType == Float.class || fieldType == float.class) {
            type = "Float";
        }
        return type;
    }

    /**
     *  获取所有属性的类型
     * @return key代表属性名，value代表属性类型
     */
    public Map<String, String> getFieldsNameAndType() {
        Map<String, String> types = new HashMap<>();
        Field[] fields = testBean.getClass().getDeclaredFields();
        for (Field field : fields) {
            String key = getFieldName(field);
            String value = getFieldType(field);
            types.put(key, value);
        }
        return types;
    }
}
