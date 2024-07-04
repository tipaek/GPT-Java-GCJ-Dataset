import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution{
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		int n=0;
		int[][] arr=new int[2][2];
		int trace=0;
		int row=0;
		int col=0;
		int actual_row=0;
		int actual_col=0;
		for(int i=0;i<t;i++)
		{
				trace=0;
				actual_row=0;
				actual_col=0;
			 st=new StringTokenizer(br.readLine());
			 n=Integer.parseInt(st.nextToken());
			 arr=new int[n][n];
			 
			 for(int j=0;j<n;j++)
			 {
				 row=0;
				 st=new StringTokenizer(br.readLine());
				 HashMap<Integer,Integer> dub=new HashMap<>();
				 for(int k=0;k<n;k++)
				 {
					 arr[j][k]=Integer.parseInt(st.nextToken());
					 if(j==k)
						 trace+=arr[j][k];
					 if(dub.containsKey(arr[j][k]))
						 row=row+1;
					 else
						 dub.put(arr[j][k],1);
				 }
				 
				 if(row>0)
					 actual_row+=1;
			 }
			 
			 for(int k=0;k<n;k++)
			 {
				 HashMap<Integer,Integer> dub=new HashMap<>();
				 col=0;
				 for(int j=0;j<n;j++)
				 {
					 if(dub.containsKey(arr[j][k]))
						 {
						 	col=col+1;
						 	break;
						 }
					 else
						 dub.put(arr[j][k],1);
				 }
				 
				 if(col>0)
					 actual_col+=1;
			 }
			 
			 System.out.println("Case #"+(int)(i+1)+": "+trace+" "+actual_row+" "+actual_col);
			 
		}
		
		
	}

}
