import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int c = 1; c <= t; c++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] arr = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            boolean foundSolution = false;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
                
                if (frequencyMap.get(arr[i]) >= d) {
                    System.out.println("Case #" + c + ": 0");
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
                if (d == 2) {
                    System.out.println("Case #" + c + ": 1");
                } else {
                    Arrays.sort(arr);
                    for (int i = 0; i < n; i++) {
                        if (frequencyMap.get(arr[i]) == 2 && i != n - 1 && arr[i] != arr[n - 1]) {
                            System.out.println("Case #" + c + ": 1");
                            foundSolution = true;
                            break;
                        }
                        for (int j = 0; j < n; j++) {
                            if (arr[j] == arr[i] * 2) {
                                System.out.println("Case #" + c + ": 1");
                                foundSolution = true;
                                break;
                            }
                        }
                        if (foundSolution) break;
                    }
                    if (!foundSolution) {
                        System.out.println("Case #" + c + ": 2");
                    }
                }
            }
        }
        scanner.close();
    }
}