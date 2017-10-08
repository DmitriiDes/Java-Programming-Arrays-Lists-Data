
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPS(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("short-test_log");
       System.out.println(la.countUniqueIPs()); 
    }
    
     public void testuniqueIPVisitsOnDay(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("weblog1_log");
       ArrayList <String> rec = la.uniqueIPVisitsOnDay("Mar 24");
       for (String k : rec){
       System.out.println(k); 
       }
       System.out.println(rec.size());
    }
    
    public void testcountUniqueIPInRange(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("weblog1_log");
       
       ArrayList <String> rec = la.countUniqueIPInRange(200,299);
       for (String k : rec){
       System.out.println(k); 
       }
       System.out.println(rec.size());
    }
}
