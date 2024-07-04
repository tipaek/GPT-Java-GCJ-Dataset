import java.util.Scanner;

public class Solution {

    public static void printArray(char[] array) {
        for (char c : array) {
            if (c != 0) {
                System.out.print(c);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int t = p;

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            char[] resultArray = new char[10000];

            for (int i = 0; i < n; i++) {
                patterns[i] = sc.next();
            }

            boolean isValid = true;

            for (String pattern : patterns) {
                int j;
                for (j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        break;
                    }
                }
                for (int k = 0; k < j; k++) {
                    char c = pattern.charAt(k);
                    if (resultArray[k] == 0) {
                        resultArray[k] = c;
                    } else if (resultArray[k] != c) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    break;
                }
                for (int k = j + 1; k < pattern.length(); k++) {
                    char c = pattern.charAt(k);
                    int offset = k + 10000 - pattern.length();
                    if (resultArray[offset] == 0) {
                        resultArray[offset] = c;
                    } else if (resultArray[offset] != c) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Case #" + (p - t) + ": *");
            } else {
                System.out.print("Case #" + (p - t) + ": ");
                printArray(resultArray);
            }
        }
    }
}