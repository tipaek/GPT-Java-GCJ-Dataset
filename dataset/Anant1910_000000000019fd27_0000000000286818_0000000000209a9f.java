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

        for(int t = 1; t <= T; t++)
        {
            String s = input.nextLine();
            Vector<String> sv = new Vector<String>();
            String o = "";
            int n = s.length() - 1 ;
            int a = 0;
            int b = 0;
            int li[] = new int[n+1]; 

            for(int i = 0; i <= n;i++)
            {
                li[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            for(int i = 0; i <= n; i++)
            {
                for(int j = 1; j <= 9 ;j++)
                {
                    if(li[i] > b)
                    {
                        o += "(";
                        b++;
                    }
                    if(li[i] < b)
                    {
                        o += ")";
                        b--;
                    }
                }
                o+=li[i];
            }
            for(int i = 0; i < li[n];i++)
            {
                o+=")";
            }
            System.out.println("Case #"+t+": "+o);
        }
        // output format : "Case #x: s"
        
    }
}