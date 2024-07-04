import java.io.*;
import java.util.*;
 class Solution {
	static Integer N=0;
	static Integer K=0;
	static int x=0;
	static int [][] grid=new int[1000][1000];
	static boolean [][] visitedr=new boolean[1000][1000];
	static boolean [][] visitedc=new boolean[1000][1000];
	static boolean valid=false;
   public static void main(String[] args) {
	   try
	   {
        	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        	Integer T=Integer.parseInt(br.readLine());
       
        	while(T-->0)
        	{
        		x+=1;
        		String [] strarr=br.readLine().trim().split("\\s+");
        		 N=Integer.parseInt(strarr[0]);
        		 K=Integer.parseInt(strarr[1]);
        		 util(1,1,0);
        		 if(!valid)
        		 {
        			 System.out.println("Case #"+x+": "+"IMPOSSIBLE");
        		 }
        		 valid=false;
        	}
	   }
	   catch(Exception e)
	   {
		   
	   }
}
   public static void util(int r,int c,int t)
   {
	   if(r==N && c==N+1 && t==K && !valid)
	   {
		   valid=true;
		   System.out.println("Case #"+x+": "+"POSSIBLE");
	   
		   for(int i=1;i<=N;i++)
		   {
			   for(int j=1;j<=N;j++)
			   {
				   System.out.print(grid[i][j]+" ");
			   }
			   System.out.println();
		   }
		   return ;
	   }
	   else if(r>N) {
		   return;
	   }
	   else if(c>N)
	   {
		   util(r+1,1,t);
	   }
	   for(int i=1;i<=N && !valid;i++)
	   {
		   if(!visitedr[r][i] && !visitedc[c][i])
		   {
			   visitedr[r][i]=visitedc[c][i]=true;
			   if(r==c)
				   t+=i;
			   grid[r][c]=i;
			   util(r,c+1,t);
			   visitedr[r][i]=visitedc[c][i]=false; 
			   if(r==c)
				   t-=i;
			   grid[r][c]=0;
		   }
	   }
   }
}
