package com.example.SPRestJPAAPI.javaMethodReference;

public class MethodReferenceMain {
public static void main(String arg[]){
    //Here I want to implement method of TaskInterface. I can do it using lamda expressionlike below,
    /*TaskInterface i = (a)-> System.out.println("Hello "+a);
    i.doTask("Manali");*/

    //But above implementation is similar to the doStuff method in Stuff class.So its kind of duplicate code
    // So instead of implementing as above I can give static method reference like below
    TaskInterface i = Stuff::doStuff;
    i.doTask("Manali");

    //Here I want to implement method of TaskInterface by giving instance method reference
    TaskInterface j = new Stuff()::doWork;
    j.doTask("li");
}
}
