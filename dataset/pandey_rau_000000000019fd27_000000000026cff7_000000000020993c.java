import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for(int testCase = 1;testCase <= testCases ;testCase++) {
            int size = in.nextInt();
            int[][] array = new int[size][size];

            int diagonalLatinSum = 0;

            for(int i=0;i<size;i++) {
                for(int j=0;j<size;j++) {
                    array[i][j] = in.nextInt();
                    if(i == j) {
                        diagonalLatinSum += array[i][j];
                    }
                }
            }

            Set<Integer> integerSet = new HashSet<>();
            int rowCount = 0;
            int columnCount = 0;

            for (int i=0;i<size;i++) {
                for (int j=0;j<size;j++) {
                    if (integerSet.contains(array[i][j])) {
                        rowCount++;
                        break;
                    } else {
                        integerSet.add(array[i][j]);
                    }
                }
                integerSet.clear();
            }

            for (int i=0;i<size;i++) {
                for (int j=0;j<size;j++) {
                    if (integerSet.contains(array[j][i])) {
                        columnCount++;
                        break;
                    } else {
                        integerSet.add(array[j][i]);
                    }
                }
                integerSet.clear();
            }

            System.out.println("Case #"+testCase+": " + diagonalLatinSum + " "+ rowCount+ " " + columnCount);
        }
    }
}
