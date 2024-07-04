import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = createScanner();
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int u = scanner.nextInt();
            List<Set<String>> possibleDigits = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                possibleDigits.add(new HashSet<>());
            }

            for (int j = 0; j < 10000; j++) {
                String m = scanner.next();
                String r = scanner.next();

                if (m.length() == 1 || m.equals("10")) {
                    int val = Integer.parseInt(m);
                    possibleDigits.get(val % 10).add(r);
                }
            }

            String[] digits = new String[10];
            for (int i = 1; i <= 10; i++) {
                if (i < 10) {
                    Set<String> currentSet = possibleDigits.get(i);
                    for (int k = 1; k < i; k++) {
                        possibleDigits.get(k).forEach(currentSet::remove);
                    }
                    digits[i] = currentSet.iterator().next();
                } else {
                    digits[0] = possibleDigits.get(0).stream()
                                               .filter(d -> d.length() == 2)
                                               .findFirst()
                                               .get()
                                               .charAt(1) + "";
                }
            }

            String answer = String.join("", digits);
            System.out.printf("Case #%d: %s%s", caseNumber, answer, caseNumber != testCases ? "\n" : "");
        }
        scanner.close();
    }

    private static Scanner createScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}