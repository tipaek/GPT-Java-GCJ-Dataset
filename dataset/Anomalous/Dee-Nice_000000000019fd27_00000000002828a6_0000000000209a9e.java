import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            processTestCase(scanner, bitLength);
        }
    }

    private static void processTestCase(Scanner scanner, int bitLength) {
        int[] bits = new int[bitLength];
        int currentPos = 0;
        
        for (int queryCount = 1; queryCount <= 150; queryCount++) {
            if (currentPos >= bitLength) {
                break;
            }
            
            bits[currentPos] = makeQuery(scanner, currentPos + 1);
            
            if (queryCount % 10 == 1) {
                bits[currentPos] = makeQuery(scanner, currentPos + 1);
                queryCount++;
            }
            
            currentPos++;
        }
        
        StringBuilder result = new StringBuilder();
        for (int bit : bits) {
            result.append(bit);
        }
        
        System.out.println(result.toString());
        System.out.flush();
        scanner.next();
    }

    private static int makeQuery(Scanner scanner, int position) {
        System.out.println(position);
        System.out.flush();
        return scanner.nextInt();
    }
}