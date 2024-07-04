import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                String[] input = scanner.nextLine().trim().split(" ");
                int n = Integer.parseInt(input[0]);
                int d = Integer.parseInt(input[1]);
                
                input = scanner.nextLine().trim().split(" ");
                HashMap<BigInteger, Integer> sizes = new HashMap<>();
                
                for (String value : input) {
                    BigInteger key = new BigInteger(value);
                    sizes.put(key, sizes.getOrDefault(key, 0) + 1);
                }
                
                int result;
                if (d == 2) {
                    result = solveForTwo(sizes);
                } else if (d == 3) {
                    result = solveForThree(sizes);
                } else {
                    result = solveForLarger(sizes, d);
                }
                
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }

    private static int solveForTwo(HashMap<BigInteger, Integer> sizes) {
        for (int count : sizes.values()) {
            if (count > 1) {
                return 0;
            }
        }
        return 1;
    }

    private static int solveForThree(HashMap<BigInteger, Integer> sizes) {
        int maxCuts = 2;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger smallestDouble = null;
        
        for (BigInteger key : sizes.keySet()) {
            int count = sizes.get(key);
            if (count > 2) {
                return 0;
            } else if (sizes.containsKey(key.multiply(two))) {
                maxCuts = 1;
            } else if (count > 1) {
                if (smallestDouble == null) {
                    smallestDouble = key;
                } else {
                    smallestDouble = smallestDouble.min(key);
                }
            }
        }
        
        if (maxCuts == 2 && smallestDouble != null) {
            for (BigInteger key : sizes.keySet()) {
                if (key.compareTo(smallestDouble) > 0) {
                    maxCuts = 1;
                }
            }
        }
        
        return maxCuts;
    }

    private static int solveForLarger(HashMap<BigInteger, Integer> sizes, int d) {
        int[][] factorCounts = new int[301][301];
        BigInteger[] numbers = new BigInteger[301];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = BigInteger.valueOf(i);
        }
        
        for (BigInteger key : sizes.keySet()) {
            for (int i = 1; i < numbers.length; i++) {
                BigInteger[] divisionResult = key.divideAndRemainder(numbers[i]);
                if (divisionResult[1].equals(BigInteger.ZERO)) {
                    factorCounts[i][divisionResult[0].intValue()] += sizes.get(key);
                } else {
                    factorCounts[i][0] += divisionResult[0].intValue() * sizes.get(key);
                }
            }
        }
        
        int bestCuts = -1;
        for (int i = 1; i < 301; i++) {
            int cuts = calculateCuts(factorCounts, d, i);
            if (bestCuts == -1) {
                bestCuts = cuts;
            } else if (cuts != -1) {
                bestCuts = Math.min(bestCuts, cuts);
            }
        }
        
        return bestCuts;
    }

    private static int calculateCuts(int[][] factorCounts, int d, int index) {
        int total = 0;
        int cuts = 0;
        
        for (int i = 1; i < factorCounts.length; i++) {
            total += i * factorCounts[index][i];
            cuts += factorCounts[index][i] * (i - 1);
            
            if (total >= d) {
                while (total >= d + 2) {
                    if (total >= d + i) {
                        total -= i;
                        cuts -= (i - 1);
                    } else {
                        cuts -= total - d - 1;
                        total = d;
                    }
                }
                return cuts;
            }
        }
        
        if (total + factorCounts[index][0] >= d) {
            return cuts + d - total;
        }
        
        return -1;
    }
}