import java.util.*;
import java.io.*;

public class Solution {

    static class Node {
        String path;
        int x;
        int y;
        int step;

        Node(String path, int x, int y, int step) {
            this.path = path;
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    private static int nbCases;
    private static int caseNumber;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner in) throws Exception {
        nbCases = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= nbCases; ++i) {
            caseNumber = i;
            doCase(in);
        }
    }

    private static void doCase(Scanner sc) throws Exception {
        String input = sc.nextLine();
        String[] coordsString = input.split(" ");
        int targetX = Integer.parseInt(coordsString[0]);
        int targetY = Integer.parseInt(coordsString[1]);

        LinkedList<Node> queue = new LinkedList<>();
        Node start = new Node("", 0, 0, 1);
        queue.add(start);

        Node current = start;

        /*if (impossible(targetX, targetY)) {
            printResult("IMPOSSIBLE");
            return;
        }*/

        while (!tooFar(current, targetX, targetY)) {
            current = queue.pollFirst();
            if (current.x == targetX && current.y == targetY) {
                printResult(current.path);
                return;
            }

            Node northNode = new Node(current.path + "N", current.x, current.y + current.step, current.step * 2);
            Node southNode = new Node(current.path + "S", current.x, current.y - current.step, current.step * 2);
            Node eastNode = new Node(current.path + "E", current.x + current.step, current.y, current.step * 2);
            Node westNode = new Node(current.path + "W", current.x - current.step, current.y, current.step * 2);

            queue.addLast(northNode);
            queue.addLast(southNode);
            queue.addLast(eastNode);
            queue.addLast(westNode);
        }

        printResult("IMPOSSIBLE");
    }

    private static boolean tooFar(Node current, int targetX, int targetY) {
        return Math.abs(current.x) > 50 * Math.abs(targetX) && Math.abs(current.y) > 50 * Math.abs(targetY);
    }

    private static boolean impossible(int targetX, int targetY) {
        int absX = Math.abs(targetX);
        int absY = Math.abs(targetY);

        String x = Integer.toBinaryString(absX);
        String y = Integer.toBinaryString(absY);

        int length = Math.max(x.length(), y.length());

        for (int i = 0; i < length; i++) {
            if (i >= x.length() || i >= y.length()) {
                return false;
            }

            if (x.charAt(i) == '1' && y.charAt(i) == '1') {
                return true;
            }
        }

        return true;

    }

    public static void printResult(String result) {
        if (caseNumber < nbCases) {
            System.out.println("Case #" + Integer.toString(caseNumber) + ": " + result);
        } else {
            System.out.print("Case #" + Integer.toString(caseNumber) + ": " + result);
        }
    }
}
