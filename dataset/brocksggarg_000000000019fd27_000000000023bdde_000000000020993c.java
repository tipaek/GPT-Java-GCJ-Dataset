import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			solve(br, i);
		}
	}

	private static void solve(BufferedReader br, int test) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		String input[];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		int rows = 0, cols = 0, trace = 0;
		Set<Integer> set = new HashSet<>();
		// check rows
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!set.add(arr[i][j])) {
					++rows;
					break;
				}
			}
			set.removeAll(set);
		}

		// check columns
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (!set.add(arr[i][j])) {
					++cols;
					break;
				}
			}
			set.removeAll(set);
		}
		
		//check trace
		int i=0,j=0;
		while(i<n) {
			trace = trace+arr[i][j];
			++i;
			++j;
		}
		
		System.out.println("Case #"+test+": "+trace+" "+rows+" "+cols);
	}

}
