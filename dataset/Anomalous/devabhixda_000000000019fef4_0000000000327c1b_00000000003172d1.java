import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int arraySize = scanner.nextInt();
            int d = scanner.nextInt();
            long[] numbers = new long[arraySize];
            Set<Long> uniqueNumbers = new HashSet<>();
            
            for (int index = 0; index < arraySize; index++) {
                numbers[index] = scanner.nextLong();
                uniqueNumbers.add(numbers[index]);
            }
            
            int cuts = arraySize - (uniqueNumbers.size() + d) + 1;
            
            if (cuts != 0) {
                Arrays.sort(numbers);
                long smallestNumber = numbers[0];
                
                for (int index = 1; index < arraySize; index++) {
                    if (numbers[index] == 2 * smallestNumber) {
                        cuts = 1;
                        break;
                    }
                }
                
                if (cuts < 0) {
                    cuts = 2;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + cuts);
        }
    }
}