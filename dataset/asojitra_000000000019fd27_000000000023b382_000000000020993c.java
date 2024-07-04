import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        for(int testcase = 0; testcase < testcases; testcase++) {
            int size = scan.nextInt();
            int[][] input = new int[size][size];
            buildMatrix(scan, input);
            int trace = calculateLatinTrace(input);
            int[][] repeated = totalRepeatsInRow(input);
            System.out.println("Case #" + (testcase + 1) + ": " + trace + " " +repeated[0][0] + " "+ repeated[0][1]);
        }
    }

    public static void buildMatrix(Scanner scan, int[][] input) {
        int size = input.length;
        for(int iIndex = 0; iIndex < size; iIndex++) {
            for(int jIndex = 0; jIndex < size; jIndex++) {
                input[iIndex][jIndex] = scan.nextInt();
            }
        }
    }

    public static int calculateLatinTrace(int[][] input) {
        int size = input.length;
        int iIndex = 0;
        int jIndex = 0;
        int sum = 0;
        while(iIndex < size && jIndex < size) {
            sum += input[iIndex][jIndex];
            iIndex++;
            jIndex++;
        }
        return sum;
    }

    public static int[][] totalRepeatsInRow(int[][] input) {
        int[][] repeated = new int[1][2];
        int size = input.length;
        for(int iIndex = 0; iIndex < size; iIndex++) {
            HashSet<Integer> rowCheck = new HashSet<Integer>();
            HashSet<Integer> columnCheck = new HashSet<Integer>();
            boolean isRowAdded = false;
            boolean isColumnAdded = false;
            for(int jIndex = 0; jIndex < size; jIndex++) {
                if(!rowCheck.add(input[iIndex][jIndex]) && !isRowAdded) {
                    repeated[0][0]++;
                    isRowAdded = true;
                }
                if(!columnCheck.add(input[jIndex][iIndex]) && !isColumnAdded) {
                    repeated[0][1]++;
                    isColumnAdded = true;
                }
            }
        }
        return repeated;
    }
}