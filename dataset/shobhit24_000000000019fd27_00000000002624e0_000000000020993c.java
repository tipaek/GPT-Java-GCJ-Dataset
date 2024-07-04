import java.util.*;

class Solution 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while( t != 0 )
		{
			int n = sc.nextInt();
			
			int arr[][] = new int[n][n];
			
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
			
			for(int i=0 ; i<n ; i++)
			{
				for(int j=0 ; j<n ; j++)
				{
					
					for (int k = j+1; k < n; k++)   
	                { 
	                    if (arr[i][j] == arr[i][k])  
	                    { 
	                        r++;
	                        break;
	                    }
	                    
	                }   
		            
		            for (int k1 = j+1; k1 < n; k1++) 
	                { 
	                    if (arr[j][i] == arr[k1][i]) 
	                    { 
	                        c++;
	                        break;
	                    } 
	                    
	                } 
		            
		            break;
				}
			}
			
			System.out.println(ksum+" "+r+" "+c);
			
			
			t--;
			
		}

	}
}