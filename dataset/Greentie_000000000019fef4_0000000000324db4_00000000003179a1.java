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
			System.setIn(Files.newInputStream(Paths.get("D:\\codejam\\sample.in.txt")));
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
	
	public static class Group{
		
		public Group(String M,String R) {
			this.M=M;
			this.R=R;
		}
		
		String M;
		String R;
	}

	private static class Problem {
		
		Scanner in;
	
		Set<Group>[] dic=new Set[9];
	
		Set<Character> count=new TreeSet<>();
		char[] D;
		
		public Problem(Scanner in) {
			this.in=in;
			int u = Integer.valueOf(in.nextLine());
			D=new char[10];
			init(this.in);
		}

		public void init(Scanner in) {
			for (int i = 0; i < 9; i++)
				dic[i] = new HashSet<Group>();
			for (int i = 0; i < 10000; i++) {
				String[] x = in.nextLine().trim().split(" ");
				for(char c:x[1].toCharArray()) {
					count.add(c);
				}
				if (x[0].length() == x[1].length()) {

					int idx = x[0].charAt(0) - '1';

					dic[idx].add(new Group(x[0], x[1]));

				}
			}
		}
		
	
		private boolean isDigit(char x) {
			return x>='0'&&x<='9';
		}


		public String solve() {
			for(int i=1;i<=9;i++) {
				final int k=i;
				Set<Group> t=dic[i-1];
				t.forEach(g->{
					for(int j=1;j<k;j++) {
						g.R=g.R.replace(D[j],(char)(j+'0'));
					}
					
				});
				if(t.size()!=0) {
					Iterator<Group> it=t.iterator();
					while(it.hasNext()) {
						String el=it.next().R;
						if(!isDigit(el.charAt(0))) {
							D[k]=el.charAt(0);
							count.remove(D[k]);
							break;
						}
					}
					
				}
			}
			D[0]=count.iterator().next().charValue();
			
			return String.copyValueOf(D);
		}
	}


}