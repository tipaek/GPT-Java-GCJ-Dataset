
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


    public boolean isInside(List<Time> list, Time nextTime) {
        for (Time cT : list) {
            if (cT.contains(nextTime)) {
                return true;
            }
        }
        return false;
    }

    static boolean check(List<Time> times, List<Integer> timeIndexs) {
        int len = timeIndexs.size();
        for (int i = 0; i < len; i++) {
            Time iTime = times.get(timeIndexs.get(i));
            for (int j = i + 1; j < len; j++) {
                Time jTime = times.get(timeIndexs.get(j));
                if (iTime.contains(jTime)) return false;
            }
        }
        return true;
    }

    static String makeSchedule(List<Time> times, int caseArr) {
        int N = times.size();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int limit = (1 << N);
        for (int i = 1, index = 0; i < limit; i = (i << 1), index++) {
            if ((caseArr & i) == i) {
                ones.add(index);
                sb.append("C");
            } else {
                zeros.add(index);
                sb.append("J");
            }
        }
        if (check(times, zeros) && check(times, ones)) {
            return sb.toString();
        }
        return null;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int currentTest = 1;
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                boolean isNotValid = true;
                List<Time> times = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    times.add(new Time(start, end));
                }
                int limit = (1 << N);
                for (int i = 1; i < limit; i++) {
                    String result = makeSchedule(times, i);
                    if (result != null) {
                        System.out.printf("Case #%d: %s\n", currentTest, result);
                        isNotValid = false;
                        break;
                    }
                }
                if (isNotValid)
                    System.out.printf("Case #%d: IMPOSSIBLE\n", currentTest);

                currentTest++;
            }
        } catch (IOException e) {
        }
    }
}
