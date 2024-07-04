// A simple Java program to find sum of all 
// subsquares of size k x k 
class GFG 
{ 
	
	// Size of given matrix 
	static final int n = 3; 
	
	// A simple function to find sum of all 
	//sub-squares of size k x k in a given 
	// square matrix of size n x n 
	static void printSumSimple(int mat[][], int k) 
	{ 

		// k must be smaller than or 
		// equal to n 
		if (k > n) return; 
		
		// row number of first cell in 
		// current sub-square of size k x k 
		for (int i = 0; i < n-k+1; i++) 
		{ 
			
			// column of first cell in current 
			// sub-square of size k x k 
			for (int j = 0; j < n-k+1; j++) 
			{ 
				
				// Calculate and print sum of 
				// current sub-square 
				int sum = 0; 
				for (int p = i; p < k+i; p++) 
					for (int q = j; q < k+j; q++) 
						sum += mat[p][q]; 

				System.out.print(sum+ " "); 
			} 
		
			// Line separator for sub-squares 
			// starting with next row 
			System.out.println(); 
		} 
	} 
	
	// Driver Program to test above function 
	public static void main(String arg[]) 
	{ 
		int mat[][] = {{2, 1, 3, 3,1,2 }, 
					{3, 2, 1, 1, 2,3}, 
					{1, 3,2, 2, 3,1}}; 
					
		int k = 3; 
		printSumSimple(mat, k); 
	} 
} 

// This code is contributed by Anant Agarwal. 
