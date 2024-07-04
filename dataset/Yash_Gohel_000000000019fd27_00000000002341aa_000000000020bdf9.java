import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
       
        List<String> result = new ArrayList<>();

// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
           List<Activity> jamie = new ArrayList<>();
          List<Activity> cameroon = new ArrayList<>();
          String taskstring = "";
          
          for(int a = 0; a < N; a++){
              
              Activity ac = new Activity();
              ac.setStartingTime(in.nextInt());
              ac.setEndingTime(in.nextInt());
              
              if(jamie.size() != 0){
                  
                  if(cameroon.size() == 0){
                      cameroon.add(ac);
                      taskstring = taskstring+"C";
                  }else{
                      
                      if(jamie.get(jamie.size() -1).Check(ac.getStartingTime())){
                        
                           jamie.add(ac);
                           taskstring = taskstring+"J";
                          
                      }else if(cameroon.get(cameroon.size() -1).Check(ac.st)){
                          jamie.add(ac);
                           taskstring = taskstring+"C";
                      }else{
                          
                          taskstring = "IMPOSSIBLE";
                          break;
                      }
                      
                      
                  }
                   
                  
              }else{
                jamie.add(ac);
               taskstring = taskstring+"J";
              }
              
              
              
              
          }
          
           result.add("Case #" + i + ": "+new String(taskstring));
           
        }
        
        
        
        for(int i = 0 ; i < result.size() ; i++){
            
            System.out.println(result.get(i));
            
        }
            
            
            
            
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
        
        
        public boolean Check(int startingtime){
            
            
            
              if(startingtime >= st && startingtime < et){
                return false;
            }
            return true;
        }
        
        
    }
    }