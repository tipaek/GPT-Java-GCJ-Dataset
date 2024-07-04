import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {


    static void swap(StringBuilder s) {
        switch (s.charAt(s.length() - 1)) {
            case 'W' :
                s.setCharAt(s.length() - 1, 'E');
                return;
            case 'E' :
                s.setCharAt(s.length() - 1, 'W');
                return;
            case 'N' :
                s.setCharAt(s.length() - 1, 'S');
                return;
            case 'S' :
                s.setCharAt(s.length() - 1, 'N');
                return;
        }
        throw new IllegalArgumentException();
    }

    static void swap(StringBuilder s, boolean swapx, boolean swapy) {

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'W' :
                    if (swapx) {
                        s.setCharAt(i, 'E');
                    }
                    break;
                case 'E' :
                    if (swapx) {
                        s.setCharAt(i, 'W');
                    }
                    break;
                case 'N' :
                    if (swapy) {
                        s.setCharAt(i, 'S');
                    }
                    break;
                case 'S' :
                    if (swapy) {
                        s.setCharAt(i, 'N');
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }

        }

    }

    public static void solve(int caze, long x, long y) throws IOException {

        boolean swapx = x < 0;
        if (swapx) {
            x = -x;
        }
        boolean swapy = y < 0;
        if (swapy) {
            y = -y;
        }

        StringBuilder solution = new StringBuilder();
        if (x % 2 == y % 2) {
            System.out.println("Case #" + caze + ": IMPOSSIBLE");
            return;
        }

        boolean directionEW = x % 2 == 1;
        if (x % 2 == 1) {
            solution.append("E");
        } else {
            solution.append("N");
        }

        long modulo = 2;
        boolean stop = false;

        while(!stop) {
            if (x / modulo % 2 == 0 && y / modulo % 2 == 0) {
                swap(solution);
                solution.append(directionEW ? "E" : "N");
                modulo *= 2;
            } else if (x / modulo % 2 != 0 && y / modulo % 2 != 0) {
                swap(solution);
                if (directionEW) {
                    x += modulo;
                } else {
                    y += modulo;
                }
                directionEW = !directionEW;
            } else if (x / modulo % 2 != 0) {
                solution.append("E");
                directionEW = true;
                modulo *= 2;
            } else {
                solution.append("N");
                directionEW = false;
                modulo *= 2;
            }
            stop = modulo > x && modulo > y;
        }

        swap(solution, swapx, swapy);
        System.out.println("Case #" + caze + ": " + solution.toString());

    }

    public static void main(String... args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");
        int cases = Integer.parseInt(line[0].trim());
        for (int i = 0; i < cases; i++) {
            line = reader.readLine().split(" ");
            long x = Integer.parseInt(line[0]);
            long y = Integer.parseInt(line[1]);
            solve(i + 1, x, y);
        }

    }
}
