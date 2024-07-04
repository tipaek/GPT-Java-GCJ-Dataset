import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {


            int n = in.nextInt();

            int sum = 0;
            int sumPos = 1;
            int rowCount = 0;
            int cellCount = 0;

            int[] cellArr = new int[(n*n)+1];

            for (int i = 1; i <= n; ++i){
                int[] row = new int[n+1];
                for (int j = 1; j <= n; ++j){
                    int num = in.nextInt();
                    row[j] = num;
                    cellArr[i+(n*(j-1))] = num;
                    if (sumPos == j) {
                        sum += num;
                    }
                }
                sumPos++;
                if(repeatCount(row, n+1)) rowCount++;
            }


            int count = 1;
            for (int i = 1; i <= n; ++i){
                int[] row = new int[n+1];
                for (int j = 1; j <= n; ++j){
                    row[j] = cellArr[count++];
                }
                if(repeatCount(row, n+1)) cellCount++;
            }


            System.out.println("Case #" + t + ": " + sum + " " + rowCount + " " + cellCount);
        }
    }



    private static boolean repeatCount(int[] arr, int size){
        int count[] = new int[size];

        for (int i = 0; i < size; i++) {
            if (count[arr[i]] == 1)
                return true;
            else
                count[arr[i]]++;
        }

        return false;
    }
}

