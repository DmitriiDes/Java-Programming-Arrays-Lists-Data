
/**
 * Write a description of WordLength here.
 * 
 * @author Dmitrii Desiatkov 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class WordLength {
    public String cropTheWord(String word){
        String alph = "abcdefghijklmnoqrstuvwxyz";
        String cropWord = word;
        cropWord = cropWord.toLowerCase();
        int start = 0;
        int end = word.length();
        for (int k = 0; k<word.length(); k++){
            if (alph.indexOf(cropWord.charAt(k)) != -1 && start == 0){start = k; break;};       
        }
        for (int k = word.length(); k > 0; k = k - 1){
            if (alph.indexOf(cropWord.charAt(k-1)) != -1 && end == word.length()){end = k; break;};       
        }
        cropWord = cropWord.substring(start, end);
        return cropWord;
    }
    
    public int[] countWordLength(FileResource resource, int[] counts){
        for(String word : resource.words()){
            word = cropTheWord(word);
            int length = word.length();
            int maxLength = counts.length;
            if (length >= maxLength) {
                counts[maxLength] += 1;
            }
            else{counts[length] += 1;}
        }
        return counts;
    }
    
    public void testCountWordLengths(){
       FileResource resource = new FileResource();
       int[] counts = new int[31];
       countWordLength(resource,counts);
       for (int k =0; k < counts.length; k += 1){
           System.out.println("Length "+k+"appears "+counts[k]+" times");}; 
           System.out.println(indexOfMax(counts));
    }
    
    public int indexOfMax(int[] values){
        int max = 0;
        for (int k=0; k<values.length; k++){
            if (values[k]>values[max]){max = k;};
        }
        return max;
    }
    
}
