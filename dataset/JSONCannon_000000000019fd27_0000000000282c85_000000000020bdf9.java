import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
  static class Event{
    int numInList;
    int startTime;
    int endTime;

    public Event(int numInList, int startTime, int endTime) {
      this.numInList = numInList;
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = scanner.nextInt();
    for(int t = 1; t <= numTests; t++){  //Each test
      int numEvents = scanner.nextInt();
      List<Event> events = new ArrayList<>();
      int cameronOccupiedUntil = 0;
      int jamieOccupiedUntil = 0;
      boolean impossible = false;
      char[] assignments = new char[numEvents];
      for(int e = 0; e < numEvents; e++){  //Each event
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        events.add(new Event(e, start, end));
      }
      events.sort(new Comparator<Event>() {
        @Override
        public int compare(Event o1, Event o2) {
          if(o1.startTime < o2.startTime){
            return -1;
          }else if(o1.startTime > o2.startTime){
            return 1;
          }else{
            if(o1.numInList < o2.numInList){
              return -1;
            }else if(o1.numInList > o2.numInList){
              return 1;
            }else{
              return 0;
            }
          }
        }
      });
      for (Event currentEvent : events) {  // assign each event
        if (currentEvent.startTime >= cameronOccupiedUntil) {
          assignments[currentEvent.numInList] = 'C';
          cameronOccupiedUntil = currentEvent.endTime;
        } else if (currentEvent.startTime >= jamieOccupiedUntil) {
          assignments[currentEvent.numInList] = 'J';
          jamieOccupiedUntil = currentEvent.endTime;
        } else {
          impossible = true;
          break;
        }
      }
      if(impossible){
        System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
      }else {
        String assignment = new String(assignments);
        System.out.println("Case #" + t + ": " + assignment);
      }
    }
  }
}
