import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 1; z <= t; z++) {
            String s = sc.next();
            int n = s.length();
            List<Integer> list = new ArrayList<>();
            List<Integer> count = new ArrayList<>();
            int c = 1;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    c++;
                } else {
                    int x = s.charAt(i - 1) - 48;
                    list.add(x);
                    count.add(c);
                    c = 1;
                }
            }
            int x = s.charAt(n - 1) - 48;
            list.add(x);
            count.add(c);
            int curr = 0;
            list.add(0);
            count.add(0);
            int size = list.size();
            StringBuffer res = new StringBuffer("");
            int j = 0;
            while (j < size) {
                if (list.get(j) > curr) {
                    openBrackets(res, list.get(j) - curr);

                } else if (list.get(j) < curr) {
                    closeBrackets(res, curr - list.get(j));
                }
                add(res, list.get(j), count.get(j));
                curr = list.get(j);
                j++;
            }

            System.out.println("Case #" + z + ": " + res.toString());

        }
        sc.close();
    }

    static void add(StringBuffer sb, int val, int c) {
        for (int i = 1; i <= c; i++) {
            sb.append(Integer.toString(val));
        }
    }

    static void openBrackets(StringBuffer sb, int c) {
        for (int i = 1; i <= c; i++) {
            sb.append('(');
        }
    }

    static void closeBrackets(StringBuffer sb, int c) {
        for (int i = 1; i <= c; i++) {
            sb.append(')');
        }
    }
}