/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab2;

import java.util.Arrays;

/**
 *
 * @author notiz
 */
public class AnagramChecker {
    //Requires: word1 and word2 can't be null, two strings are needed
    //Modifies: doesn't modify anything
    //Effects: Returns true for anagram and returns false if not
    public static boolean areAnagrams(String word1, String word2){
        
        if (word1==null||word2==null){//returns false if null
            return false;
        }
        
        //remove spaces and convert to lowercase
        word1 = word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();
        
        //storing as arrays
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
               
        //sorting character arrays
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        return Arrays.equals(array1,array2);//compares the sorted array and returns true if equal
    }
    
    public static void main(String[] args) {
       //check if there are two arguments provided
        if (args.length != 2) {
            System.out.println("Need two words");
            return;
        }

        //extract strings from command line arguments
        String str1 = args[0];
        String str2 = args[1];
        
        //check if the strings are anagrams
        if (areAnagrams(str1, str2)) {
            System.out.println("The strings " + str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println("The strings " + str1 + " and " + str2 + " are not anagrams.");
        
        }
    }
}