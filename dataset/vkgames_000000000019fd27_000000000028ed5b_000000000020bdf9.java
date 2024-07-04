import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n= sc.nextInt();
			Segment[] states = new Segment[2*n];
			for(int j=0;j<n;j++) {
				int a = sc.nextInt(); int b = sc.nextInt();
				states[2*j] = new Segment(a,b,2*j,2*j+1); states[2*j+1] = new Segment(b,a,2*j+1,2*j);
			}
			PriorityQueue<Segment> pq = new PriorityQueue<Segment>();
			for(int j=0;j<2*n;j++) {
				pq.add(states[j]);
			}
			char[] assignment = new char[n];
			int cLast = 0;
			int jLast = 0;
			boolean works = true;
			while(!pq.isEmpty()) {
				Segment k = pq.poll();
				if(k.start<k.end) {
					//beginning
					if(k.start>=cLast) {
						cLast=k.end;
						assignment[k.idx/2] = 'C';
					}
					else {
						if(k.start>=jLast) {
							jLast= k.end;
							assignment[k.idx/2] = 'J';
						}
						else {
							works = false;
							break;
						}
					}
				}
				else {
					continue; //???
				}
			}
			if(works) {
				String s = "";
				for(int j=0;j<n;j++) {
					s+=assignment[j];
				}
				System.out.println("Case #" +(i+1)+": "+s);
			}
			else {
				System.out.println("Case #" +(i+1)+":"+" IMPOSSIBLE");
			}
		}
	}
	static class Segment implements Comparable<Segment>{
		int start; int end; int idx; int otheridx;
		public Segment(int s,int e,int id,int oidx) {
			start = s; end = e; idx=  id; otheridx = oidx;
		}
		@Override
		public int compareTo(Segment o) {
			// TODO Auto-generated method stub
			if(o.start!=start) {
				return start-o.start;
			}
			if(start>end) {
				return -1;
			}
			return 1;
		}
	}
}
