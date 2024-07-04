import java.util.*;
import java.io.*;
class Solution {


    public static void main(String[] args) {
        int[] result = {};
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int size = 0;
        for (int i = 1; i <= test; i++) {
            size = in.nextInt();
            int[][] set = new int[size][size];
            for (int a = 0; a < size; a++) {
                for (int b = 0; b < size; b++) {
                    set[a][b] = in.nextInt();
                }
            }
            result = solve(set);
            System.out.println("Case #" + i + ": " + result[2] + " " + result[1] + " " + result[0]);
        }
    }

    private static int[] solve(int[][] set) {
        int row = 0;
        int column = 0;
        int trace = 0;
        boolean terminate = false;
        for (int rows = 0; rows < set.length; rows++) {
            HashSet<Integer> map = new HashSet<Integer>();
            HashSet<Integer> map2 = new HashSet<Integer>();
            boolean flag = false;
            for (int columns = 0; columns < set[rows].length; columns++) {
                HashSet<Integer> map3 = new HashSet<Integer>();
                HashSet<Integer> map4 = new HashSet<Integer>();
                boolean flag2 = false;
                int check = set[rows][columns];
                if (!map.add(check)) {
                    if (map2.add(check) && !flag) {
                        column++;
                        flag = true;
                    }
                }
                if(!terminate) {
                    for (int otherCol = rows; otherCol < set.length; otherCol++) {
                        int checker = set[otherCol][columns];
                        if (!map3.add(checker)) {
                            if (map4.add(checker) && !flag2) {
                                row++;
                                flag2 = true;
                            }
                        }
                    }
                }
                if (rows == columns) {
                    trace += set[rows][columns];
                }
            }
            terminate = true;
        }
        return new int[]{row, column, trace};
    }
}