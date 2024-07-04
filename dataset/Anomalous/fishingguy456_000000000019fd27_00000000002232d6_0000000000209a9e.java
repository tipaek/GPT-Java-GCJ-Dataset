import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            StringBuilder result = new StringBuilder();
            
            for (int bitIndex = 0; bitIndex < bits; bitIndex++) {
                System.out.println(bitIndex);
                System.out.flush();
                result.append(scanner.next());
            }
            
            System.out.println(result.toString());
            System.out.flush();
            
            String response = scanner.next();
            if (response.equals("N")) {
                return;
            }
        }
    }
}