import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    int cs = 1;

    while (tc-- > 0) {
      int n = sc.nextInt();
      List<Event> events = new ArrayList<Event>();
      for (int i = 0; i < n; ++i) {
        int start = sc.nextInt();
        int end = sc.nextInt();
        Event startEvent = new Event();
        startEvent.time = start;
        startEvent.tiebreak = 1;
        startEvent.id = i;
        Event endEvent = new Event();
        endEvent.time = end;
        endEvent.tiebreak = -1;
        endEvent.id = i;
        events.add(startEvent);
        events.add(endEvent);
      }
      Collections.sort(events, new EventStartComparator());
      
      Stack<Character> availablePeople = new Stack<Character>();
      availablePeople.push('C');
      availablePeople.push('J');
      
      char[] owners = new char[n];
      boolean isPossible = true;
      for (Event e : events) {
        if (e.tiebreak == 1) {
          // start
          if (availablePeople.isEmpty()) {
            isPossible = false;
            break;
          }
          char p = availablePeople.pop();
          owners[e.id] = p;
          
        } else {
          // end
          char p = owners[e.id];
          availablePeople.push(p);
        }
      }
      
      String res = isPossible ? new String(owners) : "IMPOSSIBLE";
      
      System.out.println("Case #" + cs + ": " + res);
     ++cs;
    }
  }
}

class Event {
  int time;
  int tiebreak;
  int id;
}

class EventStartComparator implements Comparator<Event> {

  @Override
  public int compare(Event a, Event b) {
    int res = a.time - b.time;
    if (res == 0) {
      res = a.tiebreak - b.tiebreak;
    }
    return res;
  }
}


