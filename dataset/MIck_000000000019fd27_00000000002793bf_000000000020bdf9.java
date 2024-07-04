import java.util.*;
import java.io.*;
public class Solution {
	static class MyActivity implements Comparable<MyActivity> {
		  public int start,stop,index;
		  public MyActivity(int start, int stop, int index) {
			  this.index = index;
			  this.start = start;
			  this.stop = stop;	
		  }
		  public boolean overlap(MyActivity other) {
			  if(other.start == start || other.stop == stop) return true;
			  if(other.start > start && other.start < stop) return true;
			  if(other.stop > start && other.stop < stop) return true;
			  if(other.start < start && other.stop > stop) return true;
			  return false;
		  }
		  @Override
		    public int compareTo(MyActivity other) {
		        return this.start - other.start;
		    }
	  }
	
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); //Number of cases
    String unused = in.nextLine();
    for (int i = 1; i <= t; ++i) {//iterate over number of cases
   
      ArrayList<MyActivity> cam = new ArrayList<MyActivity>();
      ArrayList<MyActivity> jam = new ArrayList<MyActivity>();
      int N = in.nextInt();//
      unused = in.nextLine();
      String answer = "";
      ArrayList<MyActivity> activityList = new ArrayList<MyActivity>();
	  for(int x = 0; x<N; x++) {
		  activityList.add( new MyActivity(in.nextInt(),in.nextInt(),x));
	  }
	  Collections.sort(activityList);
	  for(MyActivity newActivity : activityList) {
		  
		  if(answer != "IMPOSSIBLE") {
		  boolean camConflict = false;
		  for(MyActivity old : cam) {
			  if(old.overlap(newActivity)) {
				  camConflict = true;
				  break;
			  }
		  }
		  if(!camConflict) {
			  answer = answer + "C";
			  cam.add(newActivity);
		  } else {
			  boolean jamConflict = false;
			  for(MyActivity old : jam) {
				  if(old.overlap(newActivity)) {
					  jamConflict = true;
					  break;
				  }
			  }
			  if(!jamConflict) {
				  answer = answer + "J";
				  jam.add(newActivity);
			  } else {
				  answer = "IMPOSSIBLE";
			  }
		  }
		  }
	  }
	  if(answer != "IMPOSSIBLE") {
		  char[] ansArray = new char[N];
		  int index = 0;
		  for(MyActivity act : activityList) {
			  ansArray[act.index] = answer.charAt(index);
			  index++;
		  }
		  answer = new String(ansArray);
	  } 
	      System.out.println("Case #" + i + ": " + answer);     
	  
      
    }
    in.close();
  }
}
