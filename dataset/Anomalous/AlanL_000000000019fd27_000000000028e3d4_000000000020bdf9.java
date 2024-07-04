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

            String result = "";
            int currentPerson = 0;
            int[] scheduleC = new int[1441];
            int[] scheduleJ = new int[1441];
            boolean canAssignC = true, canAssignJ = true, isPossible = true;

            for (int i = 0; i < n; i++) {
                boolean canAssign = true;
                if (currentPerson == 0) {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (scheduleC[j] != 0) {
                            canAssign = false;
                            break;
                        }
                    }
                    if (!canAssign) {
                        canAssignC = false;
                        if (canAssignJ) {
                            currentPerson = 1;
                            i--;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            scheduleC[j] = 1;
                        }
                        canAssignC = true;
                        canAssignJ = true;
                        result += "C";
                    }
                } else {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (scheduleJ[j] != 0) {
                            canAssign = false;
                            break;
                        }
                    }
                    if (!canAssign) {
                        canAssignJ = false;
                        if (canAssignC) {
                            currentPerson = 0;
                            i--;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            scheduleJ[j] = 1;
                        }
                        canAssignC = true;
                        canAssignJ = true;
                        result += "J";
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + z + ": " + result);
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