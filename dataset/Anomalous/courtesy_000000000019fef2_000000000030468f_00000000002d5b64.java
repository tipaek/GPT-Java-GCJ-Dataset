import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        for (int cs = 1; cs <= testCases; cs++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            if (R * S > 20) return;

            List<Pair> result = solve(R, S);
            writer.println("Case #" + cs + ": " + result.size());
            for (Pair p : result) {
                writer.println(p.x + " " + p.y);
            }
        }
        writer.flush();
    }

    private static List<Pair> solve(int R, int S) {
        Map<String, Pair> dp = new HashMap<>();
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();

        for (int i = 0; i < S; i++) {
            for (int j = 1; j <= R; j++) {
                start.append(j);
            }
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 0; j < S; j++) {
                end.append(i);
            }
        }

        dp.put(start.toString(), new Pair(0, 0));
        Queue<String> queue = new LinkedList<>();
        queue.add(start.toString());
        boolean found = false;

        while (!queue.isEmpty() && !found) {
            String current = queue.remove();
            for (int i = 1; i < current.length(); i++) {
                for (int j = 1; i + j <= current.length(); j++) {
                    String newStr = current.substring(i, i + j) + current.substring(0, i);
                    if (i + j < current.length()) {
                        newStr += current.substring(i + j);
                    }
                    if (!dp.containsKey(newStr)) {
                        dp.put(newStr, new Pair(i, j));
                        queue.add(newStr);
                    }
                    if (newStr.equals(end.toString())) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }

        List<Pair> answer = new ArrayList<>();
        String endStr = end.toString();
        while (!endStr.equals(start.toString())) {
            Pair p = dp.get(endStr);
            int i = p.y, j = p.x;
            String newStr = endStr.substring(i, i + j) + endStr.substring(0, i);
            if (i + j < endStr.length()) {
                newStr += endStr.substring(i + j);
            }
            answer.add(p);
            endStr = newStr;
        }

        Collections.reverse(answer);
        return answer;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}