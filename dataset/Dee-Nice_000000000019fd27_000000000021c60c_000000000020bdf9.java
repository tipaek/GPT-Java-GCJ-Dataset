import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + t + ": " + solve(scan));
        }
    }

    static String solve(Scanner scan) {
        int n = scan.nextInt();
        int[][] times = new int[n][3];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            times[i][0] = scan.nextInt();
            times[i][1] = scan.nextInt();
            times[i][2] = i;
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        char on = 'C';
        sb.append(times[0][2]);
        sb.append(on);
        int cFreeAt = times[0][1];
        int jFreeAt = 0;
        for (int i = 1; i < times.length; i++) {
            // If start time clashes with previous end times, switch
            if (times[i][0] < times[i - 1][1]) {
                if (on == 'C' && jFreeAt > times[i][0]) {
                    return "IMPOSSIBLE";
                }
                else if (on == 'J' && cFreeAt > times[i][0]) {
                    return "IMPOSSIBLE";
                }
                on = on == 'C'? 'J': 'C';
                if (on == 'C') {
                    cFreeAt = times[i][1];
                }
                else {
                    jFreeAt = times[i][1];
                }
                sb.append(times[i][2]);
                sb.append(on);
            }
            // Otherwise, keep same person
            else {
                sb.append(times[i][2]);
                sb.append(on);
                if (on == 'C') {
                    cFreeAt = times[i][1];
                }
                else {
                    jFreeAt = times[i][1];
                }
            }
        }
        String indexedSched = sb.toString();
        char[] ansArr = new char[indexedSched.length() / 2];
        for (int i = 1; i < indexedSched.length(); i += 2) {
            int index = indexedSched.charAt(i - 1) - '0';
            ansArr[index] = indexedSched.charAt(i);
        }
        String ans = new String(ansArr);
        return ans;
    }

    static String buildString(char c, int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }
}