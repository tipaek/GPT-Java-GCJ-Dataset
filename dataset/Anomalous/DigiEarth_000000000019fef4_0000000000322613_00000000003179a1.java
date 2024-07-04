import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = initializeScanner();

        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int u = scanner.nextInt();
            List<Set<String>> possibleDigits = new ArrayList<>(Collections.nCopies(10, new HashSet<>()));

            for (int query = 0; query < 10000; query++) {
                String m = scanner.next();
                String r = scanner.next();

                if (m.length() == 1 || "10".equals(m)) {
                    int digit = Integer.parseInt(m);
                    possibleDigits.get(digit % 10).add(r);
                }
            }

            String[] digits = new String[10];
            for (int digit = 1; digit <= 10; digit++) {
                if (digit < 10) {
                    Set<String> currentSet = possibleDigits.get(digit);
                    for (int previousDigit = 1; previousDigit < digit; previousDigit++) {
                        possibleDigits.get(previousDigit).forEach(currentSet::remove);
                    }

                    digits[digit] = currentSet.iterator().next();
                    possibleDigits.get(0).remove(digits[digit]);
                } else {
                    digits[0] = String.valueOf(possibleDigits.get(0).iterator().next().charAt(1));
                }
            }

            String result = String.join("", digits);
            System.out.printf("Case #%d: %s%s", caseNumber, result, caseNumber != testCases ? "\n" : "");
        }
        scanner.close();
    }

    private static Scanner initializeScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}