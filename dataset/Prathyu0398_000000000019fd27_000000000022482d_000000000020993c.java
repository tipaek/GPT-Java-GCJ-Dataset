import java.io.*;
import java.util.*;

public class vestigium {
	public static int findtrace(int[][] arr, int n) {
		int sum=0;
		for(int i=0;i<n;i++) {
			sum=sum+arr[i][i];
		}
		return sum;
	}
	
	public static int countidenticalrows(int[][] arr,int n) {
		int count=0;
		for(int i=0;i<n;i++) {
			HashSet<Integer> hs=new HashSet<>();
			
			for(int j=0;j<n;j++) {
				hs.add(arr[i][j]);
			}
			if(hs.size()<n) {
				count++;
			}
		}
		return count;
	}
	
	public static int countidenticalcolumns(int[][] arr, int n) {
		int count=0;
		for(int i=0;i<n;i++) {
			HashSet<Integer>hs=new HashSet<>();
			
			for(int j=0;j<n;j++) {
				hs.add(arr[j][i]);
			}
			if(hs.size()<n) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();
			int[][] arr=new int[n][n];
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					arr[j][k]=sc.nextInt();
				}
			}
			int trace=findtrace(arr,n);
			int r= countidenticalrows(arr,n);
			int c=countidenticalcolumns(arr,n);
			
			System.out.println("Case #"+t+":"+" "+trace+" "+r+" "+c);
		}
		

	}

}