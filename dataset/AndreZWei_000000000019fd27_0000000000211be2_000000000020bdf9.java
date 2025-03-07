import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	static class IntervalSet {
		TreeMap<Integer, Integer> intervals;

		public IntervalSet() {
			intervals = new TreeMap<Integer, Integer>();
		}

		/*
			Insert an interval [l, r]
		*/
		public void insert(Integer l, Integer r) {
			if (intervals.size() == 0) {
				intervals.put(l, r);
			} 
			else {
				Integer low = intervals.floorKey(l);
				Integer cur = low;
				if (low == null || intervals.get(low) < l) {
					low = l;
					cur = intervals.higherKey(low);
				}
				while (cur != null && intervals.get(cur) < r) {
					intervals.remove(cur);
					cur = intervals.higherKey(cur);
				}
				if (cur == null || cur > r) {
					intervals.put(low, r);
				} 
				else {
					Integer high = intervals.get(cur);
					intervals.remove(cur);
					intervals.put(low, high);
				}
			}
		}

		/*
			Remove an interval [l, r]
			returns true if exists
		*/
		public boolean remove(Integer l, Integer r) {
			if (intervals.containsKey(l) && intervals.get(l) == r) {
				intervals.remove(l);
				return true;
			}
			return false;
		}

		/* 
			Query a point x.
			returns true if exists an interval [l, r] such that l <= x <= r
			returns false otherwise
		*/
		public boolean query(Integer x) {
			Integer low = intervals.floorKey(x);
			if (low == null || intervals.get(low) < x) {
				return false;
			}
			return true;
		}

		/*
			Returns a string representation of the intervals
		*/
		public String toString() {
			if (intervals.size() == 0) return "";
			StringBuilder sb = new StringBuilder();
			for (Integer i: intervals.keySet()) {
				sb.append('[');
				sb.append(i);
				sb.append(',');
				sb.append(intervals.get(i));
				sb.append("],");
			}
			return sb.substring(0, sb.length()-1);
		}

		/*
			Returns the number of intervals
		*/
		public Integer size() {
			return intervals.size();
		}

		/*
			Returns a iterator of the set
		*/
		public Iterator<Map.Entry<Integer,Integer>> iterator() {
			return intervals.entrySet().iterator();
		}
	}


	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int d = in.nextInt();
	      int[][] arr = new int[d][2];
	      for (int j = 0; j < d; j++) {
	      	arr[j][0] = in.nextInt();
	      	arr[j][1] = in.nextInt();
	      }
	      System.out.println("Case #" + i + ": " + solve(arr));
	    }
  	}

  	public static String solve(int[][] arr){
  		IntervalSet c = new IntervalSet();
  		IntervalSet j = new IntervalSet();

  		StringBuilder sb = new StringBuilder();
  		for (int[] i: arr) {
  			if ((j.query(i[0]) || j.query(i[1]-1)) && (c.query(i[0]) || c.query(i[1]-1))) {
  				return "IMPOSSIBLE";
  			}
  			else if (!c.query(i[0]) && !c.query(i[1]-1)) {
  				c.insert(i[0], i[1]-1);
  				sb.append("C");
  			} 
  			else {
  				j.insert(i[0], i[1]-1);
  				sb.append("J");
  			}
  		}
  		return sb.toString();
  	}
}

