// Java code below
package com.company;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {

    static boolean exists(int[] ints, int k) {
        System.out.println(Arrays.binarySearch(ints, k));
        // if (Arrays.binarySearch(ints,int) == l)

        return true;

    }

    public static void main(String[] args) {
        int[] ints = {-9, 14, 37, 102};
        System.out.println(Main.exists(ints, 103)); // true
        System.out.println(Main.exists(ints, 36)); // false
        Main m = new Main();
        System.out.println("Hash Code: " + m.hashCode());
        Main m2 = new Main();
        System.out.println("IS EQUAL: "+m.equals(m2));
        String s = "Hola";
        String s2 = "Hola";
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());
        System.out.println("Hola".hashCode());
        StringBuilder sb = new StringBuilder("Hola");
        System.out.println(sb.hashCode());
        System.out.println(sb.equals(s));
        System.out.println("s == s2:" + s == s2);

        Predicate p = o -> o.equals("hola") ? true : false;
        System.out.println(p.test("hole"));
    }
}