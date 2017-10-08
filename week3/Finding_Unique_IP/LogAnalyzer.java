
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     
     public LogAnalyzer() {
         records  = new ArrayList<LogEntry>();
         
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for (String line : fr.lines()) {
            LogEntry log = WebLogParser.parseEntry(line);
            records.add(log);
            }
     }
     
     public void readFileRes(FileResource fr) {
         
         for (String line : fr.lines()) {
            LogEntry log = WebLogParser.parseEntry(line);
            records.add(log);
            }
     }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
        ArrayList<String> uniqueIPS = new ArrayList<String>();
         for (LogEntry entry : records){
            String uIP = entry.getIpAddress();
            if (!uniqueIPS.contains(uIP)){uniqueIPS.add(uIP);}
        }
        return uniqueIPS.size();
        }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIPS = new ArrayList<String>();
        for (LogEntry entry : records){
            String uIP = entry.getIpAddress();
            String uDate = entry.getAccessTime().toString();
            int loc = uDate.indexOf(someday);
            if (!uniqueIPS.contains(uIP) && loc != -1){uniqueIPS.add(uIP);}
        }
        return uniqueIPS;
        }
        
     public ArrayList<String> countUniqueIPInRange(int low, int high){
        ArrayList<String> uniqueIPS = new ArrayList<String>();
        for (LogEntry entry : records){
            String uIP = entry.getIpAddress();
            int uStat = entry.getStatusCode();
            if (!uniqueIPS.contains(uIP) && uStat>=low && uStat<=high){uniqueIPS.add(uIP);}
        }
        return uniqueIPS;
        }
        
     public void printAllHigherThanNum(int num) {
         for (LogEntry le : records) {
             int uStat = le.getStatusCode();
             if(uStat>=num){
             System.out.println(le);
            }
         }
     }
}
