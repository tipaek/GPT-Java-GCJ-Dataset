import java.util.*;
import java.io.*;

public class Solution {
    static class Schedule {
        int start;
        int end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static Schedule[] schedulesC = new Schedule[1000];
    private static Schedule[] schedulesJ = new Schedule[1000];
    private static String validCase;
    private static int countC, countJ;

    private static void initialize() {
        validCase = "";
        countC = 0;
        countJ = 0;
        for (int i = 0; i < 1000; i++) {
            schedulesC[i] = new Schedule(0, 0);
            schedulesJ[i] = new Schedule(0, 0);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("./input.txt"));
        // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();

            initialize();
            boolean isPossible = true;

            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();

                boolean isOverlapC = false;
                for (int j = 0; j < countC; j++) {
                    if (S < schedulesC[j].end && E > schedulesC[j].start) {
                        isOverlapC = true;
                        break;
                    }
                }

                if (!isOverlapC) {
                    validCase += "C";
                    schedulesC[countC++] = new Schedule(S, E);
                    continue;
                }

                boolean isOverlapJ = false;
                for (int j = 0; j < countJ; j++) {
                    if (S < schedulesJ[j].end && E > schedulesJ[j].start) {
                        isOverlapJ = true;
                        break;
                    }
                }

                if (!isOverlapJ) {
                    validCase += "J";
                    schedulesJ[countJ++] = new Schedule(S, E);
                    continue;
                }

                isPossible = false;
                validCase = "IMPOSSIBLE";
                break;
            }

            System.out.println("Case #" + testCase + ": " + validCase);
        }

        in.close();
    }
}