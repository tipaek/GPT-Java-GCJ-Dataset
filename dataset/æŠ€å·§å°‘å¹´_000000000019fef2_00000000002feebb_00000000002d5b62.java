import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int t = Integer.parseInt(line);

        for (int i = 1; i <= t; i++) {
            ArrayList<String> list = new ArrayList<>();
            global = null;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            dfs(0, 0, x, y, 1, list);

            String result = String.format("Case #%d: %s", i, global == null ? "IMPOSSIBLE" : global.toString());
            System.out.println(result);
        }

    }

    private static List<String> global;

    private static void dfs(long x, long y, long eX, long eY, long unit, List<String> list) {
        if (x == eX && y == eY) {
            if (global == null || global.size() > list.size()) {
                global = new ArrayList<>();
                global.addAll(list);
            }
            return;
        }
        if (x == eX && Math.abs(y - eY) != unit) {
            return;
        }
        long temp = eX >= 0 ? eX : -eX;
        long flag = unit & temp;
        if (flag != 0) {
            boolean add = false;
            if (eX > x) {
                list.add("E");
                x += unit;
                add = true;
            } else if (eX < x) {
                list.add("W");
                x -= unit;
                add = true;
            }
            dfs(x, y, eX, eY, unit << 1, list);
            if (add) {
                list.remove(list.size() - 1);
            }
        } else {
            list.add("N");
            dfs(x, y + unit, eX, eY, unit << 1, list);
            list.remove(list.size() - 1);
            list.add("S");
            dfs(x, y - unit, eX, eY, unit << 1, list);
            list.remove(list.size() - 1);
        }
    }
}