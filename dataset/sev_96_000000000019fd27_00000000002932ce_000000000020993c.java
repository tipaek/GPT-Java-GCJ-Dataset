import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        int i, j, k, size, rCount = 0, cCount = 0, value, sum;
        int[][] array;
        int[] trace;
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        for (i = 0; i < caseCount; i++) {
            size = sc.nextInt();
            array = new int[size][size];
            cCount=0;
            rCount=0;

            trace = new int[size];
            for (j = 0; j < size; j++) {
                for (k = 0; k < size; k++) {
                    value = sc.nextInt();
                    array[j][k] = value;
                    row.add(value);
                    if (j == k) trace[j] = value;
                }
                if (row.size() < size) rCount++;
                row = new HashSet<>();
            }

            for (j = 0; j < size; j++) {
                for (k = 0; k < size; k++) {
                    column.add(array[k][j]);
                }
                if (column.size() < size) cCount++;
                column = new HashSet<>();
            }
            sum = IntStream.of(trace).sum();

            System.out.println("Case #" + (i + 1) + ": " + sum + " " + rCount + " " + cCount);
        }

    }

}

