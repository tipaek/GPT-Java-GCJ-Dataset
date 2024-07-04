

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=1;i<=t;i++){
			int n=s.nextInt();
			int r=0;
			int c=0;
			int [][]arr=new int[n][n];
			int trace=0;
			for(int j=0;j<n;j++){
				HashMap<Integer,Integer> row=new HashMap<>();
				for(int k=0;k<n;k++){
					int temp=s.nextInt();
					arr[j][k]=temp;
					row.put(temp, 1);
					if(j==k){
						trace+=temp;
					}
				}
				if(row.size()!=n){
					r++;
				}
			}
			for(int j=0;j<n;j++){
				HashMap<Integer,Integer> column=new HashMap<>();
				for(int k=0;k<n;k++){
					int temp=arr[k][j];
					column.put(temp, 1);	
				}
				if(column.size()!=n){
					c++;
				}
			}
			System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
		}
	}
}
