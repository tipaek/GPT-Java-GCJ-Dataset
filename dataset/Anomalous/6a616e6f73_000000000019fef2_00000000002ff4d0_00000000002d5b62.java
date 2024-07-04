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
        char newline = '\n';

        sb.append(T).append(newline);
        for (int t = 0; t < T; t++) {
            sb.append(A).append(newline);
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
        addMapping(-4, -3, "SSW");
        addMapping(-4, -1, "NSEW");
        addMapping(-4, 1, "SNEW");
        addMapping(-4, 3, "NNW");
        addMapping(-3, -4, "WWS");
        addMapping(-3, -2, "ESW");
        addMapping(-3, 0, "WW");
        addMapping(-3, 2, "ENW");
        addMapping(-3, 4, "WWN");
        addMapping(-2, -3, "NWS");
        addMapping(-2, -1, "SW");
        addMapping(-2, 1, "NW");
        addMapping(-2, 3, "SWN");
        addMapping(-1, -4, "EWNS");
        addMapping(-1, -2, "WS");
        addMapping(-1, 0, "W");
        addMapping(-1, 2, "WN");
        addMapping(-1, 4, "EWSN");
        addMapping(0, -3, "SS");
        addMapping(0, -1, "S");
        addMapping(0, 1, "N");
        addMapping(0, 3, "NN");
        addMapping(1, -4, "WENS");
        addMapping(1, -2, "ES");
        addMapping(1, 0, "E");
        addMapping(1, 2, "EN");
        addMapping(1, 4, "WESN");
        addMapping(2, -3, "NES");
        addMapping(2, -1, "SE");
        addMapping(2, 1, "NE");
        addMapping(2, 3, "SEN");
        addMapping(3, -4, "EES");
        addMapping(3, -2, "WSN");
        addMapping(3, 0, "EE");
        addMapping(3, 2, "WNS");
        addMapping(3, 4, "EEN");
        addMapping(4, -3, "SSE");
        addMapping(4, -1, "NSWE");
        addMapping(4, 1, "SNWE");
        addMapping(4, 3, "NNE");
    }

    private static void addMapping(int x, int y, String s) {
        map.put(String.format("%d:%d", x, y), s);
    }

    private static String solve(Input input) {
        if (input.X % 2 == input.Y % 2) return "IMPOSSIBLE";

        String key = String.format("%d:%d", input.X, input.Y);
        return map.getOrDefault(key, "IMPOSSIBLE");
    }
}