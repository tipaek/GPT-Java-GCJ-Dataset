
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
		
	
		char person = 'J';
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
			chars[map.get(sortedA[i])] =person ;
			if(i <  sortedA.length-1 && doesOverlap(sortedA[i], sortedA[i+1] ))
			{
				if(person == 'J')
				{
				JStack.push(sortedA[i] );
				person = getPerson(person);
				
				if(!CStack.isEmpty() && doesOverlap( CStack.peek() , sortedA[i+1]))
				{
					impossible = true;
					break;
				}
				
				
				
				}
				else
				{
					CStack.push(sortedA[i] );
					person = getPerson(person);
					
					if(!JStack.isEmpty() && doesOverlap( JStack.peek() , sortedA[i+1]))
					{
						impossible = true;
						break;
					}
					
				}
			}
			else {
				
				if(person == 'J')
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
	
	private static char getPerson(char p )
	{
		return p =='J' ? 'C' :'J' ;
	}

	public static boolean doesOverlap(int[] a, int[] b)
	{
		return a[1] > b[0];
	}
	
	

}

