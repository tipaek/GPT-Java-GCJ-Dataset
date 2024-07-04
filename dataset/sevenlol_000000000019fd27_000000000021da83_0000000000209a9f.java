import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= T; i++) {
            String s = sc.nextLine();
            int[] arr = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                arr[j] = s.charAt(j) - '0';
            }
            solve(i, arr);
        }
    }

    private static void solve(int T, int[] arr) {
        System.out.printf("Case #%d: ", T);
        int N = arr.length;

        // System.out.println();
        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < N; ) {
        //     int j = i;
        //     boolean incr = true;
        //     while (j + 1 < N) {
        //         if (arr[j] == arr[j + 1]) {
        //             j++;
        //         } else if (arr[j] < arr[j + 1]) {
        //             if (!incr) {
        //                 break;
        //             }
        //             j++;
        //         } else {
        //             if (incr) {
        //                 incr = !incr;
        //             }
        //             j++;
        //         }
        //     }
        //     String s = build(arr, i, j + 1);
        //     // System.out.println(i + "," + (j + 1) + ", s=" + s);
        //     sb.append(s);
        //     i = j + 1;
        // }
        String s = build(arr, 0, N);
        sb.append(s);
        System.out.println(sb.toString());
    }

    private static String build(int[] arr, int st, int end) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < arr[st]; i++) {
            cnt++;
            sb.append('(');
        }
        sb.append(arr[st]);
        for (int i = st + 1; i < end; i++) {
            if (arr[i] == arr[i - 1]) {
                sb.append(arr[i]);
            } else if (arr[i] > arr[i - 1]) {
                // incr
                for (int j = cnt; j < arr[i]; j++) {
                    sb.append('(');
                }
                sb.append(arr[i]);
                cnt = arr[i];
            } else {
                // desc
                for (int j = cnt; j > arr[i]; j--) {
                    sb.append(')');
                }
                sb.append(arr[i]);
                cnt = arr[i];
            }
        }
        for (int i = 0; i < cnt; i++) {
            sb.append(')');
        }
        return sb.toString();
    }
}