import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution
{
	static int mn[] ,ar[] ;	static ArrayList<nd> al =new ArrayList<>() ;
	public static void main(String[] args) {
		new Thread(null, new Runnable() {
			public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
	}
	static void solve () {
		FastReader fr =new FastReader();	PrintWriter op =new PrintWriter(System.out);
 
 		int t =fr.nextInt() ,n ,i ,bck[][] ;	char s[] ;
 		for (int cs =1 ; cs<=t ; ++cs) {
 			s =fr.next().toCharArray() ;	n =s.length ;	ar =new int[n] ;
 			mn =new int[4*n] ;	bck =new int[n][2] ;

 			for (i =0 ; i<n ; ++i)	ar[i] =s[i]-48 ;	b (0 , 0 , n-1) ;
 			rec (n , 0 , n-1 , 0) ;
 			for (i =0 ; i<al.size() ; ++i) {
 				bck[al.get(i).h][0] += al.get(i).ct ;
 				bck[al.get(i).l][1] += al.get(i).ct ;
 			}
 			op.print("Case #"+cs+": ") ;
 			for (i =0 ; i<n ; ++i) {
 				while (bck[i][1]-- > 0)	op.print('(') ;
 				op.print(s[i]) ;
 				while (bck[i][0]-- > 0)	op.print(')') ;
 			}
 			op.println() ;	al.clear() ;
 		}
		op.flush();	op.close();
	}
	static void rec (int n , int l , int h , int v) {
		int i =f (0 , 0 , n-1 , l , h) ;
		if (ar[i]>v)	al.add(new nd(l , h , ar[i]-v)) ;	v =ar[i] ;
		if (l<i)	rec (n , l , i-1 , v) ;
		if (i<h)	rec (n , i+1 , h , v) ;
	}
	static void b (int p , int l , int h) {
		if (l==h)	{	mn[p] =l ;	return;	  }	int md =(l+h)/2 ;
		b (2*p+1 , l , md) ;	b (2*p+2 , md+1 , h) ;
		if (ar[mn[2*p+1]] < ar[mn[2*p+2]])	mn[p] =mn[2*p+1] ;
		else 	mn[p] =mn[2*p+2] ;
	}
	static int f (int p , int l , int h , int x , int y) {
		if (l>=x && h<=y)	return mn[p] ;
		if (h<x || l>y)	return -1 ;
		
		int md =(l+h)/2 ,i ,j ;
		i =f (2*p+1 , l , md , x , y) ;	j =f (2*p+2 , md+1 , h , x , y) ;
		if (i==-1)	return j ;	if (j==-1)	return i ;
		if (ar[i]<ar[j])	return i ;	else 	return j ;
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
class nd {
	int l ,h ,ct ;	nd (int x , int y , int z)	{	l =x ;	h =y ;	ct =z ;	 }
}