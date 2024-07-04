
import java.io.*; 

class Sambit{ 
	
	
	static void print(int n) 
	{ 
		
	 
	for (int line = 0; line < n; line++) 
	{ 
	
		for (int i = 0; i <= line; i++) 
		System.out.print(binom(line, i)+" "); 
						
		System.out.println(); 
	} 
	} 
	

	static int binom(int n, int k) 
	{ 
		int res = 1; 
		
		if (k > n - k) 
		k = n - k; 
			
		for (int i = 0; i < k; ++i) 
		{ 
			res *= (n - i); 
			res /= (i + 1); 
		} 
		return res; 
	} 
	

	public static void main(String args[]) 
	{ 
	int n = 5; 
	print(n); 
	} 
} 

