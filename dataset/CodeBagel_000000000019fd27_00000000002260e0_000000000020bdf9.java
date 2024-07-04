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
            
            System.out.println("Checking Cam");
            boolean camFree = isAvailable(camEvents, event);
            
            if(camFree){
                camEvents.add(event);
                res += "C";
                continue;
            }
            
            System.out.println("Checking Jamie");
            boolean jamieFree = isAvailable(jamieEvents, event);
            
            if (jamieFree){
                jamieEvents.add(event);
                res += "J";
                continue;
            }
            
            res = "IMPOSSIBLE";
            break;
        
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
                // System.out.println(event.start + " <= " + potentialEvent.start + " < " + event.finish);
                return false;
            }
            
            if(event.start < potentialEvent.finish && potentialEvent.finish <= event.finish){
                // System.out.println(event.start + " < " + potentialEvent.finish + " <= " + event.finish);
                return false;
            }
            
            if(potentialEvent.start <= event.start && event.start < potentialEvent.finish){
                // System.out.println(event.start + " <= " + potentialEvent.start + " < " + event.finish);
                return false;
            }
            
            if(potentialEvent.start < event.finish && event.finish <= potentialEvent.finish){
                // System.out.println(event.start + " < " + potentialEvent.finish + " <= " + event.finish);
                return false;
            }
            
        }
        
        return true;
      
  }
  
}