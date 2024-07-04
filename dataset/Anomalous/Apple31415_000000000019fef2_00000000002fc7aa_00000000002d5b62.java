import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numCases = Integer.parseInt(st.nextToken());

            for (int i = 0; i < numCases; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                System.out.printf("Case #%d: %s%n", i + 1, generatePath(x, y));
            }
        }
    }

    public static String generatePath(int x0, int y0) {
        int x = Math.abs(x0);
        int y = Math.abs(y0);
        StringBuilder path = new StringBuilder();

        while (x != 0 || y != 0) {
            if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
                return "IMPOSSIBLE";
            }

            if (x % 2 == 1) {
                y /= 2;
                if (y % 2 == 1) {
                    if (x % 4 == 1) {
                        path.append("W");
                        x /= 2;
                    } else {
                        path.append("E");
                        x = (x + 1) / 2;
                    }
                } else {
                    if (x % 4 == 1 && (x != 1 || y != 0)) {
                        path.append("E");
                        x = (x + 1) / 2;
                    } else {
                        path.append("W");
                        x /= 2;
                    }
                }
            } else {
                x /= 2;
                if (x % 2 == 1) {
                    if (y % 4 == 1) {
                        path.append("S");
                        y /= 2;
                    } else {
                        path.append("N");
                        y = (y + 1) / 2;
                    }
                } else {
                    if (y % 4 == 1 && (y != 1 || x != 0)) {
                        path.append("N");
                        y = (y + 1) / 2;
                    } else {
                        path.append("S");
                        y /= 2;
                    }
                }
            }
        }

        if (x0 > 0) {
            path = new StringBuilder(flipX(path.toString()));
        }
        if (y0 > 0) {
            path = new StringBuilder(flipY(path.toString()));
        }

        return path.toString();
    }

    public static String flipY(String input) {
        StringBuilder result = new StringBuilder(input);
        for (int i = 0; i < result.length(); i++) {
            switch (result.charAt(i)) {
                case 'S':
                    result.setCharAt(i, 'N');
                    break;
                case 'N':
                    result.setCharAt(i, 'S');
                    break;
            }
        }
        return result.toString();
    }

    public static String flipX(String input) {
        StringBuilder result = new StringBuilder(input);
        for (int i = 0; i < result.length(); i++) {
            switch (result.charAt(i)) {
                case 'W':
                    result.setCharAt(i, 'E');
                    break;
                case 'E':
                    result.setCharAt(i, 'W');
                    break;
            }
        }
        return result.toString();
    }
}