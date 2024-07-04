import java.util.Scanner;

// Java program to pritn Latin Square 
class Solution { 
	
		
	// Driver code 
	public static void main (String[] args) 
	{ 
        Scanner sc = new Scanner(System.in);

        int test_cases = sc.nextInt();
        int test_count = 1;
        
        while (test_count <= test_cases) {

        int n = sc.nextInt(); 

        int sumdiag = sc.nextInt();

        if (sumdiag % n != 0) {
            System.out.println("Case #" +test_count+ ": ");
            System.out.println("IMPOSSIBLE");
        } 

        else {

            System.out.println("Case #" +test_count+ ": ");
            System.out.println("POSSIBLE");
        // A variable to control the 
		// rotation point. 
		int k = n+1; 
    
        int diag_ele = sumdiag / n;
		// Loop to print rows 
		for (int i = 1; i <= n; i++) 
		{ 

			// This loops runs only after 
			// first iteration of outer 
			// loop. It prints 
			// numbers from n to k 
			int temp = k; 

			while (temp <= n) 
			{ 
				System.out.print(temp + " "); 
				temp++; 
			} 
	
			// This loop prints numbers from 
			// 1 to k-1. 
			for (int j = 1; j < k; j++) 
				System.out.print(j + " "); 
	
			k--; 
            System.out.println(); 

        }
        }
        test_count++;
    }
    sc.close();
		
	} 
} 

// This code is contributed by Anant Agarwal. 
