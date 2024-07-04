package pattern;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int totalCases = T;

        for (int caseIndex = 1; caseIndex <= totalCases; caseIndex++) {
            int N = Integer.parseInt(sc.nextLine());
            String[] patterns = new String[N];

            int maxLength = 0;
            int longestIndex = 0;
            for (int i = 0; i < N; i++) {
                patterns[i] = sc.nextLine();
                if (patterns[i].length() > maxLength) {
                    maxLength = patterns[i].length();
                    longestIndex = i;
                }
            }

            boolean isValid = true;
            for (int i = 0; i < N; i++) {
                if (!patterns[longestIndex].contains(patterns[i].replace("*", ""))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseIndex + ": " + patterns[longestIndex].replace("*", ""));
            } else {
                System.out.println("Case #" + caseIndex + ": *");
            }
        }
        sc.close();
    }
}