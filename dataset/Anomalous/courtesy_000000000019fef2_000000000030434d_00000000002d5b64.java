import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        for (int cs = 1; cs <= testCases; cs++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            if (rows * cols > 20) {
                return;
            }
            List<Pair> result = solve(rows, cols);
            writer.println("Case #" + cs + ": ");
            for (Pair p : result) {
                writer.println(p.x + " " + p.y);
            }
        }
        writer.flush();
    }

    private static List<Pair> solve(int rows, int cols) {
        Map<String, Pair> dp = new HashMap<>();
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();

        for (int i = 0; i < cols; i++) {
            for (int j = 1; j <= rows; j++) {
                start.append(j);
            }
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                end.append(i);
            }
        }

        dp.put(start.toString(), new Pair(0, 0));
        Queue<String> queue = new LinkedList<>();
        queue.add(start.toString());

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            String current = queue.poll();
            for (int i = 1; i < current.length() && !found; i++) {
                for (int j = 1; i + j <= current.length() && !found; j++) {
                    String newString = current.substring(i, i + j) + current.substring(0, i);
                    if (i + j < current.length()) {
                        newString += current.substring(i + j);
                    }
                    if (!dp.containsKey(newString)) {
                        dp.put(newString, new Pair(i, j));
                        queue.add(newString);
                    }
                    if (newString.equals(end.toString())) {
                        found = true;
                    }
                }
            }
        }

        List<Pair> result = new ArrayList<>();
        String current = end.toString();
        while (!current.equals(start.toString())) {
            Pair p = dp.get(current);
            int i = p.y, j = p.x;
            String newString = current.substring(i, i + j) + current.substring(0, i);
            if (i + j < current.length()) {
                newString += current.substring(i + j);
            }
            result.add(p);
            current = newString;
        }

        Collections.reverse(result);
        return result;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}