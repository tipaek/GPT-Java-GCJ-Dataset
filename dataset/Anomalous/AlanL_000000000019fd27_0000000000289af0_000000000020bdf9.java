import java.io.*;
import java.util.StringTokenizer;

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
            boolean firstAvailable = true, secondAvailable = true, possible = true;
            String currentPerson = "je", schedule = "";
            int[] firstPersonSchedule = new int[24 * 60 + 1];
            int[] secondPersonSchedule = new int[24 * 60 + 1];

            for (int i = 0; i < n; i++) {
                if (currentPerson.equals("je")) {
                    if (isAvailable(firstPersonSchedule, intervals[i][0], intervals[i][1])) {
                        fillSchedule(firstPersonSchedule, intervals[i][0], intervals[i][1]);
                        schedule += "J";
                        firstAvailable = true;
                        secondAvailable = true;
                    } else {
                        firstAvailable = false;
                        if (secondAvailable) {
                            currentPerson = "ce";
                            i--;
                        } else {
                            possible = false;
                            break;
                        }
                    }
                } else {
                    if (isAvailable(secondPersonSchedule, intervals[i][0], intervals[i][1])) {
                        fillSchedule(secondPersonSchedule, intervals[i][0], intervals[i][1]);
                        schedule += "C";
                        firstAvailable = true;
                        secondAvailable = true;
                    } else {
                        secondAvailable = false;
                        if (firstAvailable) {
                            currentPerson = "je";
                            i--;
                        } else {
                            possible = false;
                            break;
                        }
                    }
                }
            }
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(schedule);
            }
        }
    }

    static boolean isAvailable(int[] schedule, int start, int end) {
        for (int j = start; j < end; j++) {
            if (schedule[j] != 0) {
                return false;
            }
        }
        return true;
    }

    static void fillSchedule(int[] schedule, int start, int end) {
        for (int j = start; j < end; j++) {
            schedule[j] = 1;
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