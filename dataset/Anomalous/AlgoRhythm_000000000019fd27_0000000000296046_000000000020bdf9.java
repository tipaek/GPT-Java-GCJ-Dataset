import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            String result = assignTasks(n, intervals);
            System.out.println("Case #" + (l + 1) + ": " + result);
        }
    }

    static String assignTasks(int n, int[][] intervals) {
        int[][] jamie = new int[n][2];
        int[][] cameron = new int[n][2];
        int j = 0, c = 0;
        StringBuilder str = new StringBuilder("J");
        jamie[j][0] = intervals[0][0];
        jamie[j++][1] = intervals[0][1];
        return evaluate(jamie, cameron, n, 1, intervals, str, j, c);
    }

    static String evaluate(int[][] jamie, int[][] cameron, int n, int start, int[][] intervals, StringBuilder str, int ja, int ca) {
        for (int i = start; i < n; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            boolean fj = isAvailable(jamie, s, e, ja);
            boolean fc = isAvailable(cameron, s, e, ca);

            if (fj && !fc) {
                jamie[ja][0] = s;
                jamie[ja++][1] = e;
                str.append("J");
            } else if (fc && !fj) {
                cameron[ca][0] = s;
                cameron[ca++][1] = e;
                str.append("C");
            } else if (fj && fc) {
                jamie[ja][0] = s;
                jamie[ja++][1] = e;
                StringBuilder str1 = new StringBuilder(str).append("J");
                String res1 = evaluate(jamie, cameron, n, i + 1, intervals, str1, ja, ca);

                cameron[ca][0] = s;
                cameron[ca++][1] = e;
                jamie[--ja][0] = 0;
                jamie[ja][1] = 0;
                StringBuilder str2 = new StringBuilder(str).append("C");
                String res2 = evaluate(jamie, cameron, n, i + 1, intervals, str2, ja, ca);

                if ("IMPOSSIBLE".equals(res1)) {
                    return "IMPOSSIBLE".equals(res2) ? res1 : res2;
                } else {
                    return res1;
                }
            } else {
                return "IMPOSSIBLE";
            }
        }
        return str.toString();
    }

    static boolean isAvailable(int[][] arr, int s, int e, int n) {
        for (int i = 0; i < n; i++) {
            if ((s <= arr[i][0] && e > arr[i][0]) ||
                (s >= arr[i][0] && e < arr[i][1]) ||
                (s < arr[i][1] && e >= arr[i][1])) {
                return false;
            }
        }
        return true;
    }
}