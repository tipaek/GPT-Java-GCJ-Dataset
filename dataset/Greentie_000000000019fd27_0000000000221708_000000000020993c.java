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
		int size=1;
		
		Scanner in;
		
		int rows=0;
		int columns=0;
		int[][] m;
		int trace=0;

		public Problem(Scanner in) {
			this.in=in;
			init(in);
		}

		public void init(Scanner in) {
			size= Integer.valueOf(in.nextInt());
			m=new int[size][];
			
			for(int i=0;i<size;i++) {
				m[i]=new int[size];
				int[] c=new int[size+1];
				c[0]=1;
				for(int j=0;j<size;j++) {
					m[i][j]=in.nextInt();
					c[m[i][j]]++;
					if(c[m[i][j]]>1)c[0]=0;
					if(i==j)trace+=m[i][j];
				}
				if(c[0]==0)rows++;
				
			}
		}

		public String solve() {
			for(int i=0;i<m.length;i++) {
				int[] c=new int[size+1];
				c[0]=1;
				for(int j=0;j<size;j++) {
					c[m[j][i]]++;
					if(c[m[j][i]]>1) {
						c[0]=0;
						break;
					}	
				}
				if(c[0]==0)columns++;
			}
				
			return String.format("%d %d %d", trace,rows,columns);
		}

	}

}