
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution{
	static Scanner scan = new Scanner(System.in);
	 static int num = 0;
	 static int NN = 0;
	public static void main(String[] args) {
			
		solve();
	}

	public static void solve()
	{
		int n = scan.nextInt();

		String rough = scan.nextLine();
		
		for(int i=0; i<n;i++)
		{
			String res = solveTest();
			System.out.println("Case #"+(i+1)+": "+res);
			if(res.equalsIgnoreCase("POSSIBLE"))
			{
				printmatrix();
			}
		}
		
	}
	
	private static void printmatrix() {
		System.out.println();
		int n = NN;
	 
	      int lastone = 1 ;
      for (int x  = 1 ; x <= n ; x++)
      {
    	  for(int y= 1 ; y <= n ; y++)
    	  {
    		  if(num > n)
        	  {
        		  num = 1;
        	  }
    		  
    		  System.out.print(num+" ");
    		  if(y==n)
    		  {
    			  lastone = num;
    		  }
    		  
    		  
    		  num++;
    	  }
    	  System.out.println();
    	 num = lastone;
    	 // end of if of First line
    	 
    	 
    	  
      }
      
		
	}

	public static String solveTest()
	{
	
		int n = scan.nextInt();
		int k = scan.nextInt();
		String result = "IMPOSSIBLE";
		int constu = 0;
		
		long[] squares = new long[n];
		
		for(int x = 0 ; x < n; x++)
		{
		squares[x] = (x+1)*n ;
		if(squares[x]== k )
		{
			result = "POSSIBLE";
			
		  num =  (int) Math.sqrt(squares[x] );
		 NN = n;
			break;
		}
			
		}
		
		
		
			return ""+result;
	
		
	}
	
	
	

}
