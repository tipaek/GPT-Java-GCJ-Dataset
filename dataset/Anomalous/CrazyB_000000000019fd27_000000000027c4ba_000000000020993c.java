import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int trace = 0, r = 0, c = 0;
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    row.add(in.nextInt());
                }
                mat.add(row);
            }

            for (int j = 0; j < n; j++) {
                trace += mat.get(j).get(j);
            }

            for (int j = 0; j < n; j++) {
                boolean[] rowCheck = new boolean[n];
                for (int k = 0; k < n; k++) {
                    int el = mat.get(j).get(k);
                    if (rowCheck[el - 1]) {
                        r++;
                        break;
                    }
                    rowCheck[el - 1] = true;
                }
            }

            for (int k = 0; k < n; k++) {
                boolean[] colCheck = new boolean[n];
                for (int j = 0; j < n; j++) {
                    int el = mat.get(j).get(k);
                    if (colCheck[el - 1]) {
                        c++;
                        break;
                    }
                    colCheck[el - 1] = true;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}