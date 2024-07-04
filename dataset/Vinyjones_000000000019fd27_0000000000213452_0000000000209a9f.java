
	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;	
import java.util.stream.IntStream;

	
	public class Solution {
	
		public static void main(String[] args) throws IOException {
			Solution solver = new Solution();
	
			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
				int nbCaseToSolve = Integer.parseInt(br.readLine().trim());
				for (int i = 1; i <= nbCaseToSolve; i++) {
					String line = br.readLine();
					System.out.println( solver.solve(i, line));
	
				}
				while (br.readLine() != null) {
				}
			}
		}
	
	
	

		private String solve(int x, String line) {
			StringBuilder sb = new StringBuilder();
			int level = 0; 
			for (int cv : line.chars().toArray()) {
				char c = (char) cv; 
				int f = cv - '0';
				while(f< level) {
					sb.append(')');
					level--;
				}
				
				while (f > level) {
					sb.append('(');
					level++;
				}
				sb.append(c);
				
			}
			while (level>0) {
				sb.append(')');
				level--;
			}
			return print(x, sb.toString());
		}




		String print(int x, String path) {
	
			return String.format("Case #%d: %s", x, path);
	
		}
	
	}
