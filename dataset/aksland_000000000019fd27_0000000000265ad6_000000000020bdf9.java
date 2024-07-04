import java.util.Scanner;

public class Solution {

    static int[][] events;
    static boolean[] path;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCases = sc.nextInt();
        for (int i = 0; i < tCases; i++) {
            int nActivities = sc.nextInt();
            events = new int[nActivities][2];
            path = new boolean[nActivities];
            for (int j = 0; j < nActivities; j++) {
                events[j][0] = sc.nextInt();
                events[j][1] = sc.nextInt();
            }

            System.out.print("Case #"+ (i+1) + ": ");

            if (solve(0)){
                StringBuilder str = new StringBuilder();
                for (boolean b : path) {
                    str.append(b ? 'C' : 'J');
                }
                System.out.println(str.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
}

    private static boolean solve(int current) {
        boolean canBeFalse = true;
        boolean canBeTrue = true;

        if (current == path.length) return true;

        for (int i = 0; i < current; i++) {
                if (events[i][1] > events[current][0] && events[current][1] > events[i][0]) {
                    if (path[i]) {
                        canBeTrue = false;
                    } else {
                        canBeFalse = false;
                    }

            }
        }

        if (canBeTrue) {
            path[current] = true;
            if (solve(current+1)) {
                return true;
            }
            path[current] = false;
        }

        if (canBeFalse) {
        return solve(current+1);
        }

        return false;

    }
}
