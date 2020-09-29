package com.company;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This program search for a prefix in a group of words in an optimal way
 */
public class Main {

    private static List<String> findValues(List<String> words, String prefix){
        //Transform list to map ignoring repeated words
        Map<String, String> map = words.stream().collect(Collectors.toMap(String::toString, (val -> val), (val, val2)->{
            System.out.println("Value: "+val+", "+val2+" repeated");
            return val;
        }));

        //Transform map to SortedMap to do searching operations
        SortedMap<String, String> dictionary = new TreeMap<>(map);
        System.out.println("Dictionary: "+dictionary);

        //Search for prefix
        SortedMap subMap = dictionary.subMap(prefix, prefix+Character.MAX_VALUE);

        //Transform into a collection
        List<String> values = (List<String>)subMap.values().stream().collect(Collectors.toList());

        return values;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("dog", "deer", "death", "death","deal", "apple");
        String prefix = "de";

        System.out.println("Values: "+findValues(words, prefix));
    }
}
