
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public String open(int n) {
		String ans="";
		while(n-->0) {
			ans+="(";
		}
		return ans;
	}
	public String close(int n) {
		String ans="";
		while(n-->0) {
			ans+=")";
		}
		return ans;
	}
	private void solve() throws IOException {
		int t = readInteger();
		for (int i = 1; i <= t; i++) {
			String n = read();
			int past = 0;
			StringBuilder ans = new StringBuilder();
			for (int j = 0; j < n.length(); j++) {
				int num=n.codePointAt(j)-48;
				if(num>past) {
					ans.append(open(num-past));
				}
				else {
					System.out.println(num);
					ans.append(close(Math.abs(num-past)));
					
				}
				past= num;
				ans.append(num);
				
			}
			int num=0;
			if(num>past) {
				ans.append(open(num-past));
			}
			else {
				System.out.println(num);
				ans.append(close(Math.abs(num-past)));
				
			}
			
			wr.printf("Case #%d: %s\n",i,ans);
		}
	}

	public static void main(String[] args) {
		Solution var = new Solution();
		var.run();
	}

	private BufferedReader scan;
	private StringTokenizer tokenizer;
	private PrintWriter wr;

	public int readInteger() throws IOException {
		return Integer.parseInt(read());
	}

	public long readLong() throws IOException {
		return Long.parseLong(read());
	}

	public double readDouble() throws IOException {
		return Double.parseDouble(read());
	}

	public String read() throws IOException {
		String res = "";
		if (tokenizer.hasMoreTokens()) {
			res = tokenizer.nextToken();
		} else {
			String aux = scan.readLine();
			//if(aux == null){
			//	wr.close();
			//	System.exit(0);
			//}

			tokenizer = new StringTokenizer(aux, " ");
			res = tokenizer.nextToken();
		}
		return res;
	}

	public void run() {
		try {
			scan = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = new StringTokenizer("", "");
			//wr = new PrintWriter(new File("src/utils/output"));
			wr = new PrintWriter(System.out);

			solve();

			scan.close();
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
			wr.close();
			System.exit(0);
		}
	}
}
