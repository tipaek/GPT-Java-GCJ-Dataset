import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        for (int i = 1; i <= tests; i++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int j = 0; j < n; j++) {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
            }
            check(i, n, start, end);
        }
    }

    private static void check(int i, int n, int[] start, int[] end) {
        System.out.print("Case #" + i + ": ");
        LinkedList<Integer> cs = new LinkedList<>();
        LinkedList<Integer> ce = new LinkedList<>();
        LinkedList<Integer> js = new LinkedList<>();
        LinkedList<Integer> je = new LinkedList<>();
        cs.add(start[0]);
        ce.add(end[0]);
        StringBuilder sb = new StringBuilder("C");
        for (int k = 1; k < n; k++) {
            if (checkStart(ce, start[k]) || checkEnd(cs, end[k])) {
                sb.append("C");
                cs.add(start[k]);
                ce.add(end[k]);
            } else if (cs.isEmpty()||checkStart(je, start[k]) || checkEnd(js, end[k])) {
                sb.append("J");
                js.add(start[k]);
                je.add(end[k]);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean checkEnd(LinkedList<Integer> ce, int end) {
        for (int i : ce) {
            if (end > i) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkStart(LinkedList<Integer> cs, int start) {
        for (int i : cs) {
            if (start < i) {
                return false;
            }
        }
        return true;
    }
}
