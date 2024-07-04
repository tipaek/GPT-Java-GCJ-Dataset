 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
       
        
        List<String> result = new ArrayList<>();

 
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
         
           List<Activity> jamie = new ArrayList<>();
          List<Activity> cameroon = new ArrayList<>();
          String taskstring = "";
          
          
          
          for(int a = 0; a < N; a++){
              
                Activity ac = new Activity();
              ac.setStartingTime(in.nextInt());
              ac.setEndingTime(in.nextInt());
               
               
              
              
              if(cameroon.size() != 0){
                  
                   if(Check(ac.getStartingTime(),ac.getEndingTime(),cameroon)){
                            
                           cameroon.add(ac);
                           taskstring = taskstring+"C";
                          
                      }else if(jamie.size() == 0){
                             jamie.add(ac);
                            taskstring = taskstring+"J";
                      }else{
                      
                         if(Check(ac.getStartingTime(),ac.getEndingTime(),jamie)){
                          
                          jamie.add(ac);
                         taskstring = taskstring+"J";
                      }else{
                          
                          taskstring =  "IMPOSSIBLE";
                           
                         
                          break;
                      } 
                  } 
                   
              }else{
                cameroon.add(ac);
                taskstring =  "C";
              }
              
            }
           result.add("Case #" + i + ": "+taskstring);
           
        }
        
            for(int i = 0; i < t; i++){
            
            System.out.println(result.get(i));
            
        }
        
        
        
        
      }
      
       static boolean Check(int startingtime, int endingtime , List<Activity> list){
           for(int i = 0; i < list.size();i++){
                int start = list.get(i).getStartingTime();
                int end = list.get(i).getEndingTime();
                
                
               if(startingtime < start){
                   if(endingtime > start){
                       return false;
                   }  
               }else if(startingtime == start){
                   return false;
               }else if(startingtime > start && startingtime < end){
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