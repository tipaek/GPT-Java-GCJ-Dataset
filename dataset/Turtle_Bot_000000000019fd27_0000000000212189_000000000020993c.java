import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while(st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		FastReader reader = new FastReader();
		int t = reader.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = reader.nextInt();
			int[][] matrix = new int[n][n];
			for(int r = 0; r < n; r++)
				for(int c = 0; c < n; c++)
					matrix[r][c] = reader.nextInt();
			int k = 0;
			for(int r = 0, c = 0; r < n && c < n; r++, c++)
				k += matrix[r][c];
			int r = 0;
			for(int[] row : matrix) {
				boolean repeat = false;
				for(int j = 0; j < row.length; j++)
					for(int l = 0; l < row.length; l++)
						if(row[j] == row[l] && j != l)
							repeat = true;
				if(repeat)
					r++;
			}
			int c = 0;
			for(int col = 0; col < n; col++) {
				boolean repeat = false;
				for(int j = 0; j < n; j++)
					for(int l = 0; l < n; l++)
						if(matrix[j][col] == matrix[l][col] && j != l)
							repeat = true;
				if(repeat)
					c++;
			}
			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
		}
	}
}
