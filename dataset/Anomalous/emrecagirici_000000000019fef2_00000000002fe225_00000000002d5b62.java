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
            
            Map<Integer, Integer> firstNumberSet = createCombinationSet(first);
            Map<Integer, Integer> firstOptionalSet = createOptionalSet(first);
            
            Map<Integer, Integer> secondNumberSet = createCombinationSet(second);
            Map<Integer, Integer> secondOptionalSet = createOptionalSet(second);
            
            String result = "Case #" + (i + 1) + ": ";
            if (isValidCombination(firstNumberSet, secondNumberSet)) {
                result += decomposeSets(firstNumberSet, secondNumberSet);
            } else if (isValidCombination(firstNumberSet, secondOptionalSet)) {
                result += decomposeSets(firstNumberSet, secondOptionalSet);
            } else if (isValidCombination(firstOptionalSet, secondNumberSet)) {
                result += decomposeSets(firstOptionalSet, secondNumberSet);
            } else if (isValidCombination(firstOptionalSet, secondOptionalSet)) {
                result += decomposeSets(firstOptionalSet, secondOptionalSet);
            } else {
                result += "IMPOSSIBLE";
            }
            System.out.println(result);
        }
    }
    
    private static Map<Integer, Integer> createCombinationSet(int number) {
        Map<Integer, Integer> combinationSet = new HashMap<>();
        boolean isNegative = number < 0;
        if (isNegative) number = -number;
        
        int index = 0;
        while (number > 0) {
            if (number % 2 == 1) {
                combinationSet.put(index, isNegative ? -1 : 1);
            }
            number /= 2;
            index++;
        }
        return combinationSet;
    }
    
    private static Map<Integer, Integer> createOptionalSet(int number) {
        boolean isNegative = number < 0;
        if (isNegative) number = -number;
        
        Map<Integer, Integer> combinationSet = createCombinationSet(getRemainder(number));
        int maxPower = getMaxPower(number);
        
        for (Map.Entry<Integer, Integer> entry : combinationSet.entrySet()) {
            combinationSet.put(entry.getKey(), entry.getValue() * -1);
        }
        combinationSet.put(maxPower, 1);
        
        if (isNegative) {
            for (Map.Entry<Integer, Integer> entry : combinationSet.entrySet()) {
                combinationSet.put(entry.getKey(), entry.getValue() * -1);
            }
        }
        return combinationSet;
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
    
    private static boolean isValidCombination(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        int maxKey = Math.max(first.keySet().stream().max(Integer::compare).orElse(0),
                              second.keySet().stream().max(Integer::compare).orElse(0));
        
        for (int i = 0; i <= maxKey; i++) {
            if (!(first.containsKey(i) ^ second.containsKey(i))) {
                return false;
            }
        }
        return true;
    }
    
    private static String decomposeSets(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        StringBuilder decomposition = new StringBuilder();
        int maxKey = Math.max(first.keySet().stream().max(Integer::compare).orElse(0),
                              second.keySet().stream().max(Integer::compare).orElse(0));
        
        for (int i = 0; i <= maxKey; i++) {
            if (first.containsKey(i)) {
                decomposition.append(first.get(i) == 1 ? "E" : "W");
            } else {
                decomposition.append(second.get(i) == 1 ? "N" : "S");
            }
        }
        return decomposition.toString();
    }
}