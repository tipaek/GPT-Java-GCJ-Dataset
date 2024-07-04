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
            return path + i + " " + j;
        }
        if (n < sumSoFar || lengthSoFar > 500) {
            return null;
        }

        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int value = binomialCoefficient(i, j);
        
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            String position = newI + " " + newJ;
            
            if (newI > 0 && newJ > 0 && newI >= newJ && !visited.contains(position)) {
                visited.add(i + " " + j);
                String temp = findPath(newI, newJ, n, path + i + " " + j + "\n", sumSoFar + value, lengthSoFar + 1, visited);
                visited.remove(i + " " + j);
                
                if (temp != null) {
                    return temp;
                }
            }
        }
        return null;
    }

    static int binomialCoefficient(int n, int k) {
        int[] C = new int[k + 1];
        C[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                C[j] = C[j] + C[j - 1];
            }
        }
        return C[k];
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