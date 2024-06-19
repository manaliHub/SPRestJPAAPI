package com.example.SPRestJPAAPI.javaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * THis class has learning about java 1.8 stream api methods learning
 */
public class LearnStream {
    public static void main (String a[]){
        LearnStream obj= new LearnStream();
        System.out.println("---------------FILTER Operations-------------");
        obj.learnFilter();
        System.out.println("---------------MAP Operations-------------");
        obj.learnMap();
    }

    public void learnFilter(){

        //This is mutable list you can add items in this
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(22);
        list1.add(13);
        list1.add(44);
        list1.add(75);
        list1.add(2);
        System.out.println("original list :"+list1);

        //filter list and get only even numbers
        List<Integer> list11 = list1.stream().filter(e->e%2==0).collect(Collectors.toList());
        System.out.println("Filtered List with even numbers :"+list11);

        //filter list and get only even numbers
        List<Integer> list12 = list1.stream().filter(e->e%2!=0).collect(Collectors.toList());
        System.out.println("Filtered List with odd numbers :"+list12);

        //filter list and sort
        List<Integer> list13 = list1.stream().sorted().collect(Collectors.toList());
        System.out.println("Filtered List sort :"+list13);

        //filter list with all numbers greater than 15
        List<Integer> list14 = list1.stream().filter(e->e>15).collect(Collectors.toList());
        System.out.println("Filtered List with numbers greater than 15 :"+list14);

        //filter list with count numbers greater than 15
        long count = list1.stream().filter(e->e>15).count();
        System.out.println("Filtered List count numbers greater than 15 :"+count);

        //filter list and sort and get first one
        Optional<Integer> firstNumber = list1.stream().sorted().findFirst();
        System.out.println("Filtered List sort and get firs item :"+firstNumber);

        //filter list and check if specific number is present in list or not
        Boolean isPresent13 = list1.stream().filter(e->e==13).findAny().isPresent();
        System.out.println("Filtered List and check if number 13 is present or not :"+isPresent13);

        //filter list and check if specific number is present in list or not
        Boolean isPresent12 = list1.stream().filter(e->e==12).findAny().isPresent();
        System.out.println("Filtered List and check if number 12 is present or not :"+isPresent12);
    }

    public void learnMap(){
        //THis is immutable, u can not add item in this list
        List<Integer> list1=List.of(23,45,22,1130,67,40);
        System.out.println("Original List :"+list1);

        //map list . multiply each number by 2
        List<Integer> list11 = list1.stream().map(e->e*2).collect(Collectors.toList());
        System.out.println("Map List multiply each number by 2 :"+list11);

        //filter numbers greater than 25 and then multipy by 2 and then sort
        List<Integer> list12 = list1.stream()
                .filter(e->e>25)
                .map(e->e*2)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Filter numbers greater than 25 and then multiply by 2.and then sort :"+list12);

        //filter numbers greater than 25 and then multipy by 2 and then add all numbers using reduce method
       int addition = list1.stream()
               .filter(e->e>25)
               .map(e->e*2)
               .reduce(0,(c,e)->c+e);
        System.out.println("Filter numbers greater than 25 and then multiply by 2.and addition :"+addition);

    }
}
