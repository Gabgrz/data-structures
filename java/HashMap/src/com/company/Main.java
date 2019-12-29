package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String,Integer> playersMarketPrice = new HashMap<String,Integer>();
        playersMarketPrice.put("Messi",300000);
        playersMarketPrice.put("Ronaldo",100000);
        playersMarketPrice.put("Neymar",250000);
        playersMarketPrice.putIfAbsent("Mbappe",275000);

        System.out.println("Top players market price: "+playersMarketPrice);

        // HashMap entry set
        Set<Map.Entry<String,Integer>> marketPriceSet = playersMarketPrice.entrySet();
        System.out.println("Top market prices: "+marketPriceSet);

        // HashMap key set
        Set<String> players = playersMarketPrice.keySet();
        System.out.println("Most expensive players: "+players);

        // HashMap value set
        Collection<Integer> prices = playersMarketPrice.values();
        System.out.println("Top player prices: "+prices);
    }
}