import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int index = 0;
            while (index < input.length()) {
                StringBuilder group = new StringBuilder();
                char currentChar = input.charAt(index);
                
                while (index < input.length() && input.charAt(index) == currentChar) {
                    group.append(currentChar);
                    index++;
                }
                
                int repeatCount = Character.getNumericValue(currentChar);
                StringBuilder nestedGroup = new StringBuilder(group);
                
                for (int repeat = 0; repeat < repeatCount; repeat++) {
                    nestedGroup.insert(0, '(').append(')');
                }
                
                result.append(nestedGroup);
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}