import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalCases = scan.nextInt();
        for (int i = 0; i < totalCases; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();

            Map<Integer, Integer> firstNumberSet = setCombination(first);
            Map<Integer, Integer> firstOptionalSet = getOptionalSet(first);

            Map<Integer, Integer> secondNumberSet = setCombination(second);
            Map<Integer, Integer> secondOptionalSet = getOptionalSet(second);

            String result = getResult(firstNumberSet, firstOptionalSet, secondNumberSet, secondOptionalSet);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static Map<Integer, Integer> setCombination(int number) {
        Map<Integer, Integer> numbers = new HashMap<>();
        if (number == 0) return numbers;

        boolean negative = number < 0;
        if (negative) number = -number;

        int index = 0;
        while (number > 0) {
            if (number % 2 == 1) {
                numbers.put(index, negative ? -1 : 1);
            }
            number /= 2;
            index++;
        }
        return numbers;
    }

    private static Map<Integer, Integer> getOptionalSet(int number) {
        if (number == 0) return new HashMap<>();
        boolean negative = number < 0;
        if (negative) number = -number;

        Map<Integer, Integer> set = setCombination(getRemainder(number));
        return getNegativeSet(set, getMaxPower(number), negative);
    }

    private static Map<Integer, Integer> getNegativeSet(Map<Integer, Integer> map, int number, boolean negative) {
        Map<Integer, Integer> result = new HashMap<>(map);
        result.replaceAll((k, v) -> v * -1);
        result.put(number, 1);

        if (negative) {
            result.replaceAll((k, v) -> v * -1);
        }
        return result;
    }

    private static int getRemainder(int number) {
        int twoPower = 1;
        while (twoPower <= number) {
            twoPower *= 2;
        }
        return twoPower - number;
    }

    private static int getMaxPower(int number) {
        int twoPower = 1;
        int result = 0;
        while (twoPower <= number) {
            twoPower *= 2;
            result++;
        }
        return result;
    }

    private static boolean checkCombination(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        int max = Math.max(first.keySet().stream().max(Integer::compareTo).orElse(0),
                           second.keySet().stream().max(Integer::compareTo).orElse(0));

        for (int i = 0; i <= max; i++) {
            if (!(first.containsKey(i) ^ second.containsKey(i))) {
                return false;
            }
        }
        return true;
    }

    private static String getDecompose(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        StringBuilder result = new StringBuilder();
        int max = Math.max(first.keySet().stream().max(Integer::compareTo).orElse(0),
                           second.keySet().stream().max(Integer::compareTo).orElse(0));

        for (int i = 0; i <= max; i++) {
            if (first.containsKey(i)) {
                result.append(first.get(i) == 1 ? "E" : "W");
            } else {
                result.append(second.get(i) == 1 ? "N" : "S");
            }
        }
        return result.toString();
    }

    private static String getResult(Map<Integer, Integer> firstNumberSet, Map<Integer, Integer> firstOptionalSet,
                                    Map<Integer, Integer> secondNumberSet, Map<Integer, Integer> secondOptionalSet) {
        if (checkCombination(firstNumberSet, secondNumberSet)) {
            return getDecompose(firstNumberSet, secondNumberSet);
        } else if (checkCombination(firstOptionalSet, secondNumberSet)) {
            return getDecompose(firstOptionalSet, secondNumberSet);
        } else if (checkCombination(firstNumberSet, secondOptionalSet)) {
            return getDecompose(firstNumberSet, secondOptionalSet);
        } else if (checkCombination(firstOptionalSet, secondOptionalSet)) {
            return getDecompose(firstOptionalSet, secondOptionalSet);
        } else {
            return "IMPOSSIBLE";
        }
    }
}