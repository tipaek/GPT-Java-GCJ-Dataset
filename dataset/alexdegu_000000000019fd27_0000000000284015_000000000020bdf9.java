import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int activities[][];

            int start_time = -1;
            int end_time = -1;
            StringBuilder sb;
            int solved_activities;
            String s;
            boolean not_valid;
            for (int k = 1; k <= t; ++k) {
                int n = in.nextInt();
                sb = new StringBuilder();
                not_valid = false;
                solved_activities = 0;
                activities = new int[n][3];

                int min_start = 24 * 60;
                int max_duration = 0;
                int task_id = -1;
                int last_time;

                for (int i = 0; i < n; i++) {
                    start_time = in.nextInt();
                    end_time = in.nextInt();

                    if (start_time < min_start) {
                        min_start = start_time;
                        max_duration = end_time - start_time;
                        task_id = i;
                    } else if (start_time == min_start && max_duration < end_time - start_time) {
                        min_start = start_time;
                        max_duration = end_time - start_time;
                        task_id = i;
                    }

                    activities[i][0] = start_time;
                    activities[i][1] = end_time;
                    activities[i][2] = 0;
                }

                solved_activities++;
                activities[task_id][2] = 1;
                last_time = activities[task_id][1];

                while (solved_activities != n && !not_valid) {
                    max_duration = 0;
                    not_valid = true;
                    min_start = 24 * 60;
                    for (int i = 0; i < n; i++) {
                        if (last_time <= activities[i][0] && activities[i][2] == 0) {
                            if (activities[i][0] < min_start) {
                                min_start = activities[i][0];
                                max_duration = activities[i][1] - activities[i][0];
                                task_id = i;
                            } else if (activities[i][0] == min_start && max_duration < activities[i][1] - activities[i][0]) {
                                min_start = activities[i][0];
                                max_duration = activities[i][1] - activities[i][0];
                                task_id = i;
                            }
                        }
                    }
                    
                    if (max_duration > 0) {
                        last_time = activities[task_id][1];
                        not_valid = false;
                        solved_activities++;
                        activities[task_id][2] = 1;
                    }

                }
                last_time = 0;
                
                not_valid = false;
                while (solved_activities != n && !not_valid) {
                    max_duration = 0;
                    not_valid = true;
                    min_start = 24 * 60;
                    for (int i = 0; i < n; i++) {
                        if (last_time <= activities[i][0] && activities[i][2] == 0) {
                            if (activities[i][0] < min_start) {
                                min_start = activities[i][0];
                                max_duration = activities[i][1] - activities[i][0];
                                task_id = i;
                            } else if (activities[i][0] == min_start && max_duration < activities[i][1] - activities[i][0]) {
                                min_start = activities[i][0];
                                max_duration = activities[i][1] - activities[i][0];
                                task_id = i;
                            }
                        }
                    }

                    if (max_duration > 0) {
                        last_time = activities[task_id][1];
                        not_valid = false;
                        solved_activities++;
                        activities[task_id][2] = 2;
                    }

                }
                not_valid = false;
                for (int i = 0; i < n; i++) {
                    if (activities[i][2] == 0) {
                        not_valid = true;
                        break;
                    } else if (activities[i][2] == 1) {
                        sb.append("C");
                    } else {
                        sb.append("J");
                    }
                }

                if (not_valid) {
                    s = "IMPOSSIBLE";
                } else {
                    s = sb.toString();
                }
                System.out.println("Case #" + k + ": " + s);
            }
      }
    }