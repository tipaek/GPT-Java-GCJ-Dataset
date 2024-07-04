
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

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
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int p = 1 ;
		while(t-->0) {
			String curr = sc.nextLine();
			String out = SBar(curr);
			System.out.println("Case #"+p+": "+out);
			p++;
		}
	}
	
	public static String SBar(String s) {
		StringBuilder res = new StringBuilder();
		int StillOpen = 0 ;
		for(int i = 0 ; i < s.length() ; i++) {
			int curr = Integer.parseInt(s.charAt(i)+"");
			if( curr > StillOpen) {
				int x = Math.abs(curr - StillOpen);
				res.append(openedPar(x));res.append(s.charAt(i)+"");
				StillOpen = curr ;
			}
			else if ( curr < StillOpen) {
				int x = Math.abs(curr - StillOpen);
				res.append(closedPar(x));
				StillOpen = StillOpen - x ;
				res.append(s.charAt(i)+"");
			}
			else { res.append(s.charAt(i)+"");}
		}
		res.append(closedPar(StillOpen));
		return res.toString();
	}
	
	public static String openedPar(int x) {
		String res = "";
		for(int i = 0 ; i < x ;i++)res += "(";
		return res;
	}
	
	public static String closedPar(int x) {
		String res = "";
		for(int i = 0 ; i < x ;i++)res += ")";
		return res;
	}

}
