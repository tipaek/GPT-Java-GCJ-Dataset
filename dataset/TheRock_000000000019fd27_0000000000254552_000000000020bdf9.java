

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Activity{
		int start,end ;
		Activity(int start,int end){
			this.start = start ;
			this.end = end ;
		}
		@Override
		public boolean equals(Object a) {
			Activity A = (Activity)a ;
			return this.start == A.start && this.end == A.end ;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ;
		int T = s.nextInt() ;
		StringBuilder  strb = new StringBuilder() ;
		for(int t=1;t<=T;t++) {
			int N = s.nextInt() ;
			PriorityQueue<Activity> pq = new PriorityQueue<>(
					(a,b) -> {
						int res = a.start - b.start ;
						if(res!=0)
							return res ;
						return a.end - b.end;
					}
					);
			for(int i=0;i<N;i++) 
				pq.add(new Activity(s.nextInt(),s.nextInt()));
			
			int J = Integer.MIN_VALUE  ;
			int C = Integer.MIN_VALUE  ;
			
			StringBuilder ans = new StringBuilder();
			boolean res = true ;
			while(!pq.isEmpty()) {
				Activity A = pq.poll() ;
				if(J<=A.start || C<=A.start) {
					if(J<=C) {
						J = A.end ;
						ans.append('J');
					}else {
						C = A.end ;
						ans.append('C');
					}
				}else {
					res = false ;
					break ;
				}
			}
			strb.append(t) ;
			strb.append(": ");
			if(res)
				strb.append(ans);
			else
				strb.append("IMPOSSIBLE") ;
			strb.append("\n");
		}
		System.out.println(strb.toString());

	}

}
