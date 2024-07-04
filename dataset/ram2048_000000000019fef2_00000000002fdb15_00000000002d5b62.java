import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();

            String path = path(X, Y);

            if (path == null) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + path);
            }
        }
    }

    public static String path(int X, int Y) {
        boolean xReversed = false;
        boolean yReversed = false;

        if (X < 0) {
            X = -X;
            xReversed = true;
        }

        if (Y < 0) {
            Y = -Y;
            yReversed = true;
        }

        int m = 1;
        int M = 2;
        String path = "";
        while (X > 0 || Y > 0) {
            if (X % M == m) {
                // will be along x axis
                if (Y == 0 && X == m) {
                    path += "E";
                    X -= m;
                } else if ((X+m+Y) % (2*M) == M) {
                    path += "W";
                    X += m;
                } else if ((X-m+Y) % (2*M) == M) {
                    path += "E";
                    X -= m;
                } else {
                    return null;
                }
            } else if (Y % M == m) {
                // will be along y axis
                if (X == 0 && Y == m) {
                    path += "N";
                    Y -= m;
                } else if ((X+m+Y) % (2*M) == M) {
                    path += "S";
                    Y += m;
                } else if ((X-m+Y) % (2*M) == M) {
                    path += "N";
                    Y -= m;
                } else {
                    return null;
                }
            } else {
                // no way
                return null;
            }
            m = 2 * m;
            M = 2 * M;
        }
        String reversed = "";
        for (char ch: path.toCharArray()) {
            if (ch == 'E' || ch == 'W') {
                if (xReversed) {
                    reversed += (ch == 'E') ? "W" : "E";
                } else {
                    reversed += ch;
                }
            } else if (ch == 'S' || ch == 'N') {
                if (yReversed) {
                    reversed += (ch == 'S') ? "N" : "S";
                } else {
                    reversed += ch;
                }
            }
        }
        return reversed;
    }
}
