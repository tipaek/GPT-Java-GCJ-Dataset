import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int number = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");
            System.out.println("1 1");
            
            if (number == 1) {
                continue;
            }
            
            int currentSum = 1;
            int currentRow = 2;
            
            while (currentSum < number) {
                System.out.println(currentRow + " 1");
                currentSum++;
                currentRow++;
            }
        }
    }
}