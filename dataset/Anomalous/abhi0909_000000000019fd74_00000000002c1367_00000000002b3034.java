import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }

            if (strings[0].charAt(0) == '*') {
                String minLengthStr = strings[0];
                for (String s : strings) {
                    if (s.length() < minLengthStr.length()) {
                        minLengthStr = s;
                    }
                }

                boolean isValid = true;
                for (String s : strings) {
                    int minIndex = minLengthStr.length() - 1;
                    int strIndex = s.length() - 1;

                    while (minIndex >= 0 && strIndex >= 0) {
                        if (minLengthStr.charAt(minIndex) == '*') {
                            break;
                        }
                        if (minLengthStr.charAt(minIndex) != s.charAt(strIndex)) {
                            isValid = false;
                            break;
                        }
                        minIndex--;
                        strIndex--;
                    }

                    if (!isValid) {
                        break;
                    }
                }

                if (isValid) {
                    int longestStrIndex = 0;
                    for (int i = 1; i < n; i++) {
                        if (strings[i].length() > strings[longestStrIndex].length()) {
                            longestStrIndex = i;
                        }
                    }
                    System.out.println("CASE #" + caseNumber + ": " + strings[longestStrIndex].substring(1));
                } else {
                    System.out.println("CASE #" + caseNumber + ": *");
                }
            } else {
                System.out.println("CASE #" + caseNumber + ": *");
            }
            caseNumber++;
        }
        scanner.close();
    }
}