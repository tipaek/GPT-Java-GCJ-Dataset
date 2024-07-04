import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String s = "", s1 = "", s2 = "", s3 = "", s4 = "", temp1 = "", temp2 = "";
            int position = 0;
            int indexA = 0, indexC = 0, answerFound = 0;

            for (int queryCount = 1; queryCount <= 150; queryCount++) {
                if (indexC != 0) {
                    System.out.print(indexA + 1);
                    temp1 = scanner.next();
                    if (temp1.equals("Y")) break;
                    else System.exit(0);
                    queryCount++;

                    System.out.print(indexC + 1);
                    temp2 = scanner.next();
                    if (temp2.equals("Y")) break;
                    else System.exit(0);

                    if (s1.charAt(indexA) == temp1.charAt(0) && s1.charAt(indexC) == temp2.charAt(0)) {
                        s4 = s1;
                    } else if (s2.charAt(indexA) == temp1.charAt(0) && s2.charAt(indexC) == temp2.charAt(0)) {
                        s4 = s2;
                    } else if (s3.charAt(indexA) == temp1.charAt(0) && s3.charAt(indexC) == temp2.charAt(0)) {
                        s4 = s3;
                    }

                    answerFound = 1;
                    indexA = 0;
                    indexC = 0;
                } else {
                    position++;
                    System.out.print(position);
                    s = scanner.next();
                    if (s.equals("Y")) break;
                    else System.exit(0);
                    s4 += s;
                }

                if (queryCount % 10 == 0) {
                    s1 = complement(s4);
                    s2 = reverse(s4);
                    s3 = complement(reverse(s4));
                    answerFound = 0;
                    indexA = 0;
                    indexC = 1;

                    for (int a = 0; a < position - 1; a++) {
                        for (int c = a + 1; c < position; c++) {
                            if (checkPatterns(s1, s2, s3, s4, a, c)) {
                                indexA = a;
                                indexC = c;
                                break;
                            }
                        }
                        if (indexC != 0) break;
                    }
                }

                if (position == bitLength && answerFound == 1) {
                    System.out.print(s4);
                    s = scanner.next();
                    if (s.equals("Y")) break;
                    else System.exit(0);
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

    private static boolean checkPatterns(String s1, String s2, String s3, String s4, int a, int c) {
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