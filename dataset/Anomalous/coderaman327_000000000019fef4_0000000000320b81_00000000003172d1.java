import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            ArrayList<Long> slices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                slices.add(scanner.nextLong());
            }

            Collections.sort(slices);

            if (d == 2) {
                boolean found = false;
                for (int i = 0; i < n - 1; i++) {
                    if (slices.get(i).equals(slices.get(i + 1))) {
                        found = true;
                        break;
                    }
                }
                System.out.println("Case #" + caseNumber + ": " + (found ? 0 : 1));
            } else {
                int answer = 2;

                for (int i = 0; i < n - 2; i++) {
                    if (slices.get(i).equals(slices.get(i + 1)) && slices.get(i).equals(slices.get(i + 2))) {
                        answer = 0;
                        break;
                    }
                }

                if (answer == 2) {
                    for (int i = 0; i < n - 1; i++) {
                        if (slices.get(i).equals(slices.get(i + 1)) && slices.get(n - 1) >= 2 * slices.get(i)) {
                            answer = 1;
                            break;
                        }
                    }
                }

                if (answer == 2) {
                    for (int i = 0; i < n - 1; i++) {
                        long currentSize = slices.get(i);
                        boolean conditionMet = false;

                        for (int k = 0; k < n; k++) {
                            if (slices.get(k) == 2 * currentSize) {
                                conditionMet = true;
                                break;
                            }
                        }

                        if (conditionMet) {
                            answer = 1;
                            break;
                        }
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + answer);
            }
        }

        scanner.close();
    }
}