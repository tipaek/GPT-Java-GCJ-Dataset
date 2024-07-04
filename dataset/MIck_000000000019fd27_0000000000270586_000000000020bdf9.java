import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
	  
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); //Number of cases
    String unused = in.nextLine();
    for (int i = 1; i <= t; ++i) {//iterate over number of cases
      ArrayList<Activity> cam = new ArrayList<Activity>();
      ArrayList<Activity> jam = new ArrayList<Activity>();
      int N = in.nextInt();//
      unused = in.nextLine();
      String answer = "";
	  for(int x = 0; x<N; x++) {
		  Activity newActivity = new Activity(in.nextInt(),in.nextInt());
		  unused = in.nextLine();
		  boolean camConflict = false;
		  for(Activity old : cam) {
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
			  for(Activity old : jam) {
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
				  break;
			  }
		  }
	  }
	  System.out.println("Case #" + i + ": " + answer);     
      
    }
    in.close();
  }
  

}

class Activity{
	  int start,stop;
	  public Activity(int start, int stop) {
		  this.start = start;
		  this.stop = stop;	
	  }
	  public boolean overlap(Activity other) {
		  if(other.start > start && other.start < stop) return true;
		  if(other.stop > start && other.stop < stop) return true;
		  if(other.start < start && other.stop > stop) return true;
		  return false;
	  }
}