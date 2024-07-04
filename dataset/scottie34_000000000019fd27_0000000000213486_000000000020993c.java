import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            List<Integer>[] columns = new ArrayList[n];
            for (int j = 0; j < n; j++) {
                columns[j] = new ArrayList<>();
            }
            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<>();
                for (int j2 = 0; j2 < n; j2++) {
                    int tmp = in.nextInt();
                    list.add(tmp);
                    columns[j2].add(tmp);
                    if (j2 == j) {
                        k += tmp;
                    }
                }
                if (list.stream().distinct().count() != n) {
                    r++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (columns[j].stream().distinct().count() != n) {
                    c++;
                }
            }

            System.out.println("case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
