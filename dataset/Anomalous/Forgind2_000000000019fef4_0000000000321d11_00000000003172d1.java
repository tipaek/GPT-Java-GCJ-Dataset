import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] firstLine = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int d = Integer.parseInt(firstLine[1]);

            String[] secondLine = scanner.nextLine().trim().split(" ");
            HashMap<BigInteger, Integer> sizes = new HashMap<>();

            for (String value : secondLine) {
                BigInteger key = new BigInteger(value);
                sizes.put(key, sizes.getOrDefault(key, 0) + 1);
            }

            if (d == 2) {
                System.out.println("Case #" + caseNumber + ": " + solveForD2(sizes));
            } else if (d == 3) {
                System.out.println("Case #" + caseNumber + ": " + solveForD3(sizes));
            } else {
                System.out.println("Case #" + caseNumber + ": ");
            }
        }

        scanner.close();
    }

    private static int solveForD2(HashMap<BigInteger, Integer> sizes) {
        for (int count : sizes.values()) {
            if (count > 1) {
                return 0;
            }
        }
        return 1;
    }

    private static int solveForD3(HashMap<BigInteger, Integer> sizes) {
        int result = 2;
        BigInteger two = BigInteger.valueOf(2);

        for (BigInteger key : sizes.keySet()) {
            int count = sizes.get(key);
            if (count > 2) {
                return 0;
            } else if (sizes.containsKey(key.multiply(two))) {
                result = 1;
            }
        }

        return result;
    }
}