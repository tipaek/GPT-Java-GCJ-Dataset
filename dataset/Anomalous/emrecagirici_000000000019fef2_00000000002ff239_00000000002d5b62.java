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
            Map<Integer, Integer> firstOptionalSet = getOptionalSet(first);
            
            Map<Integer, Integer> secondNumberSet = createCombination(second);
            Map<Integer, Integer> secondOptionalSet = getOptionalSet(second);
            
            String result = "Case #" + (i + 1) + ": ";
            if (first == 0 && second == 0) {
                System.out.println(result);
            } else if (isCombinationValid(firstNumberSet, secondNumberSet)) {
                System.out.println(result + decompose(firstNumberSet, secondNumberSet));
            } else if (isCombinationValid(firstNumberSet, secondOptionalSet)) {
                System.out.println(result + decompose(firstNumberSet, secondOptionalSet));
            } else if (isCombinationValid(firstOptionalSet, secondNumberSet)) {
                System.out.println(result + decompose(firstOptionalSet, secondNumberSet));
            } else if (isCombinationValid(firstOptionalSet, secondOptionalSet)) {
                System.out.println(result + decompose(firstOptionalSet, secondOptionalSet));
            } else {
                System.out.println(result + "IMPOSSIBLE");
            }
        }
    }

    private static Map<Integer, Integer> createCombination(int number) {
        Map<Integer, Integer> combination = new HashMap<>();
        if (number == 0) {
            return combination;
        }
        
        boolean isNegative = number < 0;
        if (isNegative) {
            number = -number;
        }
        
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

    private static Map<Integer, Integer> getOptionalSet(int number) {
        if (number == 0) {
            return new HashMap<>();
        }
        
        boolean isNegative = number < 0;
        if (isNegative) {
            number = -number;
        }
        
        Map<Integer, Integer> combination = createCombination(getRemainder(number));
        int maxPower = getMaxPower(number);
        combination.put(maxPower, 1);
        
        if (isNegative) {
            combination.replaceAll((k, v) -> -v);
        }
        
        return combination;
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
        int maxPower = 0;
        while (powerOfTwo <= number) {
            powerOfTwo *= 2;
            maxPower++;
        }
        return maxPower;
    }

    private static boolean isCombinationValid(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        int maxIndex = Math.max(
            first.keySet().stream().max(Integer::compareTo).orElse(0),
            second.keySet().stream().max(Integer::compareTo).orElse(0)
        );
        
        for (int i = 0; i <= maxIndex; i++) {
            if (first.containsKey(i) == second.containsKey(i)) {
                return false;
            }
        }
        return true;
    }

    private static String decompose(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        StringBuilder result = new StringBuilder();
        int maxIndex = Math.max(
            first.keySet().stream().max(Integer::compareTo).orElse(0),
            second.keySet().stream().max(Integer::compareTo).orElse(0)
        );
        
        for (int i = 0; i <= maxIndex; i++) {
            if (first.containsKey(i)) {
                result.append(first.get(i) == 1 ? "E" : "W");
            } else {
                result.append(second.get(i) == 1 ? "N" : "S");
            }
        }
        
        return result.toString();
    }
}