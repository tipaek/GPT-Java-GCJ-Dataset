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
	
		static int MAXLINE=500;
		
		int target=1;
		public Problem(Scanner in) {
			this.in=in;
			init(this.in);
		}

		public void init(Scanner in) {
			target=Integer.valueOf(in.nextLine());
		}
		

		public String solve() {
			StringBuilder sb=new StringBuilder();
			if(target<=MAXLINE) {
				for(int i=1;i<=target;i++) {
					sb.append("\r\n").append(i).append(" ").append(1);
				}
			}else if(target<=MAXLINE*2) {
				if(target%2==0) {
					for(int i=1;i<=target/2;i++) {
						sb.append("\r\n").append(i).append(" ").append(1);
					}
					sb.append("\r\n").append(target/2).append(" ").append(2);
				}
				else {
					for(int i=1;i<=target/2;i++) {
						if(i==2)sb.append("\r\n").append(i).append(" ").append(2);
						sb.append("\r\n").append(i).append(" ").append(1);
					}
					sb.append("\r\n").append(target/2).append(" ").append(2);
				}
			}
			return sb.toString();
		}
	}


}