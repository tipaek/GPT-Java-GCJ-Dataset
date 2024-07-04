import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws java.io.IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            ArrayList<Long> slices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                slices.add(scanner.nextLong());
            }

            Collections.sort(slices);

            if (d == 2) {
                int result = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (slices.get(i).equals(slices.get(i + 1))) {
                        result = 0;
                        break;
                    }
                }
                System.out.println("Case #" + testCase + ": " + result);
            } else {
                int result = 2;
                for (int i = 0; i < n - 2; i++) {
                    if (slices.get(i).equals(slices.get(i + 1)) && slices.get(i).equals(slices.get(i + 2))) {
                        result = 0;
                        break;
                    }
                }

                if (result == 2) {
                    for (int i = 0; i < n - 1; i++) {
                        if (slices.get(i).equals(slices.get(i + 1)) && slices.get(n - 1) >= slices.get(i)) {
                            result = 1;
                            break;
                        }
                    }
                }

                if (result == 2) {
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
                            result = 1;
                            break;
                        }
                    }
                }

                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}