import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] tasks = new int[n][2];
      
      for(int j = 0; j < n; j++){
          tasks[j][0] = in.nextInt();
          tasks[j][1] = in.nextInt();
      }
      
      String schedule = getPossibleSchedule(tasks);
      
      System.out.println("Case #" + i + ": " + schedule);
    }
  }
  
  private static String getPossibleSchedule(int[][] tasks){
      //tasks[i][0] is start tasks[i][1] is end
      
      //intuition is to do the graph coloring algorithm
      //create a conflict graph of the tasks that conflict with each other O(n^2)
      //then starting with the task with the highest degree of connections,
      //label that node as well as every uncolored node that it doesnt connect to
      //with one of the labels. then get the next highest degree node and
      //do the same with all of its tasks.  if there are any tasks that 
      //have no label, then the schedule is impossible
      
      Set<Task> taskSet = new HashSet<>();
      List<Task> sortedTasks = new ArrayList<>();
      
      int id = 0;
      //initialize all the tasks and set up a graph
      for(int i = 0; i < tasks.length; i++){
          Task t = new Task(tasks[i][0],tasks[i][1], id++);
          
          //used for reporting at the end
          sortedTasks.add(t);
         
          
          for(Task o : taskSet){
              if(conflicts(t,o)){
                  o.conns.add(t);
                  t.conns.add(o);
                  o.degree++;
                  t.degree++;
              }
          }
          
          taskSet.add(t);

      }
      
      //the whole time this was just a graph problem. im dumb
      Set<Task> unlabeled = new HashSet<>(taskSet);
      Queue<Task> taskQ = new ArrayDeque<>();
      Queue<Boolean> assignQ = new ArrayDeque<>();
      boolean jTask = true;
      while(!unlabeled.isEmpty()){
    	  Task start = getMostConflicted(unlabeled);
    	  
    	  taskQ.add(start);
    	  assignQ.add(jTask);
    	  
    	  while(!taskQ.isEmpty()){
    		  start = taskQ.poll();
    		  jTask = assignQ.poll();
    		  
    		  start.label = jTask ? 'J' : 'C';
        	  unlabeled.remove(start);
        	  
        	  for(Task t : start.conns){
        		  if(t.label != 'x' && start.label == t.label){
        			  return "IMPOSSIBLE";
        		  }else if(unlabeled.contains(t)){
        			  unlabeled.remove(t);
        			  taskQ.add(t);
        			  assignQ.add(!jTask);
        		  }
        	  }
    	  }
    	  
      }
      
      return getScheduleFromTasks(sortedTasks);
      
      
      //old way that i got inspiration from https://www.ripublication.com/ijcam17/ijcamv12n2_26.pdf but its fundematally wrong 
//      
//      //get the task with the highest number of conflicts
//      Task mostConflicted = getMostConflicted(taskSet);
//      System.out.println("mostconf: "+mostConflicted.toString());
//      mostConflicted.label = 'C';
//      
//      //label the tasks that are not conflicting with this task
//      Set<Task> nonConnected = new HashSet<>(taskSet);
//      nonConnected.removeAll(mostConflicted.conns);
//      System.out.println("nonConnected: "+nonConnected.toString());
//      for(Task t : nonConnected){
//          t.label = 'C';
//      }
//      
//      unlabeled.removeAll(nonConnected);
//      unlabeled.remove(mostConflicted);
//      System.out.println("unlabeled: "+unlabeled.toString());
//
//      //get the next most conflicting task and label all remaining tasks
//      //that it does not conflict with
//      Task nextMostConflicted = getMostConflicted(unlabeled);
//
//      if(nextMostConflicted != null){
//          System.out.println("nmc: "+nextMostConflicted.toString());
//
//          Set<Task> nextNonConnected = new HashSet<>(taskSet);
//          nextNonConnected.removeAll(nonConnected);
//          nextNonConnected.removeAll(nextMostConflicted.conns);
//          System.out.println("nnc: "+nextNonConnected.toString());
//
//          nextMostConflicted.label = 'J';
//          
//          for(Task t : nextNonConnected){
//              t.label = 'J';
//          }  
//          
//          unlabeled.removeAll(nextNonConnected);
//          unlabeled.remove(nextMostConflicted);
//          System.out.println("unlabeled: "+unlabeled.toString());
//
//      }else{
//          //this means 'C' can handle every task
//          return getScheduleFromTasks(sortedTasks);
//      }
//      
//      if(unlabeled.size() > 0){
//          return "IMPOSSIBLE";
//      }
//      
//      return getScheduleFromTasks(sortedTasks);
  }
  
  private static String getScheduleFromTasks(List<Task> tasks){
      StringBuilder schedule = new StringBuilder();
      
      for(Task t : tasks){
          schedule.append(t.label);
      }
      
      return schedule.toString();
  }
  
  private static Task getMostConflicted(Set<Task> tasks){
      int max = -1;
      Task mostConflicted = null;
      for(Task t : tasks){
          if(t.degree > max){
              max = t.degree;
              mostConflicted = t;
          }
      }
      
      return mostConflicted;
  }
  
  private static boolean conflicts(Task a, Task b){
      return (a.start >= b.start && a.start < b.end) || 
      (b.start >= a.start && b.start < a.end);
  }
  
  static class Task{
      int degree;
      int start;
      int end;
      Set<Task> conns;
      char label;
      int id;
      
      public Task(int start, int end, int id){
          this.start = start;
          this.end = end;
          degree = 0;
          conns = new HashSet<>();
          this.id = id;
          this.label = 'x';
      }
      
      @Override
      public String toString(){
    	  return String.valueOf(id);
      }
  }
} 

//import java.util.*;
//import java.io.*;
//public class Solution {
//  public static void main(String[] args) {
//    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
//    for (int i = 1; i <= t; ++i) {
//      int n = in.nextInt();
//      int[][] tasks = new int[n][2];
//      
//      for(int j = 0; j < n; j++){
//          tasks[j][0] = in.nextInt();
//          tasks[j][1] = in.nextInt();
//      }
//      
//      String schedule = getPossibleSchedule(tasks);
//      
//      System.out.println("Case #" + i + ": " + schedule);
//    }
//  }
//  
//  private static String getPossibleSchedule(int[][] tasks){
//      for(int i = 0; i < tasks.length; i++){
//          for(int j = 0; j < tasks[i].length; j++){
//              System.out.print(tasks[i][j] + " ");
//          }
//          System.out.println();
//      }
//      return "IMPOSSIBLE";
//  }
//} 