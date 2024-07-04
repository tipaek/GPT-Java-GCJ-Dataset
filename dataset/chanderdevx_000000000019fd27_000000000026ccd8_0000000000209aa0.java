import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.nextLine());
		
		for(int x=1; x<=t; x++) {
			String[] sar = sc.nextLine().split(" ");
			int n = Integer.parseInt(sar[0]);
			int k = Integer.parseInt(sar[1]);
			String result = "POSSIBLE";
			int diagnol = -1;
			for(int i=1; i<=n; i++) {
				if((i * n) == k) {
					diagnol = i;
				}
			}
			
			if(diagnol == -1) {
				System.out.println("Case #"+ x +": IMPOSSIBLE");
				continue;
			}
			int a[][] = new int[n][n];
			int filler= diagnol;
			for(int i=0; i<n; i++) {
				
				for(int j=0; j<n; j++) {
					a[i][j] = (filler + j) % n + 1;
				}
				filler = filler + 1;
			}
			
			System.out.println("Case #"+ x +": POSSIBLE");
			print(a);
			
		}
	}

	public static void print(int[][] a) {
		
		for(int i=0; i<a.length; i++) {
			for(int j=a[0].length -1 ;j>=0; j--) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}