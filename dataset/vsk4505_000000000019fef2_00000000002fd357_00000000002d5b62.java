import java.util.Scanner;

public class Solution {
    public final static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            long X = scanner.nextInt();
            long Y = scanner.nextInt();

            long obsOfX = Math.abs(X);
            long obsOfY = Math.abs(Y);

            long twosvalue = 1;
            StringBuilder sb = new StringBuilder();
            boolean impossible = false;

            while ((twosvalue << 1) < (obsOfX + obsOfY)) {
                twosvalue <<= 1;
            }

            while (X != 0 || Y != 0) {
                if (obsOfX >= obsOfY) {
                    if (X < 0) {
                        X += twosvalue;
                        sb.append("W");
                    } else {
                        X += -twosvalue;
                        sb.append("E");
                    }
                } else {
                    if (Y < 0) {
                        Y += twosvalue;
                        sb.append("S");
                    } else {
                        Y += -twosvalue;
                        sb.append("N");
                    }
                }
                if (Math.abs(X) + Math.abs(Y) >= obsOfX + obsOfY) {
                    impossible = true;
                    break;
                }
                obsOfX = Math.abs(X);
                obsOfY = Math.abs(Y);
                twosvalue >>= 1;
            }
            System.out.println("Case #" + (i + 1) + ": " + (impossible ? "IMPOSSIBLE" : sb.reverse()));
        }
    }
}