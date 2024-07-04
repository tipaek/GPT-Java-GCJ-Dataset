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
            Integer[][] intervals = new Integer[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = readInt();
                intervals[i][1] = readInt();
            }

            System.out.print("Case #" + z + ": ");
            boolean firstAvailable = true, secondAvailable = true, isPossible = true;
            String current = "je", result = "";
            int[] scheduleJ = new int[24 * 60 + 1], scheduleC = new int[24 * 60 + 1];

            for (int i = 0; i < n; i++) {
                if (current.equals("je")) {
                    boolean canSchedule = true;
                    for (int j = intervals[i][0] + 1; j <= intervals[i][1]; j++) {
                        if (scheduleJ[j] != 0) {
                            canSchedule = false;
                            break;
                        }
                    }
                    if (!canSchedule) {
                        firstAvailable = false;
                        if (secondAvailable) {
                            current = "ce";
                            i--;
                            continue;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else {
                        for (int j = intervals[i][0] + 1; j <= intervals[i][1]; j++) {
                            scheduleJ[j] = 1;
                        }
                        result += "J";
                        firstAvailable = true;
                        secondAvailable = true;
                    }
                } else {
                    boolean canSchedule = true;
                    for (int j = intervals[i][0] + 1; j <= intervals[i][1]; j++) {
                        if (scheduleC[j] != 0) {
                            canSchedule = false;
                            break;
                        }
                    }
                    if (!canSchedule) {
                        secondAvailable = false;
                        if (firstAvailable) {
                            current = "je";
                            i--;
                            continue;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else {
                        for (int j = intervals[i][0] + 1; j <= intervals[i][1]; j++) {
                            scheduleC[j] = 1;
                        }
                        result += "C";
                        firstAvailable = true;
                        secondAvailable = true;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
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