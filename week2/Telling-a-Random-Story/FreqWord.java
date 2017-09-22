
/**
 * Write a description of FreqWord here.
 * 
 * @author Dmitrii Desiatkov 
 * @version (a version number or a date)
 */
import java.util.Comparator;
public class FreqWord {
    private String word;
    private Integer freq;
    
    public FreqWord(String word, Integer freq){
        this.word = word;
        this.freq = freq;
    }
    
    public String getWord(){
        return word;
    }
    
    public void setWord(String word){
        this.word = word;
    }
    
    public Integer getFreq(){
        return freq;
    }
    
    public void setFreq(Integer freq){
        this.freq = freq;
    }
     /*Comparator for sorting the list by freq*/
    public static Comparator<FreqWord> wNameComparator = new Comparator<FreqWord>() {
        public int compare(FreqWord w1, FreqWord w2) {
                Integer wFreq1 = w1.getFreq();
                Integer wFreq2 = w2.getFreq();
                //descending order
                return wFreq2-wFreq1;
            }};
         
    //public Integer compareTo(FreqWord comparewd) {
    //    Integer comparefq = ((FreqWord)comparewd).getFreq();
    //     /* For Descending*/
    //    return comparefq-this.freq;
    //}
    
    @Override
    public String toString() {
        return "[ word=" + word + ", freq=" + freq +"]";
    }

}
