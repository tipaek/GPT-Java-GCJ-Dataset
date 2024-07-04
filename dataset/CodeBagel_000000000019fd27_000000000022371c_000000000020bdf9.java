import java.util.*;
import java.io.*;

public class Solution {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();  
    
    for (int i = 1; i <= cases; ++i) {
        
        int eventCount = in.nextInt();
        
        List<Event> events = new ArrayList<Event>();
        List<Event> jamieEvents = new ArrayList<Event>();
        List<Event> camEvents = new ArrayList<Event>();
        
        String res = "";
        
        for(int j = 0; j < eventCount; j++){
            Event newEvent = new Event(in.nextInt(), in.nextInt());
            events.add(newEvent);
        }
        
        for(Event event : events){
            
            if(isAvailable(camEvents, event)){
                camEvents.add(event);
                res += "C";
            } else if (isAvailable(jamieEvents, event)){
                jamieEvents.add(event);
                res += "J";
            } else{
                res = "IMPOSSIBLE";
                break;
            }
            
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
  
  public static boolean isAvailable(List<Event> schedule, Event potentialEvent){

        for(Event event : schedule){
            
            if(event.start <= potentialEvent.start && potentialEvent.start < event.finish){
                return false;
            }
            if(event.start < potentialEvent.finish && potentialEvent.finish <= event.finish){
                return false;
            }
            
        }
        
        return true;
      
  }
  
}