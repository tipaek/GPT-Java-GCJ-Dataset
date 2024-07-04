import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // scanner = example();
        // scanner = bigTest();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            Input input = Input.fromScanner(scanner);
            printCase(t, solve(input));
        }
    }

    private static Scanner example() {
        return new Scanner("4\n" +
                "2 3\n" +
                "-2 -3\n" +
                "3 0\n" +
                "-1 1");
    }

    private static Scanner bigTest() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int T = 100;
        int A = 255;
        int maxLength = 500;

        sb.append(T).append('\n');
        for (int t = 0; t < T; t++) {
            sb.append(A).append('\n');
            for (int i = 0; i < A; i++) {
                int length = 1 + random.nextInt(maxLength);
                // TODO
            }
        }

        return new Scanner(sb.toString());
    }

    private static class Input {
        private final int X;
        private final int Y;

        public Input(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }

        public static Input fromScanner(Scanner scanner) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            return new Input(X, Y);
        }
    }

    private static void printCase(int t, String s) {
        System.out.println(String.format("Case #%d: %s", t + 1, s));
    }

    private static final Map<String, String> map = new HashMap<>();

    static {
        initializeMap();
    }

    private static void initializeMap() {
        put(-4, -3, "SSW");
        put(-4, -1, "NSW");
        put(-4, 1, "SNW");
        put(-4, 3, "NNW");
        put(-3, -4, "WWS");
        put(-3, -2, "ESW");
        put(-3, 0, "WW");
        put(-3, 2, "ENW");
        put(-3, 4, "WWN");
        put(-2, -3, "NWS");
        put(-2, -1, "SW");
        put(-2, 1, "NW");
        put(-2, 3, "SWN");
        put(-1, -4, "EWS");
        put(-1, -2, "WS");
        put(-1, 0, "W");
        put(-1, 2, "WN");
        put(-1, 4, "EWN");
        put(0, -3, "SS");
        put(0, -1, "S");
        put(0, 1, "N");
        put(0, 3, "NN");
        put(1, -4, "WES");
        put(1, -2, "ES");
        put(1, 0, "E");
        put(1, 2, "EN");
        put(1, 4, "WEN");
        put(2, -3, "NES");
        put(2, -1, "SE");
        put(2, 1, "NE");
        put(2, 3, "SEN");
        put(3, -4, "EES");
        put(3, -2, "WSE");
        put(3, 0, "EE");
        put(3, 2, "WNS");
        put(3, 4, "EEN");
        put(4, -3, "SSE");
        put(4, -1, "NSE");
        put(4, 1, "SNE");
        put(4, 3, "NNE");
    }

    private static void put(int x, int y, String s) {
        map.put(String.format("%d:%d", x, y), s);
    }

    private static String solve(Input input) {
        if (input.X % 2 == input.Y % 2) return "IMPOSSIBLE";

        String key = String.format("%d:%d", input.X, input.Y);
        return map.getOrDefault(key, "IMPOSSIBLE");
    }
}