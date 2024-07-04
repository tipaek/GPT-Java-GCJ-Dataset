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
 
 		int T =fr.nextInt() ,u ,n =(int)1e4 ,i ,j ,k ;	String nm[] =new String[n] ,cd[] =new String[n] ;
 		HashSet<Character> hs =new HashSet<>() ;	char ans[] ,c ;	boolean f ;
 		for (int t =1 ; t<=T ; ++t) {
 			u =fr.nextInt() ;	ans =new char[10] ;	c =' ' ;
 			for (i =0 ; i<n ; ++i) {
 				nm[i] =fr.next() ;	cd[i] =fr.next() ;
 				for (j =0 ; j<cd[i].length() ; ++j) {
 					hs.add(cd[i].charAt(j)) ;
 				}
 				hs.remove(cd[i].charAt(0)) ;
 			}
 			for (char id : hs)	c =id ;	ans[0] =c ;
 			
 			for (i =1 ; i<10 ; ++i) {
 				for (j =0 ; j<n ; ++j) {
 					if (nm[j].length() != cd[j].length())	continue;	f =false ;

 					for (k =0 ; k<nm[j].length() ; ++k) {
 						if (nm[j].charAt(k) > i)	{	f =true ;	break; 	}
 						if (nm[j].charAt(k) == i)	break;
 						if (nm[j].charAt(k) < i) {
 							if (cd[j].charAt(k) != ans[nm[j].charAt(k) - 48]) {
 								f =true ;	break;
 							}
 						}
 					}
 					if (f ||  k == nm[j].length())	continue;
 					ans[i] =cd[j].charAt(k) ;
 				}
 			}
 			op.print("Case #"+t+": ") ;
 			for (i =0 ; i<10 ; ++i)	op.print(ans[i]) ;
 			op.println() ;
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