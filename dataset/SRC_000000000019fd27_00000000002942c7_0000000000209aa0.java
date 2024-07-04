import java.util.*;
class Solution { 
	
	 
	static void printLatin(int n) 
	{ 
		
		 
		int k = n+1; 
	
		// Loop to print rows 
		for (int i = 1; i <= n; i++) 
		{ 

			
			int temp = k; 

			while (temp <= n) 
			{ 
				System.out.print(temp + " "); 
				temp++; 
			} 
	
			
			for (int j = 1; j < k; j++) 
				System.out.print(j + " "); 
	
			k--; 
			System.out.println(); 
		} 
	} 
		

	public static void main (String[] args) 
	{
	   Scanner sc = new Scanner(System.in);
		System.out.println("Enter side");
		int n = sc.nextInt();
		System.out.println("Enter trace");
		int m = sc.nextInt();
		if(m>n*n)
		System.out.println("Case #2: IMPOSSIBLE");
		
		printLatin(n); 
	} 
} 


