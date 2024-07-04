import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class Solution {
	
	public static void sort(int arr[], int start, int end){ 
        if (start < end){
        	int pi = partition(arr, start, end); 
        	sort(arr, start, pi-1); 
            sort(arr, pi+1, end); 
        } 
    } 
	
	public static int partition(int arr[], int start, int end) { 
        int pivot = arr[end];  
        int i = (start-1); 
        for (int j=start; j<end; j++){ 
            if (arr[j] < pivot){ 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[end]; 
        arr[end] = temp; 
        return i+1; 
    }
	
	public static int repeatCheck (int[][] M, int N) {
		int rr = 0;
		for (int rC = 0; rC < N; rC ++) {
			int[] R = M[rC];
			sort(R, 0, N -1);
			for (int cR = 0; cR < N - 1; cR ++) {
				if (R[cR] == R[cR + 1]) {
					rr ++; 
					break;
				}
			}
		}
		return rr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = 0;
		int [][] M = {{}};
		int [][] P = {{}};
		int trace = 0;
		for (int i = 1; i <= T; i ++) {
			N = sc.nextInt();
			M = new int [N][N];
			P = new int [N][N];
			int r = 0;
			int c = 0;
			while (c < N && r < N) {
				int a = sc.nextInt();
				M[r][c] = a;
				P[c][r] = a;
				if (c == N - 1 && r < N) {
					c = 0;
					r ++;
				}
				else {
					c++;
				}
			}
			for (int R = 0, C = 0; R < N && C < N; R++, C++) {
				trace += M[R][C];
			}
			int rr = repeatCheck(M, N);
			int cr = repeatCheck(P, N);
			System.out.println("Case # " + i + ": " + trace + " " + rr + " " + cr);
			trace = 0;
		}
	}

}