import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println(solveProblem(scanner));
    }

    public static String solveProblem(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
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
            countMap.put(integer, countMap.getOrDefault(integer, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(integer));
        }

        if (maxCount >= D) {
            return "0";
        }

        if (D == 2) {
            return "1";
        }

        if (maxCount == 1) {
            for (BigInteger a : integers) {
                for (BigInteger b : integers) {
                    if (b.equals(a.multiply(BigInteger.valueOf(2)))) {
                        return "1";
                    }
                }
            }
            return "2";
        }

        if (maxCount == 2) {
            BigInteger minDoubleOccurrence = new BigInteger("360000000001");
            for (BigInteger integer : integers) {
                if (countMap.get(integer) >= 2 && integer.compareTo(minDoubleOccurrence) < 0) {
                    minDoubleOccurrence = integer;
                }
            }
            for (BigInteger integer : integers) {
                if (!integer.equals(minDoubleOccurrence) && integer.compareTo(minDoubleOccurrence) > 0) {
                    return "1";
                }
            }
        }

        return "2";
    }
}