import java.util.Scanner;

class Solution {
    
    public static String appendBrackets(int count, char bracket) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previous = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int current = Character.getNumericValue(input.charAt(i));
                int difference = current - previous;
                
                if (difference > 0) {
                    result.append(appendBrackets(difference, '('));
                } else if (difference < 0) {
                    result.append(appendBrackets(-difference, ')'));
                }
                
                result.append(current);
                previous = current;
            }
            
            if (previous > 0) {
                result.append(appendBrackets(previous, ')'));
            }
            
            System.out.println(result.toString());
        }
        
        scanner.close();
    }
}