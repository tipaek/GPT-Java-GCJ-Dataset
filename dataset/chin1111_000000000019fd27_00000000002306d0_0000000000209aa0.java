import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	 static final int MAX = 100; 
	    static int[][] mat; 
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer numberOfTestCases = Integer.parseInt(br.readLine().trim());
		
		for(int i =1; i <= numberOfTestCases;i++)
		{
			String[] input = br.readLine().split(" ");
			
			int numberOfRandC = Integer.parseInt(input[0]);
			int sumRequired = Integer.parseInt(input[1]);
			
			mat = new int[numberOfRandC][numberOfRandC];
			constructMatrix(numberOfRandC);
			
			int n =0;
			for(int j = 2; j <= sumRequired;j++)
			{
				if(sumRequired == (j* numberOfRandC))
				{
					n = j;
					break;
				}
			}
			
			if(n!= 0)
			{
				int[][] output = new int[numberOfRandC][numberOfRandC];
				for(int j = 0; j < numberOfRandC;j++)
				{
					for(int k =0; k < numberOfRandC;k++)
					{
						if(mat[j][k] == n)
						{
							for(int l =0; l < numberOfRandC;l++)
							{
								output[l][j] = mat[l][k];
								
							}
							break;
						}
					}
				}
				System.out.println("Case #" + i + ": " + "POSSIBLE");
				
				for(int j =0; j < numberOfRandC;j++)
				{
					for(int k =0; k < numberOfRandC;k++)
					{
						System.out.print(output[j][k]);
						if(k < (numberOfRandC -1))
						{
							System.out.print(" ");
						}
					}
					if(j < numberOfRandC - 1)
						System.out.println();
				}
			}else {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
			}
			
			
		}
	}
	
	 static void fillRemaining(int i, int j, int n) 
	    { 
	        // Initialize value to be filled 
	        int x = 2; 
	      
	        // Fill all values below i as 2, 3, ...p 
	        for (int k = i + 1; k < n; k++) 
	            mat[k][j] = x++; 
	      
	        // Fill all values above i  
	        // as p + 1, p + 2, .. n 
	        for (int k = 0; k < i; k++) 
	            mat[k][j] = x++; 
	    }
	 
	// Fills entries in mat[][]  
    // with the given set of rules 
    static void constructMatrix(int n) 
    { 
        // Alternatively fill 1s starting from 
        // rightmost and leftmost columns. For 
        // example for n = 3, we get { {_ _ 1}, 
        // {1 _ _} {_ 1 _}} 
        int right = n - 1, left = 0; 
        for (int i = 0; i < n; i++) 
        { 
            // If i is even, then fill 
            //  next column from right 
            if (i % 2 == 0) 
            { 
                mat[i][right] = 1; 
      
                // After filling 1, fill remaining  
                // entries of column "right" 
                fillRemaining(i, right, n); 
      
                // Move right one column back 
                right--; 
            } 
              
            // Fill next column from left 
            else
            { 
                mat[i][left] = 1; 
      
                // After filling 1, fill remaining  
                // entries of column "left" 
                fillRemaining(i, left, n); 
      
                // Move left one column forward 
                left++; 
            } 
        } 
    } 

}
