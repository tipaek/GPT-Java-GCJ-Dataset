import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 
import java.io.*;

public class Solution {
	
	 class Pair implements Comparable<Pair>{
		Integer start;
		Integer end;

		public Pair(Integer s,Integer e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(Pair o) {
			return this.start.compareTo(o.start);
		}
	}
	
	
	public static void main(String[] args) {
		Solution pp = new Solution();
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t1 = scan.nextInt();
		
		for(int t=1;t<=t1;t++) {
			int n = scan.nextInt();
			
			List<Pair> pairs = new ArrayList<>();
			Map<Integer, Pair> intervalIndexMap = new HashMap<>();
			Map<Pair, Character> pairAssigneeMap = new HashMap<>();
			
			for(int i=0;i<n;i++) {
				int s=scan.nextInt();
				int e=scan.nextInt();
				Pair temp = pp.new Pair(s,e);
				pairs.add(temp);
				intervalIndexMap.put(i, temp);
			}
			
			Collections.sort(pairs);
			
			Pair cPair = null, jPair=null;
			
			boolean impossible=false;
			
			for(Pair pair : pairs) {
				
				if(cPair==null) {
					cPair = pair;
					pairAssigneeMap.put(pair, 'C');
				}
				else if(cPair!=null && (cPair.end <= pair.start) ) {
					cPair = pair;
					pairAssigneeMap.put(pair, 'C');
				}
				else if(jPair==null) {
					jPair = pair;
					pairAssigneeMap.put(pair, 'J');
				}
				else if(jPair!=null && (jPair.end <= pair.start) ) {
					jPair = pair;
					pairAssigneeMap.put(pair, 'J');
				}
				else {
					impossible = true;break;
				}
				
			}
			
			if(impossible)System.out.println("Case #"+t+": IMPOSSIBLE");
			else {
				String result="";
				
				for(int i=0;i<n;i++) {
					result+= pairAssigneeMap.get(intervalIndexMap.get(i));
				}
				
				System.out.println("Case #"+t+": "+result);
			}
			
		}
		
		
		scan.close();
	}
	
}
