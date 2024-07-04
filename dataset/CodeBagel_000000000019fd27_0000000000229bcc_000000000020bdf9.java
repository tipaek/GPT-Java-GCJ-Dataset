import java.util.*;
import java.io.*;

public class Solution {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();  
    
    for (int i = 1; i <= cases; ++i) {
        
        int eventCount = in.nextInt();
        
        List<Event> events = new ArrayList<Event>();
        List<Character> order = new ArrayList<Character>();
        
        String res = "";
        
        for(int j = 0; j < eventCount; j++){
            Event newEvent = new Event(in.nextInt(), in.nextInt());
            events.add(newEvent);
            order.add('_');
        }
        
        Event jamieEvent = null;
        Event camEvent = null;
        
        for(int j = 0; j <= 1440; j++){
            
            if(jamieEvent != null && jamieEvent.finish == j){
                jamieEvent = null;
            }
            if(camEvent != null && camEvent.finish == j){
                camEvent = null;
            }
        
            for(int k = 0; k < events.size(); k++){
                
                if(events.get(k).start == j){
                    
                    if(camEvent == null){
                        
                        camEvent = events.get(k);
                        order.set(k, 'C');
                        
                    }
                    
                    else if(jamieEvent == null){
                        
                        jamieEvent = events.get(k);
                        order.set(k, 'J');
                        
                    }
                    
                    else{
                        
                        res = "IMPOSSIBLE";
                        break;
                        
                    }
                    
                }
            
            }
            
            if(res.equals("IMPOSSIBLE")){
                break;
            }
        
        }
        
        if(!res.equals("IMPOSSIBLE")){
            StringBuilder sb = new StringBuilder();
            for(Character c : order){
                sb.append(c);
            }
            res = sb.toString();
        }
        
        System.out.println("Case #" + i + ": " + res);
        
    }
    
  }
  
  private static class Event{
      
        public int start;
        public int finish;
        
        public Event(int start, int finish){
            this.start = start;
            this.finish = finish;
        }
      
  }

}