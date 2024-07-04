
import java.util.*;
import java.io.*;

public class Solution {
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();


        for (int k = 1; k <= t; k++) {
            int matrixSize = in.nextInt();
            in.nextLine();
            int[][] first = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                String line = in.nextLine();

                String[] arr = line.split("\\s");
                for (int j = 0; j < arr.length; j++) {

                    first[i][j] = Integer.parseInt(arr[j]);
                }

            }

            //Map.Entry<Integer, Integer> a = (Map.Entry<Integer, Integer>) noOfRepeatedRows(first,matrixSize).entrySet();

            for (Map.Entry<Integer, Integer> a : noOfRepeatedRows(first, matrixSize).entrySet()) {
                //System.out.println(a.getKey() + " " +a.getValue());
                System.out.println("\n");
                System.out.println("Case #" + k + ": " + getTrace(first, matrixSize) + " " + a.getKey() + " " + a.getValue());
            }


        }


    }

    private static int getTrace(int input[][], int matrixSize) {
        int trace = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    trace += input[i][j];
                }

            }

        }

        return trace;

    }

    private static Map<Integer, Integer> noOfRepeatedRows(int input[][], int matrixSize) {
        int noOfRepeatedRows = 0;
        int noOfRepeatedColoums = 0;
        Map<Integer, Integer> out = new HashMap<>();

        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> r = new HashSet<Integer>();
            Set<Integer> c = new HashSet<Integer>();
            for (int j = 0; j < matrixSize; j++) {

                r.add(input[i][j]);
                c.add(input[j][i]);

            }
            if (r.size() < matrixSize) {
                noOfRepeatedRows += 1;
            }

            if (c.size() < matrixSize) {
                noOfRepeatedColoums += 1;
            }

        }
        out.put(noOfRepeatedRows, noOfRepeatedColoums);
        return out;
    }

}
