
import java.util.*;
import java.io.*;

public class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int T;
		Scanner sc= new Scanner(System.in);
		int N;
		T= sc.nextInt();
		//N = sc.nextInt();
		int C=T;
		while(T-- >0)
		{
			int countr=0;
			int countc=0;
			N = sc.nextInt();
			int arr[][] = new int[N][N];
			int row_sum =0;
			int arr_row_sum [] = new int[N];
			int arr_col_sum [] = new int[N];
			int trace_sum=0;
			Set<Integer> set = new HashSet<Integer>();
			//System.out.println("N is "+N);
			for(int i=0;i<N;i++)
			{	
				row_sum=0;
				for(int j=0;j<N;j++)
				{	//System.out.println("Reading line "+i+j);
					arr[i][j]=sc.nextInt();
					

					arr_col_sum[j]+=arr[i][j];
					set.add(arr[i][j]);
					row_sum+=arr[i][j];
					if(i==j) { trace_sum +=arr[i][j];}
				}
				arr_row_sum[i]=row_sum;
			}
			
			int set_sum=0;
			for(Integer i:set) set_sum+=i;
			
			for(int i=0;i<N;i++)
			{
				if(arr_row_sum[i]!=set_sum)countr++;
			}
			
			for(int i=0;i<N;i++)
			{
				if(arr_col_sum[i]!=set_sum) countc++;
			}
			int count=C-T;
			System.out.println("Case #"+count+":"+" "+ trace_sum +" "+ countr+" " +countc);
			
		}
	}

}
 