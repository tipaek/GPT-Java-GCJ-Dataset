import java.util.*;

public class Solution
{
	public  void ref(int ar[][],int n,int q)
	    {
		 int k=0,c_count=0,r_count=0,new_col=0;
	     int fr[]=new int[10];
	     String l="";
	     String u="";
	     int fc[]=new int[10];
		  for(int i=0;i<ar.length*ar.length;i++)
		  {
		      int row=i/ar.length;
		      int col=i%ar.length;
		    //  System.out.println("col-->"+col);
		      if(col<ar.length)
		      {
		    	  l+=String.valueOf(ar[row][col]);
		    	 
		    	 if(col==ar.length-1)
			     {
		    	  System.out.println("outer"+ l);
		    		 char c[]=l.toCharArray();
			          for(int g=0;g<c.length;g++)
			          {
			        	 if(fr[c[g]-'0']++>0)
			        	 {
			        		 r_count++;
			        	 } 
			          }
			          
			          for(int gk=0;gk<10;gk++)
			          {
			        	  fr[gk]=0;
			          }
			        
			          l="";
			      } 
		      }
		      
		      
		      if(col>new_col)
		      {
		    	  u+=String.valueOf(ar[row][col]);
		    	 
		    	 if(col==ar.length-1)
			     {
		    	  System.out.println("outer"+ l);
		    		 char c[]=l.toCharArray();
			          for(int gt=0;gt<c.length;gt++)
			          {
			        	 if(fc[c[gt]-'0']++>0)
			        	 {
			        		 c_count++;
			        	 } 
			          }
			          
			          for(int dk=0;dk<10;dk++)
			          {
			        	  fc[dk]=0;
			          }
			        
			          u="";
			      } 
		      }
		      
		     
		      if(row==col)
		        {
		          k+=ar[row][col];
		        }
		     new_col=col;
		  }
		  
		  if(r_count>0)
		  {
			  r_count=r_count/2;
		  }else if(c_count>0)
		  {
			  c_count=c_count/2;
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
	    		new Solution().ref(arr,n,i);
	    	}
    
     	}
}
