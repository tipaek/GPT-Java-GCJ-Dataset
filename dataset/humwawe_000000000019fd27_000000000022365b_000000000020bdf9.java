import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %s";
        for (int i = 1; i <= n; i++) {
            int len = sc.nextInt();
            List<Active> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                list.add(new Active(j, sc.nextInt(), sc.nextInt()));
            }
            list.sort(Comparator.comparingInt(a -> a.e));
            int endC = -1;
            int endJ = -1;
            char prevC = 'C';
            char prevJ = 'J';
            boolean f = true;
            for (Active a : list) {
                if (a.s >= endC) {
                    a.p = prevC;
                    endC = a.e;
                } else if (a.s >= endJ) {
                    a.p = prevJ;
                    endJ = a.e;
                } else {
                    f = false;
                    break;
                }
            }
            if (!f) {
                System.out.println(String.format(result, i, "IMPOSSIBLE"));
            } else {
                list.sort(Comparator.comparingInt(a -> a.index));
                StringBuilder res = new StringBuilder();
                for (Active a : list) {
                    res.append(a.p);
                }
                System.out.println(String.format(result, i, res.toString()));
            }
        }

    }

    static class Active {
        int index;
        int s;
        int e;
        char p;

        Active(int index, int s, int e) {
            this.index = index;
            this.s = s;
            this.e = e;
        }
    }
}
