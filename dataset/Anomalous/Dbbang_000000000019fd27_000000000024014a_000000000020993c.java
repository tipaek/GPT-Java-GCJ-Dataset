import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.math.BigInteger;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader reader = new FastReader();

    public static void main(String[] args) {
        int t = reader.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = reader.nextInt();
            int sum = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map.containsKey(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    } else {
                        map.put(matrix[i][j], 1);
                    }
                }
                map.clear();
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (map.containsKey(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    } else {
                        map.put(matrix[i][j], 1);
                    }
                }
                map.clear();
            }

            System.out.println("Case #" + caseNumber + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }
    }

    public static String factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact.toString();
    }

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}