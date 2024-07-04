import java.io.*;
import java.util.*;
import java.lang.*;

class codejam1{
	public static void main(String args[]){ 
		try{
	 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] inp = br.readLine().trim().split("\\s+");
			int yre = Integer.parseInt(inp[0]);
			for(int rt=0 ; rt<yre ; rt++){
				inp = br.readLine().trim().split("\\s+");
				int n = Integer.parseInt(inp[0]);
				int arr[][] = new int[n][n];
				int sum = 0;
				int rows=0; 
				int col=0;
				for(int i=0 ; i<n ; i++){
					inp = br.readLine().trim().split("\\s+");
					int vis[] = new int[n];
					int flag=0;
					for(int j=0 ; j<n ; j++){
						arr[i][j] = Integer.parseInt(inp[j]);
						if(flag ==0 &&vis[arr[i][j]-1]==1){
							rows+=1;
							flag=1;
						}
						else{
							vis[arr[i][j]-1]=1;
						}
					}
				}
				for(int i=0 ; i<n ; i++){
					int vis[] = new int[n];
					int flag = 0 ;
					for(int j=0 ; j<n ; j++){
						if(flag==0 && vis[arr[j][i]-1]==1){
							col+=1;
							flag=1;
						}
						else{
							vis[arr[j][i]-1]=1;
						}

					}
				}
				for(int i=0 ; i<n ; i++){
					sum+=arr[i][i];
				}
				System.out.println("Case #"+(rt+1)+": "+sum + " " +rows + " " + col);					
			}				
		}
		catch(Exception E){}
	}
}