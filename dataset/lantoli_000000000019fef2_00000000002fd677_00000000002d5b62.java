import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            System.out.println("Case #" + test + ": " + doit(sc.nextLong(), sc.nextLong()));
        }
    }

    private static String doit(long xx, long yy) {
        long x = Math.abs(xx);
        boolean xaxis = x == xx;
        long y = Math.abs(yy);
        boolean yaxis = y == yy;
        boolean xodd = x % 2 != 0;
        boolean yodd = y % 2 != 0;
        if (!(xodd ^ yodd)) return "IMPOSSIBLE";
        long sum_total = x + y;

        long sum = 1;
        long mul = 1;
        int times = 1;
        while (sum < sum_total) {
            mul <<= 1;
            times++;
            sum += mul;
        }

        StringBuilder sb = new StringBuilder();
        long xcur = x, ycur = y;
        while (mul >= 1) {
            long xleft = Math.abs(xcur - mul);
            long xright = Math.abs(xcur + mul);
            long yup = Math.abs(ycur + mul);
            long ydown = Math.abs(ycur - mul);
            long choose = Math.min(Math.min(xleft, xright), Math.min(yup, ydown));
            if (xleft == choose) {
                sb.append(xaxis ? 'E' : 'W');
                xcur -= mul;
            } else if (xright == choose) {
                sb.append(xaxis ? 'W' : 'E');
                xcur += mul;
            } else if (yup == choose) {
                sb.append(yaxis ? 'S' : 'N');
                ycur += mul;
            } else { // ydown
                sb.append(yaxis ? 'N' : 'S');
                ycur -= mul;
            }
            mul >>= 1;
        }
        return sb.reverse().toString();
    }
}
