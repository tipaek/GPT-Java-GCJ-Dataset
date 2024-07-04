import java.util.HashSet;
import java.util.Scanner;

public class Solution {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int i=1; i<=T; i++) {
		int N = sc.nextInt();
		int r=0;
		int c=0; 
		int k=0;
		int[][] m = new int[N][N];
		for(int j=1; j<=N; j++) {
			HashSet<Integer> row = new HashSet<>();
			boolean rodup = false;
			for(int h=1; h<=N; h++) {
				int x = sc.nextInt();
				if(h==j) 
					k+=x;
				if(row.contains(x)) {
					rodup=true;
				}
				row.add(x);
				m[j-1][h-1]=x;
			}
			if(rodup) {
				r++;
			}
		}
		
		for(int j=1; j<=N; j++) {  
			HashSet<Integer> column = new HashSet<>();
			boolean cedup=false;
			for(int h=1; h<=N; h++) {
				int x = m[h-1][j-1]; 
				if(column.contains(x)) {
					cedup=true;
				} 
				column.add(x);
				
			}
			if(cedup) {
				c++;
			}
		}
		
		System.out.println("Case #"+i+": "+k+" "+r+" "+c);
	}
}
}
