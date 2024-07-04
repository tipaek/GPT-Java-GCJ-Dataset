import java.util.*; 
  
class CodeJam { 
      
    static int ar[][];
	static int[] PascalWalk(int n)
	{
		Pascal(n);
		int[] ans = new int[n*2]; 
		ans[0]=0;
		int sum=0;
		int c=0;
  
		for(int i=0;i<n;i++)
		{
			for(int k=0;k<=i;k++)
			{
				sum=sum+ar[i][k];
				
				if(ar[i][k]==n||sum==n)
				{
					ans[c++]=i+1;
					ans[c++]=k+1;
					break;
				}
				else if(ar[i][k]<n)
				{
					ans[c++]=i+1;
					ans[c++]=k+1;
					
				}
				
			}
		}
		return ans;
		
	}
    static void Pascal(int n) 
    { 
	 ar=new int[n][n];
    for (int line = 0; line < n; line++) 
    { 
        
        for (int i = 0; i <= line; i++)

		ar[line][i]=binomialCoeff(line,i);						
                          
        
    } 
    } 
      
    static int binomialCoeff(int n, int k) 
    { 
        int res = 1; 
          
        if (k > n - k) 
        k = n - k; 
              
        for (int i = 0; i < k; ++i) 
        { 
            res *= (n - i); 
            res /= (i + 1); 
        } 
        return res; 
    } 
      
    // Driver code 
    public static void main(String args[]) 
    { 
	Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
	for(int i=0;i<t;i++)
	{
		int n=sc.nextInt();
		int j[]=PascalWalk(n); 
		for(int k=0;k<n;k=k+2)
		{
			for(int m=k;m<2;m++)
			System.out.print(j[m]+" ");
		System.out.println();
		
	}
	}
    
    } 
} 