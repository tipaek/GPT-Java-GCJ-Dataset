import java.util.Scanner;

public class Solution {

    static String[] sortByLength(String[] stringArray) {
        for (int i = 1; i < stringArray.length; i++) {
            String temp = stringArray[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < stringArray[j].length()) {
                stringArray[j + 1] = stringArray[j];
                j--;
            }
            stringArray[j + 1] = temp;
        }
        return stringArray;
    }

    static boolean isEndSubstring(String s1, String s2) {
        return s2.endsWith(s1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }
            patterns = sortByLength(patterns);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!isEndSubstring(patterns[i].split("\\*")[1], patterns[j].split("\\*")[1])) {
                        impossible = true;
                    }
                }
            }
            if (impossible) {
                System.out.printf("Case #%d: *\n", c + 1);
            } else {
                System.out.printf("Case #%d: %s\n", c + 1, patterns[n - 1].split("\\*")[1]);
            }
        }
        scanner.close();
    }
}