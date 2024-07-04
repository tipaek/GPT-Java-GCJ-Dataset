import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int c = 1; c <= t; c++) {
            Map<Long, Integer> frequencyMap = new HashMap<>();
            boolean resultPrinted = false;
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
                
                if (frequencyMap.get(arr[i]) >= d) {
                    System.out.println("Case #" + c + ": 0");
                    resultPrinted = true;
                    break;
                }
            }

            if (!resultPrinted) {
                if (d == 2) {
                    System.out.println("Case #" + c + ": 1");
                } else {
                    Arrays.sort(arr);
                    for (int i = 0; i < n - 1; i++) {
                        if (frequencyMap.get(arr[i]) == 2) {
                            System.out.println("Case #" + c + ": 1");
                            resultPrinted = true;
                            break;
                        }
                    }
                    if (!resultPrinted) {
                        System.out.println("Case #" + c + ": 2");
                    }
                }
            }
        }
    }
}