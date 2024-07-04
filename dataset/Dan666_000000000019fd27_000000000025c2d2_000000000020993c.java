import java.util.*;

public class Solution
{
	
	public static void ref(int ar[][],int n,int q)
	    {
		 int k=0,c_count=0,r_count=0 ,d=0,j=0;
		  String a="",b=""; 
	      int arr[]=new int[n];
	      LinkedList<Integer> ch1=new LinkedList<Integer>();
	      LinkedList<Integer> ch2=new LinkedList<Integer>();
		  for(int i=0;i<ar.length*ar.length;i++)
		  {
		      int row=i/ar.length;
		      int col=i%ar.length;
               
		      if(col<n)
		      {
		           a+=String.valueOf(ar[row][col]);
		           b+=String.valueOf(ar[col][row]);
		            
		     if(col==n-1)
		    	{
		    	 //System.out.println("row"+" "+a);
		    	// System.out.println("col"+" "+b);
                   for(char c:a.toCharArray())
                   {
                	  ch1.add(Integer.parseInt(String.valueOf(c)));   
                   }
                   for(char c:b.toCharArray())
                   {
                	   ch2.add(Integer.parseInt(String.valueOf(c))); 
                   }
                   Collections.sort(ch1);
                   Collections.sort(ch2);
                  // System.out.println(ch1);
                   //System.out.println(ch2);
                   for(d=0,j=d+1;j<ch1.size();d++,j++)
                    {
                	   if(ch1.get(d)==ch1.get(j))
                	   {
                		   r_count++;
                		   break;
                	   }
                    }
                   for(d=0,j=d+1;j<ch1.size();d++,j++)
                    {
                       if(ch2.get(d)==ch2.get(j))
                       {
                    	   c_count++;
                    	   break;
                       }                   	   
                    }
                   ch1.clear();
                   ch2.clear();
	    		   a="";
	    		   b="";
		    	}
		      }
		      if(row==col)
		         {
		          k+=ar[row][col];
		        }
		     
		  }
		  System.out.format("Case #%d: %d %d %d",q,k,r_count,c_count);
 
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
