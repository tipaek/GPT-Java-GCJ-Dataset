import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

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
			
			int[] sequence = new int[numberOfRandC];
			 
	        for (int j = 0; j < numberOfRandC; j++)
	            sequence[j] = j+1;
	        
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        
	        permute(sequence, 0, list);
			
	        int pp = -1;
	        for(int j =0; j < list.size(); j++)
	        {
	        	int num = list.get(j);
	        	String str = "" + num;
	        	int sum = 0;
	        	for(int k =0; k < str.length();k++)
	        	{
	        		int index = Integer.parseInt(str.charAt(k) + "");
	        		sum += mat[index-1][k];
	        		
	        	}
	        	if(sum == sumRequired)
	        	{
	        		pp =  j;
	        		break;
	        	}
	        }
	        
	        if(pp == -1)
	        {
	        	System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
	        }else
	        {
	        	System.out.println("Case #" + i + ": " + "POSSIBLE");
	        	String temp = list.get(pp) + "";
	        	for(int j =0; j < temp.length();j++)
	        	{
	        		
	        		int index = Integer.parseInt(temp.charAt(j) + "");
	        		
	        		for(int k =0; k < numberOfRandC;k++)
	        		{
	        			System.out.print(mat[index-1][k]);
	        			if(k < numberOfRandC -1)
	        			{
	        				System.out.print(" ");
	        			}
	        		}
	        		System.out.println();
	        	}
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
    
    static void permute(int[] a, int k, ArrayList<Integer> list) 
    {
        if (k == a.length) 
        {
        	String temp = "";
            for (int i = 0; i < a.length; i++) 
            {
               temp+= a[i];
            }
           list.add(Integer.parseInt(temp));
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1,list);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

}
