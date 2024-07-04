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
			out.println(String.format(RESULT_FOMAT, i,p.solve()));
		}
	}
	
	

	private static class Problem {
		
		Scanner in;
	
		String imp="IMPOSSIBLE";
		int x,y;
		char[] step=null;
		public Problem(Scanner in) {
			this.in=in;
			init(this.in);
		}

		public void init(Scanner in) {
			this.x=in.nextInt();
			this.y=in.nextInt();
			this.step=in.nextLine().trim().toCharArray();
		}
		
	
		


		public String solve() {
			int k=0;
			for(;k<step.length;k++) {
				if(step[k]=='N')y+=1;
				else if(step[k]=='S')y-=1;
				else if(step[k]=='E')x+=1;
				else if(step[k]=='W')x-=1;
				int r=Math.abs(x)+Math.abs(y);
				if(r-1<=k) {
					return String.valueOf(k+1);
				}
			}
			return imp;
		}
	}


}