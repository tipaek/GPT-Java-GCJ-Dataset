import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();

            int[][] arr = new int[n][3];
            for(int j=0;j<n;j++) {
                arr[j][0] = scanner.nextInt();
                arr[j][1] = scanner.nextInt();
                arr[j][2] = j;
            }
            String result = solve(arr);
            System.out.println(String.format("Case #%d: %s", i+1, result));
        }

    }

    private static String solve( int[][] arr) {

       char[] result = new char[arr.length];


        Arrays.sort(arr, (int[] a, int[] b) -> a[0] - b[0]);

        int cEnd = -1;
        int jEnd = -1;

        for(int[] time : arr) {
            int start = time[0];
            int end = time[1];
            int index = time[2];
            if(cEnd > start && jEnd > start) {
                return "IMPOSSIBLE";
            }

            if(cEnd <= start ) {
                cEnd = end;
                result[index] = 'C';
            } else if(jEnd <= start ) {
                jEnd = end;
                result[index] = 'J';
            }

        }


        return new String(result);
    }
}
