package com.company;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class CreateLinkedListExample {

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
	    LinkedList<String> friends = new LinkedList<>();
        friends.add("Rachel");

        System.out.println("Initial friends list: "+friends);

        friends.add(0,"Phoebe");
        friends.addFirst("Ross");
        friends.addLast("Chandler");
        System.out.println("Three more friends: "+friends);

        List<String> twoFriends = new ArrayList<>();
        twoFriends.add("Joey");
        twoFriends.add("Monica");

        friends.addAll(twoFriends);

        System.out.println("All friends list: "+friends);
    }
}