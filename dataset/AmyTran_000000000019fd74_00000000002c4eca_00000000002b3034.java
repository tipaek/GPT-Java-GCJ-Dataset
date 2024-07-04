import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int i = 0; i < numberOfTest; i++) {
            int numberOfPattern = sc.nextInt();
            List<String> patternList = new ArrayList<>();
            for (int j = 0; j < numberOfPattern; j++) {
                patternList.add(sc.nextToken());
            }
            System.out.println("Case #" + (i + 1) + ": " + findFinalString(patternList));
        }
    }

    private static String findFinalString(List<String> patterns) {
        String result = patterns.get(0);
        for (int i = 1; i < patterns.size(); i++) {
            String pattern = patterns.get(i);
            if (pattern.length() > result.length()) {
                result = pattern;
            }
        }

        for (int i = 0; i < patterns.size(); i++) {
            String pattern = patterns.get(i).replace("*", "");
            String finalPattern = result.replace("*", "");
            if (!finalPattern.equals(pattern) && !finalPattern.endsWith(pattern))
                return "*";
        }

        return result.replace("*", "");
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
