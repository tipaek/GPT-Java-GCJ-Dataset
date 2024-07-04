import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int totalTestCases=Integer.valueOf(in.nextLine());
		int count=0;
		//System.out.println(totalTestCases);
		while(count<totalTestCases) {
			count++;
			int m=in.nextInt(), n=in.nextInt();
			int[][] arr=new int[m][n];
			for(int i=0; i<m; i++)
				for(int j=0; j<n; j++) arr[i][j]=in.nextInt();
			int output=helper(arr, m, n);
			System.out.println("Case #"+count+": "+output);
		}
//		int[][] arr=new int[][] {{1,2,3}};
//		System.out.println(helper(arr, 1,3));
	}
	
	public static int helper(int[][] arr, int m, int n) {
		int res=0;
		double[] rows=new double[m];
		double[] cols=new double[n];
		int prevSum=Integer.MAX_VALUE, curSum=Integer.MIN_VALUE;
		while(true) {
			curSum=0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]>=rows[i]&&arr[i][j]>=cols[j]) curSum+=arr[i][j];
					else arr[i][j]=0;
				}
			}
			//System.out.println(curSum);
			if(prevSum==curSum) break;
			prevSum=curSum;
			res+=curSum;
			avgCal(arr, rows, cols, n, m);
		}
		return res;
	}
	
	public static void avgCal(int[][] arr, double[] rows, double[] cols, int n, int m) {
		for(int i=0; i<m; i++) {
			int div=0;
			int sum=0;
			for(int j=0; j<n; j++) {
				if(arr[i][j]>0) {
					sum+=arr[i][j];
					div++;
				}
			}
			if(div>0) rows[i]= (double)sum/(div);
		}
		
		for(int i=0; i<n; i++) {
			int div=0;
			int sum=0;
			for(int j=0; j<m; j++) {
				if(arr[j][i]>0) {
					sum+=arr[j][i];
					div++;
				}
			}
			if(div>0) cols[i]= (double)sum/(div);
		}
	}
}