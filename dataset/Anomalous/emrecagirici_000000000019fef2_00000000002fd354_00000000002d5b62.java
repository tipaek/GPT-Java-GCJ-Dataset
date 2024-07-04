import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        
        for (int i = 0; i < totalCases; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            
            Map<Integer, Integer> firstNumberSet = createCombination(first);
            Map<Integer, Integer> firstOptionalSet = createNegativeSet(createCombination(getRemainder(first)), getMaxPower(first));
            
            Map<Integer, Integer> secondNumberSet = createCombination(second);
            Map<Integer, Integer> secondOptionalSet = createNegativeSet(createCombination(getRemainder(second)), getMaxPower(second));
            
            String result = "Case #" + (i + 1) + ": ";
            
            if (isValidCombination(firstNumberSet, secondNumberSet)) {
                result += decompose(firstNumberSet, secondNumberSet);
            } else if (isValidCombination(firstNumberSet, secondOptionalSet)) {
                result += decompose(firstNumberSet, secondOptionalSet);
            } else if (isValidCombination(firstOptionalSet, secondNumberSet)) {
                result += decompose(firstOptionalSet, secondNumberSet);
            } else if (isValidCombination(firstOptionalSet, secondOptionalSet)) {
                result += decompose(firstOptionalSet, secondOptionalSet);
            } else {
                result += "IMPOSSIBLE";
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    private static Map<Integer, Integer> createCombination(int number) {
        Map<Integer, Integer> combination = new HashMap<>();
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
    
    private static Map<Integer, Integer> createNegativeSet(Map<Integer, Integer> map, int maxPower) {
        Map<Integer, Integer> negativeSet = new HashMap<>(map);
        
        for (Map.Entry<Integer, Integer> entry : negativeSet.entrySet()) {
            negativeSet.put(entry.getKey(), entry.getValue() * -1);
        }
        
        negativeSet.put(maxPower, 1);
        return negativeSet;
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
    
    private static boolean isValidCombination(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        int maxPower = Math.max(first.keySet().stream().max(Integer::compareTo).orElse(0),
                                second.keySet().stream().max(Integer::compareTo).orElse(0));
        
        for (int i = 0; i <= maxPower; i++) {
            if (!(first.containsKey(i) ^ second.containsKey(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    private static String decompose(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        StringBuilder result = new StringBuilder();
        int maxPower = Math.max(first.keySet().stream().max(Integer::compareTo).orElse(0),
                                second.keySet().stream().max(Integer::compareTo).orElse(0));
        
        for (int i = 0; i <= maxPower; i++) {
            if (first.containsKey(i)) {
                result.append(first.get(i) == 1 ? "E" : "W");
            } else {
                result.append(second.get(i) == 1 ? "N" : "S");
            }
        }
        
        return result.toString();
    }
}