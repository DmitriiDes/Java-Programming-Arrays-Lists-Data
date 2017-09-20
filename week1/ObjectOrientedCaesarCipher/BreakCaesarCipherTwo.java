
/**
 * Write a description of BreakCaesarCipherTwo here.
 * 
 * @author Dmitrii Desiatkov 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class BreakCaesarCipherTwo {
    private String alph = "abcdefghijklmnopqrstuvwxyz";
    
    public String PearsString(String message, int key){
        String halfMess = "";
        for (int k = key; k<message.length(); k += 2){
            halfMess = halfMess + message.charAt(k);
        }
        return halfMess;
    }
    
    public int[] countLetters(String message){
        int[] counts = new int[26];
        for (int k=0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    };
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public int getKey(String message){
        int maxInd = maxIndex(countLetters(message));
        int key = maxInd - 4;
        if (maxInd < 4) {
            key = 26 - (4 - maxInd);
        }        
        return key;
    }
    
    public String putBackTogether(String[] values){
        int length = 0;
        int[] count = new int[2];
        for (int k = 0; k<values.length; k ++){length += values[k].length();};
        String mess = "";
        for (int k = 0; k<length; k ++){
            if (k%2 == 0){
                mess = mess + values[0].charAt(count[0]);
                count[0] += 1;}
            else{
                mess = mess + values[1].charAt(count[1]);
                count[1] += 1;}
        }
        return mess;
    }
    
    public String breakTwoKeysCaesarCipher(String message){
        
        String[] pearsed = new String[2];
        int[] keys = new int[2];
        for (int k=0; k < pearsed.length; k++){
            pearsed[k] = PearsString(message, k);
            keys[k] = getKey(pearsed[k]);
        };
        CaesarCipherTwo cc = new CaesarCipherTwo(keys[0],keys[1]);
        return cc.decryptTwoKeys(message);
    }
    
    public void SimpleTest(){
        FileResource resource = new FileResource();
        String message = resource.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(18, 9);
        //System.out.println(message);
        String encrypted = cc.encryptTwoKeys(message);
        System.out.println(encrypted);
        System.out.println(breakTwoKeysCaesarCipher(encrypted));
    }
}
