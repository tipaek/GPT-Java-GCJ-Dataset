import java.util.*;
import java.util.Arrays.*;
public class Solution
 {	static String fun(int rarr[][])
	 {int l=rarr.length;
	 	int arr[][]=new int[l][3];
	 	for(int i=0;i<l;i++)
	 	{
	 		
	 			arr[i][0]=rarr[i][0];
	 			arr[i][1]=rarr[i][1];
	 			arr[i][2]=i;	
	 			
	 	}
	 	for(int i=0;i<l-1;i++)
	 	{
	 		for(int j=i;j<l;j++)
	 		{
	 			if(arr[i][0]>arr[j][0])
	 			{
	 				int swap=arr[i][0];
	 				arr[i][0]=arr[j][0];
	 				arr[j][0]=swap;
	 				swap=arr[i][1];
	 				arr[i][1]=arr[j][1];
	 				arr[j][1]=swap;
	 				swap=arr[i][2];
	 				arr[i][2]=arr[j][2];
	 				arr[j][2]=swap;
	 			}
	 		}
	 	}
	 	
	 	int c_end = 0,j_end = 0,res_arr[][] = new int[l][2];
	 		    for (int i=0;i<l;i++)
	 		    {
	 		        if (arr[i][0] < c_end && arr[i][0]  < j_end)
	 		        {
	 		            return "IMPOSSIBLE";
	 		        }
	 		        if (arr[i][0]  >= c_end)
	 		        {
	 		        	res_arr[i][0]='C';
	 		        	res_arr[i][1]=arr[i][2];
	 		            c_end = arr[i][1] ;
	 		        }
	 		        else
	 		        {
	 		        	res_arr[i][0]='J';
	 		        	res_arr[i][1]=arr[i][2];
	 		            j_end = arr[i][1];
	 		        }
	 		    }
	 		    String str="";
	 		   for(int i=0;i<l;i++)
	 		 	{
	 		 		
	 		 		for(int j=0;j<l;j++)
	 		 		{
	 		 			if(res_arr[j][1]==i)
	 		 			{
	 		 				str=str+(char)res_arr[j][0];
	 		 			}
	 		 		}
	 			   
	 		 	}
	 	return str;
	 	
	 
	 }
	 public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 for(int a0=0;a0<t;a0++)
		 {	int n=sc.nextInt();
			 int arr[][]=new int[n][n];
			 for(int i=0;i<n;i++)
			 {
				 for(int j=0;j<2;j++)
				 {
					 arr[i][j]=sc.nextInt();
				 }
			 }
			 String ans=fun(arr);
			 System.out.println("Case #"+(a0+1)+": "+ans);
		 }
		 
	 }
	  
 }