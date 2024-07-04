import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
      
    int[] tasks;
    Map<Integer,Integer> endTimes;
    
    for (int s = 1; s <= t; ++s) {
        
        int noOfTasks = in.nextInt();

        tasks = new int[noOfTasks];
        endTimes = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < noOfTasks; i++){
          tasks[i] = in.nextInt();
          endTimes.put(tasks[i],in.nextInt());
        }
        
        String assignment = assign(tasks, endTimes);

        System.out.println("Case #" + s + ": " + assignment);
      
      }
    in.close();
    System.exit(0);
    }

    public static String assign(int[] tasks, Map<Integer,Integer> endTimes){
      
      String assignment = "";
      int c = 0, j = 0;
      int[] sorted = tasks.clone();
      Map<Integer,Character> result = new HashMap<Integer,Character>();
      Arrays.sort(sorted);
      
      for(int i = 0; i < tasks.length; i++){
        if(sorted[i] >= c){
          
          c = endTimes.get(sorted[i]);
          result.put(sorted[i],'C');
        
        } 
        
        else if (sorted[i] >= j){
          
          j = endTimes.get(sorted[i]);
          result.put(sorted[i],'J');

        } 
        
        else return "IMPOSSIBLE";

      }
      for(int i:tasks){
        assignment = assignment + String.valueOf((char)((int)result.get(i)));
      }

      return assignment;

    }
}