package com.company;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Queue<String> cloudPrintQueue = new LinkedList<>();
        cloudPrintQueue.add("lotr.pdf");
        cloudPrintQueue.add("smiley_face.png");
        cloudPrintQueue.add("ballack_pic.jpg");
        cloudPrintQueue.add("bert simpson.jpg");
        cloudPrintQueue.add("goku.png");

        System.out.println("Google Cloud Print queue: "+cloudPrintQueue);
        System.out.println("Now printing...: "+cloudPrintQueue.peek());
        cloudPrintQueue.remove();

        System.out.println("=== Iterating over Queue using Java SE 8 forEach() method ===");
        cloudPrintQueue.forEach(job -> {
            System.out.println(job);
        });

        System.out.println("=== Iterating over Queue using Iterator ===");
        Iterator<String> printJobsIterator = cloudPrintQueue.iterator();
        while(printJobsIterator.hasNext()){
            System.out.println(printJobsIterator.next());
        }

        System.out.println("\n=== Iterating over a Queue using iterator() and Java 8 forEachRemaining() ===");
        printJobsIterator = cloudPrintQueue.iterator();
        printJobsIterator.forEachRemaining(job ->{
            System.out.println(job);
        });

        System.out.println("\n=== Iterating over a Queue using simple for-each loop ===");
        for(String job : cloudPrintQueue){
            System.out.println(job);
        }
    }
}