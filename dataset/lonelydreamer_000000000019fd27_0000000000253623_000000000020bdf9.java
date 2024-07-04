import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	private static class Interval implements Comparable<Interval> {
		public int start , end , index;		
		public Interval(int start , int end , int index) {
			this.start = start;
			this.end = end;			
			this.index = index;			
		}
		@Override
		public int compareTo(Interval interval) {
			return this.start - interval.start;			
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {			
		Scanner scan = new Scanner(System.in);		
		int t = scan.nextInt() , caseNum = 1;	
		while (t > 0) {
			List<Interval> intervalList = new ArrayList<>();
			int n = scan.nextInt();
			for (int i = 0;i < n;i ++) {
				intervalList.add(new Interval(scan.nextInt() , scan.nextInt() , i));
			}			
			Collections.sort(intervalList);
			boolean isValid = true;
			int end1 = - 1 , end2 = - 1;			
			int[] result = new int[n];			
			for (int i = 0;i < n;i ++) {				
				int start = intervalList.get(i).start , end = intervalList.get(i).end;
				if (start >= end1) {					
					end1 = end;
					result[intervalList.get(i).index] = 0;					
				} else if (start >= end2) {
					end2 = end;
					result[intervalList.get(i).index] = 1;					
				} else {
					isValid = false;
					break;					
				}
			}			
			if (isValid) {
				StringBuilder builder = new StringBuilder();
				for (int i = 0;i < n;i ++) {
					if (result[i] == 0) {
						builder.append("C");
					} else {
						builder.append("J");						
					}
				}
				System.out.println(String.format("Case #%d: %s" , caseNum , builder.toString()));
			} else {
				System.out.println(String.format("Case #%d: IMPOSSIBLE" , caseNum));
			}
			t --;
			caseNum ++;
		}
	}    	
		
}





