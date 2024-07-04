
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
        //* * 가 양쪽� �다면 그냥 뒤� 붙여버리면�
        //*A*A*AA �렇게 복�한 경우
        //*AAA
        //*BBB
        //*A*AA
        //*DQWEQAA
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
                        if (sb.length() >= 1) {
                            mid.add(sb.toString());
                        }
                        sb = new StringBuilder();
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
            long max = 1;
            long mod = 113131313133l;
            long hashs[] = new long[prefix.get(0).length() + 1];
            for (int i = 0; i <= prefix.get(0).length(); i++) {
                hashs[i] = max;
                max *= 1313;
            }
            for (int j = 1; j < prefix.size(); j++) {
                long v = hash(prefix.get(j));
                long start = 0;
                int k = 0;
                for (; k < prefix.get(j).length(); k++) {
                    start = (start * 1313 + prefix.get(0).charAt(k));
                }
                if (v == start) {
                    continue;
                }
                boolean flag = false;
                for (; k < prefix.get(0).length(); k++) {
                    start = ((start - hashs[prefix.get(j).length() - 1] * prefix.get(0).charAt(k - prefix.get(j).length())) * 1313 + prefix.get(0).charAt(k));
                    if (v == start) {
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                pw.print("*");
                return;
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
            long max = 1;
            long mod = 113131313133l;
            long hashs[] = new long[postfix.get(0).length() + 1];
            for (int i = 0; i <= postfix.get(0).length(); i++) {
                hashs[i] = max;
                max *= 1313;
            }
            for (int j = 1; j < postfix.size(); j++) {
                long v = hash(postfix.get(j));
                long start = 0;
                int k = 0;
                for (; k < postfix.get(j).length(); k++) {
                    start = (start * 1313 + postfix.get(0).charAt(k));
                }
                if (v == start) {
                    continue;
                }
                boolean flag = false;
                for (; k < postfix.get(0).length(); k++) {
                    start = ((start - hashs[postfix.get(j).length() - 1] * postfix.get(0).charAt(k - postfix.get(j).length())) * 1313 + postfix.get(0).charAt(k));
                    if (v == start) {
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                pw.print("*");
                return;
            }
        }
        pw.print(resString.toString());
    }

    public static long hash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * 1313 + s.charAt(i);
        }
        return hash;
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