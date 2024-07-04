import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = getScanner();

        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int u = scanner.nextInt();
            List<Set<String>> possibleDigits = initializePossibleDigits();

            for (int j = 0; j < 10000; j++) {
                String m = scanner.next();
                String r = scanner.next();

                if (m.length() == 1 || "10".equals(m)) {
                    int val = Integer.parseInt(m);
                    possibleDigits.get(val % 10).add(r);
                }
            }

            String[] digits = determineDigits(possibleDigits);
            String answer = String.join("", digits);
            System.out.printf("Case #%d: %s%s", caseNum, answer, caseNum != testCases ? "\n" : "");
        }
        scanner.close();
    }

    private static List<Set<String>> initializePossibleDigits() {
        List<Set<String>> possibleDigits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            possibleDigits.add(new HashSet<>());
        }
        return possibleDigits;
    }

    private static String[] determineDigits(List<Set<String>> possibleDigits) {
        String[] digits = new String[10];
        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                Set<String> currentSet = possibleDigits.get(i);
                for (int j = 1; j < i; j++) {
                    possibleDigits.get(j).forEach(currentSet::remove);
                }
                digits[i] = currentSet.stream().findFirst().orElse("?");
            } else {
                digits[0] = possibleDigits.get(0).stream()
                        .filter(d -> d.length() == 2)
                        .map(d -> String.valueOf(d.charAt(1)))
                        .findFirst()
                        .orElse("?");
            }
        }
        return digits;
    }

    private static Scanner getScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}