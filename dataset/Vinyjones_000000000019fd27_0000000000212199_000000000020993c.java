
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
					int N = Integer.parseInt(br.readLine().trim());
					int [] [] matrice = new int[N][N] ;
					for (int j = 0; j < N; j++) {
						String line = br.readLine();
						matrice[j] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
					}
					System.out.println( solver.solve(i, matrice));
	
				}
				while (br.readLine() != null) {
				}
			}
		}
	
	
		private String solve(int i, int[][] matrice) {
			int N  = matrice.length;
			int k, r, c;
			k = IntStream.range(0, N).map(v-> matrice[v][v]).sum();
			r = (int) IntStream.range(0, N).mapToObj(v-> matrice[v]).filter(
					l -> (Arrays.stream(l).distinct().count() < N)
					).count();
			c = (int) IntStream.range(0, N).filter(col -> 
					IntStream.range(0, N).map(row -> matrice[row][col])
					.distinct().count() < N
					
					).count();
			return String.format("Case #%d: %d %d %d", i, k, r, c);	
		}


		String print(int x, String path) {
	
			return String.format("Case #%d: %s", x, path);
	
		}
	
	}
