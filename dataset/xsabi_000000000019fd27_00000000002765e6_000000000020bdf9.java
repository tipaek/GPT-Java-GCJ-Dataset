import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            boolean valid = true;
            int doubleN = 2 * N;
            int[] time = new int[doubleN];
            char[] schedule = new char[N];
            for (int i = 0; i < N; i++) {
                // stops are earlier in the timeline than starts in the same minute
                time[i * 2] = in.nextInt() * 2000 + 1000 + i;
                time[i * 2 + 1] = in.nextInt() * 2000 + i;
            }
            Arrays.sort(time);
            int min = 0;
            int type = 0;
            int id = 0;
            int actionJamie = -1;
            int actionCameron = -1;
            int j = 0;
            while (valid && j < doubleN) {
                min = time[j] / 2000;
                id = time[j] % 1000;
                if (time[j] % 2000 < 1000) {
                    // handle a new end
                    //System.out.println("Activity " + id + ": ends in " + min + " min");
                    if (actionJamie == id) {
                        actionJamie = -1;
                    } else if (actionCameron == id) {
                        actionCameron = -1;
                    } else
                        valid = false;
                } else {
                    // handle a new start
                    //System.out.println("Activity " + id + ": starts in " + min + " min");
                    if (actionJamie < 0) {
                        actionJamie = id;
                        schedule[id] = 'J';
                    } else if (actionCameron < 0) {
                        actionCameron = id;
                        schedule[id] = 'C';
                    } else
                        valid = false;
                }
                j++;
            }
            System.out.println("Case #" + t + ": " + (valid ? String.valueOf(schedule) : "IMPOSSIBLE"));
        }
    }
}