import java.util.*;
 
class sol5Final
{
	static int n;
	static void buildMatrix(int[][] arr, int i, int j, int x) 
	{ 
		int temp=0;
		
		for(int k=i+1; k<n; k++)
		{
			if (x < n)
				arr[k][j] = x+=1;
			else
				arr[k][j] = temp+=1;
		}

		for (int k=0; k<i; k++)
		{
			if (x < n)
				arr[k][j] = x+=1;
			else
				arr[k][j] = temp+=1;
		}
	} 

	static void constructMatrix(int[][] arr, int x) 
	{ 
		int right, left; 
		for (int i = 0; i < n; i++) 
		{ 
			if (i % 2 == 0) 
			{ 
				right = i;
				arr[i][right] = x; 
	
				buildMatrix(arr, i, right, x); 
			}

			else
			{ 
				left = i; 
				arr[i][left] = x; 
	
                buildMatrix(arr, i, left, x); 
			}
		}

		for (int j=0; j<n; j++) 
		{ 
			for (int k=0 ; k<n; k++) 
				System.out.print(arr[j][k]+" "); 
			System.out.println(); 
		}
	} 
	
	public static void main(String args[]) 
	{ 
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        for (int i=1; i<=t; i++)
        {
            n = scan.nextInt();
            int trace = scan.nextInt();
			int x = trace/n;
            int[][] arr = new int[n][n];
        
            if (trace>=n && trace%n == 0 && trace<=(n*n))
            {
                System.out.println("Case #" + i + ": POSSIBLE");
			   
				constructMatrix(arr, x);
            }
            else
                System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
        scan.close(); 
	} 
}