import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] array = new long[n];
            Set<Long> uniqueElements = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLong();
                uniqueElements.add(array[i]);
            }
            
            int cutsNeeded = n - (uniqueElements.size() + d) + 1;
            
            if (cutsNeeded != 0) {
                Arrays.sort(array);
                boolean found = false;
                
                for (int i = 1; i < n && !found; i++) {
                    for (int j = 0; j < n; j++) {
                        if (array[i] == 2 * array[j]) {
                            cutsNeeded = 1;
                            found = true;
                            break;
                        }
                    }
                }
                
                if (cutsNeeded < 0) {
                    cutsNeeded = 2;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + cutsNeeded);
        }
    }
}