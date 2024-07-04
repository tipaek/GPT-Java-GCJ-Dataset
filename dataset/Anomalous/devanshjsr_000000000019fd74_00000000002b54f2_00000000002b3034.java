import java.util.Scanner;

public class Solution {

    static void sort(String[] s, int n) {
        for (int i = 1; i < n; i++) {
            String temp = s[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < s[j].length()) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = temp;
        }
    }

    public static String concatenate(String first, String second) {
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

        while (t > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];

            for (int i = 0; i < n; i++) {
                String s = sc.next();

                if (s.charAt(0) == '*') {
                    a[i] = "";
                    b[i] = s.substring(1);
                } else {
                    String[] splitString = s.split("\\*", 2);
                    a[i] = splitString[0];
                    b[i] = splitString.length > 1 ? splitString[1] : "";
                }
            }

            sort(a, n);
            sort(b, n);

            boolean isValid = true;

            for (int i = 0; i < n - 1; i++) {
                if (!a[n - 1].contains(a[i])) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                for (int i = 0; i < n - 1; i++) {
                    if (!b[n - 1].contains(b[i])) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                System.out.println("Case #" + caseNumber + ": " + concatenate(a[n - 1], b[n - 1]));
            }

            caseNumber++;
            t--;
        }

        sc.close();
    }
}