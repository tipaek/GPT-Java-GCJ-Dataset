import java.util.*;
public class Solution{
	
	static int cD(int temp[], int n) 
	{ 
	    int res = 1; 
	  
	    
	    for (int i = 1; i < n; i++)  
	    { 
	        int j = 0; 
	        for (j = 0; j < i; j++) 
	            if (temp[i] == temp[j]) 
	                break; 
	  
	        
	        if (i == j) 
	            res++; 
	    } 
	    return res; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	
	
	 Scanner s=new Scanner(System.in);
     int t=s.nextInt();
     int [] ro=new int[t];
     int [] co=new int[t];
     int [] su=new int[t];
     for(int i=1;i<=t;i++)
     {
    	int n=s.nextInt();
    	 int[][] arr=new int[n][n];
    	 for(int j=0;j<n;j++)
    	 {
    		 for(int k=0;k<n;k++)
    		 {
    			arr[j][k]=s.nextInt(); 
    		 }
    	 }
    	 //Row uniqueness
    	 int row=n;
    	 for(int j=0;j<n;j++)
    	 {
    		int[] temp=new int[n];
    		 for(int k=0;k<n;k++)
    		 {
    			temp[k]=arr[j][k];
    		 }
    	    int r= cD(temp,n);
    	    if(r==n)
    	    {
    	    	row--;
    	    }
    	 }
    	 int column=n;
    	 for(int j=0;j<n;j++)
    	 {
    		int[] temp=new int[n];
    		 for(int k=0;k<n;k++)
    		 {
    			temp[k]=arr[k][j];
    		 }
    	    int r= cD(temp,n);
    	    if(r==n)
    	    {
    	    	column--;
    	    }
    	 }
    	int sum=0;
    	 for(int j=0;j<n;j++)
    	 {
    		
    		 for(int k=0;k<n;k++)
    		 {
    			if(j==k)
    			{
    				sum=sum+arr[j][k];
    			}
    		 }
    	   
    	    ro[i-1]=row;
    	    co[i-1]=column;
    	    su[i-1]=sum;
    	 }
    	 
     
     
     
     }
    
    for(int i=0;i<t;i++)
    {
    	System.out.println("Case #"+(i+1)+": "+su[i]+" "+ro[i]+" "+co[i]);
    }
	}

}