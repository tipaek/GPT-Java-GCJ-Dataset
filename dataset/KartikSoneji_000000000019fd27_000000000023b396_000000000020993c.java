import java.util.*;
import java.math.*;

public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[][] a;
		int n, trace;
		Set[] rows, cols;
		int r, c;
		for(int t = 0, cases = sc.nextInt(); t < cases; t++){
			n = sc.nextInt();
			
			rows = new Set[n];
			cols = new Set[n];
			for(int i = 0; i < n; i++){
				rows[i] = new HashSet<Integer>();
				cols[i] = new HashSet<Integer>();
			}
			
			a = new int[n][n];
			trace = 0;
			for(int i = 0; i < a.length; i++)
				for(int j = 0; j < a[i].length; j++){
					a[i][j] = sc.nextInt();
					
					rows[i].add(a[i][j]);
					cols[j].add(a[i][j]);
					
					if(i == j)
						trace += a[i][j];
				}
			
			r = 0;
			c = 0;
			for(int i = 0; i < n; i++){
				if(rows[i].size() != n)
					r++;
				if(cols[i].size() != n)
					c++;
			}
			
			
			System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
		}
		
		sc.close();
	}
}