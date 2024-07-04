
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution  {

	static int n ;
	static int [][] arr ;
	static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public Scanner(String file) throws Exception {br = new BufferedReader(new FileReader(file));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(3000);}
    }
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in);
		int t  = sc.nextInt();
		int p = 1 ;
		while(t-- > 0) {
			 n = sc.nextInt();
			 arr = new int [n][n];
			 for(int i = 0 ; i< n ; i++)
				 for(int j = 0 ; j < n ; j++)
					 arr[i][j]  = sc.nextInt();
			int k = 0 , r = 0 , c = 0 ;
			// k
			for(int i = 0 ; i < n ; i++) {
				k += arr[i][i];
			}
			//r
			for(int i = 0 ; i< n ; i++) {
				if(hasDubRow(arr[i])) r++;
			}
			//c
			for(int i = 0 ; i< n ;i++) {
				if(hasDubCol(i))c++;
			}
			System.out.println("Case #"+p+": "+k+" "+r+" "+c);
			p++;
		}
	}
	
	static boolean hasDubRow(int [] row) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int a : row) set.add(a);
		return set.size() == row.length;
	}
	
	static boolean hasDubCol(int colIdx) {
		int [] col = new int [n];
		for(int i = 0 ; i < n ; i++) {
			col[i] = arr[i][colIdx];
		}
		return hasDubRow(col);
	}

}
