

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
        	int N = in.nextInt();
        	int[][] input = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			input[i][j] = in.nextInt();
        		}
        	}
        	int[] res = solve(N, input);
        	String resStr = res[0] + " " + res[1] + " " + res[2];
        	System.out.println(String.format("Case #%d: %s", t, resStr));
        }
	}

    private static int[] solve(int n, int[][] input) {
    	int[] res = new int[3];
    	res[0] = calculateTrace(n, input);
    	res[1] = countRowsWithDuplicates(n, input);
    	res[2] = countColumnsWithDuplicates(n, input);
		return res;
	}

	private static int countRowsWithDuplicates(int n, int[][] input) {
		int rowsWithDuplications = 0;
    	for (int i = 0; i < n; i++) {
    		Set<Integer> nums = new HashSet<>();
    		for (int j = 0; j < n; j++) {
    			nums.add(input[i][j]);
    		}
    		if (nums.size() < n) {
    			rowsWithDuplications++;
    		}
    	}
		return rowsWithDuplications;
	}

	private static int countColumnsWithDuplicates(int n, int[][] input) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			Set<Integer> nums = new HashSet<>();
			for (int j = 0; j < n; j++) {
				nums.add(input[j][i]);
			}
			if (nums.size() < n) {
				res++;
			}
		}
		return res;
	}

	private static int calculateTrace(int n, int[][] input) {
		int trace = 0;
    	for (int i = 0; i < n; i++) {
    		trace += input[i][i];
    	}
		return trace;
	}

	public static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
