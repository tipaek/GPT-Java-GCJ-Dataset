import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfCases; i++) {
            String inputString = scanner.nextLine();
            String result = processString(inputString);
            System.out.printf("Case #%d: %s%n", i, result);
        }
    }

    public static String processString(String str) {
        if (str.equals("1")) {
            return "(1)";
        }
        if (str.length() <= 1) {
            return str;
        }
        if (str.startsWith("1")) {
            return "(" + str.substring(0, findFirstChange(str)) + ")" + processString(str.substring(findFirstChange(str)));
        } else {
            return str.substring(0, findFirstChange(str)) + processString(str.substring(findFirstChange(str)));
        }
    }

    public static int findFirstChange(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                return i + 1;
            }
        }
        return str.length();
    }
}