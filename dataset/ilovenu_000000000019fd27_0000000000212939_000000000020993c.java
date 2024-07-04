import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws IOException {
        FileInputStream input = null;
        input = new FileInputStream("src/CodeJam/part1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = br.readLine();
        PartOne p = new PartOne();

        int numTest = Integer.valueOf(line);
        for (int i = 0; i < numTest; i++) {
            int dimension = Integer.valueOf(br.readLine());
            int[][] array = new int[dimension][dimension];
            for (int j = 0; j < dimension; j++) {
                String eachLine = br.readLine();
                String[] row = eachLine.split(" ");
                System.out.println(eachLine);
                for (int k = 0; k < dimension; k++) {
                    array[j][k] = Integer.valueOf(row[k]);
                }
            }
            p.matrix(array, i+1);
        }

    }

    public void matrix(int[][] array, int num) {
        String output = "Case #" + num + ": ";
        int count = calculate(array);
        int dupRow = duplicateRow(array);
        int dupCol = duplicateCol(array);

        output += count + " " + dupRow + " " + dupCol;
        System.out.println(output);
    }


    private int calculate(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += array[i][i];
        }
        return count;
    }

    private int duplicateRow(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = 0; j < array.length; j++) {
                if (!hashset.add(array[i][j])) {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

    private int duplicateCol(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = 0; j < array.length; j++) {
                if (!hashset.add(array[j][i])) {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

}
