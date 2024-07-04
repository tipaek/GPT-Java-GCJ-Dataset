import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Solution {
	private static final String RESULT_FOMAT = "Case #%d: %s";

	public static void main(String[] args) throws IOException {
		solve(getScanner(), System.out);
	}

	private static Scanner getScanner() {
		try {
			System.setIn(Files.newInputStream(Paths.get("D:\\codejam\\Test.txt")));
		} catch (IOException e) {
		}
		return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	}

	private static void solve(Scanner in, PrintStream out) {
		int t = Integer.valueOf(in.nextLine());
		for (int i = 1; i <= t; ++i) {
			Problem p = new Problem(in);
			out.println(String.format(RESULT_FOMAT, i, p.solve()));
		}
	}

	private static class Problem {
		
		Scanner in;
		
		char[] str;

		public Problem(Scanner in) {
			this.in=in;
			init(this.in);
		}

		public void init(Scanner in) {
			str=in.nextLine().trim().toCharArray();
		}

		public String solve() {
			StringBuilder sb=new StringBuilder();
			int count=0;
			int o=str[0]-'0';
			for(int k=0;k<o;k++) {
				sb.append('(');
			}
			sb.append(o);
			count=o;
			for(int i=1;i<str.length;i++) {
				int c=str[i]-'0';
				
				if(c==count) {
					//do nothing
				}else
				if(c>count) {
					for(int k=0;k<c-count;k++)sb.append('(');
					count=c;
					
				}else {
					for(int k=0;k<count-c;k++)sb.append(')');
					count=c;
				}
				sb.append(c);
			}
			for(int k=0;k<count;k++) {
				sb.append(')');
			}
			return sb.toString();
		}

	}

}