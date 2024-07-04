import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		int cases = i();
		for(int c = 1; c<=cases; c++){
			StringBuilder line = new StringBuilder(s());

			int depth = 0; 
			for(int k =0; k<line.length(); k++){
				int num = Integer.parseInt(line.substring(k,k+1));
				if(depth<num){
					while(depth<num){
						line = line.insert(k,"(");
						depth++;
						k++;
					}
				}
				else if(depth>num){
					while(depth>num){
						line = line.insert(k,")");
						depth--;
						k++;
					}
				}
			}

			while(depth>0){
				line = line.insert(line.length(), ")");
				depth--;
			}
			out.println("Case #"+c+": "+line.toString());
		}

		out.close();
	}

	static BufferedReader in;
	static StringTokenizer st = new StringTokenizer("");
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static {
		try {
			in = Files.newBufferedReader(Paths.get("test.in"));
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	static void check() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
	}
	static String s() throws Exception { check(); return st.nextToken(); }
	static int i() throws Exception { return Integer.parseInt(s()); }
	static long l() throws Exception { return Long.parseLong(s()); }
	static double d() throws Exception { return Double.parseDouble(s()); }
}
