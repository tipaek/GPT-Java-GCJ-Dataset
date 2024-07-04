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
 
 		int t =fr.nextInt() ,n ,se[][] ,r[][] ,sl[] ,i ,j ,k ;
 		for (int cs =1 ; cs<=t ; ++cs) {
 			n =fr.nextInt() ;	se =new int[n][2] ;	r =new int[n][2] ;	sl =new int[n] ;
 			for (i =0 ; i<n ; ++i)	{	se[i][1] =fr.nextInt() ;	se[i][0] =fr.nextInt() ;	}
 			sort (se,0,n-1) ;	r[0][0] =se[0][0] ;	i =j =r[0][1] =sl[0] =0 ;
 			for (k =1 ; k<n ; ++k) {
 				if (se[k][1]<r[i][0]) {
 					r[++j][0] =se[k][0] ;	r[j][1] =j-i ;
 				}
 				else {
 					r[++j][0] =se[k][0] ;	r[j][1] =r[i++][1] ;
 				}
 				sl[k] =r[j][1] ;
 			}
 			if (j-i>1)	op.println("Case #"+cs+": IMPOSSIBLE") ;
 			else {
 				op.print("Case #"+cs+": ") ;
 				for (i =0 ; i<n ; ++i) {
 					if (sl[i]==0)	op.print('C') ;	else 	op.print('J') ;
 				}
 				op.println() ;
 			}
 		}
		op.flush();	op.close();
	}
	public static void sort(int[][] arr , int l , int u) {
		int m ;
 
		if(l < u){
			m =(l + u)/2 ;
 
			sort(arr , l , m);	sort(arr , m + 1 , u);
 
			merge(arr , l , m , u);
		}
	}
	public static void merge(int[][]arr , int l , int m , int u) {
		int[][] low = new int[m - l + 1][2];
 
		int[][] upr = new int[u - m][2];
 
		int i ,j =0 ,k =0 ;
 
		for(i =l;i<=m;i++){
			low[i - l][0] =arr[i][0];
			low[i - l][1] =arr[i][1];
		}
 
		for(i =m + 1;i<=u;i++){
			upr[i - m - 1][0] =arr[i][0];
			upr[i - m - 1][1] =arr[i][1];
		}
 
		i =l;
 
		while((j < low.length) && (k < upr.length))
		{
			if(low[j][0] < upr[k][0])
			{
				arr[i][0] =low[j][0];
				arr[i++][1] =low[j++][1];
			}
			else
			{
				if(low[j][0] > upr[k][0])
				{
					arr[i][0] =upr[k][0];
					arr[i++][1] =upr[k++][1];
				}
				else
				{
					if(low[j][1] < upr[k][1])
					{
						arr[i][0] =low[j][0];
						arr[i++][1] =low[j++][1];
					}
					else
					{
						arr[i][0] =upr[k][0];
						arr[i++][1] =upr[k++][1];
					}
				}
			}
		}
 
		while(j < low.length)
		{
			arr[i][0] =low[j][0];
			arr[i++][1] =low[j++][1];
		}
 
		while(k < upr.length)
		{
			arr[i][0] =upr[k][0];
			arr[i++][1] =upr[k++][1];
		}
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