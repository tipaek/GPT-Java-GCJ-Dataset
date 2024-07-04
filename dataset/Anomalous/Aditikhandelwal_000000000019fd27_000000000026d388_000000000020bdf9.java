import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;

        while (t > 0) {
            int n = scn.nextInt();
            int minC = 0, maxC = 0, minJ = Integer.MAX_VALUE, maxJ = Integer.MIN_VALUE;
            StringBuilder str = new StringBuilder();
            boolean impossible = false;

            for (int i = 1; i <= n; i++) {
                int s = scn.nextInt();
                int e = scn.nextInt();

                if (i == 1) {
                    str.append("C");
                    minC = s;
                    maxC = e;
                } else if (isOverlapping(minC, maxC, s, e) || isOverlapping(s, e, minC, maxC)) {
                    if (isOverlapping(minJ, maxJ, s, e) || isOverlapping(s, e, minJ, maxJ)) {
                        System.out.println("Case #" + (tc - t + 1) + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else {
                        str.append("J");
                        minJ = Math.min(minJ, s);
                        maxJ = Math.max(maxJ, e);
                    }
                } else {
                    str.append("C");
                    minC = Math.min(minC, s);
                    maxC = Math.max(maxC, e);
                }
            }

            if (!impossible) {
                System.out.println("Case #" + (tc - t + 1) + ": " + str.toString());
            }

            t--;
        }
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < start2 && end1 > start2) || (start1 < end2 && end1 > end2) || (start2 < start1 && end2 > end1);
    }
}