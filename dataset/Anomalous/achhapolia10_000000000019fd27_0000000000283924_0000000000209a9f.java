import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int index = 0;
            while (index < input.length()) {
                char currentChar = input.charAt(index);
                StringBuilder segment = new StringBuilder();
                
                while (index < input.length() && input.charAt(index) == currentChar) {
                    segment.append(currentChar);
                    index++;
                }
                
                int repeatCount = Character.getNumericValue(currentChar);
                for (int i = 0; i < repeatCount; i++) {
                    segment.insert(0, "(").append(")");
                }
                
                result.append(segment);
            }
            
            System.out.printf("Case #%d: %s%n", caseNum, result);
        }
        
        scanner.close();
    }
}