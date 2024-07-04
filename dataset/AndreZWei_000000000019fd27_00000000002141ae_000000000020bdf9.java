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
			intervals.put(l, r);
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
		public boolean query(Integer l, Integer r) {
			Integer low = intervals.lowerKey(r);
			if (low != null && intervals.get(low) > l) {
				return true;
			}
			return false;
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
  		Integer[] indices = new Integer[arr.length];
  		for (int i = 0; i < arr.length; i++) indices[i] = i;
  		Arrays.sort(indices, new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {
  				return arr[i][0] - arr[j][0];
  			}
  		});
  		Arrays.sort(arr, new Comparator<int[]>() {
  			public int compare(int[] a, int[] b) {
  				return a[0] - b[0];
  			}
  		});
  		IntervalSet c = new IntervalSet();
  		IntervalSet j = new IntervalSet();

  		char[] ans = new char[arr.length];
  		for (int cnt = 0; cnt < arr.length; cnt++) {
  			int[] i = arr[cnt];
  			Integer index = indices[cnt];
  			if (j.query(i[0], i[1]) && c.query(i[0], i[1])) {
  				return "IMPOSSIBLE";
  			}
  			else if (!c.query(i[0], i[1])) {
  				c.insert(i[0], i[1]);
  				ans[index] = 'C';
  			} 
  			else {
  				j.insert(i[0], i[1]);
  				ans[index] = 'J';
  			}
  		}
  		return new String(ans);
  	}
}

