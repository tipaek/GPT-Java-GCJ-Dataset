import java.util.*;

public class Solution
{
	
	public static void ref(int ar[][],int n,int q)
	    {
		 int k=0,c_count=0,r_count=0 ,d=0;
		  String a="",b=""; 
	      int arr[]=new int[10];
	      int acc[]=new int[10];
		  for(int i=0;i<ar.length*ar.length;i++)
		  {
		      int row=i/ar.length;
		      int col=i%ar.length;
               
		      if(col<=n-1)
		      {
		           a+=String.valueOf(ar[row][col]);
		           b+=String.valueOf(ar[col][row]);
		            
		     if(col==ar.length-1)
		    	{
		    	 System.out.println("row"+" "+a);
		    	 System.out.println("col"+" "+b);
                    for(char c :a.toCharArray())
                    {
                    	if(arr[c-'0']++>0)r_count++;
                    }
                    for(char c : b.toCharArray())
                    {
                    	if(acc[c-'0']++>0)c_count++;
                    }
                    for(d=0;d<10;d++)
                    {
                    	acc[d]=0;
                    	arr[d]=0;
                    }
	    		   a="";
	    		   b="";
		    	}
		      }
		      if(row==col)
		         {
		          k+=ar[row][col];
		        }
		     
		  }
		  System.out.format("Case #%d: %d %d %d\n",q,k,r_count,c_count);
 
    	}
	    public static void main(String[] args) {
	    	Scanner sc=new Scanner(System.in);
	    	int t=sc.nextInt();
	       for(int i=1;i<=t;i++)
	    	{
	    	   int n=sc.nextInt();
	    	   int arr[][]=new int[n][n];
	    	   for(int k=0;k<arr.length*arr.length;k++)
	    	   {
	    		   int row=k/arr.length;
	    		   int col=k%arr.length;
	    		   arr[row][col]=sc.nextInt();
	    	   }
	    		ref(arr,n,i);
	    	}
    
     	}
}
