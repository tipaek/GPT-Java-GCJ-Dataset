import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String args[]) {

        int i;
        int j;
        int k;
        int dimension;
        int trace;
        int rowCounter;
        int columnCounter;
        int[][] array;
        Set<Integer> helper = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(i=1; i<=testCases; i++) {
            dimension = scanner.nextInt();
            array = new int[dimension][dimension];
            trace = 0;
            rowCounter = 0;
            columnCounter = 0;
            for(j=0; j<dimension; j++) {
                for(k=0; k<dimension; k++) {
                    array[j][k] = scanner.nextInt();
                    if(j == k) trace += array[j][k];
                    helper.add(array[j][k]);
                }
                if(helper.size() != dimension) rowCounter++;
                helper.clear();
            }

            for(j=0; j<dimension; j++) {
                for(k=0; k<dimension; k++) {
                    helper.add(array[k][j]);
                }
                if(helper.size() != dimension) columnCounter++;
                helper.clear();
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCounter + " " + columnCounter);
        }
    }
}
