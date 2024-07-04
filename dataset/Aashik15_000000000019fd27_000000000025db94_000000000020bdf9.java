import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	private static Scanner sc;
	static int tn = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sc = new Scanner(System.in);
	       
	       int t = sc.nextInt();
	       sc.nextLine();
	       
	       while(t-- > 0)
	       {
	    	   solve();
	       }

	}
	
	private static void solve()
	{
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		int[][] arrSorted = arr.clone(); 
		boolean impossible = false;
		
		//StringBuilder sb = new StringBuilder();
		char person = 'J';
		
		char[] chars = new char[n];
		Stack<int[]> JStack = new Stack<>();
		Stack<int[]> CStack = new Stack<>();
		
		Map<int[], Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length; i++)
		{
			for(int j = 0; j<arr[i].length; j++)
			{
				arr[i][j] = sc.nextInt();
			}
			map.put(arr[i], i);
		}
		
		Arrays.sort(arrSorted, new Comparator<int[]>()
				{
					public int compare(int[]a , int[] b)
					{
						return a[0] - b[0];
					}
				});
		
		for(int i = 0; i<arrSorted.length; i++)
		{
			chars[map.get(arrSorted[i])] = person;
			
			if(i < arrSorted.length - 1 && doesOverlap(arrSorted[i], arrSorted[i+1]))
			{
				if(person == 'J')
				{
					JStack.push(arrSorted[i]);
					person = getPerson(person);
					
					if(!CStack.isEmpty() && doesOverlap(CStack.peek(), arrSorted[i+1]))
					{
						impossible = true;
						break;
					}
				}
				else
				{
					CStack.push(arrSorted[i]);
					person = getPerson(person);
					
					if(!JStack.isEmpty() && doesOverlap(JStack.peek(), arrSorted[i+1]))
					{
						impossible = true;
						break;
					}
				}
			}
			else
			{
				if(person == 'J')
				{
					JStack.push(arrSorted[i]);
				}
				else
				{
					CStack.push(arrSorted[i]);
				}
			}
		}
		
		System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
	}
	
	private static char getPerson(char p)
	{
		return p == 'J' ? 'C' : 'J';
	}
	
	private static boolean doesOverlap(int[] a, int[] b)
	{
		return a[1] > b[0];
	}
}


