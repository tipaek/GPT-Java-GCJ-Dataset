import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	static long[][] grid;
	static LinkedList<Integer> X,Y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		grid = new long[33][33];
		grid[0][0]=1;
		grid[1][0]=grid[1][1]=1;
		long ans = 3;
		int step = 2;
		while(step<30){
			grid[step][0]=1;
			for(int a=1;a<step+1;a++){
				grid[step][a]=grid[step-1][a]+grid[step-1][a-1];
				ans+=grid[step][a];
			}
//			System.out.println(Arrays.toString(grid[step]));
			step++;
		}
		
//		System.out.println(step);
//		System.out.println(ans);
		X = new LinkedList<Integer>();
		Y = new LinkedList<Integer>();
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			X = new LinkedList<Integer>();
			Y = new LinkedList<Integer>();
			int N = sc.nextInt();
			StringBuilder answer = new StringBuilder();
			solve(0,0,(long)(N-grid[0][0]),0, 1);
			while(!X.isEmpty()){
				answer.append("\n"+Y.poll()+" "+X.poll());
			}
				
			System.out.printf("Case #%d: %s%n", t, answer);
		}
	}

	private static boolean solve(int a, int b, long v, int d, int e) {
		X.add(b+1);
		Y.add(a+1);
		if (e<500 && grid[a][b]!=0&&v>=0){
			if(v==0L)return true;
			if(d!=-1){
				if(solve(a,b+1,v-grid[a][b+1],1,e+1))return true;
			}
			if(d!=1 && b!=0){
				if(solve(a,b-1,v-grid[a][b-1],-1,e+1))return true;
			}
			if(solve(a+1,b,v-grid[a+1][b],0,e+1))return true;
			if(solve(a+1,b+1,v-grid[a+1][b+1],0,e+1))return true;			
		}
		X.removeLast();
		Y.removeLast();
		return false;
	}
}
