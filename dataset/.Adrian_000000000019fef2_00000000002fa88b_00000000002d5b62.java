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

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            System.out.println("Case #" + test + ": IMPOSSIBLE");
            return;
        }

        int max0 = (int) Math.ceil(Math.log(ax) / Math.log(2));
        int max1 = (int) Math.ceil(Math.log(ay) / Math.log(2));

        int max = max0 > max1 ? max0 : max1;

        List<Integer> path = move(new ArrayList<>(), 0, 0, ax, ay, -1, (int) Math.pow(2, max));
        if (path == null) {
            System.out.println("Case #" + test + ": IMPOSSIBLE");
            return;
        }

        boolean mx = x > 0;
        boolean my = y > 0;

        StringBuilder pathString = new StringBuilder();
        for (int i : path) {
            if (i == 0) {
                if (mx) {
                    pathString.append("E");
                } else {
                    pathString.append("W");
                }
            } else if (i == 1) {
                if (mx) {
                    pathString.append("W");
                } else {
                    pathString.append("E");
                }
            } else if (i == 2) {
                if (my) {
                    pathString.append("N");
                } else {
                    pathString.append("S");
                }
            } else {
                if (my) {
                    pathString.append("S");
                } else {
                    pathString.append("N");
                }
            }
        }

        System.out.println("Case #" + test + ": " + pathString);
    }

    private static List<Integer> move(List<Integer> moves, int x, int y, int dx, int dy, int n, int max) {
        if (n > max * 100) return null;
        if (x == dx) {
            if (y == dy) {
                return moves;
            } else {
                if (y > dx) return null;
            }
        } else {
            if (x > dx) return null;
        }

        int i = n * 2;
        if (i == -2) i = 1;

        List<List<Integer>> ress = new ArrayList<>();

        List<Integer> res;

        res = move(combinedList(moves, 0), x + i, y, dx, dy, i, max);
        if (res != null) ress.add(res);
        res = move(combinedList(moves, 1), x - i, y, dx, dy, i, max);
        if (res != null) ress.add(res);
        res = move(combinedList(moves, 2), x, y + i, dx, dy, i, max);
        if (res != null) ress.add(res);
        res = move(combinedList(moves, 3), x, y - i, dx, dy, i, max);
        if (res != null) ress.add(res);

        List<Integer> tmp = null;
        int size = 0;
        for (List<Integer> s : ress) {
            if (tmp == null) {
                tmp = s;
                size = s.size();
            } else {
                if (s.size() < size) {
                    tmp = s;
                    size = s.size();
                }
            }
        }

        return tmp;
    }

    private static List<Integer> combinedList(List<Integer> list, int i) {
        List<Integer> newlist = new ArrayList<>(list);
        newlist.add(i);
        return newlist;
    }
}
