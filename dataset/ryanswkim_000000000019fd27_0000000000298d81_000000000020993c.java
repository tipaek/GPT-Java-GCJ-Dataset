import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            ArrayList<ArrayList<Integer>> rows = new ArrayList<>(n);
            ArrayList<ArrayList<Integer>> columns = new ArrayList<>(n);
            boolean[] rowc = new boolean[n];
            boolean[] colc = new boolean[n];

            for (int j = 0; j < n; j++) {
                rows.add(new ArrayList<>());
                columns.add(new ArrayList<>());
                rowc[j] = false;
                colc[j] = false;
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int o = in.nextInt();
                    if (x == y) k += o;
                    if (rows.get(x).contains(o) && !rowc[x]){
                        r++;
                        rowc[x] = true;
                    }
                    if (columns.get(y).contains(o) && !colc[y]){
                        c++;
                        colc[y] = true;
                    }

                    rows.get(x).add(o);
                    columns.get(y).add(o);
                }
            }
            System.out.println("Case #" + (i+1) + ": " + k + " " + r + " " + + c);
        }
    }
}
