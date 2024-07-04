import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            Schedule[] schedules = new Schedule[N];
            for (int i = 0; i < N; i++) {
                String[] schStr = br.readLine().split(" ");
                schedules[i] = new Schedule(Integer.parseInt(schStr[0]), Integer.parseInt(schStr[1]), i);
            }

            Arrays.sort(schedules);

            boolean isImpossible = false;
            char[] reqChar = new char[N];

            Schedule prev = schedules[0];
            reqChar[prev.index] = 'C';

            int lastCEnd = prev.endTime;
            int lastJEnd = 0;

            char curr = 'J';
            for (int i = 1; i < N; i++) {
                Schedule current = schedules[i];
                if (current.startTime >= prev.endTime) {
                    reqChar[current.index] = curr;
                    prev = current;
                    if (curr == 'J') {
                        lastJEnd = current.endTime;
                    } else {
                        lastCEnd = current.endTime;
                    }
                } else {
                    if (curr == 'J') {
                        if (current.startTime >= lastJEnd) {
                            reqChar[current.index] = curr;
                            prev = current;
                            lastJEnd = current.endTime;

                        } else if (current.startTime >= lastCEnd) {
                            curr = 'C';
                            reqChar[current.index] = curr;
                            prev = current;
                            lastCEnd = current.endTime;

                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        if (current.startTime >= lastCEnd) {
                            reqChar[current.index] = curr;
                            prev = current;
                            lastCEnd = current.endTime;

                        } else if (current.startTime >= lastJEnd) {
                            curr = 'J';
                            reqChar[current.index] = curr;
                            prev = current;
                            lastJEnd = current.endTime;

                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                }
            }

            String answer;
            if (isImpossible) {
                answer = "IMPOSSIBLE";
            } else {
                answer = String.valueOf(reqChar);
            }

            output.append("Case #").append(t).append(": ").append(answer).append("\n");
        }

        System.out.print(output);
    }

    static class Schedule implements Comparable<Schedule> {
        int startTime;
        int endTime;
        int index;

        Schedule(int s, int e, int i) {
            startTime = s;
            endTime = e;
            index = i;
        }

        @Override
        public int compareTo(Schedule sch) {
            return startTime - sch.startTime;
        }

        @Override
        public String toString() {
            return "{ startTime: " + startTime + ", endTime: " + endTime + " }";
        }
    }
}