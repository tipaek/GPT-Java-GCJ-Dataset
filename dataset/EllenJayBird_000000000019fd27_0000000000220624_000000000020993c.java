import java.util.*;
import java.io.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    PrintWriter wr;

    String nextToken() throws IOException {
        String token = null;
        token = rd.readLine();
        return token;
    }

	private String calculator(int nbr) throws IOException {
		int n = 0;
		n = Integer.valueOf(nextToken());

		int[][] matrix = new int[n][n];
		int trace = 0;
		int repeatRow = 0, repeatCol = 0;
		for (int i = 0; i < n; i ++) {
			String row = nextToken();
			String[] r = row.split("\\s+");
			boolean[] used = new boolean[n];
			boolean isRepeated = false;
			matrix[i] = new int[n];
			for (int j = 0; j < r.length; j ++) {
                int val = Integer.valueOf(r[j]);
				matrix[i][j] = val;
				if (i == j) {
					trace += matrix[i][j];
				}
				if (used[val - 1]) {
					isRepeated = true;
				}
				used[val - 1] = true;
			}
			if (isRepeated) {
				repeatRow += 1;
			}
		}
		for (int i = 0; i < n; i ++) {
			boolean[] used = new boolean[n];
			boolean isRepeated = false;
			for (int j = 0; j < n; j ++) {
				if (used[matrix[j][i]-1]) {
					isRepeated = true;
					break;
				}
                used[matrix[j][i]-1] = true;
			}
			if (isRepeated) {
				repeatCol += 1;
			}			
		}
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(nbr);
        sb.append(": ");
        sb.append(trace);
        sb.append(" ");
        sb.append(repeatRow);
        sb.append(" ");
        sb.append(repeatCol);
		return sb.toString();
	}

	private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);

		int tnbr = Integer.parseInt(nextToken());

		for (int i = 0; i < tnbr; i ++) {
			String sub = calculator(i + 1);
            wr.println(sub);
		}
		
        rd.close();
        wr.close();
		return;
	}
}