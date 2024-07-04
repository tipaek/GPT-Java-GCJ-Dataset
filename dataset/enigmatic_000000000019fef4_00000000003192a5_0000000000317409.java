import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String[] args) {
		new Thread(null, new Runnable() {
			public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
	}
	static void solve () {
		FastReader fr =new FastReader();	PrintWriter op =new PrintWriter(System.out);
 
 		int T =fr.nextInt() ,x ,y ,n ,i ,j ;	char s[] ;
 		for (int t =1 ; t<=T ; ++t) {
 			x =fr.nextInt() ;	y =fr.nextInt() ;	s =fr.next().toCharArray() ;	n =s.length ;
 			for (i =0 ; i<n ; ++i) {
 				j =Math.abs(x) + Math.abs(y) ;	if (j <= i)	break;
 				if (s[i]=='N')	++y ;
 				if (s[i]=='S')	--y ;
 				if (s[i]=='E')	++x ;
 				if (s[i]=='W')	--x ;
 			}
 			j =Math.abs(x) + Math.abs(y) ;
 			if (j<=i)	op.println("Case #"+t+": "+i) ;
 			else 	op.println("Case #"+t+": IMPOSSIBLE") ;
 		}
		op.flush();	op.close();
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br =new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st==null || (!st.hasMoreElements())) 
			{
				try
				{
					st =new StringTokenizer(br.readLine());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
			}
			return st.nextToken();
		}

		String nextLine() {
			String str ="";

			try
			{
				str =br.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next()) ;
		}
	}
}