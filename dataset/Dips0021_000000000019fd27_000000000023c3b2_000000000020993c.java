import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for(int k=1;k<=T;k++){
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int t=0;
			int r=0;
			int c=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i==j)
						t=t+arr[i][j];
				}
			}
			for(int i=0;i<n;i++){
				for(int j=1;j<n;j++){
					if(arr[i][0]==arr[i][j]){
						r++;
						break;
					}
				}
			}
			
			for(int i=n-1;i>=0;i--){
				for(int j=n-2;j>=0;j--){
					if(arr[n-1][i]==arr[j][i]){
						c++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+ k+":"+ t+" "+r+" "+c);
		}
	}
}
				
			
			