import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

 public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long startTime = System.currentTimeMillis();
		int T = 0,N = 0;
		Scanner reader =  
                new Scanner(new InputStreamReader(System.in)); 
      
     String name = reader.next();
	T = Integer.parseInt(name);
     for(int t=0;t<T;t++)
     {
//	     reader =  
//	             new Scanner(new InputStreamReader(System.in)); 
	     String name1 = reader.next();
		N = Integer.parseInt(name1);
	     int [][]arr = new int[N][N];
	     for(int i=0;i<N;i++)
	     {
	    	 
	    	 
//    		 reader =  
//    	             new Scanner(new InputStreamReader(System.in)); 
    	     //String name11 = reader.next();
			//String[] splited = name11.split("\\s+");
			for(int j=0;j<N;j++)
				arr[i][j] = Integer.parseInt(reader.next());

	     }
	         
	     VestigiumNess(arr,N, t+1);
	     
     }
     //long endT = System.currentTimeMillis();
     //System.out.println(endT-startTime);
      
	}

	private static void VestigiumNess(int[][] arr, int n, int cas) {
		// TODO Auto-generated method stub
		int trace = 0;
		for(int i=0;i<n;i++)
			trace += arr[i][i];
		int r=0,c=0;
		int []hash = new int[n+1];
		for(int i=0; i<n+1;i++)
			hash[i] = 0;
		
		//All rows
		for(int i=0; i<n;i++)
		{
			hash = new int[n+1];
			for(int k=0; k<n+1;k++)
				hash[k] = 0;
			for(int j=0; j<n;j++)
			{
				hash[arr[i][j]] += 1;
				if(hash[arr[i][j]] > 1)
				{
					r++;
					
					break;
				}
			}
		}
		//All columns
		for(int i=0; i<n;i++)
		{
			hash = new int[n+1];
			for(int k=0; k<n+1;k++)
				hash[k] = 0;
			for(int j=0; j<n;j++)
			{
				hash[arr[j][i]] += 1;
				if(hash[arr[j][i]] > 1)
				{
					c++;
					
					break;
				}
			}
		}
		
		//System.out.printf("Case #%d: %d %d %d\n", cas, trace, r, c);
//		System.out.println();
		System.out.println("Case #" + cas + ": " + trace + " " + r + " " + c);
	}

}
