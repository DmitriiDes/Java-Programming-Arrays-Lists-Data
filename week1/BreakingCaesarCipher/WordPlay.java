
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays; 
import java.lang.*;
public class WordPlay {
    public boolean isVowel(char ch){
        String str = "AEIOU";
        char testCh = Character.toUpperCase(ch);
        if (str.indexOf(testCh) != -1){return true;};
        return false;
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder encrypted = new StringBuilder(phrase);
        for (int i=0; i<encrypted.length(); i++){
        char currChar = encrypted.charAt(i);
        if (isVowel(currChar)){encrypted.setCharAt(i, ch);};
        }
        return encrypted.toString();
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder encrypted = new StringBuilder(phrase);
        for (int i=0; i<encrypted.length(); i++){
        char currChar = encrypted.charAt(i);
        if (currChar == Character.toUpperCase(ch) || currChar == Character.toLowerCase(ch)){
            if (i%2 == 0){encrypted.setCharAt(i, '+');}
            else {encrypted.setCharAt(i, '*');};
        }
    }
    return encrypted.toString();
    }
}
