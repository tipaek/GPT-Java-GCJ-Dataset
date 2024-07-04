import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int size = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    ArrayList<Integer[][]> list = new ArrayList<Integer[][]>(size);
    for (int i = 0; i < size; i++) {
        int s = in.nextInt();
        Integer[][] matrix = new Integer[s][s];
        for (int j = 0; j < s; j++) {
            for (int k = 0; k < s; k++) {
                matrix[j][k] = in.nextInt();
            }
        }
        list.add(matrix);
    }
    ArrayList<Integer[]> output = new ArrayList<Integer[]>(size);
    for (int i = 0; i < size; i++) {
        Integer[] out = new Integer[3];
        int diagonal = 0;
        for (int j = 0; j < list.get(i).length; j++) {
            diagonal += list.get(i)[j][j];
        }
        int row = 0;
        int col = 0;
        for (int j = 0; j < list.get(i).length; j++) {
            HashSet<Integer> rowCheck = new HashSet<Integer>();
            for (int k = 0; k < list.get(i).length; k++) {
                if (rowCheck.contains(list.get(i)[j][k])) {
                    row++;
                    break;
                }
                else {
                    rowCheck.add(list.get(i)[j][k]);
                }
            }
        }
        for (int j = 0; j < list.get(i).length; j++) {
            HashSet<Integer> colCheck = new HashSet<Integer>();
            for (int k = 0; k < list.get(i).length; k++) {
                if (colCheck.contains(list.get(i)[k][j])) {
                    col++;
                    break;
                }
                else {
                    colCheck.add(list.get(i)[k][j]);
                }
            }
        }
        out[0] = diagonal;
        out[1] = row;
        out[2] = col;
        output.add(out);
    }
    for (int i = 0; i < output.size(); i++) {
        System.out.println("Case #" + i + ": " + output.get(i)[0] + " " + output.get(i)[1] + " " + output.get(i)[2]);
    }
  }
}