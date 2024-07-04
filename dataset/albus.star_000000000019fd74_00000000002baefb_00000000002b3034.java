
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int TEST_CASE = sc.nextInt();
        for (int t = 1; t <= TEST_CASE; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int n = sc.nextInt();
        String[] array = new String[n];
        int[] asteriskCount = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.next();
            for (int j = 0; j < array[i].length(); j++) {
                if (array[i].charAt(j) == '*') {
                    asteriskCount[i]++;
                }
            }
        }
        ArrayList<String> prefix = new ArrayList<>();
        ArrayList<String> postfix = new ArrayList<>();
        ArrayList<String> mid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int len = array[i].length();
            int aster = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                char c = array[i].charAt(j);
                if (aster < 1) {
                    if (c == '*') {
                        aster++;
                        if (sb.length() >= 1) {
                            prefix.add(sb.toString());
                        }
                        sb = new StringBuilder();
                    } else {
                        sb.append(c);
                    }
                } else if (aster < asteriskCount[i]) {
                    if (c == '*') {
                        aster++;
                        if (sb.length() >= 1 && aster == asteriskCount[i]) {
                            mid.add(sb.toString());
                            sb = new StringBuilder();
                        }
                    } else {
                        sb.append(c);
                    }
                } else {
                    if (c == '*') {
                        aster++;
                    } else {
                        sb.append(c);
                    }
                }
            }
            if (sb.length() >= 1) {
                postfix.add(sb.toString());
            }
        }
        Comparator<String> comparator = (o1, o2) -> o2.length() - o1.length();
        StringBuilder resString = new StringBuilder();
        if (prefix.size() >= 1) {
            prefix.sort(comparator);
            resString.append(prefix.get(0));
            for (int j = 1; j < prefix.size(); j++) {
                for (int k = 0; k < prefix.get(j).length(); k++) {
                    if (prefix.get(0).charAt(k) != prefix.get(j).charAt(k)) {
                        pw.print("*");
                        return;
                    }
                }
            }
        }
        if (mid.size() >= 1) {
            for (String s : mid) {
                resString.append(s);
            }
        }
        if (postfix.size() >= 1) {
            postfix.sort(comparator);
            resString.append(postfix.get(0));
            for (int j = 1; j < postfix.size(); j++) {
                int diff = postfix.get(0).length() - postfix.get(j).length();
                for (int k = 0; k < postfix.get(j).length(); k++) {
                    if (postfix.get(0).charAt(k + diff) != postfix.get(j).charAt(k)) {
                        pw.print("*");
                        return;
                    }
                }
            }
        }
        pw.print(resString.toString());
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            nullOrGet();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            nullOrGet();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            nullOrGet();
            return stk.nextToken();
        }

        private StringTokenizer nullOrGet() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
            return stk;
        }
    }

}