import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.next();
            }
            String m = "";
            for (int i = 1; i < n; i++) {
                m = match(a[i - 1], a[i]);
            }
            t--;
        }
        sc.close();
    }

    static String match(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int text_length = s1.length;
        int pattern_length = s2.length;

        if (pattern_length > text_length) {
            return "-1";
        }

        for (int c = 0; c <= text_length - pattern_length; c++) {
            int position = c;
            int e = c;
            int d;
            for (d = 0; d < pattern_length; d++) {
                if (s2[d] == s1[e]) {
                    e++;
                } else {
                    break;
                }
            }
            if (d == pattern_length) {
                return String.valueOf(position);
            }
        }

        return "*";
    }
}