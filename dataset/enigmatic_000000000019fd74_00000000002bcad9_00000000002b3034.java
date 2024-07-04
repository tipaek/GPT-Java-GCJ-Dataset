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
 
 		int t =fr.nextInt() ,n ,i ,j ,k ,mx ;	String a[] ;
 		for (int ts =1 ; ts<=t ; ++ts) {
 			n =fr.nextInt() ;	a =new String[n] ;	k =0 ;	mx =-1 ;
 			for (i =0 ; i<n ; ++i) {
 				a[i] =fr.next() ;	if (a[i].length() > k)	{	k =a[i].length() ;	mx =i ;	}
 			}
 			for (i =n-1 ; i>-1 ; --i) {
 				if (i==mx)	continue;	j =a[mx].length()-1 ;
 				for (k =a[i].length()-1 ; k>0 ; --k, --j) {
 					if (a[i].charAt(k)!=a[mx].charAt(j))	break;
 				}
 				if (k!=0)	break;
 			}
 			op.print("Case #"+ts+": ") ;
 			if (i==-1)	op.println(a[mx].substring(1)) ;	else 	op.println('*') ;
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