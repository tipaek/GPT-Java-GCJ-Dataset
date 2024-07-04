import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static int radius = (int) (10e9 / 2);

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = in.readLine().split(" ");
            int tests = Integer.parseInt(line[0]);
            int x;
            int y;
            for (int test = 0; test < tests; test++) {
                x = (int) Math.sqrt(2) * radius - 1;
                y = (int) Math.sqrt(2) * radius - 1;
                int res = test(in, x, y);
                if (res == 2)
                    continue;
                else if (res == 1) {
                    loop(in, x, y);
                }
                x = (int) Math.sqrt(2) * radius - 1;
                y = -(int) Math.sqrt(2) * radius - 1;
                res = test(in, x, y);
                if (res == 2)
                    continue;
                else if (res == 1) {
                    loop(in, x, y);
                }
                x = -(int) Math.sqrt(2) * radius - 1;
                y = (int) Math.sqrt(2) * radius - 1;
                res = test(in, x, y);
                if (res == 2)
                    continue;
                else if (res == 1) {
                    loop(in, x, y);
                }
                x = -(int) Math.sqrt(2) * radius - 1;
                y = -(int) Math.sqrt(2) * radius - 1;
                res = test(in, x, y);
                if (res == 1) {
                    loop(in, x, y);
                }
            }
        }
    }

    private static void loop(BufferedReader in, int x, int y) throws IOException {
        int[] res = findEdge(in, x, y, -1, 0, radius);
        if (res[2] == 1)
            return;
        int x1 = res[0];
        res = findEdge(in, x, y, 1, 0, radius - (x - x1));
        if (res[2] == 1)
            return;
        int x2 = res[0];
        x = (x1 + x2) / 2;

        res = findEdge(in, x, y, 0, -1, radius);
        if (res[2] == 1)
            return;
        int y1 = res[0];
        res = findEdge(in, x, y, 0, 1, radius - (y - y1));
        if (res[2] == 1)
            return;
        int y2 = res[0];
        y = (y1 + y2) / 2;

        int code = test(in, x, y);
        if (code == 2)
            return;
        code = test(in, x + 1, y);
        if (code == 2)
            return;
        code = test(in, x - 1, y);
        if (code == 2)
            return;
        code = test(in, x, y - 1);
        if (code == 2)
            return;
        code = test(in, x, y + 1);
        if (code == 2)
            return;
        code = test(in, x + 1, y + 1);
        if (code == 2)
            return;
        code = test(in, x - 1, y - 1);
        if (code == 2)
            return;
        code = test(in, x - 1, y + 1);
        if (code == 2)
            return;
        code = test(in, x + 1, y - 1);
        if (code == 2)
            return;
        System.exit(0);
    }

    private static int[] findEdge(BufferedReader in, int x, int y, int dx, int dy, int dist) throws IOException {
        int delta = dist / 2;
        while (delta > 0) {
            x += dx * dist;
            y += dy * dist;

            int res = test(in, x, y);
            if (res == 2)
                return new int[]{0, 0, 1};
            if (res == 0) {
                dist -= delta;
            }
            if (res == 1) {
                dist += delta;
            }
            delta /= 2;
        }
        return new int[]{x, y, 0};
    }

    private static int test(BufferedReader in, int x, int y) throws IOException {
        System.out.println(x + " " + y);
        String result = in.readLine();
        if (result.equals("CENTER")) {
            return 2;
        } else if (result.equals("MISS")) {
            return 0;
        } else if (result.equals("HIT")) {
            return 1;
        } else {
            System.exit(0);
        }
        return -1;
    }
}