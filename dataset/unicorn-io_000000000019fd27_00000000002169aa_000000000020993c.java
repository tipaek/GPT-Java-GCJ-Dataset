import java.util.*;

public class Main {

    private static Scanner scn = new Scanner(System.in);
    private static int[][] arr;

    private static int rowCalc(int[] row) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < row.length; i++) {
           if (hashtable.contains(row[i])) {
               return 1;
           } else {
               hashtable.put(i,row[i]);
           }
        }
        return 0;
    }

    private static int colCalc(int[][] arr, int colNum) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashtable.contains(arr[i][colNum])) {
                return 1;
            } else {
                hashtable.put(i,arr[i][colNum]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int tcases = scn.nextInt();
        int tcpy = tcases;
        while (tcases-- > 0) {
            int dim = scn.nextInt();
            int trace = 0;
            int repRow = 0;
            int repCol = 0;
            arr = new int[dim][dim];
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    Hashtable<Integer, Integer> hash = new Hashtable<>();
                    arr[i][j] = scn.nextInt();
                    if (i == j) trace += arr[i][j];
                }
            }
            for (int i = 0; i < dim; i++) {
                repRow += rowCalc(arr[i]);
                repCol += colCalc(arr,i);
            }
            System.out.printf("Case #%d: %d %d %d\n", tcpy-tcases,trace, repRow, repCol);
        }
    }
}