
/**
 * Write a description of CharactersPlay here.
 * 
 * @author Dmitrii Desiatkov 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CharactersPlay {
    private ArrayList<String> myNames;
    private ArrayList<Integer> myFreqs;
    private ArrayList<FreqWord> Fnames;
    public CharactersPlay() {
        myNames = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    private void update(String person){
            person = person.toLowerCase();
            int index = myNames.indexOf(person);
            if (index == -1){
                myNames.add(person);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
    }
    
    private String getNameFromLine(String line){
    int i = line.indexOf(".");
    if (i == -1){return line;}
    else{return line.substring(0,i);}
    }
    
    public void findAllCharacters(){
        myNames.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for(String s : resource.lines()){
            String person = getNameFromLine(s);
            update(person);}
    }
    
    public int findIndexOfMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    private void sortTheNames(){
        Fnames = new ArrayList<FreqWord>();
        for(int k=0; k < myFreqs.size(); k++){
                Fnames.add(new FreqWord(myNames.get(k), myFreqs.get(k)));
        }
        Collections.sort(Fnames, FreqWord.wNameComparator);
        }
    
    private void printWithinRange(int num1, int num2){
        for(FreqWord str: Fnames){
            if(str.getFreq()<=num1 && str.getFreq()>=num2){
            System.out.println(str.toString());};
        }
    }
    
    public void tester(){
        findAllCharacters();
        sortTheNames();
        printWithinRange(15,10);
        //System.out.println("# unique characters: "+myWords.size());
        //int index = findIndexOfMax();
        //for (int i = 0; i < 10; i++){
        //System.out.println("Freq: "+myFreqs.get(i)+"  Name: "+myWords.get(i));};
        //System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));
        //System.out.println("the index is:"+" "+index);
    }
    
    
}
