import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        for (int t = 1; t <= tc; ++t) {
            int n = in.nextInt();
            int s = in.nextInt();

            if (s % n == 0) {
                System.out.println(String.format("Case #%s: %s", t, "POSSIBLE"));
                int d = s / n;
                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    int curr = d;
                    for (int j = i; j < n; j++) {
                        arr[j] = curr;
                        curr += 1;
                        if (curr > n) {
                            curr = 1;
                        }
                    }
                    for (int j = 0; j < i; j++) {
                        arr[j] = curr;
                        curr += 1;
                        if (curr > n) {
                            curr = 1;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        sb.append(arr[j]).append(" ");
                    }
                    System.out.println(sb.toString());
                }

            } else {
                System.out.println(String.format("Case #%s: %s", t, "IMPOSSIBLE"));
            }
        }
    }

}
