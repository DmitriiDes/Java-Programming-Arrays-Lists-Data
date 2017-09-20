
/**
 * Write a description of CaesarBraker here.
 * 
 * @author Dmitrii Desiatkov
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBraker {
    public int[] countLetters(String alph, String message){
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
    
    public String SimpleDecryptCaesar (String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String alph ="abcdefghijklmnoqrstuvwxyz";
        int[] freqs = countLetters(alph, encrypted);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if (maxDex < 4) {
            key = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26-key);
    }
    
    public String PearsString(String message, int key){
        String halfMess = "";
        for (int k = key; k<message.length(); k += 2){
            halfMess = halfMess + message.charAt(k);
        }
        return halfMess;
    }
    
    public int getKey(String message){
        String alph ="abcdefghijklmnopqrstuvwxyz";
        int maxInd = maxIndex(countLetters(alph, message));
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
    
    public String decryptTwoKeys(String message){
        CaesarCipher cc = new CaesarCipher();
        String[] pearsed = new String[2];
        int[] keys = new int[2];
        for (int k=0; k < pearsed.length; k++){
            pearsed[k] = PearsString(message, k);
            keys[k] = getKey(pearsed[k]);
            pearsed[k] = cc.encrypt(pearsed[k], 26-keys[k]);
        };
        return putBackTogether(pearsed);
    }
    
    public String decryptTwoKeys2(String message){
        CaesarCipher cc = new CaesarCipher();
        String[] pearsed = new String[2];
        int[] keys = new int[2];
        for (int k=0; k < pearsed.length; k++){
            pearsed[k] = PearsString(message, k);
            keys[k] = getKey(pearsed[k]);
        };
        System.out.println(26 - keys[0]);
        System.out.println(26 - keys[1]);
        
        return cc.encryptTwoKeys(message, 26 - keys[0], 26 - keys[1]);
    }
    
    public void testBoth(){
    FileResource resource = new FileResource();
    String message = resource.asString();
    CaesarCipher cc = new CaesarCipher();
    message = decryptTwoKeys2(message);
    System.out.println(message);
    //System.out.println(decryptTwoKeys(message));
    //System.out.println(decryptTwoKeys2(message));
    
    }
    
}
