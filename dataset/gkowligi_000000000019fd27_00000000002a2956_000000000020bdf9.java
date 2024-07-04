import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String cam = "C";
      String jam = "J";
      char camChar = 'C';
      char jamChar = 'J';
      String output = "";
      boolean camFree = true;
      boolean jamFree = true;
      int camEnd = -1;
      int jamEnd = -1;
      boolean impossible = false;
      int numActivities = in.nextInt();
      
      char[] test = new char[numActivities];
      
      TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
      
      // TreeMap<Integer, String
      
      int[] start = new int[numActivities];
      int[] end = new int[numActivities];
      
      for (int getInput = 0; getInput < numActivities; getInput++) {
          start[getInput] = in.nextInt();
          end[getInput] = in.nextInt();
          treemap.put(start[getInput], end[getInput]);
      }
      
      List<Integer> startList = Arrays.stream(start).boxed().collect(Collectors.toList());
      
      List<Integer> endList = Arrays.stream(end).boxed().collect(Collectors.toList());
      
      
      for (Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
              // free
              // busy, but ends before next start
              // busy, not end
          
          int entryStart = entry.getKey().intValue();
          int entryEnd = entry.getValue().intValue();
          
          int index = -1;
          
          for (int blarg = 0; blarg < start.length; blarg++) {
              if (startList.get(blarg) == entryStart && endList.get(blarg) == entryEnd) {
                  index = blarg;
              }
          }
          
          
          if (camFree) {
              output += cam;
              test[index] = camChar;
              start[index] = -1;
              end[index] = -1;
              camFree = false;
              camEnd = entryEnd;
              continue;
          }
          
          if (jamFree) {
              output += jam;
              test[index] = jamChar;
              start[index] = -1;
              end[index] = -1;
              jamFree = false;
              jamEnd = entryEnd;
              continue;
          }
          
          if (!camFree && camEnd <= entryStart) {
              output += cam;
              test[index] = camChar;
              start[index] = -1;
              end[index] = -1;
              camFree = false;
              camEnd = entryEnd;
              continue;
          }
          
          if (!jamFree && jamEnd <= entryStart) {
              output += jam;
              test[index] = jamChar;
              start[index] = -1;
              end[index] = -1;
              jamFree = false;
              jamEnd = entryEnd;
              continue;
          }
          
          
          impossible = true;
          break;
      }
      
      /*
      for (int schedule = 0; schedule < numActivities; schedule++) {
          
          
          
          // base case
          if (schedule == 0) {
              output += cam;
              camFree = false;
              camEnd = end[0]
              continue;
          }
          
          
          if (start[schedule] > end[schedule-1]) {
              // free
              // busy, but ends before next start
              // busy, not end
              
              
              if (camFree) {
                  
              }
          }
          
          if (camFree == false && jamFree == false) {
              impossible = true;
              break;
          }
      }
      */
      
      
      if (impossible) {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      } else {
          
          String thing = new String(test);
          
        System.out.println("Case #" + i + ": " + thing);
      }
    }
  }
  
}
