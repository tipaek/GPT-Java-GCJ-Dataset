import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int cameron[] = new int[24 * 60];
            int jamie[] = new int[24 * 60];
            int start_time = -1;
            int end_time = -1;
            StringBuilder sb;
            String s;
            boolean not_valid;
            for (int k = 1; k <= t; ++k) {
                int n = in.nextInt();
                s = null;
                sb = new StringBuilder();
                not_valid = false;
                for (int i = 0; i < 24 * 60; i++) {
                    cameron[i] = 24 * 60 - i;
                    jamie[i] = 24 * 60 - i;
                }

                for (int i = 0; i < n; i++) {
                    start_time = in.nextInt();
                    end_time = in.nextInt();
                    if (!not_valid) {
                        if (cameron[start_time] >= end_time - start_time) {
                            int temp = start_time - 1;
                            int br = 1;
                            while (temp >= 0 && cameron[temp] > 0) {
                                cameron[temp] = br;
                                br++;
                                temp--;
                            }

                            for (int j = start_time; j < end_time; j++) {
                                cameron[j] = 0;
                            }
                            sb.append("C");

                        } else if (jamie[start_time] >= end_time - start_time) {
                            int temp = start_time - 1;
                            int br = 1;
                            while (temp >= 0 && jamie[temp] > 0) {
                                jamie[temp] = br;
                                br++;
                                temp--;
                            }

                            for (int j = start_time; j < end_time; j++) {
                                jamie[j] = 0;
                            }
                            sb.append("J");

                        } else {

                            not_valid = true;
                        }
                    }

                }
                if (not_valid) {
                    s = "IMPOSSIBLE";
                } else {
                    s = sb.toString();
                }
                //int m = in.nextInt();
                System.out.println("Case #" + k + ": " + s);
            }
      }
    }