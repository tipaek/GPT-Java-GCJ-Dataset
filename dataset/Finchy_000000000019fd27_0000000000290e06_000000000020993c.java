import java.util.*;
import java.io.*;
class Vestigium {
        static boolean checkDuplicatesWithinK(int arr[], int k) {

            HashSet<Integer> set = new HashSet<>();


            for (int i=0; i<arr.length; i++)
            {
                if (set.contains(arr[i]))
                    return true;
                set.add(arr[i]);

                if (i >= k)
                    set.remove(arr[i-k]);
            }
            return false;
        }
        private static int[][] swapMatrix(int[][] pField) {
            int initialRows = pField.length;
            int initialColumns = pField[0].length;

            int[][] newMatrix = new int[initialColumns][initialRows];

            for(int i=0; i< initialRows; i++){
                for(int j=0; j < initialColumns; j++){
                    newMatrix[j][i] = pField[i][j];
                }
            }
            return newMatrix;
        }

        public static void main (String[] args) {
            boolean debug = false;
            Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = input.nextInt();
            for (int i = 1; i <= t; ++i) {
                int trace = 0;
                int countRows = 0;
                int countColumns = 0;
                int tt = input.nextInt();
                int[][] matrix = new int[tt][tt];

                for (int j = 0; j < tt; j++) {
                    boolean match = false;

                    for (int k = 0; k < tt; k++) {
                        boolean rowRepeat = false;
                        matrix[j][k] = input.nextInt();

                        if (j == k) {
                            trace += matrix[j][k];
                        }
                    }
                    match = checkDuplicatesWithinK(matrix[j], tt);
                    countRows += match ? 1 : 0;
                }
                int[][] swapped = swapMatrix(matrix);
                for (int j = 0; j < tt; j++) {
                    boolean match = false;
                    match = checkDuplicatesWithinK(swapped[j], tt);
                    countColumns += match ? 1 : 0;
                }

                if (debug) {
                    System.out.println(Arrays.deepToString(matrix));
                    System.out.println(Arrays.deepToString(swapped));
                }
                System.out.println("Case #" + i + ": " + trace + " " + countRows + " " + countColumns);
            }
        }
    }
