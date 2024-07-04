import java.io.*;
import java.util.*;
public class Solution {
   public static void main(String[] args) {
	   try
	   {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   Integer T=Integer.parseInt(br.readLine());
	   int x=0;
	   while(T-->0)
	   {
		   Integer N=Integer.parseInt(br.readLine());
		   int [][] grid=new int[N][N];
		   int k=0;
		   for(int i=0;i<N;i++)
		   {
			   String [] strarr=br.readLine().trim().split("\\s+");
			   
			   for(int j=0;j<strarr.length;j++)
			   {
				  grid[k][j]=Integer.parseInt(strarr[j]);
			   }
			   k+=1;
		   }
		  x+=1;
		   System.out.println("Case #"+x+": "+sum(grid)+" "+duplicate(grid)+" "+columnutil(grid));
	   }
	
	   }
	   catch(Exception e)
	   {
		   
   }
}
   public static boolean rowutil(int [] arr)
   {
	   Set<Integer> set=new HashSet<>();
	   for(int i:arr)
	   {
		   
		   if(!set.add(i))
			   return true;
	   }
	   return false;
   }

   public static int duplicate(int [][] grid)
   {
	   int res=0,n=grid.length;
	   for(int [] arr:grid)
	   {
		  
		   if(rowutil(arr))
			   res+=1;
	   }
	   
	   return res;
   }
   public static int columnutil(int [][] grid)
   {
	   int i=0,n=grid.length,res=0;
	   while(i<n)
	   {
		 
		   Set<Integer> set=new HashSet<>();
		   for(int j=0;j<n;j++)
		   {
			  // System.out.print(grid[j][i]);
			   if(!set.add(grid[j][i]))
			   {
				   res+=1;
				   break;
			   }
		   }
		   System.out.println();
		  i+=1;   
	   }
	   return res;
   }
   public static int sum(int [][] grid)
   {
	   int n=grid.length;
	   int res=0;
        for(int i=0;i<n;i++)
        {
			   res+=grid[i][i];
        }
	   return res;
   }
}
