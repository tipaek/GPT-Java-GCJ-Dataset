import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int n = in.nextInt();

            int total = 0;
            int colRepeat = 0;
            int rowRepeat = 0;
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            //int[][] matrix;
            //matrix = new int[n][n];
            for (int y = 0; y < n; y++) { //rows
                boolean rowrep = false;
                ArrayList<Integer> row = new ArrayList<>();
                for (int x = 0; x < n; x++) { //cols
                    int num = in.nextInt();
                    if(x == y){
                        total += num;
                    }
                    if (row.contains(num) && !rowrep){
                        rowRepeat += 1;
                        rowrep = true;
                    }
                    row.add(num);
                    //matrix[x][y] = num;

                }
                matrix.add(row);
            }

            for (int j = 0; j < n; j++) {
                ArrayList<Integer> col = getColumn(matrix, j);
                Set<Integer> set = new HashSet<Integer>(col);
                if(set.size() < col.size()){ //has repeats
                    colRepeat += 1;
                }
            }

            System.out.println("Case #" + i +  ": " + total + " " + rowRepeat + " " + colRepeat);
        }
    }


    public static ArrayList<Integer> getColumn (ArrayList<ArrayList<Integer>> grid, int colNum){
        ArrayList<Integer> column = new ArrayList<>();
        for ( ArrayList<Integer> boxes: grid ) {
            column.add(boxes.get(colNum));
        }
        return column;
    }

}