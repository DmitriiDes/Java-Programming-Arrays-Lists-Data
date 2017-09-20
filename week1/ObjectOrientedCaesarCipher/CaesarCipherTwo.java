
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author Dmitrii Desiatkov 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        mainKey1 = key1;
        shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        mainKey2 = key2;
    }
    
    public String encryptTwoKeys(String input) {
        
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)){
                int idx = alphabet.indexOf(Character.toUpperCase(currChar));
                if(idx != -1){
                    if (i%2 == 0){
                        char newChar = shiftedAlphabet1.charAt(idx);
                        encrypted.setCharAt(i, Character.toLowerCase(newChar));}
                    else{char newChar = shiftedAlphabet2.charAt(idx);
                         encrypted.setCharAt(i, Character.toLowerCase(newChar));};
                };
            }
            else {
                int idx = alphabet.indexOf(currChar);
                if(idx != -1){
                    if (i%2 == 0){
                        char newChar = shiftedAlphabet1.charAt(idx);
                        encrypted.setCharAt(i, newChar);}
                    else{
                        char newChar = shiftedAlphabet2.charAt(idx);
                        encrypted.setCharAt(i, newChar);};
                    };
            };
        }
        //System.out.println(encrypted.toString());
        return encrypted.toString();
    }
    
    public String decryptTwoKeys(String input) {
       CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2); 
       return cc.encryptTwoKeys(input); 
    }
}
