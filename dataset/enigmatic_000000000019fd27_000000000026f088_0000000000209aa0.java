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
 
 		int t =fr.nextInt() ,n ,K ,md ,q ,i ,j ,mt[][] ;	boolean mrk[] ;
 		for (int cs =1 ; cs<=t ; ++cs) {
 			n =fr.nextInt() ;	K =fr.nextInt() ;	mt =new int[n][n] ;
 			md =K%n ;	q =K/n ;
 			for (i =0 ; i<md ; ++i) {
 				for (j =0 ; j<n ; ++j)	mt[i][(i+j)%n] =(q + j)%n ;
 			}
 			for (; i+1<n ; ++i) {
 				for (j =0 ; j<n ; ++j)	mt[i][(i+j)%n] =(q-1 + j)%n ;
 			}
 			mt[i][i] =q-1 ;
 			for (i =0 ; i+1<n ; ++i) {
 				mrk =new boolean[n] ;
 				for (j =0 ; j+1<n ; ++j) {
 					if (mrk[mt[j][i]])	break ;	mrk[mt[j][i]] =true ;
 				}
 				if (j+1<n)	break;	j =-1 ;	while (mrk[++j]);
 				mt[n-1][i] =j ;
 			}
 			if (i==n-1) {
	 			mrk =new boolean[n] ;
				for (j =0 ; j<n ; ++j) {
					if (mrk[mt[j][i]])	break ;	mrk[mt[j][i]] =true ;
				}
				if (j==n)	++i ;
			}
 			op.print("Case #"+cs+": ") ;
 			if (i==n) {
 				op.println("POSSIBLE") ;
 				for (i =0 ; i<n ; ++i) {
 					for (j =0 ; j<n ; ++j)	op.print((mt[i][j]+1)+" ") ;
 					op.println() ;
 				}
 			}
 			else 	op.println("IMPOSSIBLE") ;
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