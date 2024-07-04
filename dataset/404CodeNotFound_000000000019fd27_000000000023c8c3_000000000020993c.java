import java.util.Scanner;
import java.util.HashSet;
public class Solution {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, c, r, trace;
		int[][] arr;
		HashSet<Integer> data; 
		for(int k=0;k<t;k++){
			c = 0;
			r = 0;
			trace = 0;
			n = sc.nextInt();
			arr = new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[i][j] = sc.nextInt();	
				}
			}

			for(int i=0;i<n;i++){
				data = new HashSet<Integer>();
				for(int j=0;j<n;j++){
					if(i==j){
						trace += arr[i][j];
					}
				}
				for(int j=0;j<n;j++){
					
					if(!data.contains(arr[i][j])){
						data.add(arr[i][j]);
					}
					else{
						r++;
						break;
					}
						
				}
				data = new HashSet<Integer>();
				for(int j=0;j<n;j++){
					if(!data.contains(arr[j][i])){
						data.add(arr[j][i]);
					}
					else{
						c++;
						break;
					}	
				}
			}
			System.out.println(trace+" "+r+" "+c);
		}
	}
}