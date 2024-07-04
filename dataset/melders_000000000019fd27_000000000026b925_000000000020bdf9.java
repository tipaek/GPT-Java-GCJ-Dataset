import java.io.*;
import java.util.*;

public class Solution {
    private static final String FILE_NAME = null;

    private static String solve(Scanner in) {
        int N = in.nextInt();

        boolean impossible = false;
        List<Integer> jFreeTimes = new ArrayList<>();
        List<Integer> cFreeTimes = new ArrayList<>();
        jFreeTimes.add(0);
        cFreeTimes.add(0);
        jFreeTimes.add(1440);
        cFreeTimes.add(1440);

        StringBuilder schedule = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int startTime = in.nextInt();
            int endTime = in.nextInt();

            if (!impossible) {
                boolean addedToSchedule = false;

                for (int j = 0; j < jFreeTimes.size() && !addedToSchedule && startTime >= jFreeTimes.get(j); j += 2) {
                    if (startTime <= jFreeTimes.get(j + 1)) {
                        if (endTime >= jFreeTimes.get(j) && endTime <= jFreeTimes.get(j + 1)) {
                            if (startTime == jFreeTimes.get(j)) {
                                if (endTime == jFreeTimes.get(j + 1)) {
                                    jFreeTimes.remove(j + 1);
                                    jFreeTimes.remove(j);
                                    schedule.append('J');
                                    addedToSchedule = true;
                                } else {
                                    jFreeTimes.remove(j);
                                    jFreeTimes.add(j, endTime);
                                    schedule.append('J');
                                    addedToSchedule = true;
                                }
                            } else if (endTime == jFreeTimes.get(j + 1)) {
                                jFreeTimes.remove(j + 1);
                                jFreeTimes.add(j + 1, startTime);
                                schedule.append('J');
                                addedToSchedule = true;
                            } else {
                                jFreeTimes.add(j + 1, startTime);
                                jFreeTimes.add(j + 2, endTime);
                                schedule.append('J');
                                addedToSchedule = true;
                            }
                        }
                    }
                }

                for (int j = 0; j < cFreeTimes.size() && !addedToSchedule && startTime >= cFreeTimes.get(j); j += 2) {
                    if (startTime <= cFreeTimes.get(j + 1)) {
                        if (endTime >= cFreeTimes.get(j) && endTime <= cFreeTimes.get(j + 1)) {
                            if (startTime == cFreeTimes.get(j)) {
                                if (endTime == cFreeTimes.get(j + 1)) {
                                    cFreeTimes.remove(j + 1);
                                    cFreeTimes.remove(j);
                                    schedule.append('C');
                                    addedToSchedule = true;
                                } else {
                                    cFreeTimes.remove(j);
                                    cFreeTimes.add(j, endTime);
                                    schedule.append('C');
                                    addedToSchedule = true;
                                }
                            } else if (endTime == cFreeTimes.get(j + 1)) {
                                cFreeTimes.remove(j + 1);
                                cFreeTimes.add(j + 1, startTime);
                                schedule.append('C');
                                addedToSchedule = true;
                            } else {
                                cFreeTimes.add(j + 1, startTime);
                                cFreeTimes.add(j + 2, endTime);
                                schedule.append('C');
                                addedToSchedule = true;
                            }
                        }
                    }
                }

                if (!addedToSchedule) {
                    impossible = true;
                }
            }
        }

        return (impossible ? "IMPOSSIBLE" : schedule.toString());
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                System.out.println("Case #" + t + ": " + solution);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
