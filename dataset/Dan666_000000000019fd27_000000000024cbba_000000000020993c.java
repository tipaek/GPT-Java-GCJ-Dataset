import java.util.*;

public class Solution
{
	public static void ref(int ar[][],int n,int q)
	    {
		 int k=0,c_count=0,r_count=0,new_row=0;
	     int fr[]=new int[10];
	     int fc[]=new int[10];
	     String l="";
	     String u="";
	     
		  for(int i=0;i<ar.length*ar.length;i++)
		  {
		      int row=i/ar.length;
		      int col=i%ar.length;
		    //  System.out.println("col-->"+col);
		      if(col<ar.length)
		      {
		    	  l+=String.valueOf(ar[row][col]);
		    	  u+=String.valueOf(ar[col][row]);
		    	 if(col==ar.length-1)
			     {
		    	  System.out.println("outerl"+ l);
		    	  System.out.println("outeru"+ u);
		    		 char c[]=l.toCharArray();
		    		 char t[]=u.toCharArray();
			          for(int g=0;g<c.length;g++)
			          {
			        	 if(fr[c[g]-'0']++>0)
			        	 {
			        		 r_count++;
			        	 } 
			        	 if(fc[t[g]-'0']++>0)
			        	 {
			        		 c_count++;
			        	 }
			          }
			          
			          for(int gk=0;gk<10;gk++)
			          {
			        	  fr[gk]=0;
			        	  fc[gk]=0;
			          }
			        
			          l="";
			          u="";
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
