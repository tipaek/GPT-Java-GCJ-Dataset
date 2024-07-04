import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=s.nextInt();
		for (int i=0;i<t;i++){
			int n=s.nextInt();
			int arr[][]=new int[n][n];
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					System.out.println(j+""+k);
					arr[j][k]=s.nextInt();
				}
			}
			int sum=n*(n+1)/2;
			int rowsum=0;
			int colsum=0;
			int rowcount=0;
			int colcount=0;
			int trace=0;
			for(int j=0;j<n;j++){
				trace=trace+arr[j][j];
			}
			for(int j=0;j<n;j++){
				rowsum=0;
				colsum=0;
				for(int k=0;k<n;k++){
					rowsum=rowsum+arr[j][k];
					colsum=colsum+arr[k][j];
				}
				if(rowsum!=sum){
					rowcount++;
					
				}
				if(colsum!=sum){
					colcount++;
					
				}
			}
		System.out.println("Case #"+(i+1)+": "+trace+" "+rowcount+" "+colcount);	
		}
	}

}
