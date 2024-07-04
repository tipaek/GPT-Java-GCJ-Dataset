import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());

        for (int run = 1; run <= runs; run++) {
            int num = Integer.parseInt(console.nextLine());
            int[] starts = new int[num];
            int[] ends = new int[num];

            for (int i = 0; i < num; i++) {
                starts[i] = console.nextInt();
                ends[i] = console.nextInt();
            }
            console.nextLine();

            ArrayList<int[]> CTimes = new ArrayList<>();
            ArrayList<int[]> JTimes = new ArrayList<>();
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < num; i++) {
                boolean canUseC = canUseSlot(CTimes, starts[i], ends[i]);
                boolean canUseJ = canUseSlot(JTimes, starts[i], ends[i]);

                if (canUseC) {
                    CTimes.add(new int[]{starts[i], ends[i]});
                    answer.append("C");
                } else if (canUseJ) {
                    JTimes.add(new int[]{starts[i], ends[i]});
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + run + ": " + answer.toString());
        }
    }

    private static boolean canUseSlot(ArrayList<int[]> times, int start, int end) {
        for (int[] time : times) {
            if (!(end <= time[0] || start >= time[1])) {
                return false;
            }
        }
        return true;
    }
}