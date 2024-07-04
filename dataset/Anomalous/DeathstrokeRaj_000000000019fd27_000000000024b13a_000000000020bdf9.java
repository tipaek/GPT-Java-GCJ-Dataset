import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int z = 1; z <= t; z++) {
            int n = scan.nextInt();
            char[] output = new char[n];
            List<Time> times = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                times.add(new Time(scan.nextInt(), scan.nextInt(), i));
            }

            times.sort(Comparator.comparingInt(t1 -> t1.startTime));

            int jEndTime = 0, cEndTime = 0;
            boolean possible = true;

            for (Time time : times) {
                if (time.startTime >= cEndTime) {
                    cEndTime = time.endTime;
                    output[time.index] = 'C';
                } else if (time.startTime >= jEndTime) {
                    jEndTime = time.endTime;
                    output[time.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + z + ": " + new String(output));
            } else {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            }
        }
    }
}

class Time {
    int startTime;
    int endTime;
    int index;

    public Time(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
}