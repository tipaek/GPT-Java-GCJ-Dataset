/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nikunj
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
       
        
        List<String> result = new ArrayList<>();

 
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
           List<Activity> jamie = new ArrayList<>();
          List<Activity> cameroon = new ArrayList<>();
          StringBuilder sb = new StringBuilder();
          
           for(int a = 0; a < N; a++){
              
              Activity ac = new Activity();
              ac.setStartingTime(in.nextInt());
              ac.setEndingTime(in.nextInt());
              
              if(jamie.size() != 0){
                  
                  if(cameroon.size() == 0){
                      cameroon.add(ac);
                      sb.append("C");
                  }else{
                      
                      if(Check(ac.getStartingTime(),ac.getEndingTime(),jamie)){
                            
                           jamie.add(ac);
                           sb.append("J");
                          
                      }else if(Check(ac.getStartingTime(),ac.getEndingTime(),cameroon)){
                          
                          cameroon.add(ac);
                          sb.append("C");
                      }else{
                          
                          sb.delete(0, sb.length());
                          sb.append("IMPOSSIBLE");
                         
                          break;
                      }
                      
                      
                  }
                   
                  
              }else{
                jamie.add(ac);
                sb.append("J");
              }
              
            }
           result.add("Case #" + i + ": "+sb.toString());
           
        }
        
            for(int i = 0; i < t; i++){
            
            System.out.println(result.get(i));
            
        }
       
        
    }
    
  
    public static boolean Check(int startingtime, int endingtime , List<Activity> list){
            
            
            for(int i = 0; i < list.size();i++){
                int start = list.get(i).getStartingTime();
                int end = list.get(i).getEndingTime();
                
                
                if(startingtime >= start && startingtime < end || endingtime > start && endingtime <= end){
                return false;
                } 
                
            }
           
              
             return true;
        }
    
  
    
    
    public static class Activity{
        int st;
        int et;
       
        
        
        
        public Activity(){
            
        }
        
        public void setStartingTime(int stt){
            st = stt;
        }
        public void setEndingTime(int ett){
            et = ett;
        }
        
        
        public int getStartingTime(){
            return st;
        }
        
        public int getEndingTime(){
            return et;
        }
       
        
    } 
    
    
}
