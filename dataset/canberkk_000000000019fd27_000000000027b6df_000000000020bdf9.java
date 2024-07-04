import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    //int cases = Integer.parseInt(in.nextLine());
    int cases = in.nextInt();

    for (int c = 1; c <= cases; c++) {
      String answer = "Case #" + c + ": ";

      int N = in.nextInt();
      Event[] events = new Event[N];
      char[] assignment = new char[N];
      boolean possible = true;
      for (int i = 0; i < N; i++) {
        events[i] = new Event(i,in.nextInt(),in.nextInt());
      }
      Arrays.sort(events);

      int jFree = 0;
      int cFree = 0;
      for (int i = 0; i < N && possible; i++) {
        Event event = events[i];
        if(jFree <= event.starTime){
          jFree = event.endTime;
          assignment[event.id] = 'J';
        }  else if(cFree <= event.starTime){
          cFree = event.endTime;
          assignment[event.id] = 'C';
        } else {
          possible = false;
        }
      }
      if(possible)
        answer += new String(assignment);
      else
        answer += "IMPOSSIBLE";

      out.println(answer);
    }

    in.close();
    out.close();
  }

  static private class Event implements Comparable<Event>{
    public int id,starTime, endTime;
    Event(int id, int starTime,int endTime){
      this.id = id;
      this.starTime = starTime;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(Event o) {
      return starTime-o.starTime;
    }

    @Override
    public String toString() {
      return "Event #"+id+" starts at "+starTime+" ends at "+endTime;
    }
  }
}