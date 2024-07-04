import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int activities = in.nextInt();
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            int[][] CAM = new int[1002][2];
            int[][] JAM = new int[1002][2];
            int c = 0, j = 0;
            
            for (int p = 0; p < activities; p++) {
                int start = in.nextInt();
                int end = in.nextInt();

                if (impossible) {
                    continue;
                }

                if (canAssignActivity(CAM, c, start, end)) {
                    result.append("C");
                    c++;
                } else if (canAssignActivity(JAM, j, start, end)) {
                    result.append("J");
                    j++;
                } else {
                    impossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : result.toString()));
        }
        in.close();
    }

    private static boolean canAssignActivity(int[][] data, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if (!(start > data[i][1] || (end - 1) < data[i][0])) {
                return false;
            }
        }
        data[count][0] = start;
        data[count][1] = end - 1;
        return true;
    }
}