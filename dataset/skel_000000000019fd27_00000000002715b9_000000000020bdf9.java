
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Time implements Comparable<Time> {
        int index;
        int start;
        int end;

        public Time(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public boolean contains(Time t) {
            if (t.end <= this.start || this.end <= t.start) return false;
            return true;
        }

        @Override
        public int compareTo(Time o) {
            if (start == o.start) return Integer.compare(end, o.end);
            return Integer.compare(start, o.start);
        }
    }


    public static boolean isInside(List<Time> list, Time nextTime) {
        for (Time cT : list) {
            if (cT.contains(nextTime)) {
                return true;
            }
        }
        return false;
    }

    static class Output implements Comparable<Output> {
        String s;
        int priority;

        public Output(String s, int priority) {
            this.s = s;
            this.priority = priority;
        }

        @Override
        public int compareTo(Output o) {
            return Integer.compare(priority, o.priority);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int currentTest = 1;
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                boolean isNotValid = false;
                List<Time> C = new ArrayList<>();
                List<Time> J = new ArrayList<>();
                List<Time> times = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    times.add(new Time(i, start, end));
                }
                Collections.sort(times);
                PriorityQueue<Output> output = new PriorityQueue<>();
                for (Time nextTime : times) {
                    if (!isInside(C, nextTime)) {
                        C.add(nextTime);
                        output.add(new Output("C", nextTime.index));
                    } else if (!isInside(J, nextTime)) {
                        J.add(nextTime);
                        output.add(new Output("J", nextTime.index));
                    } else {
                        isNotValid = true;
                    }
                }
                if (isNotValid) {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", currentTest);
                } else {
                    System.out.printf("Case #%d: ", currentTest);
                    while (!output.isEmpty()) {
                        System.out.printf("%s", output.poll().s);
                    }
                    System.out.println("");
                }
                currentTest++;
            }
        } catch (IOException e) {
        }
    }
}
