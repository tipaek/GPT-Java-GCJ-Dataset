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
 
 		int T =fr.nextInt() ,a[][] ,rs[][] ,x ,y ,i ,j ,k ,l ,n ;	boolean flg ,bit[][] ,pos[] ;
 		for (int t =1 ; t<=T ; ++t) {
 			a =new int[2][32] ;	x =fr.nextInt() ;	y =fr.nextInt() ;	pos =new boolean[2] ;
 			if (x>=0)	pos[0] =true ;	if (y>=0)	pos[1] =true ;
 			x =Math.abs(x) ;	y =Math.abs(y) ;	flg =true ;

 			if (x%2==y%2)	op.println("Case #"+t+": IMPOSSIBLE") ;
 			else {
 				k =1 ;	i =-1 ;		while (x>=k)	{	a[0][++i] =(x&(1<<i))==0 ? 0:1 ;	k<<=1;	}
 				l =1 ;	j =-1 ;		while (y>=l)	{	a[1][++j] =(y&(1<<j))==0 ? 0:1 ;	l<<=1 ;	}
 				n =Math.max(i,j) ;	rs =new int[n+5][2] ;	bit =new boolean[n+5][2] ;
 				
 				for (i =0 ; i<=n ; ++i) {
 					if (a[0][i]==a[1][i] && a[0][i]==0)	{	flg =false ;	break;	}
 					if (a[0][i]==a[1][i] && a[0][i]==1)
 					{
 						if (a[0][i-1]==1)	j =0 ;	else 	j =1 ;	rs[i-1][j] =-1 ; 
 						while (j!=-1) 
 						{	
 							while (i<=n && a[0][i]==a[1][i] && a[0][i]==1) {
 								bit[i][j] =true ;	rs[i][j^1] =1 ;	++i ;
 							}//System.out.println(i+" "+j+" "+rs[0][1]+" "+n) ;
 							rs[i][j] =1 ;	bit[i][j] =true ;
 							if (a[j][i]==1)	{	flg =false ;	break;	}
	 						else if (a[j^1][i]==1) {
	 							j ^= 1 ;	if (bit[i-1][j])	{	flg =false ;	break;	}
	 							rs[i-1][j] =-1 ;	++i ;
	 						}
	 						else 	j =-1 ;//System.out.println(a[0][i+1]+" "+a[1][i+1]) ;
 						}
 					}
 					else {
 						if (a[0][i]==1)	rs[i][0] =1 ;	else 	rs[i][1] =1 ;
 					}
 					if (!flg)	break;
 				}
 				if (!flg)	op.println("Case #"+t+": IMPOSSIBLE") ;
 				else {
 					op.print("Case #"+t+": ") ;
 					for (i =0 ; i<=(n+1) ; ++i) {
						if (rs[i][1]==1) {
							if (pos[1])	op.print('N') ;	else  	op.print('S') ;
						}
						if (rs[i][1]==-1) {
							if (!pos[1])	op.print('N') ;	else  	op.print('S') ;
						}
						if (rs[i][0]==1) {
							if (pos[0])	op.print('E') ;	else  	op.print('W') ;
						}
						if (rs[i][0]==-1) {
							if (!pos[0])	op.print('E') ;	else  	op.print('W') ;
						}
 					}
 					op.println() ;
 				}
 			}
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