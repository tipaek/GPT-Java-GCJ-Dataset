import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;

class Solution 
{ 
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 

	public static void main(String[] args) 
	{
	    FastReader input = new FastReader();
	    int T = input.nextInt();
	    for(int t = 0; t < T ; t++)
	    {
	        ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
	        int n = input.nextInt();  // size of matrix
	        for(int i = 0; i < n; i++)
	        {
	            ArrayList<Integer> row = new ArrayList<Integer>();
                for(int j = 0; j < n; j++)
                {
                    row.add(input.nextInt());
                }
                mat.add(row);
                    
            }

                /*Case #x: k r c ->
                x is the test case,
                k is the sum of diagonals from left to right,
                 r is number of rows repeated,
                 c is the number of columns repeated
                 */
            int trace = 0;
            int r = 0;
            int c = 0;

            for(int i = 0; i < n; i++)
            {
                trace += mat.get(i).get(i);
            }

            
            for(int i = 0; i < n; i++)
            {
                Boolean a = false;
                Vector<Integer> hr = new Vector<Integer>();
                for(int j = 0; j < n; j++)
                {
                    
                    int x = mat.get(i).get(j);
                    
                    if(hr.contains(x) && a == false)
                    {
                        r++;
                        a = true;
                    }
                    else
                    {
                        hr.add(x);
                    }
                }
            }
            for(int i = 0; i < n; i++)
            {
                Boolean b = false;
               
                Vector<Integer> hc = new Vector<Integer>();
                for(int j = 0; j < n; j++)
                {
                    
                    int y = mat.get(j).get(i);
                    if(hc.contains(y) && b == false)
                    {
                        c++;
                        b = true;
                    }
                    else
                    {
                        hc.add(y);
                    }
                }
            }
            System.out.println("Case #"+(t+1)+": "+trace+" "+r+" "+c);
        }
    }
}