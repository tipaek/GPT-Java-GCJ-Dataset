import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int c = 1; c <= t; c++) {
            int n = in.nextInt();
            int d = in.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            boolean caseHandled = false;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
                if (frequencyMap.get(arr[i]) >= d) {
                    System.out.println("Case #" + c + ": 0");
                    caseHandled = true;
                    break;
                }
            }

            if (!caseHandled) {
                if (d == 2) {
                    System.out.println("Case #" + c + ": 1");
                } else {
                    Arrays.sort(arr);
                    boolean foundPair = false;
                    for (int i = 0; i < n - 1; i++) {
                        if (arr[i] == arr[i + 1] && frequencyMap.get(arr[i]) == 2) {
                            System.out.println("Case #" + c + ": 1");
                            foundPair = true;
                            break;
                        }
                    }
                    if (!foundPair) {
                        System.out.println("Case #" + c + ": 2");
                    }
                }
            }
        }
    }
}