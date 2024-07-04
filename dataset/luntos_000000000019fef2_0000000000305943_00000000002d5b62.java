import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            System.out.print("Case #" + t + ": ");
            StringBuilder sb = new StringBuilder();
            boolean minX = (X < 0);
            boolean minY = (Y < 0);
            if (minX) X = -X;
            if (minY) Y = -Y;

            boolean impossible = false;
            if (X % 2 == Y % 2) {
                impossible = true;
            }
            boolean xRev = false, yRev = false;
            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();
            while (!impossible && (X > 0 || Y > 0)) {
                int xD = X % 2;
                int yD = Y % 2;
                X /= 2; Y /= 2;
                if (xRev) xD = 1 - xD;
                if (yRev) yD = 1 - yD;
                xList.add(xD); yList.add(yD);
                boolean last = X == 0 && Y == 0;
                int nextXD = xRev ? 1 - X % 2 : X % 2;
                int nextYD = yRev ? 1 - Y % 2 : Y % 2;
                boolean nexEqual = (nextXD == nextYD);

                if (xD == yD) {
                    impossible = true;
                    break;
                } else if (nexEqual) {
                    if (xD == 1) {
                        xRev ^= true;
                        sb.append(((minX ^ xRev) ? "W" : "E"));
                    } else if (yD == 1) {
                        yRev ^= true;
                        sb.append(((minY ^ yRev) ? "S" : "N"));
                    }
                } else if (xD == 1) {
                    sb.append(((minX ^ xRev) ? "W" : "E"));
//                    if (xRev) {
//                        xRev = false;
//                    }
                } else if (yD == 1) {
                    sb.append(((minY ^ yRev) ? "S" : "N"));
//                    if (yRev) {
//                        yRev = false;
//                    }
                }
            }

            if (impossible || (xRev && yRev)) {
                System.out.println("IMPOSSIBLE");
            } else {
                if (xRev) {
                    sb.append(!minX ? "E" : "W");
                }
                if (yRev) {
                    sb.append(!minY ? "N" : "S");
                }
                System.out.println(sb.toString());
            }

        }

    }
}
