import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int cases = in.nextInt();

            for (int i = 1; i <= cases; i++) {
                int[] camSchedule = new int[1500];
                int[] jamieSchedule = new int[1500];
                int activities = in.nextInt();
                boolean impossible = false;
                StringBuilder solution = new StringBuilder();

                for (int j = 0; j < activities; j++) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    boolean addedToCam = false;

                    if (isScheduleFree(camSchedule, start, end)) {
                        markSchedule(camSchedule, start, end);
                        solution.append("C");
                        addedToCam = true;
                    }

                    if (!addedToCam) {
                        if (isScheduleFree(jamieSchedule, start, end)) {
                            markSchedule(jamieSchedule, start, end);
                            solution.append("J");
                        } else {
                            solution = new StringBuilder("IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    }
                }

                System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : solution.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isScheduleFree(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}