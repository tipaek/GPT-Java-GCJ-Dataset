import java.io.*;
import java.util.*;

public class Solution {
	public static void print(int[][] arr,int n,int c){
		int trace=0,reprow=0,repcol=0;
		HashSet<Integer> row,col;
		for(int i=0;i<n;i++){
			trace+=arr[i][i];
		}
		for(int j=0;j<n;j++){
			row=new HashSet<Integer>();
			for(int k=0;k<n;k++){
				if(row.contains(arr[j][k])){
					reprow++;
					break;
				}
				row.add(arr[j][k]);
			}
		}
		for(int j=0;j<n;j++){
			col=new HashSet<Integer>();
			for(int k=0;k<n;k++){
				if(col.contains(arr[k][j])){
					repcol++;
					break;
				}
				col.add(arr[k][j]);
			}
		}
		System.out.println("Case #"+ c +": "+trace+" "+reprow+" "+repcol);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(scan.readLine());
		for(int i=0;i<t;i++){
			int n=Integer.parseInt(scan.readLine());
			int arr[][]= new int[n][n];
			for(int j=0;j<n;j++){
				String[] s=scan.readLine().split(" ");
				for(int k=0;k<n;k++){
					arr[j][k]=Integer.parseInt(s[k]);
				}
			}
			print(arr, n,i+1);
		}
		scan.close();
	}
}