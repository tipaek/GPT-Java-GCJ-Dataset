import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int caseCount = Integer.parseInt(br.readLine());
        int i, j, k, size, rCount = 0, cCount = 0, value, sum;
        int[][] array;
        int[] trace;
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        for (i = 0; i < caseCount; i++) {
            size = Integer.parseInt(br.readLine());;
            array = new int[size][size];

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

            System.out.println("Case #" + (i + 1) + ":" + sum + " " + rCount + " " + cCount);
        }

    }

}