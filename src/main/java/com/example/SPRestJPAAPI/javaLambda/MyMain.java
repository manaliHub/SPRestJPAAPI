package com.example.SPRestJPAAPI.javaLambda;

/**
 * THis class implements abstract method of interface: MyInterface1, MyInterface2 using lambda expression
 * you don't need to create separate implementation class to implement interface method
 */
public class MyMain {
    public static void main(String arg[]){
        System.out.println("My Main method");

        //using lambda implementing abstract method of interface MyInterface1
        MyInterface1 i = (a, b)->{

            return a + b;
        };
        System.out.println("Addition is : "+i.additions(1,2));

        //OR

        MyInterface1 ii = (a, b)-> a + b;
        System.out.println("Addition is : "+ii.additions(1,2));

        //using lambda implementing abstract method of interface MyInterface2
        MyInterface2 i1 = (e)-> System.out.println("Hello "+ e);
        i1.namePrint("Manali");
    }
}
