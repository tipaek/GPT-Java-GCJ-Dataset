import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int t1 = 1; t1 <= t; t1++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            
            char[] assignments = new char[n];
            assignments[0] = 'C';
            boolean isPossible = true;
            
            for (int i = 1; i < n && isPossible; i++) {
                boolean overlapWithC = false;
                boolean overlapWithJ = false;
                for (int j = 0; j < i; j++) {
                    if ((intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0])) {
                        if (assignments[j] == 'C') {
                            overlapWithC = true;
                        } else {
                            overlapWithJ = true;
                        }
                    }
                }
                if (overlapWithC && overlapWithJ) {
                    isPossible = false;
                } else if (overlapWithC) {
                    assignments[i] = 'J';
                } else {
                    assignments[i] = 'C';
                }
            }
            
            if (isPossible) {
                System.out.print("Case #" + t1 + " ");
                for (char c : assignments) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t1 + " IMPOSSIBLE");
            }
        }
        sc.close();
    }
}