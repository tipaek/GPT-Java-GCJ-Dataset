

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{
    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean contains(Time t) {
            if (t.end <= this.start || this.end <= t.start) return false;
            return true;
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

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int currentTest = 1;
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                boolean isNotValid = false;
                List<Time> C = new ArrayList<>();
                List<Time> J = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    Time nextTime = new Time(start, end);

                    if (!isInside(C, nextTime)) {
                        C.add(nextTime);
                        sb.append("C");
                    } else if (!isInside(J, nextTime)) {
                        J.add(nextTime);
                        sb.append("J");
                    } else {
                        isNotValid = true;
                    }
                }
                if (isNotValid) {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", currentTest);
                } else {
                    System.out.printf("Case #%d: %s\n", currentTest, sb.toString());
                }
                currentTest++;
            }
        } catch (IOException e) {
        }
    }
}
