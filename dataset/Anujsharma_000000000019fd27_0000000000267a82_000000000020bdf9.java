import java.util.*;
import java.lang.*;
import java.io.*;
class abc
{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++)    
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    int b[]=new int[n];
		    
		    for(int j=0;j<n;j++)
		    a[j]=sc.nextInt();
		    for(int j=0;j<n;j++)
		    b[j]=sc.nextInt();
		    int c=0,j=0;
		    String s="";
		    int summ=0;
		    for(int j1=0;j1<=1440;j1++)
		    {
		      if(c!=0)
		      c--;
		      if(j!=0)
		      j--;
		      for(int k =0;k<n;k++)
		      {
		      if(j1==a[k])
		      {
		      if(c==0)
		      {c=b[k]-a[k];
		          s=s+"C";
		      }
		      else if(j==0)
		      {
		          j=b[k]-a[k];
		          s=s+"J";
		      }
		      else
		      {System.out.println("IMPOSSIBLE");
		         summ=-1;
		          break;
		          
		      }
		      }
		  
		  }   
		      }
		      if(summ==0)
		    System.out.println(s);
		    
		    
		    
		  }
		  
}
}