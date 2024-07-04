
/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class Solution {
    static int[][] arr;
    static int[][][] mem;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t++ < T; ) {
            sb.append("Case #").append(t).append(": ");
            int N = parseInt(in.readLine());
            arr = new int[N][];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                arr[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken()), i};
            }
            String r = f();
            if (r == null)
                sb.append("IMPOSSIBLE");
            else
                sb.append(r);
            /*Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[1] - b[1] : a[0] - b[0]);
            mem = new int[N][N + 1][];
            boolean ws = f(1, -1);
            char[] solution = new char[N];
            solution[arr[0][2]] = 'C';
            if (ws) {
                int c = 0, p = 1, o = -1;
                for (; p < N; p++) {
                    if (mem[p][o + 1][1] == 1) {
                        c = (c + 1) % 2;
                        o = p - 1;
                    }
                    solution[arr[p][2]] = c == 0 ? 'C' : 'J';
                }
                sb.append(new String(solution));
            } else sb.append("IMPOSSIBLE");*/
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }

    static boolean f(int p, int o) {
        if (p == arr.length)
            return true;
        if (mem[p][o + 1] != null)
            return mem[p][o + 1][0] == 1;
        if (arr[p - 1][1] <= arr[p][0] && f(p + 1, o)) {
            mem[p][o + 1] = new int[]{1, 0};
            return true;
        }
        if ((o < 0 || arr[o][1] <= arr[p][0]) && f(p + 1, p - 1)) {
            mem[p][o + 1] = new int[]{1, 1};
            return true;
        }
        mem[p][o + 1] = new int[]{0};
        return false;
    }

    static String f() {
        int N = arr.length;
        for (int i = 0; i < (1 << N); i++) {
            boolean ws = true;
            for (int j = 0; j < N && ws; j++)
                for (int k = j + 1; k < N && ws; k++) {
                    if ((((1 << j) & i) == 0 && ((1 << k) & i) == 0) ||
                            ((1 << j) & i) != 0 && ((1 << k) & i) != 0) {
                        if (
                                (arr[j][0] > arr[k][0] && arr[j][0] < arr[k][1]) ||
                                        (arr[j][1] > arr[k][0] && arr[j][1] < arr[k][1]) ||
                                        (arr[k][0] > arr[j][0] && arr[k][0] < arr[j][1]) ||
                                        (arr[k][1] > arr[j][0] && arr[k][1] < arr[j][1])

                                )
                            ws = false;
                        else
                            if(arr[j][0] == arr[k][0] && arr[j][1] == arr[k][1])
                                ws = false;
                    }
                }
            if (ws) {
                String s = toBinaryString(i);
                for (; s.length() < N; s = "0" + s) ;
                return new String(new StringBuilder(s.replaceAll("0", "C").replaceAll("1", "J")).reverse());
            }
        }
        return null;
    }
}
