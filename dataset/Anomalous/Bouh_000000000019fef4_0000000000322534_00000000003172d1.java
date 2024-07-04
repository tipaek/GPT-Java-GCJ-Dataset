import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = solveProblem(scanner);
        System.out.println(result);
    }

    public static String solveProblem(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            List<BigInteger> integers = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                integers.add(new BigInteger(scanner.next()));
            }
            result.append("Case #").append(i).append(": ").append(solveCase(N, D, integers)).append("\n");
        }
        return result.toString().trim();
    }

    public static String solveCase(int N, int D, List<BigInteger> integers) {
        Map<BigInteger, Integer> countMap = new HashMap<>();
        int maxCount = 1;

        for (BigInteger integer : integers) {
            int currentCount = countMap.getOrDefault(integer, 0) + 1;
            countMap.put(integer, currentCount);
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }

        if (maxCount >= D) {
            return "0";
        }

        if (D == 2) {
            return "1";
        }

        for (BigInteger integer : integers) {
            if (integers.contains(integer.multiply(BigInteger.valueOf(2)))) {
                return "1";
            }
        }

        if (maxCount == 2) {
            BigInteger minInteger = new BigInteger("360000000001");
            for (BigInteger integer : integers) {
                if (countMap.get(integer) >= 2 && integer.compareTo(minInteger) < 0) {
                    minInteger = integer;
                }
            }
            for (BigInteger integer : integers) {
                if (!integer.equals(minInteger) && integer.compareTo(minInteger) > 0) {
                    return "1";
                }
            }
        }

        return "2";
    }
}