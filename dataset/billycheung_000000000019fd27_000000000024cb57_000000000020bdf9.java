import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int s = in.nextInt();
            System.out.println("Case #" + i + ": " + getParents(in, s));
        }
    }

    public static String getParents(Scanner sc, int s) {
        if (s == 0) {
            return "";
        }
        int[][] start = new int[s][2];
        int[][] end = new int[s][2];
        for (int i = 0; i < s; i++) {
            start[i][0] = sc.nextInt();
            end[i][0] = sc.nextInt();
            start[i][1] = i;
            end[i][1] = i;
        }

        Arrays.sort(start, (a, b) -> a[0]- b[0]);
        Arrays.sort(end, (a, b) -> a[0]- b[0]);
        char[] res = new char[s];
        int needed = 0, endIndex = 0;
        for (int i = 0; i < s; i++) {
            int index = start[i][1];
            if (start[i][0] < end[endIndex][0]) {
                if (++needed > 2) {
                    return "IMPOSSIBLE";
                }
                res[index] = i == 0 || res[start[i-1][1]] == 'C' ? 'J':'C';
            } else {
                res[index] = res[end[endIndex][1]] == 'C' ? 'C':'J';
                endIndex++;
            }

        }
        return new String(res);
    }
    //res = {J,C,C,J,0}
    // endIndex = 1, needed = 0, i = 3
    // start = {{1,1},{2,3},{99,0},{100,2},{150,4}}
    // end   = {{5,3},{100,1},{150,0},{250,4},{301,2}}

    // 2 5 3-->   C (endIndex = 0, needed = 1)
    // 1 100 1 --> J (endIndex = 0, needed = 2)
    // 99 150 0 -> C (endIndex = 1, needed = 1)
    // 150 250 4 -> J  (endIndex = 2, needed = 0)
    // 100 301 2 ->
}
