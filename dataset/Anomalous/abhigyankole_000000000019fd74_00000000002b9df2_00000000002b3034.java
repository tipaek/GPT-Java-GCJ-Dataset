import java.io.*;
import java.util.*;

public class Solution {

    static final long MOD = 1000000007;
    static final int TEN_NINE = 1000000000;
    static long[][] dp;
    static List<List<Long>> listList;
    static List<Long> lolist;
    static List<Pair> plist;
    static List<Integer> inList;
    static int[][] pascal;

    public static void main(String[] args) throws IOException {
        SReader sc = new SReader();
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            int n = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine());
            }

            int maxLength = 0;
            int pos = 0;
            for (int i = 0; i < n; i++) {
                String s = list.get(i);
                int len = s.length();
                if (len > maxLength) {
                    maxLength = len;
                    pos = i;
                }
            }

            boolean match = true;
            int matchLength = 0;
            int i;
            for (i = maxLength - 1; i <= 2 * maxLength; i++) {
                for (int j = 0; j < list.size(); j++) {
                    String s = list.get(j);
                    if (s.length() < i) {
                        list.set(j, modifyString(s, i));
                    }
                }

                match = true;
                for (int k = 0; k < list.size(); k++) {
                    String template = list.get(k);
                    for (int j = k + 1; j < list.size(); j++) {
                        String s = list.get(j);
                        if (!match(s, template)) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) break;
                }
                if (match) break;
            }
            matchLength = i;
            caseNumber++;
            sb.append("Case #").append(caseNumber).append(": ");
            if (match) {
                char[] arr = new char[list.get(0).length()];
                for (String s : list) {
                    for (int kk = 0; kk < s.length(); kk++) {
                        char ch = s.charAt(kk);
                        if (ch != '*') {
                            arr[kk] = ch;
                        }
                    }
                }
                String s = modify(String.valueOf(arr));
                sb.append(s.trim());
            } else {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static String modify(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                sb.append('A');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static boolean match(String s, String temp) {
        for (int i = 0; i < s.length(); i++) {
            try {
                if (s.charAt(i) != temp.charAt(i) && temp.charAt(i) != '*' && s.charAt(i) != '*') {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static String modifyString(String s, int n) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < (n - s.length() + 1); j++) {
                    sb.append("*");
                }
                return s.substring(0, i) + sb.toString() + s.substring(i + 1);
            }
        }
        return null;
    }

    static class Pair {
        long a, b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "a: " + a + " b: " + b;
        }

        public Pair getReversePair() {
            return new Pair(b, a);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    static class SReader {
        BufferedReader br;
        StringTokenizer st;

        public SReader() {
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