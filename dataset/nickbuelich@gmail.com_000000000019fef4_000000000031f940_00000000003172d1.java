import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
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
				for(int b=1;b<=51;b++){
					possible.add(degree[a]/b);
				}
			}
			
			long answer = Long.MAX_VALUE;
			
			for(Long x : possible){
				if (x==0)continue;
				answer = Math.min(answer, magic(x,D,degree));
			}
			
			System.out.printf("Case #%d: %s%n", t, answer);
		}
	}

	private static long magic(long x, int D, long[] degree) {
		int[] multiples = new int[55];
		for(int a=0;a<degree.length;a++){
			if (degree[a]%x==0){
				long m = degree[a]/x;
				int mm = (int)Math.min(m, 54);
				multiples[mm]++;
			}
		}
		
		int needed = D;
		int moves = 0;
		stuff: for(int a=1;a<55;a++){
			while(needed>0&&multiples[a]>0){
				if (needed<a){
					moves+=needed;
					needed=0;
					break;
				}
				
				needed-=a;
				moves+=a-1;
				multiples[a]--;
			}
			if(needed==0){
				return moves;
			}
		}
		
		return D-1;
	}
}
