package com.example.SPRestJPAAPI.javaOptional;

import java.util.Optional;

public class LearningOptionalClass {
    public static void main(String arg[]){
        String name="HI";
        if(name==null){
            System.out.println("It is null");
        }else{
            System.out.println("Hello "+name);
        }
        //Same null check can put using Optional class as below
        Optional<String> optionalName = Optional.ofNullable(name);
        System.out.println("Value present="+optionalName.isPresent());
        System.out.println("Print="+optionalName.orElse("its null value"));
    }
}
