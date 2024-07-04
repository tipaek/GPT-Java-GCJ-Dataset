import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

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
            search(0, 0, 1, moves);
            // System.out.println(works);
            if (works.size() > 0) {
                // works.sort(new ListComparator());
                List<Integer> best = works.get(0);
                for (int index = 1; index < works.size(); index++) {
                    if (best.size() > works.get(index).size()) {
                        best = works.get(index);
                    }
                }
                List<String> print = new ArrayList<>();
                for (int count = 0; count < best.size(); count++) {
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

    public static void search(int px, int py, int add, List<Integer> moves) {
        if (Math.abs(px) > Math.abs(x) * 2) {
            return;
        } else if (Math.abs(py) > Math.abs(y) * 2) {
            return;
        }
        if (px == x && py == y) {

            List<Integer> temp = new ArrayList<>();
            temp.addAll(moves);
            // temp.add(0, index);
            // System.out.println(temp);
            works.add(temp);
            return;
        }
        // System.out.println(px + " " + py);
        List<Integer> temp = new ArrayList<>();
        temp.addAll(moves);
        temp.add(1);
        search((px + add), py, (add * 2), temp);
        temp.remove(temp.size() - 1);
        temp.add(2);
        search(px, (py + add), (add * 2), temp);
        temp.remove(temp.size() - 1);
        temp.add(-1);
        search((px - add), py, (add * 2), temp);
        temp.remove(temp.size() - 1);
        temp.add(-2);
        search(px, (py - add), (add * 2), temp);
    }
}
