import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            StringBuilder s4 = new StringBuilder();
            String s1 = "", s2 = "", s3 = "";
            int p = 0;
            int aa = 0, cc = 0;

            for (int j = 1; j <= 150; j++) {
                if (cc != 0) {
                    System.out.print(aa + 1);
                    String t1 = sc.next();
                    j++;

                    System.out.print(cc + 1);
                    String t2 = sc.next();

                    if (s1.charAt(aa) == t1.charAt(0) && s1.charAt(cc) == t2.charAt(0)) {
                        s4 = new StringBuilder(s1);
                    } else if (s2.charAt(aa) == t1.charAt(0) && s2.charAt(cc) == t2.charAt(0)) {
                        s4 = new StringBuilder(s2);
                    } else if (s3.charAt(aa) == t1.charAt(0) && s3.charAt(cc) == t2.charAt(0)) {
                        s4 = new StringBuilder(s3);
                    }

                    aa = 0;
                    cc = 0;
                } else {
                    if (p < b) {
                        p++;
                        System.out.print(p);
                        s4.append(sc.next());
                    } else {
                        System.out.print(1);
                    }
                }

                if (j % 10 == 0) {
                    s1 = comp(s4.toString());
                    s2 = reve(s4.toString());
                    s3 = reve(comp(s4.toString()));
                    aa = 0;
                    cc = 1;

                    for (int a = 0; a < p - 1; a++) {
                        for (int c = a + 1; c < p; c++) {
                            if (isValidPair(s1, s2, s3, s4.toString(), a, c)) {
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

                if (p == b) {
                    System.out.print(s4);
                    String s = sc.next();
                    if (s.equals("Y")) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static boolean isValidPair(String s1, String s2, String s3, String s4, int a, int c) {
        return (s1.charAt(a) == '0' && s1.charAt(c) == '0' && s2.charAt(a) == '0' && s2.charAt(c) == '1' && s3.charAt(a) == '1' && s3.charAt(c) == '0' && s4.charAt(a) == '1' && s4.charAt(c) == '1') ||
               (s1.charAt(a) == '0' && s1.charAt(c) == '1' && s2.charAt(a) == '1' && s2.charAt(c) == '0' && s3.charAt(a) == '1' && s3.charAt(c) == '1' && s4.charAt(a) == '0' && s4.charAt(c) == '0') ||
               (s1.charAt(a) == '1' && s1.charAt(c) == '0' && s2.charAt(a) == '1' && s2.charAt(c) == '1' && s3.charAt(a) == '0' && s3.charAt(c) == '0' && s4.charAt(a) == '0' && s4.charAt(c) == '1') ||
               (s1.charAt(a) == '1' && s1.charAt(c) == '1' && s2.charAt(a) == '0' && s2.charAt(c) == '0' && s3.charAt(a) == '0' && s3.charAt(c) == '1' && s4.charAt(a) == '1' && s4.charAt(c) == '0');
    }

    private static String reve(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String comp(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            ans.append(ch == '0' ? '1' : '0');
        }
        return ans.toString();
    }
}