import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            scanner.next(); // Consume the initial input
            ArrayList<Integer> bits = new ArrayList<>();
            int queryCount = 1;
            
            for (int j = 0; j < bitLength; j++) {
                if (queryCount % 10 == 1) {
                    j--;
                } else {
                    System.out.println(j);
                    System.out.flush();
                    bits.add(scanner.nextInt());
                }
                queryCount++;
            }
            
            StringBuilder result = new StringBuilder();
            for (int bit : bits) {
                result.append(bit);
            }
            System.out.println(result);
            System.out.flush();
            
            String response = scanner.next();
            if ("N".equals(response)) {
                break;
            }
        }
    }
}