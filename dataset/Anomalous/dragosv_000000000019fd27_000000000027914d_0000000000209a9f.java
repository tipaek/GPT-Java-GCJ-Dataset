import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            char[] charArray = inputString.toCharArray();
            int currentDepth = 0;
            
            for (char character : charArray) {
                int targetDepth = character - '0';
                
                while (currentDepth < targetDepth) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > targetDepth) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(character);
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