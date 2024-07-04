import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        scan.nextLine();
        String[] results = new String[testcases];

        for (int t = 0; t < testcases; t++) {
            results[t] = "";
            String s = scan.nextLine();
            int strLen = s.length();

            int currDepth = 0;

            for (int i = 0; i < strLen; i++) {
                int digit = Character.getNumericValue(s.charAt(i));
                while (currDepth < digit) {
                    results[t] += "(";
                    currDepth++;
                }
                while (currDepth > digit) {
                    results[t] += ")";
                    currDepth--;
                }
                results[t] += digit;
            }

            while (currDepth > 0) {
                results[t] += ")";
                currDepth--;
            }
        }
        scan.close();

        for (int t = 0; t < testcases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }
}