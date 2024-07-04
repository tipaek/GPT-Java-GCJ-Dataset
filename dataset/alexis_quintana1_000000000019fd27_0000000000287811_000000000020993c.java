import java.util.*;
import java.io.File;

public class Solution
{
	public static void main (String [] args)
	{
		ArrayList<ArrayList<Integer>> matrix;
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		int [] sum = new int[T];
		int [] row = new int[T];
		int [] col = new int[T];
		for (int i = 0; i < T; i++)
		{
		    int N = in.nextInt();
		    matrix = new ArrayList<>(N);
		    ArrayList<Integer> cols;
		    sum[i] = 0;
		    row[i] = 0;
		    col[i] = 0;
		    int count = 0;
		    int count2 = 0;
		    for (int j = 0; j < N; j++)
		    {
		        matrix.add(new ArrayList<>(N));
		        count = 0;
		        for (int k = 0; k < N; k++)
		        {
		            int cur = in.nextInt();
		            if (k != 0 && matrix.get(j).contains(cur) && count == 0)
		            {
		            	row[i]++;
		            	count++;
		            }
		            matrix.get(j).add(cur);
		        }
		    }
		    for (int j = 0; j < N; j++)
		    {
		    	cols = new ArrayList<>(N);
		    	count2 = 0;
		    	for (int k = 0; k < N; k++)
		    	{
		    		if (k != 0 && cols.contains(matrix.get(k).get(j)) && count2 == 0)
		    		{
		    			col[i]++;
		    			count2++;
		    		}
		    		cols.add(matrix.get(k).get(j));
		    	}
		    }
		    for (int j = 0; j < N; j++)
		        sum[i] += matrix.get(j).get(j);
		}
		for (int i = 0; i < T; i++)
		{
			int c = i+1;
			System.out.println("Case #" + c + ": " + sum[i] + " " + row[i] + " " + col[i]);
		}
	}
}
