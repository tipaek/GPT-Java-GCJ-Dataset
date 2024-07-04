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

            int d = 1;
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
                xList.add(xD); yList.add(yD);
                boolean last = X == 0 && Y == 0;
                boolean nexZeroes = !last && X % 2 == 0 && Y % 2 == 0;
                boolean nextOnes = !last && X % 2 == 1 && Y % 2 == 1;

                if (xRev && xD == 0) {
                    if (!nexZeroes) {
                        xRev = false;
                    }
                    sb.append(((minX ^ nexZeroes)? "W" : "E"));
                    if (yD == 1) {
                        impossible = true;
                        break;
                    }
                } else if (yRev && yD == 0) {
                    if (!nexZeroes) {
                        yRev = false;
                    }
                    sb.append(((minY ^ nexZeroes)? "S" : "N"));
                    if (xD == 1) {
                        impossible = true;
                        break;
                    }
                } else if (!xRev && !yRev && nextOnes) {
                    if (xD == 0 && yD == 0) {
                        impossible = true;
                        break;
                    } else if (xD == 1) {
                        xRev = true;
                        sb.append((!minX ? "W" : "E"));
                    } else {
                        yRev = true;
                        sb.append((!minY ? "S" : "N"));
                    }
                } else {
                    if (xRev) {
                        xD = 1 - xD;
                    }
                    if (yRev) {
                        yD = 1 - yD;
                    }
                    if (xD == yD) {
                        impossible = true;
                        break;
                    }
                    if (xD == 1) {
                        sb.append(((minX ^ xRev) ? "W" : "E"));
                    }
                    if (yD == 1) {
                        sb.append(((minY ^ yRev) ? "S" : "N"));
                    }
                }
            }

            if (impossible) {
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
