
/**
 * Write a description of CaesarCipher here.
 * 
 * @author Dmitrii Desiatkov 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key) {
        
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)){
                int idx = alphabet.indexOf(Character.toUpperCase(currChar));
                if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, Character.toLowerCase(newChar));
            };
            }
            else {int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            };
            };
        }
        System.out.println(encrypted.toString());
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        
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
        System.out.println(encrypted.toString());
        return encrypted.toString();
    }
}
