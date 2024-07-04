 // Java program to construct an n x n 
// matrix such that every row and every 
// column has distinct values. 
class GFG 
{ 
	
	static final int MAX = 100; 
	static int[][] mat = new int[MAX][MAX]; 
	
	// Fills non-one entries in column j 
	// Given that there is a "1" at 
	// position mat[i][j], this function 
	// fills other entries of column j. 
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
			// next column from right 
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
	
	// Driver Code 
	public static void main(String args[]) 
	{ 
		int n = 5; 
	
		// Passing n to constructMatrix function 
		constructMatrix(n); 
	
		// Printing the desired unique matrix 
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = 0 ; j < n; j++) 
			System.out.print(mat[i][j]+" "); 
			System.out.println(); 
		} 
	} 
} 

// This code is contributed by Anirban sadhukhan
