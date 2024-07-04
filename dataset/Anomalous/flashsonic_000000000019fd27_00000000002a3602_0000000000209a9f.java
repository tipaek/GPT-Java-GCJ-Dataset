import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int cases = scanner.nextInt();
        scanner.nextLine();
        
        for (int n = 0; n < cases; n++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            
            int previous = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int current = Character.getNumericValue(input.charAt(i));
                
                if (current > previous) {
                    for (int j = 0; j < current - previous; j++) {
                        result.append('(');
                    }
                } else if (current < previous) {
                    for (int j = 0; j < previous - current; j++) {
                        result.append(')');
                    }
                }
                
                result.append(current);
                previous = current;
            }
            
            for (int j = 0; j < previous; j++) {
                result.append(')');
            }
            
            System.out.println("Case #" + (n + 1) + ": " + result.toString());
        }
        
        scanner.close();
    }
}