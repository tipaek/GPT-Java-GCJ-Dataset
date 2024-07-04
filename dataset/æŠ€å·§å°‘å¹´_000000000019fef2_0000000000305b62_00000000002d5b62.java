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
            dfs1(0, 0, x, y, 1, list);
            dfs2(0, 0, x, y, 1, list);
            String s;
            if (global == null) {
                s = "IMPOSSIBLE";
            } else {
                StringBuilder builder = new StringBuilder(global.size());
                for (int j = 0; j < global.size(); j++) {
                    builder.append(global.get(j));
                }
                s = builder.toString();
            }
            String result = String.format("Case #%d: %s", i, s);
            System.out.println(result);
        }
    }

    private static List<String> global;

    private static void dfs1(long x, long y, long eX, long eY, long unit, List<String> list) {
        if (x == eX && y == eY) {
            if (global == null || global.size() > list.size()) {
                global = new ArrayList<>();
                global.addAll(list);
            }
            return;
        }
        if ((x == eX)) {
            if (eY > y && y + unit > eY) return;
            if (eY < y && y - unit < eY) return;
            if (eY > y) {
                list.add("N");
                dfs1(x, y + unit, eX, eY, unit << 1, list);
            } else {
                list.add("S");
                dfs1(x, y - unit, eX, eY, unit << 1, list);
            }
            list.remove(list.size() - 1);
            return;
        }

        long temp = eX >= 0 ? eX : -eX;
        long flag = unit & temp;
        if (flag != 0) {
            boolean add = false;
            long a = x;
            if (eX > x) {
                list.add("E");
                a += unit;
                add = true;
            } else if (eX < x) {
                list.add("W");
                a -= unit;
                add = true;
            }
            dfs1(a, y, eX, eY, unit << 1, list);
            if (add) {
                list.remove(list.size() - 1);
            }
        } else {
            list.add("N");
            dfs1(x, y + unit, eX, eY, unit << 1, list);
            list.remove(list.size() - 1);
            list.add("S");
            dfs1(x, y - unit, eX, eY, unit << 1, list);
            list.remove(list.size() - 1);
        }


    }

    private static void dfs2(long x, long y, long eX, long eY, long unit, List<String> list) {
        if (x == eX && y == eY) {
            if (global == null || global.size() > list.size()) {
                global = new ArrayList<>();
                global.addAll(list);
            }
            return;
        }
        if (y == eY) {
            if (eX > x && x + unit > eY) return;
            if (eX < x && x - unit < eY) return;
            if (eX > x) {
                list.add("E");
                dfs2(x + unit, y, eX, eY, unit << 1, list);
            } else {
                list.add("W");
                dfs2(x - unit, y, eX, eY, unit << 1, list);
            }
            list.remove(list.size() - 1);
            return;
        }


        long temp = eY >= 0 ? eY : -eY;
        long flag = unit & temp;
        if (flag != 0) {
            boolean add = false;
            long a = y;
            if (eY > y) {
                list.add("N");
                a += unit;
                add = true;
            } else if (eY < y) {
                list.add("S");
                a -= unit;
                add = true;
            }
            dfs2(x, a, eX, eY, unit << 1, list);
            if (add) {
                list.remove(list.size() - 1);
            }
        } else {
            list.add("E");
            dfs2(x + unit, y, eX, eY, unit << 1, list);
            list.remove(list.size() - 1);
            list.add("W");
            dfs2(x - unit, y, eX, eY, unit << 1, list);
            list.remove(list.size() - 1);
        }
    }
}