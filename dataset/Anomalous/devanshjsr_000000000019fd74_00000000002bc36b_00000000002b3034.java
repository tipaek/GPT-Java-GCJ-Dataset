import java.util.Scanner;

public class Solution {

    static void sortStringsByLength(String[] arr, int n) {
        for (int i = 1; i < n; i++) {
            String temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < arr[j].length()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static String concatenateStrings(String first, String second) {
        if (!first.contains(second.substring(0, 1))) {
            return first + second;
        }
        int idx = second.length();
        try {
            while (!first.endsWith(second.substring(0, idx--))) ;
        } catch (Exception e) {
            // Ignored
        }
        return first + second.substring(idx + 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] prefix = new String[n];
            String[] suffix = new String[n];
            boolean hasAsterisk = false;

            for (int i = 0; i < n; i++) {
                String s = sc.next();
                if (s.charAt(0) == '*') {
                    prefix[i] = "";
                    suffix[i] = s.substring(1);
                } else if (s.charAt(s.length() - 1) == '*') {
                    prefix[i] = s.substring(0, s.length() - 1);
                    suffix[i] = "";
                } else {
                    String[] parts = s.split("\\*");
                    prefix[i] = parts[0];
                    suffix[i] = parts[1];
                    hasAsterisk = true;
                }
            }

            sortStringsByLength(prefix, n);
            sortStringsByLength(suffix, n);

            if (!hasAsterisk) {
                boolean isValid = true;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < suffix[i].length(); j++) {
                        if (suffix[i].charAt(suffix[i].length() - 1 - j) != suffix[n - 1].charAt(suffix[n - 1].length() - 1 - j)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if (isValid) {
                    System.out.println("Case #" + caseNumber + ": " + suffix[n - 1]);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
                caseNumber++;
                continue;
            }

            boolean isValid = true;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < prefix[i].length(); j++) {
                    if (prefix[i].charAt(j) != prefix[n - 1].charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < suffix[i].length(); j++) {
                    if (suffix[i].charAt(suffix[i].length() - 1 - j) != suffix[n - 1].charAt(suffix[n - 1].length() - 1 - j)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + concatenateStrings(prefix[n - 1], suffix[n - 1]));
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }

            caseNumber++;
        }
    }
}