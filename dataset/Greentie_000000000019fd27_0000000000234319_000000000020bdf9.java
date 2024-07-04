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
		
		String imp="IMPOSSIBLE";
		int[] t=new int[1440];
		int[][] x;
		public Problem(Scanner in) {
			this.in=in;
			init(this.in);
		}

		public void init(Scanner in) {
			int tasks = Integer.valueOf(in.nextInt());
			x=new int[tasks][];
			for(int i=0;i<tasks;i++) {
				x[i]=new int[2];
				x[i][0]=in.nextInt();
				x[i][1]=in.nextInt();
				
			}
		}
		

		public String solve() {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<x.length;i++) {
				int task2='C';
				int max=-1;
				for (int k = x[i][0]; k < x[i][1]; k++) {
					if(t[k]>max)max=t[k];
					if(max== 'C' * 'J')return imp;
				}
				if(max==0)task2='C';
				else if(max<'J')task2='J';
				else task2='C';
				for (int k = x[i][0]; k < x[i][1]; k++) {
					if(t[k]==0)t[k]=1;
					t[k]*=task2;
				}
				sb.append(Character.valueOf((char) task2));
			}
			return sb.toString(); 
		}

	}

}