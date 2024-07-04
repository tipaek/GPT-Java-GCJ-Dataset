import java.util.HashSet;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        LinkedList<testcase> testcases = new LinkedList<>();
        int id = 1;
        testcase temp = null;
        int rowc = 0;
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextLine();  
        for (int i = 1; i <= t; i++) {
            if (args[i].length() == 1) {
                if (temp != null) {
                    testcases.add(temp);
                    id++;
                }
                temp = new testcase(id, Integer.parseInt(args[i]));
                rowc = 0;
            } else {
                String[] row = (args[i]).split(" ");
                for (int j = 0; j < row.length; j++) {
                    temp.matrix[rowc][j] = Integer.valueOf(row[j]);
                }
                rowc++;
            }
        }

        for (int i = 0; i < testcases.size(); i++) {
            testcases.get(i).calculateSolution();            
        }
    }
}

class testcase {

    int id;
    int[][] matrix;
    int trace = 0;
    int no_of_cols = 0;
    int no_of_rows = 0;
    String output;

    testcase(int id, int matrixsize) {
        this.id = id;
        this.matrix = new int[matrixsize][matrixsize];
    }

    void calculateSolution() {
        for (int i = 0; i < matrix.length; i++) {
            trace = trace + matrix[i][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowset = new HashSet<Integer>();
            for (int j = 0; j < matrix.length; j++) {
                if (rowset.contains(matrix[i][j])) {
                    no_of_rows++;
                    i++;
                    j = 0;
                } else {
                    rowset.add(matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> colset = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (colset.contains(matrix[j][i])) {
                    no_of_cols++;
                    i++;
                    j = 0;
                }
            }
        }

        output = "Case #" + String.valueOf(id) + ": " + String.valueOf(trace) + " " + String.valueOf(no_of_rows) + " "
                + String.valueOf(no_of_cols);
        System.out.println(output);
    }

}