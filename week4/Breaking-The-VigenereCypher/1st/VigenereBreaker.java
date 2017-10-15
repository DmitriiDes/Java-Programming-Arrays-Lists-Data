import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String sliced = "";
        for (int i = whichSlice; i < message.length(); i += totalSlices){
            sliced = sliced + message.substring(i,i+1);
        }
        return sliced;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++){
            String slicedMess = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(slicedMess);
        }
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] keys = tryKeyLength(message,4,'e'); 
        VigenereCipher vc = new VigenereCipher(keys);
        String dmessage = vc.decrypt(message);
        System.out.println(dmessage);
    }
    
    public void slicertest(){
        System.out.println(sliceString("abcdefghijklm",0,3));
    }
    
    public void tryKeyLengthTest(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] keys = tryKeyLength(message,4,'e');        
        for (int i = 0; i < keys.length; i++){System.out.println(keys[i]);}
    }
    
}
