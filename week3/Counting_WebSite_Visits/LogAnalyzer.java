
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
            uDate = uDate.substring(4,10);
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
     
     public HashMap<String,Integer> countVisitsPerIp(){
        HashMap<String,Integer> counts = new HashMap<String, Integer>();
        for (LogEntry le: records){
            String ip = le.getIpAddress();
            if (!counts.containsKey(ip)){
                counts.put(ip,1);
            }
            else {
            counts.put(ip,counts.get(ip)+1);
            }
        }
            return counts;
     }
    
     public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
        int max = 0;
        for (String ip : counts.keySet()) {
            int cur = counts.get(ip);
            if (cur>max){max=cur;};
        }
        return max;
        }
        
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts){
         int max = mostNumberVisitsByIP(counts);
         ArrayList<String> maxIPs = new ArrayList<String>();
         for (String ip : counts.keySet()) {
            if (max <= counts.get(ip)){maxIPs.add(ip);};
            }
         return maxIPs;   
        }
        
     public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> IPbyDay = new HashMap<String, ArrayList<String>>();
        for (LogEntry le: records){
            String uIP = le.getIpAddress();
            String uDate = le.getAccessTime().toString().substring(4,10);
            if (!IPbyDay.containsKey(uDate)){
                ArrayList<String> uAr = new ArrayList<String>();
                uAr.add(uIP);
                IPbyDay.put(uDate,uAr);
            }
            else {
            ArrayList<String> uAr = IPbyDay.get(uDate);
            uAr.add(uIP);
            IPbyDay.put(uDate,uAr);
            }
        }
        return IPbyDay;
        
        }  
     
     private int maxDateByIp(HashMap<String, ArrayList<String>> IPbyDay){
         int max = 0;
         for (String uDate : IPbyDay.keySet()) {
             int uDateSize = IPbyDay.get(uDate).size();
             if (max<uDateSize){max=uDateSize;}
             
            }
            return max;
        }
        
     public HashMap<String, ArrayList<String>> dayWithMostIPVisits(){
         HashMap<String, ArrayList<String>> IPbyDay = iPsForDays();
         HashMap<String, ArrayList<String>> dayWithMostIP = new HashMap<String, ArrayList<String>>();
         int max = maxDateByIp(IPbyDay);
         for (String uDate : IPbyDay.keySet()) {
            int uDateSize = IPbyDay.get(uDate).size();
            if (max == uDateSize){dayWithMostIP.put(uDate,IPbyDay.get(uDate));}
            }
         return dayWithMostIP;   
        }
        
     public ArrayList<String> iPsWithMostVisitsOnDay(String day ){
         HashMap<String, ArrayList<String>> IPbyDay = iPsForDays();
         ArrayList<String> allIPs = IPbyDay.get(day);
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         for (String ip: allIPs){
            if (!counts.containsKey(ip)){
                counts.put(ip,1);
            }
            else {
                counts.put(ip,counts.get(ip)+1);
            }
            }
         return iPsMostVisits(counts);
        }   
}
