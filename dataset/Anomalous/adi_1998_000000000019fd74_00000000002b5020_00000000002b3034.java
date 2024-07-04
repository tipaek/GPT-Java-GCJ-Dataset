import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            String[] ar = new String[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.next();
            }

            String smax = "";
            int maxLen = 0;
            boolean isValid = true;

            // Find the string with the maximum length (excluding the first character)
            for (String str : ar) {
                if (str.length() > maxLen) {
                    maxLen = str.length();
                    smax = str.substring(1);
                }
            }

            maxLen -= 1; // Adjust maxLen to account for the substring operation

            // Check if all strings (excluding the first character) match the suffix of smax
            for (String str : ar) {
                int len = str.length() - 1;
                if (!smax.substring(maxLen - len).equals(str.substring(1))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + (t1 + 1) + ": " + smax);
            } else {
                System.out.println("Case #" + (t1 + 1) + ": *");
            }
        }
    }
}