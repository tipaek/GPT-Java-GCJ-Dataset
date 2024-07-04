import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter writer = new PrintWriter(System.out, true)) {
             
            int testCaseCount = scanner.nextInt();
            int bitsCount = scanner.nextInt();
            
            for (int t = 0; t < testCaseCount; t++) {
                if (!processTestCase(scanner, writer, bitsCount)) {
                    System.exit(0);
                }
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, PrintWriter writer, int bitsCount) {
        StringBuilder bits = new StringBuilder(bitsCount);
        
        for (int i = 1; i <= bitsCount; i++) {
            writer.print(i);
            writer.flush();
            int bitValue = scanner.nextInt();
            bits.append(bitValue);
        }

        writer.println(bits.toString());
        writer.flush();
        
        String result = scanner.next();
        return "Y".equals(result);
    }
}