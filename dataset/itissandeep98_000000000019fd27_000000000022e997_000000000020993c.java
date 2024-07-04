import java.io.*;
import java.util.*;

public class Test {
	public static void print(int[][] arr,int n,int c){
		int trace=0,reprow=0,repcol=0;
		HashSet[] row=new HashSet[n];
		HashSet[] col=new HashSet[n];
		for(int i=0;i<n;i++){
			row[i]=new HashSet<Integer>();
			col[i]=new HashSet<Integer>();
			trace+=arr[i][i];
		}
		for(int j=0;j<n;j++){
			for(int k=0;k<n;k++){
				if(row[j].contains(arr[j][k])){
					reprow++;
					break;
				}
				row[j].add(arr[j][k]);
			}
		}
		for(int j=0;j<n;j++){
			for(int k=0;k<n;k++){
				if(col[j].contains(arr[k][j])){
					repcol++;
					break;
				}
				col[j].add(arr[k][j]);
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