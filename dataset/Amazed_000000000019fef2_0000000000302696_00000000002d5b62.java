import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class ListComparator implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
            for (int i = 0; i < l1.size(); ++i) {
                if (l1.get(i).compareTo(l2.get(i)) != 0) {
                    return l1.get(i).compareTo(l2.get(i));
                }
            }
            return 0;
        }
    }

    private static int x = 0;
    private static int y = 0;
    private static List<List<Integer>> works = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            List<Integer> moves = new ArrayList<>();
            search(0, 0, 0, 1, moves);
            // System.out.println(works);
            if (works.size() > 0) {
                works.sort(new ListComparator());
                List<Integer> best = works.get(0);
                List<String> print = new ArrayList<>(best.size() - 1);
                for (int count = 1; count < best.size(); count++) {
                    if (best.get(count) == 1) {
                        print.add("E");
                    } else if (best.get(count) == -1) {
                        print.add("W");
                    } else if (best.get(count) == 2) {
                        print.add("N");
                    } else {
                        print.add("S");
                    }
                }
                out.print("Case #" + (i + 1) + ": ");
                for (int count = 0; count < print.size(); count++) {
                    out.print(print.get(count));
                }
                out.println();
                works.clear();

            } else {
                out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }

        }
        out.close();
    }

    public static void search(int px, int py, int index, int add, List<Integer> moves) {
        if (Math.abs(px) > Math.abs(x)) {
            return;
        } else if (Math.abs(py) > Math.abs(y)) {
            return;
        }
        if (px == x && py == y) {

            List<Integer> temp = new ArrayList<>();
            temp.addAll(moves);
            temp.add(0, index);
            // System.out.println(temp);
            works.add(temp);
            return;
        }
        // System.out.println(px + " " + py);
        List<Integer> temp = new ArrayList<>();
        temp.addAll(moves);
        temp.add(1);
        search((px + add), py, index + 1, (add * 2), temp);
        temp.remove(temp.size() - 1);
        temp.add(2);
        search(px, (py + add), index + 1, (add * 2), temp);
        temp.remove(temp.size() - 1);
        temp.add(-1);
        search((px - add), py, index + 1, (add * 2), temp);
        temp.remove(temp.size() - 1);
        temp.add(-2);
        search(px, (py - add), index + 1, (add * 2), temp);
    }
}
