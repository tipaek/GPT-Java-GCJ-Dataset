import java.util.*;
import java.io.*;

public class Solution {
	
	static int count;
	// static int dp[][];
	static Map<String, int[][]> map;
	
	static boolean solve(int[][] a, int n, int k, int i, int j) {
		count++;
		// printMatrix(a);
		if(i==n-1 && j==n) return checkDiagonalSum(a, n, k);
		if(j>=n) return solve(a, n, k, i+1, 0);
		for(int num=1;num<=n;num++){
			a[i][j] = num;
			if(!isSafeTillNow(a, n, i, j)) continue;
			if(solve(a, n, k, i, j+1)) return true;
		}
		return false;
	}
	
	static boolean safeMatrix(int[][] a, int n){
		for(int i=0;i<n;i++){
			if(!isRowSafe(a, n, i) || !isColSafe(a, n, i)) return false;
		}
		return true;
	}
	
	static boolean checkDiagonalSum(int[][] a, int n, int k){
		int sum = 0;
		for(int i=0;i<n;i++){
			sum += a[i][i];
		}
		return sum == k;
	}
	
	static boolean isSafeTillNow(int[][] a, int n, int row, int col){
		return isRowSafeTillNow(a, n, row, col) && isColSafeTillNow(a, n, row, col);
	}
	
	static boolean isRowSafeTillNow(int[][] a, int n, int row, int col){
		int[] f = new int[n];
		for(int i=0;i<=col;i++){
			f[a[row][i]-1]++;
			if(f[a[row][i]-1]>1) return false;
		}
		for(int i=0;i<n;i++){
			if(f[i]>1) return false;
		}
		return true;
	}
	
	static boolean isColSafeTillNow(int[][] a, int n, int row, int col){
		int[] f = new int[n];
		for(int i=0;i<=row;i++){
			f[a[i][col]-1]++;
			if(f[a[i][col]-1]>1) return false;
		}
		for(int i=0;i<n;i++){
			if(f[i]>1) return false;
		}
		return true;
	}
	
	static boolean isSafe(int[][] a, int n, int row, int col){
		return isRowSafe(a, n, row) && isColSafe(a, n, col);
	}
	
	static boolean isRowSafe(int[][] a, int n, int row){
		int[] f = new int[n];
		for(int i=0;i<n;i++){
			if(a[row][i]==0) continue;
			f[a[row][i]-1]++;
			if(f[a[row][i]-1]>1) return false;
		}
		for(int i=0;i<n;i++){
			if(f[i]>1) return false;
		}
		return true;
	}
	
	static boolean isColSafe(int[][] a, int n, int col){
		int[] f = new int[n];
		for(int i=0;i<n;i++){
			if(a[i][col]==0) continue;
			f[a[i][col]-1]++;
			if(f[a[i][col]-1]>1) return false;
		}
		for(int i=0;i<n;i++){
			if(f[i]>1) return false;
		}
		return true;
	}
	
	static int nextSafeNum(int[][] a, int n, int row, int col){
		int[] colf = new int[n];
		int[] rowf = new int[n];
		for(int i=0;i<n;i++){
			rowf[a[row][i]-1]++;
		}
		for(int i=0;i<n;i++){
			colf[a[i][col]-1]++;
		}
		for(int i=0;i<n;i++){
			if(rowf[i]!=1 && colf[i]!=1) return i+1;
		}
		return -1;
	}
	
	static int nextRowNum(int[][] a, int n, int row){
		int[] f = new int[n];
		for(int i=0;i<n;i++){
			f[a[row][i]-1]++;
		}
		for(int i=0;i<n;i++){
			if(f[i]!=1) return i+1;
		}
		return n;
	}
	
	static int nextColNum(int[][] a, int n, int col){
		int[] f = new int[n];
		for(int i=0;i<n;i++){
			f[a[i][col]-1]++;
		}
		for(int i=0;i<n;i++){
			if(f[i]!=1) return i+1;
		}
		return n;
	}
	
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int max = 50;
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int[][] a;
        for(int t=1;t<=T;t++){
        	int n = sc.nextInt();
        	int k = sc.nextInt();
        	if(map.containsKey(n+"_"+k)){
	            sb.append("Case #" + t + ": " + "POSSIBLE\n");
        		sb.append(printMatrix(map.get(n+"_"+k)));
        		continue;
        	}
        	a = new int[n][n];
        	count = 0;
        	boolean possible = solve(a, n, k, 0, 0);
        	String ans = possible ? "POSSIBLE" : "IMPOSSIBLE";
            sb.append("Case #" + t + ": " + ans);
            sb.append("\n");
        	// System.out.println(count);
            if(possible){
            	// printMatrix(a);
            	sb.append(printMatrix(a));
            	map.put(n+"_"+k, a);
            }
        }
        System.out.println(sb.toString());
    }
    
    static String printMatrix(int[][] a) {
    	StringBuilder sb = new StringBuilder();
    	int n = a.length;
    	// System.out.println("printing matrix");
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
				sb.append(a[i][j]);
				sb.append(" ");
    		}
    		sb.append("\n");
    	}
    	return sb.toString();
    }
}