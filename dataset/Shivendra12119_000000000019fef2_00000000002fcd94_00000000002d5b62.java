import java.util.*;
import java.io.*;

public class Solution {
	static FastReader sc;
	static BufferedWriter bufferedWriter;
	static String no = "IMPOSSIBLE";

	public static void main(String[] args) throws IOException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		sc = new FastReader();
		int tp = sc.nextInt();
		for (int i_t = 0; i_t < tp; i_t++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			String ans=solve(x,y);
			bufferedWriter.write("Case #" + (i_t + 1) + ": " + ans + "\n");
		}
		bufferedWriter.flush();

	}

	private static String solve(int x, int y) {
		String ans="";
		if(Math.abs(x%2)==Math.abs(y%2))
			return no;
		while(Math.abs(x%2)!=Math.abs(y%2)) {
			if(Math.abs(x%2)==1) {
				if(y==0) {
					if(x==1)return ans+"E";
					if(x==-1)return ans+"W";
				}
				y/=2;
				if( Math.abs(y%2) != Math.abs(((x+1)/2)%2) ) {
					ans+="W";
					x++;
					x/=2;
				}else {
					ans+="E";
					x--;
					x/=2;
				}
			}else {
				if(x==0) {
					if(y==1)return ans+"N";
					if(y==-1)return ans+"S";
				}
				x/=2;
				if( Math.abs(x%2) != Math.abs(((y+1)/2)%2) ) {
					ans+="S";
					y++;
					y/=2;
				}else {
					ans+="N";
					y--;
					y/=2;
				}
				
			}
		}
		if(x==0&&y==0)return ans;
		return no;
	}

	
	

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br=new  BufferedReader(new InputStreamReader(System.in));
	
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	String nextLine() {
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
