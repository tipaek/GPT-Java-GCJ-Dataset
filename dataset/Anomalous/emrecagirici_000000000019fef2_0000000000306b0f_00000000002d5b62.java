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
            
            Map<Integer, Integer> firstNumberSet = createCombination(first);
            Map<Integer, Integer> firstOptionalSet = createOptionalSet(first);
            
            Map<Integer, Integer> secondNumberSet = createCombination(second);
            Map<Integer, Integer> secondOptionalSet = createOptionalSet(second);
            
            processCase(i, firstNumberSet, firstOptionalSet, secondNumberSet, secondOptionalSet);
        }
    }

    private static Map<Integer, Integer> createCombination(int number) {
        Map<Integer, Integer> combination = new HashMap<>();
        if (number == 0) return combination;

        boolean isNegative = number < 0;
        if (isNegative) number = -number;

        int index = 0;
        while (number > 0) {
            if (number % 2 == 1) {
                combination.put(index, isNegative ? -1 : 1);
            }
            number /= 2;
            index++;
        }
        return combination;
    }

    private static Map<Integer, Integer> createOptionalSet(int number) {
        if (number == 0) return new HashMap<>();

        boolean isNegative = number < 0;
        if (isNegative) number = -number;

        Map<Integer, Integer> combination = createCombination(getRemainder(number));
        int maxPower = getMaxPower(number);
        return adjustSet(combination, maxPower, isNegative);
    }

    private static int getRemainder(int number) {
        int powerOfTwo = 1;
        while (powerOfTwo <= number) {
            powerOfTwo *= 2;
        }
        return powerOfTwo - number;
    }

    private static int getMaxPower(int number) {
        int powerOfTwo = 1;
        int power = 0;
        while (powerOfTwo <= number) {
            powerOfTwo *= 2;
            power++;
        }
        return power;
    }

    private static Map<Integer, Integer> adjustSet(Map<Integer, Integer> set, int maxPower, boolean isNegative) {
        set.replaceAll((k, v) -> v * -1);
        set.put(maxPower, 1);

        if (isNegative) {
            set.replaceAll((k, v) -> v * -1);
        }
        return set;
    }

    private static void processCase(int caseNumber, Map<Integer, Integer> firstNumberSet, Map<Integer, Integer> firstOptionalSet,
                                    Map<Integer, Integer> secondNumberSet, Map<Integer, Integer> secondOptionalSet) {
        if (isValidCombination(firstNumberSet, secondNumberSet)) {
            printResult(caseNumber, firstNumberSet, secondNumberSet);
        } else if (firstOptionalSet.size() > secondOptionalSet.size()) {
            if (isValidCombination(firstNumberSet, secondOptionalSet)) {
                printResult(caseNumber, firstNumberSet, secondOptionalSet);
            } else if (isValidCombination(firstOptionalSet, secondNumberSet)) {
                printResult(caseNumber, firstOptionalSet, secondNumberSet);
            } else if (isValidCombination(firstOptionalSet, secondOptionalSet)) {
                printResult(caseNumber, firstOptionalSet, secondOptionalSet);
            } else {
                printImpossible(caseNumber);
            }
        } else {
            if (isValidCombination(firstOptionalSet, secondNumberSet)) {
                printResult(caseNumber, firstOptionalSet, secondNumberSet);
            } else if (isValidCombination(firstNumberSet, secondOptionalSet)) {
                printResult(caseNumber, firstNumberSet, secondOptionalSet);
            } else if (isValidCombination(firstOptionalSet, secondOptionalSet)) {
                printResult(caseNumber, firstOptionalSet, secondOptionalSet);
            } else {
                printImpossible(caseNumber);
            }
        }
    }

    private static boolean isValidCombination(Map<Integer, Integer> set1, Map<Integer, Integer> set2) {
        int maxIndex = Math.max(set1.keySet().stream().max(Integer::compareTo).orElse(0),
                                set2.keySet().stream().max(Integer::compareTo).orElse(0));

        for (int i = 0; i <= maxIndex; i++) {
            if (set1.containsKey(i) == set2.containsKey(i)) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(int caseNumber, Map<Integer, Integer> set1, Map<Integer, Integer> set2) {
        System.out.println("Case #" + (caseNumber + 1) + ": " + decomposeSets(set1, set2));
    }

    private static void printImpossible(int caseNumber) {
        System.out.println("Case #" + (caseNumber + 1) + ": IMPOSSIBLE");
    }

    private static String decomposeSets(Map<Integer, Integer> set1, Map<Integer, Integer> set2) {
        StringBuilder result = new StringBuilder();
        int maxIndex = Math.max(set1.keySet().stream().max(Integer::compareTo).orElse(0),
                                set2.keySet().stream().max(Integer::compareTo).orElse(0));

        for (int i = 0; i <= maxIndex; i++) {
            if (set1.containsKey(i)) {
                result.append(set1.get(i) == 1 ? "E" : "W");
            } else if (set2.containsKey(i)) {
                result.append(set2.get(i) == 1 ? "N" : "S");
            }
        }
        return result.toString();
    }
}