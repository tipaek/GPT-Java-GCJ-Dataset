import java.util.*;

class Solution 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int x=1;
		while( x <= t )
		{
			int n = sc.nextInt();
			
			long arr[][] = new long[n][n];
			
			for(int i=0 ; i<n ; i++)
			{
				for(int j=0 ; j<n ; j++)
				{
					arr[i][j] = sc.nextInt();
					
				}
			}
			
			int r=0,c=0,ksum=0;
			
			for(int i=0 ; i<n ; i++)
			{
				for(int j=0 ; j<n ; j++)
				{
					if(i==j)
						ksum += arr[i][j];
					
				}
			}
			
			boolean check = false;
			
			for(int i=0 ; i<n ; i++)
			{
				for(int j=0 ; j<n ; j++)
				{
					for (int k = j+1; k < n; k++)   
	                { 
	                    if (arr[i][j] == arr[i][k])  
	                    { 
	                        r++;
	                        check = true;
	                        break;
	                    }
	                    
	                }  
					
					if(check == true)
						break;
				}
			}
			
			boolean check2 = false;
			
			for(int i=0 ; i<n ; i++)
			{
				
				for(int j=0 ; j<n ; j++)
				{
		            
		            for (int k1 = j+1; k1 < n; k1++) 
	                { 
	                    if (arr[j][i] == arr[k1][i]) 
	                    { 
	                        c++;
	                        check2 = true;
	                        break;
	                    } 
	                    
	                } 
		            
		            if(check2 == true)
		            	break;
		            
				}
				
				
			}
			
			System.out.println("Case #"+x+": "+ksum+" "+r+" "+c);
			
			x++;
			
			
		}

	}
}