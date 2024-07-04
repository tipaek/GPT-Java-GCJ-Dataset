import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int[][] c = new int[N][2];
            int[][] j = new int[N][2];
            int cCount = 0, jCount = 0;
            StringBuilder order = new StringBuilder();
            boolean isPossible = true;

            for (int n = 0; n < N; n++) {
                int start = scan.nextInt();
                int end = scan.nextInt();

                if (hasTimeSlot(start, end, c, cCount)) {
                    c[cCount][0] = start;
                    c[cCount][1] = end;
                    cCount++;
                    order.append('C');
                } else if (hasTimeSlot(start, end, j, jCount)) {
                    j[jCount][0] = start;
                    j[jCount][1] = end;
                    jCount++;
                    order.append('J');
                } else {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(order.toString());
            }
        }
    }

    static boolean hasTimeSlot(int start, int end, int[][] slots, int count) {
        for (int i = 0; i < count; i++) {
            if ((start >= slots[i][0] && start < slots[i][1]) || 
                (end > slots[i][0] && end <= slots[i][1]) || 
                (start <= slots[i][0] && end >= slots[i][1])) {
                return false;
            }
        }
        return true;
    }
}