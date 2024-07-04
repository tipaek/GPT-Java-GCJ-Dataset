import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            boolean[] columnsContainMultipleNumbers = new boolean[n];
            ArrayList<HashMap<Integer, Integer>> columns = new ArrayList<HashMap<Integer, Integer>>();

            for (int row = 0; row < n; row++) {
                boolean firstTimeInRow = true;
                HashMap<Integer, Integer> rowHashMap = new HashMap<>();
                for (int column = 0; column < n; column++) {
                    int m = in.nextInt();
                    if (rowHashMap.containsKey(m) && firstTimeInRow) {
                        r++;
                        firstTimeInRow = false;
                        rowHashMap.replace(m, rowHashMap.get(m));
                    } else {
                        rowHashMap.put(m, 1);
                    }
                    if (row == 0) {
                        HashMap<Integer, Integer> columnHashMap = new HashMap<>();
                        columnHashMap.put(m, 1);
                        columns.add(columnHashMap);
                    } else {
                        HashMap<Integer, Integer> columnHashMap = columns.get(column);

                        if (columnHashMap.containsKey(m)) {
                            columnsContainMultipleNumbers[column] = true;
                        } else {
                            columnHashMap.put(m, 1);
                        }
                    }

                    if (column == row) {
                        k += m;
                    }
                }
            }

            for (boolean columnsContainMultipleNumber : columnsContainMultipleNumbers) {
                if (columnsContainMultipleNumber) {
                    c++;
                }
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }

}
