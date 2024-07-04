import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String inputString = sc.next();
            List<Character> resultList = new ArrayList<>();
            char currentChar = inputString.charAt(0);
            int currentNum = Character.getNumericValue(currentChar);
            boolean isFirstChar = true;
            
            for (int i = 0; i < inputString.length(); i++) {
                char nextChar = inputString.charAt(i);
                int nextNum = Character.getNumericValue(nextChar);
                
                if (isFirstChar && currentChar == nextChar) {
                    addChars(resultList, '(', currentNum);
                    resultList.add(nextChar);
                    isFirstChar = false;
                } else if (!isFirstChar && currentChar == nextChar) {
                    resultList.add(nextChar);
                } else if (currentChar != nextChar) {
                    addChars(resultList, ')', currentNum);
                    currentChar = nextChar;
                    currentNum = nextNum;
                    addChars(resultList, '(', currentNum);
                    resultList.add(nextChar);
                }
                
                if (i == inputString.length() - 1) {
                    addChars(resultList, ')', currentNum);
                }
            }
            
            char[] resultArray = convertListToArray(resultList);
            resultArray = removeAdjacentPairs(resultArray);
            
            System.out.print("Case #" + caseNum + ": ");
            for (char ch : resultArray) {
                if (ch != 'x') {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
    
    private static void addChars(List<Character> list, char ch, int count) {
        for (int i = 0; i < count; i++) {
            list.add(ch);
        }
    }
    
    private static char[] convertListToArray(List<Character> list) {
        char[] array = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    private static char[] removeAdjacentPairs(char[] array) {
        List<Character> list = new ArrayList<>();
        for (char ch : array) {
            list.add(ch);
        }
        
        boolean hasAdjacentPairs;
        do {
            hasAdjacentPairs = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) == '(' && list.get(i - 1) == ')') {
                    list.set(i, 'x');
                    list.set(i - 1, 'x');
                    hasAdjacentPairs = true;
                }
            }
            list.removeIf(ch -> ch == 'x');
        } while (hasAdjacentPairs);
        
        return convertListToArray(list);
    }
}