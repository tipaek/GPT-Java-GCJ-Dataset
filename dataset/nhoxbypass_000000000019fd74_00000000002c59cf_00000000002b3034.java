import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int N = Integer.parseInt(sc.nextToken());
            List<String> patterns = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                patterns.add(sc.nextToken());
            }

            // Solve
            String res = solve(patterns);
            System.out.println("Case #" + (i+1) + ": " + res);
        }
    }

    private static String solve(List<String> patterns) {
        patterns.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        boolean matched = true;
        String smallestP = patterns.get(0);
        int asteriskIdx = smallestP.indexOf("*");

        String prevLeft = getLeftText(smallestP, asteriskIdx);
        String prevRight = getRightText(smallestP, asteriskIdx);

        for (int i = 0; i < patterns.size(); i++) {
            String p = patterns.get(i);
            int idx = p.indexOf("*");

            String curLeft = getLeftText(p, idx);
            String curRight = getRightText(p, idx);

            char[] prevChars = prevLeft.toCharArray();
            char[] curChars = curLeft.toCharArray();

            int n1 = prevChars.length, n2 = curChars.length;
            int j = 0, k = 0;
            // before *
            while (j < n1 && k < n2) {
                if (prevChars[j] == curChars[k]) {
                    j++;
                    k++;
                } else {
                    matched = false;
                    break;
                }
            }

            if (!matched) {
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            // after *
            prevChars = prevRight.toCharArray();
            curChars = curRight.toCharArray();
            n1 = prevChars.length;
            n2 = curChars.length;

            int i3 = n1 - 1, i4 = n2 - 1;
            while (i3 >= 0 && i4 >= 0) {
                if (prevChars[i3] == curChars[i4]) {
                    i3--;
                    i4--;
                } else {
                    matched = false;
                    break;
                }
            }

            if (!matched) {
                break;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }
        }

        String result = "*";
        if (matched) {
            result = prevLeft + prevRight;
        }

        return result;
    }

    private static String getLeftText(String p, int asteriskIdx) {
        return p.substring(0, asteriskIdx);
    }

    private static String getRightText(String p, int asteriskIdx) {
        String right = "";
        if (asteriskIdx < p.length()) {
            right = p.substring(asteriskIdx + 1);
        }
        return right;
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