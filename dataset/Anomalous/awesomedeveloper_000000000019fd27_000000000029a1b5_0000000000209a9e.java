import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int bitCount = scanner.nextInt();
            
            if (bitCount > 10) {
                System.exit(0);
            }
            
            for (int i = 1; i <= testCases; i++) {
                processTestCase(i, scanner, bitCount);
            }
        }
    }

    private static void processTestCase(int testCaseId, Scanner scanner, int bitCount) {
        int[] bits = new int[bitCount];
        
        for (int i = 0; i < bitCount; i++) {
            System.out.println(i + 1);
            System.out.flush();
            bits[i] = scanner.nextInt();
        }
        
        StringBuilder output = new StringBuilder();
        for (int bit : bits) {
            output.append(bit);
        }
        
        System.out.println(output);
        System.out.flush();
        
        String judgeResponse = scanner.next();
        if ("N".equalsIgnoreCase(judgeResponse)) {
            System.exit(0);
        }
    }
}