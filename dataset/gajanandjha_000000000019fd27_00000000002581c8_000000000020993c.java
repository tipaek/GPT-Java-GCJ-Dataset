import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int sum = 0;
			int r = 0, c = 0;
			int[][] mat = new int[N][N];
			for(int i = 0; i < N; i++) {
				String[] spl = br.readLine().trim().split("\\s+");
				for(int j = 0; j < N; j++) {
					mat[i][j] = Integer.parseInt(spl[j]);
				}
			}
			for(int i = 0; i < N; i++) {
				Set<Integer> set = new HashSet<Integer>();
				for(int j = 0; j < N; j++) {
					set.add(mat[i][j]);
				}
				if(set.size() < N) r++;
				sum += mat[i][i];
			}
			for(int i = 0; i < N; i++) {
				Set<Integer> set = new HashSet<Integer>();
				for(int j = 0; j < N; j++) {
					set.add(mat[j][i]);
				}
				if(set.size() < N) c++;
			}
			System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);
		}
	}

}
