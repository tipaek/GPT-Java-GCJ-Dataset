import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            String s = "";
            String s1 = "", s2 = "", s3 = "", s4 = "", t1 = "", t2 = "";
            int p = 0;
            int aa = 0, cc = 0, ans = 0;

            for (int j = 1; j <= 150; j++) {
                if (cc != 0) {
                    System.out.print(aa + 1);
                    System.out.flush();
                    t1 = sc.next();
                    if (t1.equals("N")) {
                        System.exit(0);
                    }
                    ++j;

                    System.out.print(cc + 1);
                    System.out.flush();
                    t2 = sc.next();
                    if (t2.equals("N")) {
                        System.exit(0);
                    }

                    if (s1.charAt(aa) == t1.charAt(0) && s1.charAt(cc) == t2.charAt(0)) {
                        s4 = s1;
                    } else if (s2.charAt(aa) == t1.charAt(0) && s2.charAt(cc) == t2.charAt(0)) {
                        s4 = s2;
                    } else if (s3.charAt(aa) == t1.charAt(0) && s3.charAt(cc) == t2.charAt(0)) {
                        s4 = s3;
                    }

                    ans = 1;
                    aa = 0;
                    cc = 0;

                } else {
                    if (p < b) {
                        ++p;
                        System.out.print(p);
                        System.out.flush();
                        s = sc.next();
                        if (s.equals("N")) {
                            System.exit(0);
                        }
                        s4 += s;
                    } else {
                        System.out.print(1);
                        System.out.flush();
                        s = sc.next();
                        if (s.equals("N")) {
                            System.exit(0);
                        }
                    }
                }

                if (j % 10 == 0) {
                    s1 = complement(s4);
                    s2 = reverse(s4);
                    s3 = complement(reverse(s4));
                    ans = 0;
                    aa = 0;
                    cc = 1;

                    for (int a = 0; a < p - 1; a++) {
                        for (int c = a + 1; c < p; c++) {
                            if (isMatchingPattern(s1, s2, s3, s4, a, c)) {
                                aa = a;
                                cc = c;
                                break;
                            }
                        }

                        if (cc != 0) {
                            break;
                        }
                    }
                }

                if (p == b && ans == 1) {
                    System.out.print(s4);
                    System.out.flush();
                    s = sc.next();
                    if (s.equals("Y")) {
                        break;
                    } else if (s.equals("N")) {
                        System.exit(0);
                    }
                }
            }
        }
        sc.close();
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String complement(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(s.charAt(i) == '0' ? '1' : '0');
        }
        return ans.toString();
    }

    private static boolean isMatchingPattern(String s1, String s2, String s3, String s4, int a, int c) {
        return (s1.charAt(a) == '0' && s1.charAt(c) == '0' && s2.charAt(a) == '0' && s2.charAt(c) == '1' &&
                s3.charAt(a) == '1' && s3.charAt(c) == '0' && s4.charAt(a) == '1' && s4.charAt(c) == '1') ||
                (s1.charAt(a) == '0' && s1.charAt(c) == '1' && s2.charAt(a) == '1' && s2.charAt(c) == '0' &&
                s3.charAt(a) == '1' && s3.charAt(c) == '1' && s4.charAt(a) == '0' && s4.charAt(c) == '0') ||
                (s1.charAt(a) == '1' && s1.charAt(c) == '0' && s2.charAt(a) == '1' && s2.charAt(c) == '1' &&
                s3.charAt(a) == '0' && s3.charAt(c) == '0' && s4.charAt(a) == '0' && s4.charAt(c) == '1') ||
                (s1.charAt(a) == '1' && s1.charAt(c) == '1' && s2.charAt(a) == '0' && s2.charAt(c) == '0' &&
                s3.charAt(a) == '0' && s3.charAt(c) == '1' && s4.charAt(a) == '1' && s4.charAt(c) == '0');
    }
}