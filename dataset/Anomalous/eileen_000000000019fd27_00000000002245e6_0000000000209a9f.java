import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.print("#" + (i + 1) + ": ");
            String S = scan.next();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < S.length(); j++) {
                char currentChar = S.charAt(j);
                char prevChar = j > 0 ? S.charAt(j - 1) : ' ';
                char nextChar = j < S.length() - 1 ? S.charAt(j + 1) : ' ';

                if (currentChar == '0') {
                    if (flag) {
                        result.append(")0");
                        flag = false;
                    } else {
                        result.append('0');
                    }
                } else if (currentChar == '1') {
                    if (!flag) {
                        result.append('(');
                        flag = true;
                    }
                    result.append('1');
                    if (j == S.length() - 1 || nextChar == '0') {
                        result.append(')');
                        flag = false;
                    }
                }
            }
            System.out.println(result);
        }
        scan.close();
    }
}