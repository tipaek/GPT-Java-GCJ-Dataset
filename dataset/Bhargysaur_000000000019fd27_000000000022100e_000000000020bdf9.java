import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	private static class Interval {
		final int start;
		final int end;
		public String person = "";
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	private static class IntComp implements Comparator<Interval>
	{

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start>o2.start) return 1; 
			return -1;
		}
		
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0;i<t;i++) {
			int n = sc.nextInt();
			ArrayList<Interval> al = new ArrayList<Interval>();
			for (int j = 0;j<n;j++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				al.add(new Interval(s,e));
			}
			ArrayList<Interval> sorted = (ArrayList<Interval>) al.clone();
			Collections.sort(sorted, new IntComp());
			
			Interval c = null;
			Interval j = null;
			String result = "";
			HashMap<Interval, Integer> indexIt = new HashMap<Interval, Integer>();
			for (int k = 0;k<n;k++) {
				indexIt.put(al.get(k),k);
			}
			for (int k = 0;k<n;k++) {
				Interval interval = sorted.get(k);
				if (c==null || c.end<=interval.start) {
					result+="C";
					int ind = indexIt.get(interval).intValue();
					al.get(ind).person="C";
					c = al.get(ind);
				}
				else if (j==null || j.end<=interval.start) {
					result+="J";
					int ind = indexIt.get(interval).intValue();
					al.get(ind).person="J";
					j = al.get(ind);
				}
				else {
					result = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+(i+1)+": "+result);
		}
	}
}