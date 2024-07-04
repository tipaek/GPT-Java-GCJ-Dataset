import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

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
 
 		int t =fr.nextInt() ,n ,se[][] ,sl[] ,i ,j ;	PriorityQueue<nd> q =new PriorityQueue<>(new cmp()) ;	nd dm ;
 		for (int cs =1 ; cs<=t ; ++cs) {
 			n =fr.nextInt() ;	se =new int[n][3] ;	sl =new int[n] ;
 			for (i =0 ; i<n ; ++i)	{	se[i][0] =fr.nextInt() ;	se[i][1] =fr.nextInt() ;	se[i][2] =i ;	}
 			sort (se,0,n-1) ;	q.add(new nd(se[0][1] , 0)) ;	sl[0] =0 ;

 			for (i =1 ; i<n ; ++i) {
 				dm =q.peek () ;	j =q.size() ;//System.out.println(dm.end+" "+dm.typ+" "+j) ;
 				if (dm.end > se[i][0]) {
 					q.add(new nd(se[i][1] , j)) ;	sl[se[i][2]] =j ;
 				}
 				else {
 					dm =q.poll() ;	q.add (new nd(se[i][1] , dm.typ)) ;	sl[se[i][2]] =dm.typ ;
 				}
 			}
 			if (q.size()>2)	op.println("Case #"+cs+": IMPOSSIBLE") ;
 			else {
 				op.print("Case #"+cs+": ") ;
 				for (i =0 ; i<n ; ++i) {
 					if (sl[i]==0)	op.print('C') ;	else 	op.print('J') ;
 				}
 				op.println() ; 
 			}
 			q.clear() ;
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
		int[][] low = new int[m - l + 1][3];
 
		int[][] upr = new int[u - m][3];
 
		int i ,j =0 ,k =0 ;
 
		for(i =l;i<=m;i++){
			low[i - l][0] =arr[i][0];
			low[i - l][1] =arr[i][1];
			low[i - l][2] =arr[i][2];
		}
 
		for(i =m + 1;i<=u;i++){
			upr[i - m - 1][0] =arr[i][0];
			upr[i - m - 1][1] =arr[i][1];
			upr[i - m - 1][2] =arr[i][2];
		}
 
		i =l;
 
		while((j < low.length) && (k < upr.length))
		{
			if(low[j][0] < upr[k][0])
			{
				arr[i][0] =low[j][0];	arr[i][1] =low[j][1];
				arr[i++][2] =low[j++][2];
			}
			else
			{
				if(low[j][0] > upr[k][0])
				{
					arr[i][0] =upr[k][0];	arr[i][1] =upr[k][1];
					arr[i++][2] =upr[k++][2];
				}
				else
				{
					if(low[j][1] < upr[k][1])
					{
						arr[i][0] =low[j][0];	arr[i][1] =low[j][1];
						arr[i++][2] =low[j++][2];
					}
					else
					{
						arr[i][0] =upr[k][0];	arr[i][1] =upr[k][1];
						arr[i++][2] =upr[k++][2];
					}
				}
			}
		}
 
		while(j < low.length)
		{
			arr[i][0] =low[j][0];	arr[i][1] =low[j][1];
			arr[i++][2] =low[j++][2];
		}
 
		while(k < upr.length)
		{
			arr[i][0] =upr[k][0];	arr[i][1] =upr[k][1];
			arr[i++][2] =upr[k++][2];
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
class nd {
	int end ,typ ;	nd (int x , int y)	{	end =x ;	typ =y ;	}
}
class cmp implements Comparator<nd> {
	public int compare (nd a , nd b) {	return a.end-b.end ;	}
}