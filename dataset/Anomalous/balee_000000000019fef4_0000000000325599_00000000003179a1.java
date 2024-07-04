import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static String process(Scanner scanner) {
        int U = scanner.nextInt();
        int[] maxCharPos = new int[255];
        Arrays.fill(maxCharPos, 99);

        for (int i = 0; i < 4000; i++) {
            char[] qDigits = scanner.next().toCharArray();
            char[] rDigits = scanner.next().toCharArray();

            if (qDigits.length == rDigits.length) {
                int digit = qDigits[0] - '0';
                if (digit < maxCharPos[rDigits[0]]) {
                    maxCharPos[rDigits[0]] = digit;
                }
            }

            for (char rDigit : rDigits) {
                if (maxCharPos[rDigit] > 10) {
                    maxCharPos[rDigit] = 10;
                }
            }
        }

        char[] result = new char[10];
        for (char i = 'A'; i <= 'Z'; i++) {
            if (maxCharPos[i] < 0) {
                return "X";
            }
            if (maxCharPos[i] <= 10) {
                if (maxCharPos[i] == 10) {
                    result[0] = i;
                } else {
                    result[maxCharPos[i]] = i;
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in.available() > 0 ? System.in :
                new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.printf("Case #%d: %s%n", i, process(scanner));
        }
    }
}