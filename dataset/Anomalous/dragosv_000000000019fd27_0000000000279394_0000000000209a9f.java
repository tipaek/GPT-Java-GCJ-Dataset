import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (char digitChar : inputString.toCharArray()) {
                int targetDepth = Character.getNumericValue(digitChar);
                
                while (currentDepth < targetDepth) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > targetDepth) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(digitChar);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}