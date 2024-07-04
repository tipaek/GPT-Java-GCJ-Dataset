import java.util.Scanner;

public class Solution {

    static final boolean LOG = false;
    static final int MIN = -1_000_000_000;
    static final int MAX = 1_000_000_000;
    static int sx;
    static int sy;

    static void log(String message) {
        if (LOG) {
            System.err.println(message);
        }
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static String sendCommand(Scanner scanner, String command) {
        log("Send: " + command);
        System.out.println(command);
        System.out.flush();
        String response = scanner.next();
        log("Read: " + response);
        return response;
    }

    private static boolean attemptToSetCenter(Scanner scanner, int x, int y) {
        String response = sendCommand(scanner, x + " " + y);
        if (!"MISS".equals(response)) {
            sx = x;
            sy = y;
            return true;
        }
        return false;
    }

    private static Position locateEdgeX(Scanner scanner, int xIn, int xOut, int y) {
        if (Math.abs(xIn - xOut) == 1) {
            return new Position(xIn, y);
        }
        int mid = (xIn + xOut) / 2;
        String response = sendCommand(scanner, mid + " " + y);
        if ("MISS".equals(response)) {
            return locateEdgeX(scanner, xIn, mid, y);
        }
        return locateEdgeX(scanner, mid, xOut, y);
    }

    private static Position locateEdgeY(Scanner scanner, int yIn, int yOut, int x) {
        log("EdgeY in: " + yIn + " out: " + yOut);
        if (Math.abs(yIn - yOut) == 1) {
            return new Position(x, yIn);
        }
        int mid = (yIn + yOut) / 2;
        String response = sendCommand(scanner, x + " " + mid);
        if ("MISS".equals(response)) {
            return locateEdgeY(scanner, yIn, mid, x);
        }
        return locateEdgeY(scanner, mid, yOut, x);
    }

    private static boolean process(Scanner scanner, int A, int B) {
        if (!attemptToSetCenter(scanner, MAX / 2, 0) &&
            !attemptToSetCenter(scanner, -MAX / 2, 0) &&
            !attemptToSetCenter(scanner, 0, MAX / 2)) {
            attemptToSetCenter(scanner, 0, -MAX / 2);
        }

        log("START: " + sx + " " + sy);

        Position p1 = locateEdgeX(scanner, sx, MIN - 1, sy);
        log("P1: " + p1);
        Position p2 = locateEdgeX(scanner, sx, MAX + 1, sy);
        log("P2: " + p2);
        Position p3 = locateEdgeY(scanner, sy, MIN - 1, sx);
        log("P3: " + p3);
        Position p4 = locateEdgeY(scanner, sy, MAX + 1, sx);
        log("P4: " + p4);

        log("P1: " + p1);
        log("P2: " + p2);
        log("P3: " + p3);
        log("P4: " + p4);

        int x = (p1.x + p2.x) / 2;
        int y = (p3.y + p4.y) / 2;
        log("Result: " + x + " " + y);
        String result = sendCommand(scanner, x + " " + y);
        return "CENTER".equals(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        log(T + " " + A + " " + B);
        for (int i = 0; i < T; i++) {
            if (!process(scanner, A, B)) {
                break;
            }
        }
    }
}