import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num_cases = Integer.parseInt(in.nextLine());
        ArrayList<String> outputs = new ArrayList<>();
        for(int i=0; i<num_cases; i++) {
            int dim = Integer.parseInt(in.nextLine());
            String[][] grid = new String[dim][dim];
            for(int j=0; j<dim; j++) {
                String[] row = in.nextLine().split(" ");
                grid[j] = row;
            }
            int trace = 0;
            String output = "Case #" + (i+1) + ": ";
            for(int j=0; j<dim; j++) {
                trace += Integer.parseInt(grid[j][j]);
            }
            output += trace + " ";
            int row_repeats = 0;
            int col_repeats = 0;
            for(int j=0; j<dim; j++) {
                ArrayList<Integer> row_nums = new ArrayList<>();
                for(int k=0; k<dim; k++) {
                    int num = Integer.parseInt(grid[j][k]);
                    if(row_nums.contains(num)) {
                        row_repeats += 1;
                        break;
                    } else {
                        row_nums.add(num);
                    }
                }
            }
            output += row_repeats + " ";
            for(int j=0; j<dim; j++) {
                ArrayList<Integer> col_nums = new ArrayList<>();
                for(int k=0; k<dim; k++) {
                    int num = Integer.parseInt(grid[k][j]);
                    if(col_nums.contains(num)) {
                        col_repeats += 1;
                        break;
                    } else {
                        col_nums.add(num);
                    }
                }
            }
            output += "" + col_repeats;
            outputs.add(output);
        }
        for(String s : outputs) {
            System.out.println(s);
        }
    }
}