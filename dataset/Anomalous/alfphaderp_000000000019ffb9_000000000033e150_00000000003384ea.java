import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCases;
    private BigInteger L, R;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            Solution solution = new Solution();
            solution.solve(i);
        }

        scanner.close();
    }

    private BigInteger sumUpTo(BigInteger number) {
        return number.multiply(number.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
    }

    private BigInteger calculateCost(BigInteger number) {
        BigInteger sum = sumUpTo(number.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2))).multiply(BigInteger.valueOf(2));
        if (number.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
            return sum;
        } else {
            return sum.add(number.divide(BigInteger.valueOf(2)));
        }
    }

    private boolean satisfiesCondition(BigInteger number, BigInteger smaller, BigInteger larger) {
        BigInteger smallerCost = calculateCost(number);
        BigInteger largerCost = calculateCost(number.add(BigInteger.ONE));
        return smallerCost.compareTo(smaller) <= 0 && largerCost.compareTo(larger) <= 0;
    }

    private void solve(int caseNumber) {
        readInput();

        BigInteger smaller, larger;
        if (L.compareTo(R) > 0) {
            smaller = R;
            larger = L;
        } else {
            smaller = L;
            larger = R;
        }

        BigInteger minGuess = BigInteger.ONE;
        BigInteger maxGuess = BigInteger.TEN;

        while (minGuess.compareTo(maxGuess) <= 0) {
            BigInteger guess = minGuess.add(maxGuess).divide(BigInteger.valueOf(2));
            if (satisfiesCondition(guess, smaller, larger)) {
                minGuess = guess.add(BigInteger.ONE);
            } else {
                maxGuess = guess.subtract(BigInteger.ONE);
            }
        }

        System.out.println("Case #" + caseNumber + ": " + maxGuess + " " + maxGuess + " " + maxGuess);
    }

    private void readInput() {
        L = new BigInteger(scanner.next());
        R = new BigInteger(scanner.next());
    }
}