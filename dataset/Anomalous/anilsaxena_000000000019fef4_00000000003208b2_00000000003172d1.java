import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N, D;
    private static BigDecimal[] A;

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
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

        BigDecimal half = BigDecimal.valueOf(0.5);
        for (BigDecimal cake : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(cake.multiply(half))) {
                return "1";
            }
        }

        return "2";
    }

    private static Long getMaxKey(Map<Long, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String joinValues(List<?> list, String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private static String joinValues(int[] array, String delimiter) {
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(delimiter));
    }

    private static int[] readInts(Scanner scanner, int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printDebug(Object message) {
        if (debug) {
            System.out.println("DEBUG: " + message);
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }
}