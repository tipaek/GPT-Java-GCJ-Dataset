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
		
		static String imp="IMPOSSIBLE";
		static String mp="POSSIBLE";
	
		int size=0;
		int trace=0;
		
		public Problem(Scanner in) {
			this.in=in;
			init(this.in);
		}

		public void init(Scanner in) {
			size=in.nextInt();
			trace=in.nextInt();
		}
		

		public String solve() {
			
			String judge=trace%size==0?(mp+"\r\n"):imp;
			StringBuilder sb=new StringBuilder();
			sb.append(judge);
			
			if (trace % size == 0) {
				int x = trace / size;
				for (int i = 0; i < size; i++) {
					int start = (x + i) % size;
					if (start == 0)
						start = size;
					for (int j = 0; j < size; j++) {
						int o = (start - j+size) % size;
						if (o == 0)
							o = size;
						sb.append(o);
						if (j + 1 == size&&i+1!=size)
							sb.append("\r\n");
						else
							sb.append(" ");
					}

				}
			}
			return sb.toString();
		}
	}


}