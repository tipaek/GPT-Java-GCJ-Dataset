import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < 10; j++) {
                System.out.println(j + 1);
                System.out.flush();
                
                char inputChar = scanner.next().charAt(0);
                result.append(inputChar);
            }
            
            System.out.println(result.toString());
            System.out.flush();
            
            char continueResponse = scanner.next().charAt(0);
            if (continueResponse == 'N' || continueResponse == 'n') {
                break;
            }
        }
        
        scanner.close();
    }
}