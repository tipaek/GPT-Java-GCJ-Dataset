

	import java.util.*;
	import java.io.*;
	public class Solution {
		static class Pair{
			int start ;
			int end;
			Pair(int start,int end){
				this.start=start;
				this.end = end;
			}
		}
	  public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	   
	    for (int i = 1; i <= t; ++i) {
	 	    ArrayList<Pair> cSchedule = new ArrayList<>();
	 	    ArrayList<Pair> jSchedule = new ArrayList<>();
	 	    String sol = "";
	 	    int n = in.nextInt();
	
	    	for(int j = 0; j<n;++j) {
	    		
	    		int start = in.nextInt();
	    		int end = in.nextInt();
	    	
	    		
	    		if(!sol.equals("IMPOSSIBLE")) {
	    		if(end<start) {
	    			sol = "IMPOSSIBLE";
	    		}
	    		else if(isAvailable(cSchedule,start,end)) {
	    			sol=sol+'C';
	    			cSchedule.add(new Pair(start,end));
	    		}else if(isAvailable(jSchedule,start,end)) {
	    			sol = sol+'J';
	    			jSchedule.add(new Pair(start,end));
	    		}else {
	    			sol = "IMPOSSIBLE";
	    		}
	    		}
	    	}
	    	
	    	System.out.println("Case #" + i + ": " + sol);
	    }
	  }
	  static boolean isAvailable(ArrayList<Pair> schedule, int start, int end) {
		  for(Pair p: schedule) {
			  if((start<p.end&&start>=p.start)||(end<=p.end&&end>p.start)){
				  return false;
			  }
		  }
		  return true;
		  
	  }
	}
