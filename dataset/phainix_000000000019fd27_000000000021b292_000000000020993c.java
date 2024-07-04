import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int i = 0; i < testCase; i++) {
            // System.out.println("Starting test case "+(i+1));
            int n = scan.nextInt();
            String[][] arr = new String[n][n];
            scan.nextLine();
            for(int j = 0; j < n; j++) {
                String s = scan.nextLine();
                // System.out.println(s);
                arr[j] = s.split(" ");
            }

            int[] result = compute(n, arr);

            System.out.printf("Case #%d: %d %d %d", i+1, result[0], result[1], result[2]);
            System.out.println("");
        }
    }

    private static int[] compute(int n, String[][] arr) {
        int trace = 0, row_duplicate = 0, column_duplicate = 0;
        int[] result = new int[3];
        for(int i = 0; i < n; i++) {
            // System.out.println(Arrays.toString(arr[i]));
            Long distinctRowCount = Stream.of(arr[i])
                    .distinct().count();

            if(arr[i].length != distinctRowCount) {
                ++row_duplicate;
            }

            String[] column_array = new String[n];
            for(int j = 0; j < n; j++) {
                column_array[j] = arr[j][i];
            }
            Long distinctColCount = Stream.of(column_array)
                    .distinct().count();
            if(column_array.length != distinctColCount) {
                ++column_duplicate;
            }

            trace += Integer.parseInt(arr[i][i]);
        }
        result[0] = trace;
        result[1] = row_duplicate;
        result[2] = column_duplicate;
        return result;
    }
}