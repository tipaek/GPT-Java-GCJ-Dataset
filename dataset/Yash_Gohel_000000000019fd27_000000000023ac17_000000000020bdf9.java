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
                      
                      if(jamie.get(jamie.size() -1).Check(ac.getStartingTime(),ac.getEndingTime())){
                        
                           jamie.add(ac);
                           sb.append("J");
                          
                      }else if(cameroon.get(cameroon.size() -1).Check(ac.getStartingTime(),ac.getEndingTime())){
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
        
        
        public boolean Check(int startingtime, int endingtime){
            
            
            
              if(startingtime >= st && startingtime < et || endingtime > st && endingtime <= et){
                return false;
            }
            return true;
        }
        
        
    }
      
         
    }