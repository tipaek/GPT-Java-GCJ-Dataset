import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] arr = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            boolean found = false;
            
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
                if (frequencyMap.get(arr[i]) >= d) {
                    System.out.println("Case #" + caseNum + ": 0");
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                if (d == 2) {
                    System.out.println("Case #" + caseNum + ": 1");
                } else {
                    Arrays.sort(arr);
                    for (int i = 0; i < n; i++) {
                        if ((frequencyMap.get(arr[i]) == 2 && i != n - 1 && arr[i] != arr[n - 1]) ||
                            frequencyMap.containsKey(arr[i] / 2)) {
                            System.out.println("Case #" + caseNum + ": 1");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Case #" + caseNum + ": 2");
                    }
                }
            }
        }
    }
}