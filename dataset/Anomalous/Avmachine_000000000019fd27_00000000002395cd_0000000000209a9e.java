import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            StringBuilder bitSequence = new StringBuilder();
            String s1 = "", s2 = "", s3 = "", s4 = "";
            int position = 0, queryCount = 0;
            int aa = 0, cc = 0, ans = 0;

            for (int j = 1; j <= 150; j++) {
                if (cc != 0) {
                    System.out.print(aa + 1);
                    String t1 = scanner.next();
                    j++;

                    System.out.print(cc + 1);
                    String t2 = scanner.next();

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
                    position++;
                    System.out.print(position);
                    String response = scanner.next();
                    bitSequence.append(response);
                    s4 = bitSequence.toString();
                }

                if (j % 10 == 0) {
                    s1 = complement(s4);
                    s2 = reverse(s4);
                    s3 = reverse(complement(s4));
                    ans = 0;
                    aa = 0;
                    cc = 1;

                    outerLoop:
                    for (int a = 0; a < position - 1; a++) {
                        for (int c = a + 1; c < position; c++) {
                            if (isMatchingPattern(s1, s2, s3, s4, a, c)) {
                                aa = a;
                                cc = c;
                                break outerLoop;
                            }
                        }
                    }
                }

                if (position == bitLength && ans == 1) {
                    System.out.print(s4);
                    String result = scanner.next();
                    if (result.equals("Y")) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String complement(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            result.append(ch == '0' ? '1' : '0');
        }
        return result.toString();
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