import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();

            int[][] arr = new int[n][2];
            for(int j=0;j<n;j++) {
                arr[j][0] = scanner.nextInt();
                arr[j][1] = scanner.nextInt();
            }
            String result = solve(arr);
            System.out.println(String.format("Case #%d: %s", i+1, result));
        }

    }

    private static String solve( int[][] arr) {

        StringBuilder result = new StringBuilder(arr.length);


        Arrays.sort(arr, (int[] a, int[] b) -> a[0] - b[0]);

        int cEnd = -1;
        int jEnd = -1;

        for(int[] time : arr) {
            int start = time[0];
            int end = time[1];
            if(cEnd > start && jEnd > start) {
                return "IMPOSSIBLE";
            }

            if(cEnd <= start ) {
                cEnd = end;
                result.append('C');
            } else if(jEnd <= start ) {
                jEnd = end;
                result.append('J');
            }

        }


        return result.toString();
    }
}
