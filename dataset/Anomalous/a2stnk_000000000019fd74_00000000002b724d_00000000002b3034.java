import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            pw.printf("Case #%d: ", t + 1);
            processTestCase(sc, pw);
        }

        sc.close();
        pw.close();
    }

    static void processTestCase(Scanner sc, PrintWriter pw) {
        int numStrings = sc.nextInt();
        String[] strings = new String[numStrings];

        for (int i = 0; i < numStrings; i++) {
            strings[i] = sc.next();
        }

        String result = "*";
        for (String str : strings) {
            int resultPrefixIndex = result.indexOf('*');
            int strPrefixIndex = str.indexOf('*');

            int commonPrefixLength = Math.min(resultPrefixIndex, strPrefixIndex);
            if (!result.substring(0, commonPrefixLength).equals(str.substring(0, commonPrefixLength))) {
                pw.println("*");
                return;
            }
            if (resultPrefixIndex < strPrefixIndex) {
                result = str.substring(0, strPrefixIndex) + result.substring(resultPrefixIndex);
            }

            int resultSuffixIndex = result.lastIndexOf('*');
            int strSuffixIndex = str.lastIndexOf('*');

            int commonSuffixLength = Math.min(result.length() - resultSuffixIndex - 1, str.length() - strSuffixIndex - 1);
            if (!result.substring(result.length() - commonSuffixLength).equals(str.substring(str.length() - commonSuffixLength))) {
                pw.println("*");
                return;
            }
            if (result.length() - resultSuffixIndex - 1 < str.length() - strSuffixIndex - 1) {
                result = result.substring(0, resultSuffixIndex) + str.substring(strSuffixIndex);
            }

            String middlePart = str.substring(strPrefixIndex, strSuffixIndex + 1);
            int middleInsertPosition = result.indexOf('*');
            result = result.substring(0, middleInsertPosition) + middlePart + result.substring(middleInsertPosition + 1);
        }

        result = result.replace("*", "");
        pw.println(result);
    }
}