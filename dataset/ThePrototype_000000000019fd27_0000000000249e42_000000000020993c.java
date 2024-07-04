import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args){
		int T,N;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		for(int t = 0; t < T; ++t){
			N = in.nextInt();
			int[][] M = new int[N][N];
			List<Set<Integer>> colSet = new ArrayList<Set<Integer>>();
			boolean[] colDup = new boolean[N];
			int r=0,c=0;
			long k=0L;
			for( int i = 0; i < N; ++i){
				Set<Integer> rowSet = new HashSet<Integer>();
				boolean dup = false;
				for(int j = 0; j < N; ++j){
					if(i == 0){
						colSet.add(j,new HashSet<Integer>());
						colDup[j] = false;
					}
					M[i][j] = in.nextInt();
					if(i == j){
						k = k + M[i][j];
					}
					if(!rowSet.add(M[i][j])){
						dup = true;
					}
					if(!colSet.get(j).add(M[i][j])){
						colDup[j] = true;
					}
					if( (i == N-1) && (colDup[j])){
						++c;
					}
				}
				if(dup){
					++r;
				}
			}
			
			System.out.println("Case #"+ (t+1) +": "+ k +" "+ r + " " +c); 
		}
	}
}