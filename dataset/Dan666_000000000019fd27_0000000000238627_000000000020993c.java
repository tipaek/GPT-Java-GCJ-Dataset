import java.util.*;

public class Main
{
	public static void ref(int ar[][],int n,int i)
	    {
		 int k=0,c_count=0,r_count=0;
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
		    	//	 System.out.println("outer"+ l);
		    		 char c[]=l.toCharArray();
			          for(int g=0;g<c.length;g++)
			          {
			        	 fr[c[g]-'0']++;
			          }
			          for(int g=0;g<10;g++)
			          {
			        	  if(fr[g]>0)
			        		{
			        		   r_count++;
			        		   break;
			        		 }
			          }
			          for(int g=0;g<10;g++)
			          {
			        	  fr[g]=0;
			          }
			          l="";
			      } 
		      }
		      
		      
		      if(row<ar.length)
		      {
		    	  u+=String.valueOf(ar[row][col]);
		          
		    	  if(row==ar.length-1)
			      {
		        	  char c[]=u.toCharArray();
			          for(int g=0;g<c.length;g++)
			          {
			        	 fc[c[g]-'0']++;
			          }
			          
			          for(int g=0;g<10;g++)
			          {
			              if(fc[g]>0)
			              {
			            	  c_count++;
			            	  break;
			              }
			          }
			          for(int g=0;g<10;g++)
			          {
			        	  fc[g]=0;
			          }
			          u="";
			      }
		      }
		      
		     
		      if(row==col)
		        {
		          k+=ar[row][col];
		        }
		     
		  }
		  System.out.println("Case #%d: %d %d %d",i,k,r_count,c_count);

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
	    		ref(arr,n);
	    	}
    
     	}
}
