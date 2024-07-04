import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numOfSlices = scanner.nextInt();
            int divisor = scanner.nextInt();
            ArrayList<Long> slices = new ArrayList<>();
            
            for (int i = 0; i < numOfSlices; i++) {
                slices.add(scanner.nextLong());
            }
            
            Collections.sort(slices);
            int result = determineResult(slices, numOfSlices, divisor);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static int determineResult(ArrayList<Long> slices, int numOfSlices, int divisor) {
        if (divisor == 2) {
            return checkPairs(slices, numOfSlices);
        } else {
            return checkTriples(slices, numOfSlices);
        }
    }

    private static int checkPairs(ArrayList<Long> slices, int numOfSlices) {
        for (int i = 0; i < numOfSlices - 1; i++) {
            if (slices.get(i).equals(slices.get(i + 1))) {
                return 0;
            }
        }
        return 1;
    }

    private static int checkTriples(ArrayList<Long> slices, int numOfSlices) {
        for (int i = 0; i < numOfSlices - 2; i++) {
            if (slices.get(i).equals(slices.get(i + 1)) && slices.get(i).equals(slices.get(i + 2))) {
                return 0;
            }
        }

        for (int i = 0; i < numOfSlices - 1; i++) {
            if (slices.get(i).equals(slices.get(i + 1)) && i != numOfSlices - 2) {
                if (slices.get(numOfSlices - 1) >= slices.get(i)) {
                    return 1;
                }
            }
        }

        for (int i = 0; i < numOfSlices - 1; i++) {
            long currentSize = slices.get(i);
            if (slices.contains(2 * currentSize)) {
                return 1;
            }
        }

        return 2;
    }
}