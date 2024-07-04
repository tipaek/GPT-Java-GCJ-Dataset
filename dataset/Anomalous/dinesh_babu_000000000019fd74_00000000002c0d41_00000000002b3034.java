import java.util.*;

public class Solution {
    static boolean match(String s, String k) {
        int lengthS = s.length();
        int lengthK = k.length();
        int index = lengthS;

        for (int i = lengthK - 1; i >= 0; i--) {
            index--;
            if (k.charAt(i) == '*' || s.charAt(index) == '*') {
                return true;
            } else if (k.charAt(i) == s.charAt(index)) {
                continue;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            String longestString = "";
            int maxLength = -1;
            String[] strings = new String[N];

            for (int i = 0; i < N; i++) {
                strings[i] = scanner.next();
                if (strings[i].length() > maxLength) {
                    maxLength = strings[i].length();
                    longestString = strings[i];
                }
            }

            int flag = 0;
            Arrays.sort(strings);

            for (String str : strings) {
                if (match(str, longestString)) {
                    continue;
                } else {
                    flag = 1;
                    System.out.println("Case #" + caseNumber + ": *");
                    break;
                }
            }

            if (flag == 0) {
                System.out.println("Case #" + caseNumber + ": " + longestString.substring(1));
            }
        }

        scanner.close();
    }
}