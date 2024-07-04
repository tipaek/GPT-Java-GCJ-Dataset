import java.util.*;
import java.io.*;
public class Solution {
  public static void main (String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    final char[] name = {'C','J'};
    outerLoop: for (int i = 1; i <= t; ++i) {
      Queue<ETime> q = new PriorityQueue<>();
      boolean[] av = new boolean[2];
      av[1] = true;
      int n = in.nextInt();
      Task[] tasks = new Task[n];
      char[] out = new char[n];
      for(int j = 0; j < n; j++) {
    	  tasks[j] = new Task(in.nextInt(),in.nextInt(), j);
      }
      Arrays.parallelSort(tasks);
      q.add(new ETime(tasks[0].e, 0));
      out[tasks[0].index] = name[0];
      for(int j = 1; j < n; j++) {
    	  int sj = tasks[j].s;
    	  while(q.peek() != null && q.peek().time <= sj)
    		  av[q.poll().partner] = true;
    	  if(q.size() == 2) {
    		  System.out.println("Case #" + i + ": IMPOSSIBLE");
    		  continue outerLoop;
    	  }
    	  if (av[0]) {
    		  av[0] = false;
    	      q.add(new ETime(tasks[j].e, 0));
    	      out[tasks[j].index] = name[0];
    	  }
    	  else {
    		  av[1] = false;
    	      q.add(new ETime(tasks[j].e, 1));
    	      out[tasks[j].index] = name[1];
    	  }
      }
      System.out.println("Case #" + i + ": "+ new String(out));
    }
  }
  
  public static class ETime implements Comparable<ETime>{
	  int partner;
	  int time;
	  
	  public ETime(int t, int p) {
		  partner = p;
		  time = t;
	  }
	  
	  public int compareTo(ETime o) {
		  return time - o.time;
	  }
  }
  
  public static class Task implements Comparable<Task>{
	  int s;
	  int e;
	  int index;
	  
	  public Task(int s1, int e1, int i) {
		  s = s1;
		  e = e1;
		  index = i;
	  }
	  
	  public int compareTo(Task o) {
		  return s - o.s;
	  }
  }
}