import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class Solution {
	
	
	static void generateSquare(int [][] magicSquare,int n,int k) 
    { 
        
          
        // Initialize position for 1 
        int i = n/2; 
        int j = n-1; 
   
        // One by one put all values in magic square 
        for (int num=1; num <= n*n; ) 
        { 
            if (i==-1 && j==n) //3rd condition 
            { 
                j = n-2; 
                i = 0; 
            } 
            else
            { 
                //1st condition helper if next number  
                // goes to out of square's right side 
                if (j == n) 
                    j = 0; 
                      
                //1st condition helper if next number is  
                // goes to out of square's upper side 
                if (i < 0) 
                    i=n-1; 
            } 
              
            //2nd condition 
            if (magicSquare[i][j] != 0)  
            { 
                j -= 2; 
                i++; 
                continue; 
            } 
            else
            {
                magicSquare[i][j] = ((num-1)%n)+1;
				num++;
			}
			
                  
            //1st condition 
            j++;  i--;  
        } 
		
		for(i=0; i<n; i++) 
        { 
            for(j=0; j<n; j++) 
                System.out.print(magicSquare[i][j]+" "); 
            System.out.println(); 
        } 
	}
	
	
	static boolean isMagicSquare(int mat[][],int N,int k) 
    { 
          
        // calculate the sum of 
        // the prime diagonal 
         int sum = 0,sum2=0;  
        for (int i = 0; i < N; i++) 
            sum = sum + mat[i][i]; 
  
		if(sum !=k)
			return false;
  
        // the secondary diagonal 
        for (int i = 0; i < N; i++) 
            sum2 = sum2 + mat[i][N-1-i]; 
  
        if(sum!=sum2)  
            return false; 
  
        // For sums of Rows 
        for (int i = 0; i < N; i++) { 
  
            int rowSum = 0; 
            for (int j = 0; j < N; j++) 
                rowSum += mat[i][j]; 
  
            // check if every row sum is 
            // equal to prime diagonal sum 
            if (rowSum != sum) 
                return false; 
        } 
  
        // For sums of Columns 
        for (int i = 0; i < N; i++) { 
  
            int colSum = 0; 
            for (int j = 0; j < N; j++) 
                colSum += mat[j][i]; 
  
            // check if every column sum is 
            // equal to prime diagonal sum 
            if (sum != colSum) 
                return false; 
        } 
  
        return true; 
    } 
	
	
    public static void main(String args[] ) throws Exception 
	{
        
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
		int t = scan.nextInt();
		
		for(int test=1;test<=t;test++)
		{
			int n = scan.nextInt();
			int k = scan.nextInt();
			
			int[][] magicSquare = new int[n][n]; 
			
			boolean flag =true;
			
			if(n%2 == 1)
			{
			generateSquare(magicSquare,n,k);
			flag = isMagicSquare(magicSquare,n,k);
			}
			else
				flag = false;
			
					
			if(!flag)
				System.out.println("Case #"+test+": IMPOSSIBLE");	
			else
			{
				System.out.println("Case #"+test+": POSSIBLE");	
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<n;j++)
					{
						System.out.print(magicSquare[i][j]+" ");
					}
					System.out.println();
				}
			}
			
		}
		
    }
}
