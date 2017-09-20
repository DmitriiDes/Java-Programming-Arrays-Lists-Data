
/**
 * Write a description of BreakCaesarCipher here.
 * 
 * @author Dmitrii Desiatkov 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class BreakCaesarCipher {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    public int[] countLetters(String message){
        int[] counts = new int[26];
        for (int k=0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alphabet.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] counts){
        int maxDex = 0;
        for(int k=0; k < counts.length; k++){
            if (counts[k] > counts[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
           
    public String BreakCaesarCipher (String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if (maxDex < 4) {
            key = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(encrypted);
    }
        
    public void SimpleTest(){
        FileResource resource = new FileResource();
        String message = resource.asString();
        CaesarCipher cc = new CaesarCipher(18);
        System.out.println(message);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        System.out.println(BreakCaesarCipher(encrypted));
    }
    
}
