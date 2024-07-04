import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
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
			int rowflag=0;
			int colflag=0;
			for(int j=0;j<n;j++){
				rowsum=0;
				colsum=0;
				HashMap<Integer,Boolean> rowmap=new HashMap();
				HashMap<Integer,Boolean> colmap=new HashMap();
				if(!rowmap.containsKey(arr[j][0])){
					rowmap.put(arr[j][0], true);
				}
				if(!colmap.containsKey(arr[0][j])){
					colmap.put(arr[0][j], true);
				}
				rowflag=0;
				colflag=0;
				for(int k=0;k<n;k++){
					if(k!=0&&colmap.containsKey(arr[k][j])){
						colflag=1;
					}
					if(!colmap.containsKey(arr[k][j])){
						colmap.put(arr[k][j],true);
					}
					colsum=colsum+arr[k][j];
					if(colflag==1){
						colcount++;
						break;
					}
				}
				for(int k=0;k<n;k++){
					if(k!=0&&rowmap.containsKey(arr[j][k]))
					{
						rowflag=1;
					}
					if(!rowmap.containsKey(arr[j][k])){
						rowmap.put(arr[j][k], true);
					}
					rowsum=rowsum+arr[j][k];
					
					if(rowflag==1){
						rowcount++;
						break;
					}
					
				}
				if(rowsum!=sum&&rowflag!=1){
					rowcount++;
					
				}
				if(colsum!=sum&&colflag!=1){
					colcount++;
					
				}
				
			}
		System.out.println("Case #"+(i+1)+": "+trace+" "+rowcount+" "+colcount);	
		}
	}

}
