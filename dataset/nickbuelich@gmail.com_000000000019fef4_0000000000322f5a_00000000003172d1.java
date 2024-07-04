import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			long[] degree = new long[N]; 
			HashSet<Long> possible = new HashSet<Long>();
			for(int a=0;a<N;a++){
				degree[a]=sc.nextLong();
			}
			
			long answer = D-1;
			
			for(int a=0;a<N;a++){
				for(int b=1;b<=50;b++){
					answer = Math.min(answer, magic(degree[a],b,D,degree));					
				}
			}
			
			System.out.printf("Case #%d: %s%n", t, answer);
		}
	}

	private static long magic(long xn, long xd, int D, long[] degree) {
		long many = 0;
		int N = degree.length;
		
		long[] temp = new long[N];
		for(int a=0;a<N;a++){
			temp[a]=degree[a]*xd;
		}
		
		test:for(int a=0;a<N;a++){
			many+=temp[a]/xn;
			if (many>=D)break test;
		}
		if (many<D)return Long.MAX_VALUE;
		
		PriorityQueue<Long> PQ = new PriorityQueue<Long>();
		long extra = 0;
		for(int a=0;a<N;a++){
			if(temp[a]>=xn && temp[a]%xn==0){
				PQ.add(temp[a]/xn);
			}
			else{
				extra+=temp[a]/xn;
			}
		}
	//	System.out.println(PQ);
		int moves = 0;
		int needed = D;
		
		while(!PQ.isEmpty() && needed>0){
			long cur = PQ.poll();
			if (cur > needed){
				moves+=needed;
				needed=0;
				break;
			}
			needed-=cur;
			moves+=cur-1;
		}

	//	System.out.println(xn+" "+xd+" "+moves);
		return moves + needed;
	}
}
