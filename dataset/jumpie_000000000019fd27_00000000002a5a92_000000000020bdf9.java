import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int activities = in.nextInt();

	      List<Job> cameron_jobs = new ArrayList<Job>();
	      List<Job> james_jobs = new ArrayList<Job>();

	      StringBuilder sb = new StringBuilder();

	      for(int j=0 ; j < activities ; j++) {
	    	  int s = in.nextInt();
	    	  int e = in.nextInt();
	    	  if(insertJob(cameron_jobs,s,e)) {
	    		  sb.append("C");
	    	  }else if(insertJob(james_jobs,s,e)){
	    		  sb.append("J");
	    	  }else{
	    		  sb=new StringBuilder("IMPOSSIBLE");
	    		  break;
	    	  }
	      }

	      System.out.println("Case #" + i + ": " + sb.toString());
	    }
	}

	private static boolean insertJob(List<Job> list, int start, int end) {
		if(list.size()==0) {
			list.add(new Job(start,end));
			return true;
		}
		else {
			for(int i=0 ; i < list.size() ;i++) {
				if(start >= list.get(i).getEnd() && end >= list.get(i).getEnd() ) {
					list.add(new Job(start,end));
					return true;
				}
				else if(start <= list.get(i).getStart() && end <= list.get(i).getStart()) {
					list.add(new Job(start,end));
					return true;
				}
			}
		}
		return false;
	}

}

class Job{
	int start;
	int end;

	Job(int start, int end){
		this.start=start;
		this.end=end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}