import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();

        for (int z = 1; z <= t1; z++) {
            StringBuilder result = new StringBuilder();
            int n = sc.nextInt();
            int[][] cameron = new int[n][2];
            int[][] jamie = new int[n][2];
            int cameronCount = 0, jamieCount = 0;
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean assignToCameron = true, assignToJamie = true;

                for (int h = 0; h < cameronCount; h++) {
                    if ((cameron[h][1] > start && cameron[h][0] <= start) || (cameron[h][1] >= end && cameron[h][0] < end)) {
                        assignToCameron = false;
                        break;
                    }
                }

                for (int h = 0; h < jamieCount; h++) {
                    if ((jamie[h][1] > start && jamie[h][0] <= start) || (jamie[h][1] >= end && jamie[h][0] < end)) {
                        assignToJamie = false;
                        break;
                    }
                }

                if (assignToCameron) {
                    result.append('C');
                    cameron[cameronCount][0] = start;
                    cameron[cameronCount][1] = end;
                    cameronCount++;
                } else if (assignToJamie) {
                    result.append('J');
                    jamie[jamieCount][0] = start;
                    jamie[jamieCount][1] = end;
                    jamieCount++;
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + z + ": " + (isPossible ? result.toString() : "IMPOSSIBLE"));
        }
    }
}