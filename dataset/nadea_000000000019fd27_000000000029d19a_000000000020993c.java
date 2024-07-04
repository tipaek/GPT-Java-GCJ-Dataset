import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int cases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cases; i++) {
                int size = Integer.parseInt(in.nextLine());
                int sum = 0;
                int rows = 0;
                boolean locks[] = new boolean[size];
                Arrays.fill(locks, false);
                int[][] cols = new int[size][size];
                for (int j = 0; j < size; j++) {
                    String[] line = in.nextLine().split(" +");
                    int[] row = new int[size ];
                    for (int k = 0; k < line.length; k++) {
                        int parsed  = Integer.parseInt(line[k]);
                        if (k == j){
                            sum += parsed;
                        }
                        parsed--;
                        if(!locks[k]) {
                            cols[k][parsed]++;
                            if(cols[k][parsed] > 1){
                                locks[k] = true;
                            }
                        }
                        row[parsed]++;
                    }
                    boolean found = false;
                    for (int k = 0; k < line.length && !found; k++) {
                        if (row[k] > 1) {
                            rows++;
                            found = true;
                        }
                    }
                }
                int cc = 0;
                for (int j = 0; j < cols.length; j++) {
                    if (locks[j]) {
                        cc++;
                    }
                }
                System.out.print("Case #" + (i + 1) + ":");
                System.out.print(" " + sum + " " + rows + " " + cc);
                if (i < cases - 1) {
                    System.out.println();
                }
            }
        }
    }
}
