import java.io.FileInputStream;
import java.util.*;

public class Solution {

    private static String process(Scanner scanner) {
        int U = scanner.nextInt();
        List<Set<Integer>> characterSets = new ArrayList<>(16);
        for (int i = 0; i < 16; i++) {
            characterSets.add(new HashSet<>());
        }

        int[] maxCharPositions = new int[255];
        Arrays.fill(maxCharPositions, 99);

        for (char c = 'A'; c <= 'Z'; c++) {
            maxCharPositions[c] = 99;
        }

        for (int i = 0; i < 4000; i++) {
            char[] qDigits = scanner.next().toCharArray();
            char[] rDigits = scanner.next().toCharArray();

            if (qDigits.length == rDigits.length) {
                int digit = qDigits[0] - '0';
                if (digit < maxCharPositions[rDigits[0]]) {
                    maxCharPositions[rDigits[0]] = digit;
                }
            }

            for (char rDigit : rDigits) {
                if (maxCharPositions[rDigit] > 10) {
                    maxCharPositions[rDigit] = 10;
                }
            }
        }

        char[] result = new char[10];
        for (char c = 'A'; c <= 'Z'; c++) {
            if (maxCharPositions[c] <= 10) {
                System.out.println(c + " " + maxCharPositions[c]);
                if (maxCharPositions[c] == 10) {
                    result[0] = c;
                } else {
                    result[maxCharPositions[c]] = c;
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
            System.out.format("Case #%d: %s\n", i, process(scanner));
        }
    }
}