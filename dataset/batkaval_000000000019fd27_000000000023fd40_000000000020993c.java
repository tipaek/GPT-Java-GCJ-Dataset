package cz.li.codejam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vestigium {
    public static void main(String[] args) {
        List<TC> tcs = new ArrayList<>();
        int cnt = 1;
        int i = 1;
        while (i < args.length) {
            int n = Integer.parseInt(args[i]);
            System.out.println("Case #" + cnt + ": " + (new TC(args, i)).krc());
            i += n + 1;
        }

    }

    public static class TC {
        int[][] matrix;
        int n;

        public TC(String[] args, int start) {
            n = Integer.parseInt(args[start]);

            matrix = new int[n][n];

            for (int x = 0; x < n; x++) {
                int y = 0;
                for (String s : args[start + 1 + x].split(" ")) {
                    matrix[x][y++] = Integer.parseInt(s);
                }
            }
        }

        public String krc() {
            int k = 0;
            int c = 0;
            int r = 0;

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> column = new HashMap<>();
                Map<Integer, Integer> row = new HashMap<>();
                k += matrix[i][i];
                for (int j = 0; j < n; j++) {
                    int rowI = matrix[i][j];
                    row.compute(rowI, (key, v) -> v == null ? 1 : ++v);
                    column.compute(this.matrix[j][i],(key, v) -> v == null ? 1 : ++v);
                }

                for(Integer rpt: row.values()) {
                    if (rpt > 1) {
                        r++;
                        break;
                    }
                }
                for(Integer rpt: column.values()) {
                    if (rpt > 1) {
                        c++;
                        break;
                    }
                }
            }


            return k + " " + r + " " + c;
        }

        public String toString() {
            String s = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    s += matrix[i][j] + " ";
                }
                s += "\n";
            }
            return s;
        }
    }
}


