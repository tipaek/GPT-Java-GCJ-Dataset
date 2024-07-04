import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            
            int u = scanner.nextInt();
            Map<Character, Set<Integer>> charToPossibleDigits = new HashMap<>();
            Map<Integer, Character> digitToChar = new HashMap<>();
            long maxQueries = (long) Math.pow(10, 4);
            
            for (int i = 1; i <= maxQueries; i++) {
                int q = scanner.nextInt();
                String r = scanner.next();
                
                if (r.length() == 1) {
                    char c = r.charAt(0);
                    Set<Integer> possibles = charToPossibleDigits.computeIfAbsent(c, k -> initializeSet());
                    possibles.remove(0);
                    eliminateHigherDigits(q, possibles);
                }
                
                if (r.length() == String.valueOf(q).length()) {
                    String qStr = String.valueOf(q);
                    char c = r.charAt(0);
                    Set<Integer> possibles = charToPossibleDigits.computeIfAbsent(c, k -> initializeSet());
                    possibles.remove(0);
                    eliminateHigherDigits(Character.getNumericValue(qStr.charAt(0)), possibles);
                    
                    int index = 0;
                    while (index < qStr.length() && getDigitAt(index, q) != 1) {
                        index++;
                    }
                    
                    index++;
                    if (index > 0 && index < qStr.length()) {
                        c = r.charAt(index);
                        possibles = charToPossibleDigits.computeIfAbsent(c, k -> initializeSet());
                        eliminateHigherDigits(getDigitAt(index, q), possibles);
                    }
                }
                
                charToPossibleDigits.forEach((charKey, possibleDigits) -> {
                    if (possibleDigits.size() == 1) {
                        digitToChar.put(possibleDigits.iterator().next(), charKey);
                    }
                });
                
                charToPossibleDigits.forEach((charKey, possibleDigits) -> digitToChar.keySet().forEach(possibleDigits::remove));
            }
            
            for (int i = 0; i <= 9; i++) {
                System.out.print(digitToChar.get(i));
            }
            System.out.println();
        }
    }

    private static int getDigitAt(int index, int number) {
        return Character.getNumericValue(String.valueOf(number).charAt(index));
    }

    private static void eliminateHigherDigits(int digit, Set<Integer> possibles) {
        if (digit < 9) {
            for (int i = digit + 1; i <= 9; i++) {
                possibles.remove(i);
            }
        }
    }

    private static Set<Integer> initializeSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            set.add(i);
        }
        return set;
    }
}