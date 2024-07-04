import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            StringBuilder result = new StringBuilder();
            int position = 1;
            
            while (position <= 10) {
                System.out.println(position);
                String response = scanner.next();
                
                if (response.charAt(0) == 'N') {
                    System.exit(0);
                }
                
                result.append(response);
                position++;
            }
            
            System.out.println(result.toString());
            String finalResponse = scanner.next();
            
            if (finalResponse.charAt(0) != 'Y') {
                System.exit(0);
            }
        }
    }
}