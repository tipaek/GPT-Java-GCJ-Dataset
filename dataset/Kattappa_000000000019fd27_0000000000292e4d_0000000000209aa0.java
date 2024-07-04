import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int[] n = new int[t];
		int[] k = new int[t];
		for(int i=0; i<t; i++) {
			n[i] = in.nextInt();
			k[i] = in.nextInt();
		}

		for(int i=0; i<t; i++) {
			findMatrix(i+1, n[i], k[i]);
		}
	}
	public static void findMatrix(int t, int n, int k) {
	int A[] = new int[n];
	int M[][] = new int[n][n];
	int j=1;
	int q=0, c=0, i=0;

	if(k % n == 0)
	{
		System.out.println("Case #"+t+": "+ "POSSIBLE");
		q = k/n; c=q; i=0;
		if (q<n) {
			while(q >= 1){
				A[i++]=q;
				q--;
			}
			while(i<n){
				A[i++]=c+1;
				c++;
			}
		} else {
			while(q!=0){
				A[i++]= q;
				--q;
			}
		}

		for(int y = 0; y<n ; ++y){
			for(int z = 0; z<n ;++z){
				M[y][z]= A[z];
			}
		}
		for(int x=0; x<n; x++) {
			rotateRow(M[x], x, n);
		}
		display(M, n);
		
	} else {
		System.out.println("Case #"+t+": "+ "IMPOSSIBLE");
	}
}

	public static int[] rotateRow(int[] A, int shift, int n) {
		for (int l = 0; l<shift ; ++l ) {
			int last= A[n-1];
			for (int m=n-1 ; m>0 ; --m) {
				A[m]= A[m-1];
			}
			A[0]=last;
			}
		return A;
	}
	public static void display(int[][] M, int n) {
		for(int i=0; i<n;i++) {
			for(int j= 0; j<n ; j++){
			System.out.print(M[i][j]+ " ");
		}
		System.out.println();
	}

}
}
