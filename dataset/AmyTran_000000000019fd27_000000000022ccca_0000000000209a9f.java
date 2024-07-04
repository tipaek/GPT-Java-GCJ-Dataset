import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            String line = sc.nextToken();
            // Solve
            List<Character> openList = new ArrayList<>();
            List<String> result = new ArrayList<>();
            for (int j = 0; j < line.length(); j++) {
                int openCount = line.charAt(j) - '0' - openList.size();
                for (int k = 0; k < openCount ; k++) {
                    openList.add('(');
                    result.add("(");
                }
                result.add(line.charAt(j) + "");
                int closeCount = line.charAt(j) - '0';
                if (j < line.length() -1) {
                    closeCount = line.charAt(j) - line.charAt(j + 1);
                }
                if (closeCount > 0) {
                    for (int k = 0; k < closeCount; k++) {
                        result.add(")");
                        openList.remove(0);
                    }
                }
            }
            System.out.print("Case #" + (i + 1) + " ");
            for (String x : result) {
                System.out.print(x);
            }
            System.out.println("");
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
