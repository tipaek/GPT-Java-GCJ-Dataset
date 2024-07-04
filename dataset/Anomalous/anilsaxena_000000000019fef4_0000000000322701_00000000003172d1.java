import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N, D;
    private static BigDecimal[] A;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream("input.in"));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCount = scanner.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = scanner.nextInt();
            D = scanner.nextInt();
            A = new BigDecimal[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextBigDecimal();
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        Map<BigDecimal, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 1;

        for (BigDecimal cake : A) {
            frequencyMap.put(cake, frequencyMap.getOrDefault(cake, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(cake));
        }

        if (maxFrequency >= D) {
            return "0";
        }

        if (D == 2) {
            return 1;
        }

        BigDecimal two = BigDecimal.valueOf(2);
        for (Map.Entry<BigDecimal, Integer> entry1 : frequencyMap.entrySet()) {
            for (Map.Entry<BigDecimal, Integer> entry2 : frequencyMap.entrySet()) {
                if (entry2.getKey().compareTo(entry1.getKey()) < 0 && entry2.getValue() >= 2) {
                    return 1;
                }
            }
            if (frequencyMap.containsKey(entry1.getKey().divide(two))) {
                return 1;
            }
        }

        return 2;
    }

    private static String joinValues(List<?> list, String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private static String joinValues(int[] array, String delimiter) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(delimiter));
    }

    private static int[] readInts(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printDebug(Object message) {
        if (debug) {
            System.out.println("DEBUG: " + message);
        }
    }
}