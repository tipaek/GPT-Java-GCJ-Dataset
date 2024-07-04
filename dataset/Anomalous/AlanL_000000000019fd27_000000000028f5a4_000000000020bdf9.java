import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int z = 1; z <= t; z++) {
            int n = readInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = readInt();
                intervals[i][1] = readInt();
            }
            StringBuilder ans = new StringBuilder();
            int current = 0;
            int[] scheduleA = new int[1441];
            int[] scheduleB = new int[1441];
            boolean firstAvailable = true, secondAvailable = true, possible = true;

            for (int i = 0; i < n; i++) {
                boolean canAssign = true;
                if (current == 0) {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (scheduleA[j] != 0) {
                            canAssign = false;
                            break;
                        }
                    }
                    if (!canAssign) {
                        firstAvailable = false;
                        if (secondAvailable) {
                            current = 1;
                            i--;
                        } else {
                            possible = false;
                            break;
                        }
                    } else {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            scheduleA[j] = 1;
                        }
                        firstAvailable = true;
                        secondAvailable = true;
                        ans.append("C");
                    }
                } else {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (scheduleB[j] != 0) {
                            canAssign = false;
                            break;
                        }
                    }
                    if (!canAssign) {
                        secondAvailable = false;
                        if (firstAvailable) {
                            current = 0;
                            i--;
                        } else {
                            possible = false;
                            break;
                        }
                    } else {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            scheduleB[j] = 1;
                        }
                        firstAvailable = true;
                        secondAvailable = true;
                        ans.append("J");
                    }
                }
            }
            if (!possible) {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + z + ": " + ans.toString());
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }
}