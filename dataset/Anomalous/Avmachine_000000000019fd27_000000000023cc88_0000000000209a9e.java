import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            String s4 = "";
            String s1 = "", s2 = "", s3 = "";
            int p = 0;
            int aa = 0, cc = 0;
            boolean ans = false;

            for (int j = 1; j <= 150; j++) {
                if (cc != 0) {
                    System.out.print(aa + 1);
                    System.out.flush();
                    String t1 = sc.next();
                    ++j;

                    System.out.print(cc + 1);
                    System.out.flush();
                    String t2 = sc.next();

                    if (s1.charAt(aa) == t1.charAt(0) && s1.charAt(cc) == t2.charAt(0)) {
                        s4 = s1;
                    } else if (s2.charAt(aa) == t1.charAt(0) && s2.charAt(cc) == t2.charAt(0)) {
                        s4 = s2;
                    } else if (s3.charAt(aa) == t1.charAt(0) && s3.charAt(cc) == t2.charAt(0)) {
                        s4 = s3;
                    }

                    ans = true;
                    aa = 0;
                    cc = 0;
                } else {
                    if (p < b) {
                        ++p;
                        System.out.print(p);
                        System.out.flush();
                        String s = sc.next();
                        s4 += s;
                    } else {
                        System.out.print(1);
                        System.out.flush();
                    }
                }

                if (j % 10 == 0) {
                    s1 = complement(s4);
                    s2 = reverse(s4);
                    s3 = reverse(complement(s4));
                    ans = false;
                    aa = 0;
                    cc = 1;

                    outerLoop:
                    for (int a = 0; a < p - 1; a++) {
                        for (int c = a + 1; c < p; c++) {
                            if (checkPair(s1, s2, s3, s4, a, c)) {
                                aa = a;
                                cc = c;
                                break outerLoop;
                            }
                        }
                    }
                }

                if (p == b && ans) {
                    System.out.print(s4);
                    System.out.flush();
                    String response = sc.next();
                    if ("Y".equals(response)) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static boolean checkPair(String s1, String s2, String s3, String s4, int a, int c) {
        return (s1.charAt(a) == '0' && s1.charAt(c) == '0' && s2.charAt(a) == '0' && s2.charAt(c) == '1' &&
                s3.charAt(a) == '1' && s3.charAt(c) == '0' && s4.charAt(a) == '1' && s4.charAt(c) == '1') ||
               (s1.charAt(a) == '0' && s1.charAt(c) == '1' && s2.charAt(a) == '1' && s2.charAt(c) == '0' &&
                s3.charAt(a) == '1' && s3.charAt(c) == '1' && s4.charAt(a) == '0' && s4.charAt(c) == '0') ||
               (s1.charAt(a) == '1' && s1.charAt(c) == '0' && s2.charAt(a) == '1' && s2.charAt(c) == '1' &&
                s3.charAt(a) == '0' && s3.charAt(c) == '0' && s4.charAt(a) == '0' && s4.charAt(c) == '1') ||
               (s1.charAt(a) == '1' && s1.charAt(c) == '1' && s2.charAt(a) == '0' && s2.charAt(c) == '0' &&
                s3.charAt(a) == '0' && s3.charAt(c) == '1' && s4.charAt(a) == '1' && s4.charAt(c) == '0');
    }

    private static String reverse(String s) {
        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();
    }

    private static String complement(String s) {
        StringBuilder complemented = new StringBuilder();
        for (char c : s.toCharArray()) {
            complemented.append(c == '0' ? '1' : '0');
        }
        return complemented.toString();
    }
}