


	import java.util.*;
	import java.io.*;
	public class Solution {
		static class Pair{
			int start ;
			int end;
			int index;
			char owner = ' ';
			Pair(int start,int end, int index){
				this.start=start;
				this.end = end;
				this.index=index;
			}
		}
	  public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	   
	    for (int i = 1; i <= t; ++i) {
	 	    int cEnd = 0;
	 	    int jEnd = 0;
	 	    ArrayList<Pair> list = new ArrayList<>();
	 	    String sol = "";
	 	    int n = in.nextInt();
	
	    	for(int j = 0; j<n;++j) {
	    		
	    		int start = in.nextInt();
	    		int end = in.nextInt();
	    		list.add(new Pair(start,end,j));
	    		
	    	}
	    	list.sort((x,y)->{
	    		return Integer.compare(x.start, y.start);
	    	});
	    	
	    	for(int k=0; k<list.size();++k) {
	    		if(cEnd<=list.get(k).start) {
	    			cEnd = list.get(k).end;
	    			list.get(k).owner = ('C');
	    		}
	    		else if(jEnd<=list.get(k).start) {
	    			jEnd = list.get(k).end;
	    			list.get(k).owner = 'J';
	    		}else {
	    			sol = "IMPOSSIBLE";
	    		}
	    	}
	    	list.sort((x,y)->{
	    		return Integer.compare(x.index, y.index);
	    	});
	    	if(!sol.equals("IMPOSSIBLE")) {
	    		for(int k  = 0; k<list.size();++k) {
	    			sol = sol + list.get(k).owner;
	    		}
	    	}
	    	
	    	System.out.println("Case #" + i + ": " + sol);
	    }
	  }
	  static boolean isAvailable(ArrayList<Pair> schedule, int start, int end) {
		  for(Pair p: schedule) {
			  if(!((start<p.start&&end<=p.start)||(start>=p.end&&end>p.start))){
				  return false;
			  }
		  }
		  return true;
		  
	  }
	}


