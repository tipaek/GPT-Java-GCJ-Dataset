import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution{
	static Scanner scan = new Scanner(System.in);

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
		}
		
	}
	
	public static String solveTest()
	{
		int n = scan.nextInt();
		int x =0;
		
		int[][] Array1 = new int[n][2];
		int[][] sortedA = Array1.clone();
		
	
		char worker = 'J';
		char[] chars = new char[n];
		
		
		
		Map< int[],Integer> map = new  HashMap<>();
		
		Stack<int[]> JStack = new Stack<>() ;
		Stack<int[]> CStack = new Stack<>() ;
		
		boolean impossible = false;
		
		for(int i = 0; i<Array1.length; i++)
		{
			for(int j = 0; j< Array1[i].length;j++)
			{
				Array1[i][j] = scan.nextInt();
				
			}
			map.put(Array1[i] ,i );
		}
		
		Arrays.sort(sortedA  , new Comparator<int[]>() 
		{
			@Override
			public int compare(int[] a, int[] b )
			{
				return a[0] - b[0];
			}
		});
		
		
		
		for (int i = 0; i < sortedA.length; i++)
		{
			chars[map.get(sortedA[i])] =worker ;
			if(i <  sortedA.length-1 && checkOverlap(sortedA[i], sortedA[i+1] ))
			{
				if(worker == 'J')
				{
				JStack.push(sortedA[i] );
				worker = getWorker(worker);
				
				if(!CStack.isEmpty() && checkOverlap( CStack.peek() , sortedA[i+1]))
				{
					impossible = true;
					break;
				}
				
				
				
				}
				else
				{
					CStack.push(sortedA[i] );
					worker = getWorker(worker);
					
					if(!JStack.isEmpty() && checkOverlap( JStack.peek() , sortedA[i+1]))
					{
						impossible = true;
						break;
					}
					
				}
			}
			else {
				
				if(worker == 'J')
				{
					JStack.push(sortedA[i]);
				}
				else
				{
					CStack.push(sortedA[i]);
				}
			}
		
			
			
		}
		
		
		
		
		
		return impossible? "IMPOSSIBLE": new String(chars) ;
		
	}
	
	private static char getWorker(char p )
	{
		return p =='J' ? 'C' :'J' ;
	}

	public static boolean checkOverlap(int[] a, int[] b)
	{
		return a[1] > b[0];
	}
	
	

}