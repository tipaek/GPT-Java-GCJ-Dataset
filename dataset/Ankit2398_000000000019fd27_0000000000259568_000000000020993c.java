
class Trace
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int T=sc.nextInt();
	for(int t=1;t<=T;t++)
	{
	 int n=sc.nextInt();
	 int a[][]=new int[n][n];
	 
	 int d=0;
	 for(int i=0;i<n;i++)
	 {
	     for(int j=0;j<n;j++)
	     {
	         a[i][j]=sc.nextInt();
	         if(i==j)
	         d=d+a[i][j];
	     }
	 }
	    

	
	int m,r=0;
	for(int i=0;i<n;i++)
	{
	    for(int j=0;j<n;j++)
	    {
	        m=a[i][j];
	        int count=0;
	        
	        for(int k=0;k<n;k++)
	        { 
	            if(count==2)
	            {
	                r++;
	                break;
	            }
	            
	            if(a[i][k]==m)
	            count++;
	            
	        }
	      if(count==2)
	      break;
	        
	    }
	}
	
	int p,c=0;
	for(int i=0;i<n;i++)
	{
	    for(int j=0;j<n;j++)
	    {
	        p=a[j][i];
	        int count=0;
	        for(int k=0;k<n;k++)
	        {
	            if(count==2)
	            {
	                c++;
	                break;
	            }
	            
	           else if(a[k][i]==p)
	            count++;
	        }
	       if(count==2)
	       break;
	        
	    }
	}
	    
	System.out.println("Case #"+t+": "+d+" "+r+" "+c);    
	    
	}
		
		
	}
}
