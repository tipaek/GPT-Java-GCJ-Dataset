import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public Solution()
	{
		
	}
	
	public static void main(String[] args) {

		new Solution().run();
	}

	Scanner in = null;

	public void run() {
		in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			solve(i);
		}

		//System.out.println("Done");
	}

	private void solve(int test) {
		int N = in.nextInt();

		int diag = 0;
		
		//duplicity v riadku
		Set<Integer> rowDup = new HashSet<Integer>();
		Set<Integer> colDup = new HashSet<Integer>();

		Map<Integer, Set<Integer>> colDupMap = new HashMap<Integer, Set<Integer>>(N);
		
		for (int row = 0; row < N; row++) 
		{
			
			//kontrola v riadku
			Set<Integer> rowNum = new HashSet<Integer>();
			
			for (int col = 0; col < N; col++) 
			{
				
				// row
				
				int num = in.nextInt();
				
				if (rowNum.contains(num))
				{
					if (!rowDup.contains(row))
					{
						rowDup.add(row);
					}
					
				}
				
				rowNum.add(num);
				
				//end row
				Set<Integer> colNum = colDupMap.get(col);
				if (colNum == null) {colNum = new HashSet<Integer>(); colDupMap.put(col, colNum);}
				
				if (colNum.contains(num))
				{
					if (!colDup.contains(col))
					{
						colDup.add(col);
					}
					
				}
				
				colNum.add(num);
				
				
				if (row==col)
                {
                    diag += num;
                }
			}
			
		}
		System.out.println("Case #" + test + ": " + diag + " " + rowDup.size() + " " + colDup.size() );
		
	}
}
