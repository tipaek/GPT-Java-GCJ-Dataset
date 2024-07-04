import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] N = new String[T];
        String[] R = new String[T];

        for (int i = 0; i < T; i++) {
            N[i] = sc.next();
            StringBuilder temp = new StringBuilder();
            int len = N[i].length();

            for (int j = 0; j < len; j++) {
                char currentChar = N[i].charAt(j);
                char prevChar = j > 0 ? N[i].charAt(j - 1) : ' ';

                if (currentChar == '0' && j == 0) {
                    temp.append("0");
                } else if (currentChar == '1' && j == 0 && len == 1) {
                    temp.append("(1)");
                } else if (currentChar == '0' && prevChar == '1') {
                    temp.append(")0");
                } else if (currentChar == '1' && j == 0) {
                    temp.append("(1");
                } else if (currentChar == '1' && j == len - 1 && prevChar == '0') {
                    temp.append("(1)");
                } else if (currentChar == '1' && j == len - 1) {
                    temp.append("1)");
                } else if (currentChar == '1' && prevChar == '1') {
                    temp.append("1");
                } else if (currentChar == '1') {
                    temp.append("(1");
                } else if (currentChar == '0') {
                    temp.append("0");
                }
            }
            R[i] = temp.toString();
        }

        for (String result : R) {
            System.out.println(result);
        }
    }
}