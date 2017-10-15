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
        String emessage = fr.asString();
        FileResource frd = new FileResource();
        HashSet<String> dictionary = readDictionary(frd);
        //int[] keys = tryKeyLength(emessage,5,'e'); 
        //VigenereCipher vc = new VigenereCipher(keys);
        String dmessage = breakForLanguage(emessage,dictionary);
        //String dmessage = vc.decrypt(message);
        System.out.println(countWords(dmessage,dictionary));
        System.out.println(dmessage);
    }
    
    public void breakVigenereTest () {
        FileResource fr = new FileResource();
        String emessage = fr.asString();
        FileResource frd = new FileResource();
        HashSet<String> dictionary = readDictionary(frd);
        
        int[] keys = tryKeyLength(emessage, 38, 'e');
        VigenereCipher vc = new VigenereCipher(keys);
        String decrypted = vc.decrypt(emessage);
        int count = countWords(decrypted, dictionary);
        System.out.println(count);
    }
    
    public void testWordCount(){
       FileResource fr = new FileResource();
       FileResource frd = new FileResource();
       String emessage = fr.asString();
       HashSet<String> dictionary = readDictionary(frd);
       String dmessage = breakForLanguage(emessage,dictionary);
       System.out.println(countWords(dmessage,dictionary));
       int k = 0;
        for (String word : dmessage.split("\\W")){
            //System.out.println(word);
            k++;;
        }
       System.out.println("for loop:"+k);
       System.out.println("de mes:"+dmessage.split("\\W+").length);
       System.out.println("en mes:"+emessage.split("\\W+").length);
       System.out.println("dic length:"+dictionary.size());
    }
    
    public void slicerTest(){
        System.out.println(sliceString("abcdefghijklm",0,3));
    }
    
    public void tryKeyLengthTest(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] keys = tryKeyLength(message,4,'e');        
        for (int i = 0; i < keys.length; i++){System.out.println(keys[i]);}
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<String>();
        for (String word : fr.lines()){
            if(!dictionary.contains(word.toLowerCase())){dictionary.add(word.toLowerCase());}}
        return dictionary;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        int k = 0;
        for (String word : message.split("\\W+")){
            if (dictionary.contains(word.toLowerCase())){k++;};
        }
        return k;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int max = 0;
        String message ="";
        int keyLength = 0;
        for (int i=1; i<=100; i++){
            int[] keys = tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(keys);
            String decrypted = vc.decrypt(encrypted);
            int count = countWords(decrypted, dictionary);
            if (count>max){max = count; keyLength=i; message = decrypted;};
        }
        System.out.println("keyLength:"+keyLength);
        return message;
    }
    
    
}
