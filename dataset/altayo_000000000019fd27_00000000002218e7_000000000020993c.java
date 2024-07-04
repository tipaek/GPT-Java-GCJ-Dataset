// k = trace => sum of values on main diagonal
// r = number of rows that contain repeated elements
// c = number of columns that contain repeated elements
// Case #x: k r c
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testN = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testN; i++) {
            int matrixSize = Integer.parseInt(sc.nextLine());
            int[] intArr = new int[matrixSize * matrixSize];
            ArrayList<HashSet<Integer>> rowSets = new ArrayList<>();
            ArrayList<HashSet<Integer>> colSets = new ArrayList<>();
            for (int o = 0; o < matrixSize; o++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
            }
            for (int k = 0; k < matrixSize * matrixSize; k++) {
                intArr[k] = sc.nextInt();
                // k % matrixSize gives the column
                // k / matrixSize gives the row
                rowSets.get(k / matrixSize).add(intArr[k]);
                colSets.get(k % matrixSize).add(intArr[k]);
            }
            sc.nextLine();
            int r = 0;
            int k = 0;
            int c = 0;
            for (int it = 0; it < matrixSize; it++) {
                k += intArr[it + it * matrixSize];
            }
            // k is ready
            
            for (int pl = 0; pl < matrixSize; pl++) {
                if (rowSets.get(pl).size() < matrixSize) {
                    r++;
                }
                if (colSets.get(pl).size() < matrixSize) {
                    c++;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}