
import java.util.*;
import java.io.*;
public class Solution
{
		
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i)
		{	
			int n = in.nextInt();
			HashMap<Integer, Integer>[] rows = (HashMap<Integer, Integer>[]) new HashMap[n];
			HashMap<Integer, Integer>[] cols = (HashMap<Integer, Integer>[]) new HashMap[n];
			
			int trace = 0;

			for(int r=0;r<n;++r)
			{
				rows[r] = new HashMap<Integer, Integer>();
				cols[r] = new HashMap<Integer, Integer>();
			}
			
			for(int r=0;r<n;++r)
			{
				for(int c=0;c<n;++c)
				{
					
					int m = in.nextInt();
					
					if(r==c)
						trace += m;
					
					if(rows[r].containsKey(m))
						rows[r].put(m, rows[r].get(m)+1);						
					else
						rows[r].put(m, 1);

					if(cols[c].containsKey(m))
						cols[c].put(m, cols[c].get(m)+1);						
					else
						cols[c].put(m, 1);
					
				}
			}
			
			System.out.print("Case #"  + i + ": " + trace + " ");
			int d = 0;
			for(int r=0;r<n;++r)
				for (Map.Entry m : rows[r].entrySet()) 
					if((Integer)m.getValue()>1)
						++d;

			System.out.print(d + " ");

			d = 0;
			for(int c=0;c<n;++c)
				for (Map.Entry m : cols[c].entrySet()) 
					if((Integer)m.getValue()>1)
						++d;

			System.out.println(d);

		}

		in.close();
	}
}
