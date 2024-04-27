/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab2;

/**
 *
 * @author notiz
 */
public class Palindrome {
//Requires: String a cannot be null or empty
//Modifies: doesn't modify anything
//Effects: Returns true for palindrome and returns false if not
public static boolean isPalindrome(String a) {//palindrome reads the same word backwards and fowards, e.g. deed
//write the code for isPalindrome
if (a==null||a.isEmpty()){//if it is null or empty return false, null has to be first otherwise itll cause an error if it is null
    return false;
}
int rightmost=a.length()-1;//since a string is an array of characters where the indices start from 0, so the last char is at (length of array)-1
for (int leftmost=0;leftmost<rightmost;leftmost++,rightmost--){//loops that compares the leftmost letter to the rightmost, where the left then compares the next letter in line and the right compares the letter behind the rightmost
    if (a.charAt(leftmost)!=a.charAt(rightmost)){//if the letters of the right and left do not match
        return false;//if it is not a palindrome return false
        }
}
    return true;//returns true if its a palindrome
}
    
    public static void main(String[] args) {//main method
if(args.length == 1) {
    if (args[0].equals("1"))
        System.out.println(isPalindrome(null));
    else if (args[0].equals("2"))
        System.out.println(isPalindrome(""));
    else if (args[0].equals("3"))
        System.out.println(isPalindrome("deed"));
    else if (args[0].equals("4"))
        System.out.println(isPalindrome("abcd"));
        }
    }
}
