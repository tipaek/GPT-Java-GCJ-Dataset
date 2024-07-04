import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
 
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
 
 		int t =fr.nextInt() ,n ,m[][] ,i ,j ,k ,r ,c ;	HashSet<Integer> hs =new HashSet<>() ;
 		for (int cs =1 ; cs<=t ; ++cs) {
 			n =fr.nextInt() ;	m =new int[n][n] ;
 			for (i =0 ; i<n ; ++i) {	for (j =0 ; j<n ; ++j)	m[i][j] =fr.nextInt() ;		}
 		
 			k =r =c =0 ;	for (i =0 ; i<n ; ++i)	k += m[i][i] ;
 			for (i =0 ; i<n ; ++i) {
 				hs.clear() ;
 				for (j =0 ; j<n ; ++j)	{	if (hs.contains(m[i][j]))	break;	hs.add(m[i][j]) ;	}
 				if (j!=n)	++r ;
 			}
 			for (i =0 ; i<n ; ++i) {
 				hs.clear() ;
 				for (j =0 ; j<n ; ++j)	{	if (hs.contains(m[j][i]))	break;	hs.add(m[j][i]) ;	}
 				if (j!=n)	++c ;
 			}
 			op.println("Case #"+cs+": "+k+" "+r+" "+c) ;
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