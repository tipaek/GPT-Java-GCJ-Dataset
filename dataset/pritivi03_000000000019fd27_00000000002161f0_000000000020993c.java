import java.util.*;
import java.io.*;

public class Vestig {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for (int i = 1; i <= tc; i++) {
            int n = in.nextInt();
            int [] [] matrix = new int [n] [n];
            //read input
            int trace = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix [j][k] = in.nextInt();
                    if (j == k)
                        trace += matrix[j][k];
                }
            }
            int rowDuplicates = 0, colDuplicates = 0;
            for (int j = 0; j < n; j++) {
                //row check
                if (checkForDuplicates(matrix[j]))
                    rowDuplicates++;
            }
            for (int j = 0; j < n; j++) {
                int[] colArray = new int [n];
                for (int k = 0; k < n; k++) {
                    colArray[k] = matrix[k][j];
                }
                if (checkForDuplicates(colArray))
                    colDuplicates++;
            }
            //print stuff
            System.out.print("Case #" + i + ": ");
            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    static boolean checkForDuplicates(int [] array) {
        ArrayList<Integer> previousOccuring = new ArrayList<>();
        for (Integer e: array) {
            if (previousOccuring.contains(e))
                return true;
            previousOccuring.add(e);
        }
        return false;
    }
}
