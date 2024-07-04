import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = getScanner();
        int caseNum = readLineToInt(sc);
        for(int caseIndex = 1; caseIndex <= caseNum; caseIndex ++) {
            String digits = sc.nextLine();
            System.out.println(String.format("Case #%s: %s", caseIndex, solve(digits)));
        }
    }

    private static String solve(String str) {
        StringBuilder builder = new StringBuilder();
        int[] digits = new int[str.length()];
        for(int i=0; i<str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        appendNChars(builder, digits[0]);
        builder.append((char)(digits[0] + '0'));
        for(int i=1; i<digits.length; i++) {
            appendNChars(builder, digits[i] - digits[i-1]);
            builder.append((char)(digits[i] + '0'));
        }
        appendNChars(builder, -digits[digits.length - 1]);
        return builder.toString();
    }

    private static void appendNChars(StringBuilder builder, int n) {
        char c = n > 0 ? '(' : ')';
        n = Math.abs(n);
        for(int i=0; i<n; i++) {
            builder.append(c);
        }
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
        // try {
        //     return new Scanner(new FileInputStream("input2.txt"));
        // } catch (Exception x) {
        //     return null;
        // }
    }

    private static int readLineToInt(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    private static int[] readLineToInts(Scanner sc) {
        String line = sc.nextLine();
        return Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
