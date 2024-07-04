import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testTotalCount = Integer.parseInt(in.nextLine()); //first input
        for (int testCase = 1; testCase <= testTotalCount; testCase++) {
            String s = in.nextLine();
            System.out.println(new String().format("Case #%s: %s", testCase, process(s)));
        }
    }

    public static String process(String s) {
        char[] arr = s.toCharArray();

        char last = '0';
        String newString = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > last) {
                newString += returnOpenWord(arr[i] - last) + arr[i];
            } else if (arr[i] < last) {
                newString += returnCloseWord(last - arr[i]) + arr[i];
            } else {
                newString += arr[i];
            }

            last = arr[i];
        }

        newString += returnCloseWord(last - '0');

        return newString;
    }

    public static String returnOpenWord(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += OPEN;
        }

        return result;
    }

    public static String returnCloseWord(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += CLOSE;
        }

        return result;
    }
}
