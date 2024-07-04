import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int length = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < length; j++) {
                System.out.println(j + 1);
                System.out.flush();
                char inputChar = scanner.next().charAt(0);
                result.append(inputChar);
            }
            
            System.out.println(result);
            System.out.flush();
            
            char continueChar = scanner.next().charAt(0);
            if (continueChar == 'N') {
                break;
            }
        }
    }
}