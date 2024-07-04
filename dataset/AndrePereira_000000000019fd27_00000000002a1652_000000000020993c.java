package CodeJam2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vestigium {

    private static void vestigium(int cs, int t, int[][] m) {

        int k = 0;
        int r = 0;
        int c = 0;

        for(int i=0; i<m.length; i++) {
            Map<Integer, Boolean> seem = new HashMap<>();
            for(int j=0; j< m[i].length; j++) {
                if (seem.containsKey(m[i][j])) {
                    r++;
                    break;
                }
                seem.put(m[i][j], true);
            }
        }

        for(int i=0; i<m[0].length; i++) {
            Map<Integer, Boolean> seem = new HashMap<>();
            for(int j=0; j< m.length; j++) {
                if (seem.containsKey(m[j][i])) {
                    c++;
                    break;
                }
                seem.put(m[j][i], true);
            }
        }

        for (int i=0; i<m.length; i++) {
            k += m[i][i];
        }

        System.out.println(String.format("Case #%d: %d %d %d", cs, k, r, c));
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int k = 0; k<t; k++ ) {
            int n = scanner.nextInt();
            int[][] m = new int[n][n];
            int i = 0;
            scanner.nextLine();
            while (n > 0) {
                String line = scanner.nextLine();
                String[] sline = line.split(" ");
                for (int j = 0; j < sline.length; j++) {
                    m[i][j] = Integer.parseInt(sline[j]);
                }
                n--;
                i++;
            }
            vestigium(k+1, t, m);
        }

    }
}
