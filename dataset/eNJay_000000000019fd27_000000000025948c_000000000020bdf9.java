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

	Collections.sort(intervals);

	char assign = 'C';
	
	sb.append(assign);

	
	for(int i=0; i<intervals.size()-1; i++){
		Interval in1= intervals.get(i);
		Interval in2 = intervals.get(i+1);

		//overlap?
		if(in1.end > in2.start){
			if(i>0){
				Interval in0 = intervals.get(i-1);
				if(in2.start < in0.end){
					//triple overlap, impossible
					sb = new StringBuilder(imp);
					break;
				}
			}
		
			if(assign == 'C') assign = 'J';
			else assign = 'C';	
			
		}	

		if(in2.index >= sb.length())
			sb.append(assign);
		else
		sb.insert(in2.index, assign);
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