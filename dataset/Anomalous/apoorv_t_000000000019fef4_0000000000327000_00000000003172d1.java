import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int c = 1; c <= t; c++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] arr = new long[n];
            Map<Long, Integer> map = new HashMap<>();
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                if (map.get(arr[i]) >= d) {
                    System.out.println("Case #" + c + ": 0");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                if (d == 2) {
                    System.out.println("Case #" + c + ": 1");
                } else {
                    Arrays.sort(arr);
                    for (int i = 0; i < n; i++) {
                        if (map.get(arr[i]) == 2 && i != n - 1 && arr[i] != arr[n - 1]) {
                            System.out.println("Case #" + c + ": 1");
                            flag = true;
                            break;
                        }
                        for (int j = 0; j < n; j++) {
                            if (arr[j] == arr[i] * 2) {
                                System.out.println("Case #" + c + ": 1");
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                    }
                    if (!flag) {
                        System.out.println("Case #" + c + ": 2");
                    }
                }
            }
        }

        in.close();
    }
}