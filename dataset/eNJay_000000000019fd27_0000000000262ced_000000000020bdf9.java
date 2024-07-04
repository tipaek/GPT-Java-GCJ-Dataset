import java.util.*;
import java.io.*;
public class Solution {
    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
	int n = in.nextInt();
	
	List<Interval> ins = new ArrayList<>();

	for(int j = 0; j< n; j++){
		ins.add(new Interval(in.nextInt(), in.nextInt(), j));
	}
      
      	schedule(ins, i);
    }
  }
  

  private static void schedule(List<Interval> intervals, int cs){
      
	String imp = "IMPOSSIBLE";

	StringBuilder sb = new StringBuilder();
	sb.setLength(intervals.size());

	Collections.sort(intervals);

	int c = -1;
	int j = -1;

	for(int i=0; i<intervals.size(); i++){
		Interval in = intervals.get(i);
		if(c <= in.start){
			sb.setCharAt(in.index, 'C');
			c = in.end;	
		} else if ( j <= in.start){
			sb.setCharAt(in.index, 'J');
			j = in.end;
		} else {
			sb = new StringBuilder(imp);
			break;
		}
	
	}

        System.out.println("Case #" + cs + ": " + sb.toString());
  }

  private static class Interval implements Comparable<Interval> {

	int start;
	int end;
	int index;

	public Interval(int s, int e, int j){
		start = s;
		end = e;
		index = j;
	}

	@Override
	public int compareTo(Interval that){

		if(this.start < that.start) return -1;
		if(that.start < this.start) return 1;

		if(this.end < that.end) return -1;
		if(that.end < this.end) return 1;

		return 0;
	}


}  



}