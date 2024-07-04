import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            Stack<Character> stack = new Stack<>();
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                for (int i = 0; i < digit; i++) {
                    stack.push('(');
                }
                
                stack.push(ch);
                
                for (int i = 0; i < digit; i++) {
                    stack.push(')');
                }
            }
            
            List<Character> resultList = new ArrayList<>();
            while (!stack.isEmpty()) {
                resultList.add(stack.pop());
            }
            
            for (int i = 0; i < resultList.size() - 1; i++) {
                if (resultList.get(i) == '(' && resultList.get(i + 1) == ')') {
                    resultList.remove(i + 1);
                    resultList.remove(i);
                    i -= 2;
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = resultList.size() - 1; i >= 0; i--) {
                result.append(resultList.get(i));
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}