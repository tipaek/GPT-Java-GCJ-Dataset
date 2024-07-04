import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            String[] info = scanner.nextLine().split(" ", 2);
            solve(i + 1, Integer.parseInt(info[0]), Integer.parseInt(info[1]));
        }
    }

    private static void solve(int test, int x, int y) {
        int ax = Math.abs(x);
        int ay = Math.abs(y);

        int max0 = (int) Math.ceil(Math.log(ax) / Math.log(2));
        int max1 = (int) Math.ceil(Math.log(ay) / Math.log(2));
        int max = Math.max(max0, max1);

        List<Integer> path = move(new ArrayList<>(), 0, 0, ax, ay, -1, (int) Math.pow(2, max));
        if (path == null) {
            System.out.println("Case #" + test + ": IMPOSSIBLE");
            return;
        }

        boolean mx = x > 0;
        boolean my = y > 0;

        String pathString = path.stream()
                .map(i -> {
                    switch (i) {
                        case 0: return mx ? "E" : "W";
                        case 1: return mx ? "W" : "E";
                        case 2: return my ? "N" : "S";
                        case 3: return my ? "S" : "N";
                        default: return "";
                    }
                })
                .collect(Collectors.joining());

        System.out.println("Case #" + test + ": " + pathString);
    }

    private static List<Integer> move(List<Integer> moves, int x, int y, int dx, int dy, int n, int max) {
        if (n > max * 10) return null;
        if (x == dx && y == dy) return moves;
        if (x > dx || y > dy) return null;

        int i = n * 2;
        if (i == -2) i = 1;

        List<Integer> res;
        res = move(appendToList(moves, 0), x + i, y, dx, dy, i, max);
        if (res != null) return res;
        res = move(appendToList(moves, 1), x - i, y, dx, dy, i, max);
        if (res != null) return res;
        res = move(appendToList(moves, 2), x, y + i, dx, dy, i, max);
        if (res != null) return res;
        res = move(appendToList(moves, 3), x, y - i, dx, dy, i, max);
        if (res != null) return res;

        return null;
    }

    private static List<Integer> appendToList(List<Integer> list, int i) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(i);
        return newList;
    }
}