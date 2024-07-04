import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int bitLength = scanner.nextInt();
            
            for (int testCase = 1; testCase <= testCases; testCase++) {
                StringBuilder bitString = new StringBuilder();
                
                for (int i = 0; i < bitLength; i++) {
                    System.out.println(i + 1);
                    bitString.append(scanner.next());
                }
                
                System.out.println(bitString.toString());
                String response = scanner.next();
                
                if ("N".equals(response)) {
                    break;
                }
            }
        }
    }
}