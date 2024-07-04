 import java.util.*;
    import java.io.*;
  public class Solution {
      public static void main(String[] args) {
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
       
        
        List<String> result = new ArrayList<>();

 
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
          
          
          List<Activity> input = new ArrayList<>();
           List<Activity> jamie = new ArrayList<>();
          List<Activity> cameroon = new ArrayList<>();
          StringBuilder sb = new StringBuilder();
          
           Solution s = new Solution();
          
          for(int h = 0; h < N ;h++){
              
               Activity ac = new Activity();
              ac.setStartingTime(in.nextInt());
              ac.setEndingTime(in.nextInt());
              input.add(ac);
               
          }
          
           
          
               
            
        
          
          for(int a = 0; a < N; a++){
              
              Activity ac = input.get(a);
              if(cameroon.size() != 0){
                  
                   if(s.Check(ac.getStartingTime(),ac.getEndingTime(),cameroon)){
                            
                           cameroon.add(ac);
                           sb.append("C");
                          
                      }else if(jamie.size() == 0){
                             jamie.add(ac);
                             sb.append("J");
                      }else{
                      
                         if(s.Check(ac.getStartingTime(),ac.getEndingTime(),jamie)){
                          
                          jamie.add(ac);
                          sb.append("J");
                      }else{
                          
                          sb.delete(0, sb.length());
                          sb.append("IMPOSSIBLE");
                         
                          break;
                      } 
                  } 
                   
              }else{
                cameroon.add(ac);
                sb.append("C");
              }
              
            }
           result.add("Case #" + i + ": "+sb.toString());
           
        }
        
            for(int i = 0; i < t; i++){
            
            System.out.println(result.get(i));
            
        }
       
      }
      
     public  boolean Check(int startingtime, int endingtime , List<Activity> list){
            
          Collections.sort(list,new ListComparator());
            
            for(int i = 0; i < list.size();i++){
                int start = list.get(i).getStartingTime();
                int end = list.get(i).getEndingTime();
                
                
                if((startingtime >= start && startingtime < end) || (endingtime > start && endingtime <= end)){
                return false;
                } 
                
            }
           
              
             return true;
        }
    
  
    static class  ListComparator implements Comparator<Activity>{ 
        
            public int compare(Activity s1,Activity s2){  
 
            return s2.getStartingTime() - s1.getStartingTime();  
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
       
        
    }
    }