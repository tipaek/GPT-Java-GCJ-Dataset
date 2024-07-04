import java.util.*;

 class prbm1 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
			
		solve();
	}

	public static void solve()
	{
		int n= scan.nextInt();
		for(int i=0; i<n;i++)
		{
			String res = solveTest();
			System.out.println("Case #"+(i+1)+":"+res);
		}
		
	}
	
	public static String solveTest()
	{
		int N = scan.nextInt();
		long[][] matrix = new long[N][N];
		
		long sum = 0;
		long rowC = 0;
		long colC = 0;
		
		// Filling values
		for(int i=0; i<= N-1; i++)
		{
			for(int j=0; j<= N-1; j++)
			{
				int value = scan.nextInt();
				
				matrix[i][j] = value;
		
				if(i==j)
				{
					sum= sum + matrix[i][j];
				}
			}
		}
		// 
		for(int i=0; i<= N-1; i++)
		{
			HashSet<Long> temp = new HashSet<Long>();
			for(int j=0; j<= N-1; j++)
			{
				// moving in rows 
				
				boolean c =	temp.add(matrix[i][j]);
			
				
			if(c == false)
			{
				rowC++;
				break;
			}
				
							
			}
		}
		///
		for(int i=0; i<= N-1; i++)
		{
			HashSet<Long> temp = new HashSet<Long>();
			for(int j=0; j<= N-1; j++)
			{
				// moving in col 
			
				boolean c =	temp.add(matrix[j][i]);
			if(c== false)
			{
				colC++;
				break;
			}
				
							
			}
		}
		
		
		
		
		
		return " "+sum+" "+rowC+" "+colC;
	}
	
	


}
