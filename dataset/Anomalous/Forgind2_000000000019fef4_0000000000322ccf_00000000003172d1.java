import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String[] initialInput = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(initialInput[0]);
            int d = Integer.parseInt(initialInput[1]);

            String[] sizesInput = scanner.nextLine().trim().split(" ");
            HashMap<BigInteger, Integer> sizesMap = new HashMap<>();

            for (String sizeStr : sizesInput) {
                BigInteger size = new BigInteger(sizeStr);
                sizesMap.put(size, sizesMap.getOrDefault(size, 0) + 1);
            }

            int result;
            if (d == 2) {
                result = solveForD2(sizesMap);
            } else if (d == 3) {
                result = solveForD3(sizesMap);
            } else {
                result = -1; // handle other values of d if necessary
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }

    private static int solveForD2(HashMap<BigInteger, Integer> sizesMap) {
        for (int count : sizesMap.values()) {
            if (count > 1) {
                return 0;
            }
        }
        return 1;
    }

    private static int solveForD3(HashMap<BigInteger, Integer> sizesMap) {
        int maxResult = 2;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger smallestDouble = null;

        for (BigInteger size : sizesMap.keySet()) {
            int count = sizesMap.get(size);

            if (count > 2) {
                return 0;
            } else if (sizesMap.containsKey(size.multiply(two))) {
                maxResult = 1;
            } else if (count > 1) {
                if (smallestDouble == null) {
                    smallestDouble = size;
                } else {
                    smallestDouble = smallestDouble.min(size);
                }
            }
        }

        if (maxResult == 2 && smallestDouble != null) {
            for (BigInteger size : sizesMap.keySet()) {
                if (size.compareTo(smallestDouble) > 0) {
                    maxResult = 1;
                }
            }
        }

        return maxResult;
    }
}