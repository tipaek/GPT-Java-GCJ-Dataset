import java.io.*;
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
    
    public static Boolean overlap(int i, int[] si, int[] ei)
    {
        
        int n = si.length; 
        for(int j = 0; j < n;j++)
        {
            if((si[i] > si[j] && si[i] < ei[j])
            ||(ei[i] > si[j] && ei[i] < ei[j]))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) 
	{
        FastReader input = new FastReader();

        int T = input.nextInt();
        for(int t = 1; t <= T; t++)
        {
            int n = input.nextInt();
            int si[] = new int[n];
            int ei[] = new int[n];
            Vector<Integer> c = new Vector<Integer>();
            Vector<Integer> j = new Vector<Integer>();
            for(int i = 0; i < n; i++)
            {
                si[i] = input.nextInt();
                ei[i] = input.nextInt();
            }
            String as = "";

            for(int i = 0; i < n; i++)
            {
                if(overlap(i,si,ei))
                {
                    as += "C";
                    c.addElement(i);
                }
                else
                {
                    as+= "J"; 
                    j.addElement(i);
                }
            }
            for(int i = 0; i < c.size();i++)
            {
                for(int k = 0; k < c.size(); k++)
                {
                    if((si[c.elementAt(i)] > si[c.elementAt(k)] && si[c.elementAt(i)] < ei[c.elementAt(k)])
                    ||(ei[c.elementAt(i)] > si[c.elementAt(k)] && ei[c.elementAt(i)] < ei[c.elementAt(k)]))
                    {
                        as = "IMPOSSIBLE";
                    }
                }
            }
            for(int i = 0; i < j.size();i++)
            {
                for(int k = 0; k < j.size(); k++)
                {
                    if((si[j.elementAt(i)] > si[j.elementAt(k)] && si[j.elementAt(i)] < ei[j.elementAt(k)])
                    ||(ei[j.elementAt(i)] > si[j.elementAt(k)] && ei[j.elementAt(i)] < ei[j.elementAt(k)]))
                    {
                        as = "IMPOSSIBLE";
                    }
                }
            }
            System.out.println("Case #"+t+": "+as);
        }
    }
}