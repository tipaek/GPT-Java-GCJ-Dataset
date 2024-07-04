

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Activity{
		int start,end,pos ;
		Activity(int start,int end,int pos){
			this.start = start ;
			this.end = end ;
			this.pos = pos ;
		}
		@Override
		public boolean equals(Object a) {
			Activity A = (Activity)a ;
			return this.start == A.start && this.end == A.end ;
		}
		@Override
		public String toString() {
			return Arrays.toString(new int[]{start,end});
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
						return b.end - a.end;
					}
					);
			for(int i=0;i<N;i++) 
				pq.add(new Activity(s.nextInt(),s.nextInt(),i));
			
//			ArrayList<Activity> J = new ArrayList<>() ;
//			ArrayList<Activity> C = new ArrayList<>() ;
//			J.add(new Activity(Integer.MIN_VALUE,Integer.MIN_VALUE,-1)) ;
//			C.add(new Activity(Integer.MIN_VALUE,Integer.MIN_VALUE,-1)) ;
			
			int J = Integer.MIN_VALUE ;
			int C = Integer.MIN_VALUE ;
			char[] ans= new char[N] ;
//			StringBuilder ans = new StringBuilder();
			boolean res = true ;
//			System.out.println(t);
			while(!pq.isEmpty()) {
				Activity A = pq.poll() ;
//				System.out.println(A);
//				System.out.println(J + " " + C);
				if(J<=A.start || C<=A.start) {
					if(J<C) {
						J = A.end ;
						ans[A.pos] = 'J' ;
					}else {
						C = A.end ;
						ans[A.pos] = 'C' ; 
					}
				}else {
					res = false ;
					break ;
				}
//				if(J.get(J.size()-1).end<=A.start || C.get(C.size()-1).end<=A.start) {
//					if(J.get(J.size()-1).end<=C.get(C.size()-1).end) {
//						J.add(A);
//						ans.append('J');
//					}else {
//						C.add(A) ;
//						ans.append('C');
//					}
//				}else {
//					res = false ;
//					break ;
//				}
			}
//			System.out.println(J);
//			System.out.println(C);
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
