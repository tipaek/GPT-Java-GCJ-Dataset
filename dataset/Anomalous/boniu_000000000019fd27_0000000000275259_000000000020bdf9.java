import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static int[][] activities;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            activities = new int[N][2];
            
            for (int n = 0; n < N; n++) {
                activities[n][0] = scanner.nextInt();
                activities[n][1] = scanner.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder();
            ArrayList<Integer> idxC = new ArrayList<>();
            ArrayList<Integer> idxJ = new ArrayList<>();
            
            for (int i = 0; i < activities.length; i++) {
                if (!isOverlapping(idxC, activities[i][0], activities[i][1])) {
                    idxC.add(i);
                    schedule.append("C");
                } else if (!isOverlapping(idxJ, activities[i][0], activities[i][1])) {
                    idxJ.add(i);
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.printf("Case #%d: %s%n", t, schedule.toString());
        }
    }

    public static boolean isOverlapping(ArrayList<Integer> indexes, int start, int end) {
        for (int index : indexes) {
            if (start < activities[index][1] && end > activities[index][0]) {
                return true;
            }
        }
        return false;
    }
}