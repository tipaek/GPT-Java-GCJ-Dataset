import java.util.*;

public class Solution{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
			
		solution();
	}

	public static void solution()
	{
		int N = scan.nextInt();

		String not_needed = scan.nextLine();
		
		for(int i=1; i<=N;i++)
		    System.out.println("Case #"+i+": "+testCase());
		
	}
	
	public static String testCase()
	{
        int N = scan.nextInt();
        Map< int[],Integer> Indexed = new  HashMap<>();
		
		int[][] intervals = new int[N][2];
		int[][] sortedIntervals = intervals.clone();
		
	
		char individual = 'J';
		char[] chars = new char[N];
				
		Stack<int[]> Jamie = new Stack<>() ;
		Stack<int[]> Cameron = new Stack<>() ;
		
		
		boolean flag = false;
		
		for(int i = 0; i<intervals.length; i++)
		{
			for(int j = 0; j< intervals[i].length;j++)
			{
				intervals[i][j] = scan.nextInt();
				
			}
			Indexed.put(intervals[i] ,i );
		}
		
		Arrays.sort(sortedIntervals  , new Comparator<int[]>() 
		{
			@Override
			public int compare(int[] a, int[] b )
			{
				return a[0] - b[0];
			}
		});
		
		
		
		for (int i = 0; i < sortedIntervals.length; i++)
		{
			chars[Indexed.get(sortedIntervals[i])] =individual ;
			if(i <  sortedIntervals.length-1 && overlap(sortedIntervals[i], sortedIntervals[i+1] ))
			{
				if(individual == 'C')
				{
                    Cameron.push(sortedIntervals[i] );
					individual = whoAmI(individual);
					
					if(!Jamie.isEmpty() && overlap( Jamie.peek() , sortedIntervals[i+1]))
					{
						flag = true;
						break;
					}
                }
				else
				{
					Jamie.push(sortedIntervals[i] );
                    individual = whoAmI(individual);
                    
                    if(!Cameron.isEmpty() && overlap( Cameron.peek() , sortedIntervals[i+1]))
                    {
                        flag = true;
                        break;
                    }
				}
			}
			else {
				
                if(individual == 'C')
                    Cameron.push(sortedIntervals[i]);
                else
                    Jamie.push(sortedIntervals[i]);
				    
			}
		}
		return flag? "IMPOSSIBLE": new String(chars) ;
		
	}
	
	private static char whoAmI(char p )
	{
		return p =='J' ? 'C' :'J' ;
	}

	public static boolean overlap(int[] a, int[] b)
	{
		return a[1] > b[0];
	}
	
	

}