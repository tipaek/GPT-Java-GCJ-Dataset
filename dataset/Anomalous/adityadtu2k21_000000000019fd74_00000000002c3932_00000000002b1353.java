import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        
        int tc = scn.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = scn.nextInt();
            String result = findPath(1, 1, n, "", 0, 0, new HashSet<>());
            System.out.println("Case #" + t + ": ");
            System.out.print(result);
        }
    }

    private static String findPath(int i, int j, int n, String path, int sumSoFar, int lengthSoFar, Set<String> visited) {
        if (n == sumSoFar && lengthSoFar <= 500) {
            return path;
        }
        if (n < sumSoFar || lengthSoFar > 500) {
            return null;
        }

        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int value = binomialCoefficient(i, j - 1);
        
        for (int[] direction : directions) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if (nextI > 0 && nextJ > 0 && nextI >= nextJ && !visited.contains(nextI + " " + nextJ)) {
                visited.add(i + " " + j);
                String tempPath = findPath(nextI, nextJ, n, path + i + " " + j + "\n", sumSoFar + value, lengthSoFar + 1, visited);
                visited.remove(i + " " + j);
                if (tempPath != null) {
                    return tempPath;
                }
            }
        }
        return null;
    }

    private static int binomialCoefficient(int n, int k) {
        int[] coeff = new int[k + 1];
        coeff[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                coeff[j] = coeff[j] + coeff[j - 1];
            }
        }
        return coeff[k];
    }

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
}