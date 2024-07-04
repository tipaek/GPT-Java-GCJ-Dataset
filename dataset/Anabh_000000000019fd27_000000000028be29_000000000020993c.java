import java.util.*;

class Solution{

public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	int t=s.nextInt();
	for(int i=1;i<=t;i++)
	{
	    
	    int n=s.nextInt();
	    int k=0,r=0,c=0;
	    int a[][]=new int[n][n];
	    int con=0;
	    for(int j=0;j<n;j++)
	    {int tem[]=new int[n];con=0;
	        for(int l=0;l<n;l++)
	        {
	            int v=s.nextInt();
	            a[j][l]=v;
	            if(tem[v-1]==0){
	            tem[v-1]+=1;}
	            else if(con==0)
	            {
	                r+=1;
	                con=1;
	            }
	            
	            if(j==l)
	            {
	                k+=v;
	            }
	        }
	    }
	    
	     for(int j=0;j<n;j++)
	    {int tem[]=new int[n];con=0;
	        for(int l=0;l<n;l++)
	        {
	            int v=a[l][j];
	            if(tem[v-1]==0){
	            tem[v-1]+=1;}
	            else if(con==0)
	            {
	                c+=1;
	                con=1;
	            }
	           
	        }
	    }
	    
	    
	    
	  System.out.println("case #"+i+": "+k+" "+r+" "+c );  
	}
	
}

}