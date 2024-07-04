import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
      
    Task[] tasks;
    
    for (int s = 1; s <= t; ++s) {
        
        int noOfTasks = in.nextInt();

        tasks = new Task[noOfTasks];
        
        for(int i = 0; i < noOfTasks; i++){
          int start = in.nextInt();
          int end = in.nextInt();
          tasks[i] = new Solution.Task(start, end);
        }
        System.out.print("Case #" + s + ": ");
        if(assign(tasks)){
          for(Task task:tasks){
            System.out.print(task.getParent());
          }
        }
        else System.out.print("IMPOSSIBLE");
        System.out.println();
      }
    in.close();
    System.exit(0);
    }
    static class Task implements Comparable<Task>{
      private int start;
      private int end;
      private String parent;
    
      Task(int s, int e){
        this.start = s;
        this.end = e;
      }

      public int getStart(){
        return this.start;
      }

      public int getEnd(){
        return this.end;
      }

      public String getParent(){
        return this.parent;
      }
    
      public void setParent(String p){
        this.parent = p;
      }

      public int compareTo(Task compareTask){
        int compareStartTime = ((Task) compareTask).getStart();
        return this.start - compareStartTime;
      }
    }

    public static boolean assign(Task[] tasks){
      int c = 0, j = 0;
      Task[] sortedTasks = tasks.clone();
      Arrays.sort(sortedTasks);
      for(Task t:sortedTasks){
        if(t.getStart() >= c){
          c = t.getEnd();
          t.setParent("C");
        }
        else if(t.getStart() >= j){
          j = t.getEnd();
          t.setParent("J");
        }
        else return false;
      }
      return true;
    }
}
