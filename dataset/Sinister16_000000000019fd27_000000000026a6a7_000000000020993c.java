import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

public static void compute(int[][] arr, int[] out, int n){

    Set<Integer> row;
    Set<Integer> col;
    boolean rowFlag;
    boolean colFlag;

    for(int i = 0; i < n; i++){

        out[0] += arr[i][i];

        rowFlag = false;
        colFlag = false;

        row = new HashSet<>();
        col = new HashSet<>();

        for(int j = 0; j < n; j++)
        {
            if(!rowFlag) {
                if (row.contains(arr[i][j])) {
                    out[1]++;
                    rowFlag = true;
                }
                else
                    row.add(arr[i][j]);
            }

            if(!colFlag) {
                if (col.contains(arr[j][i])) {
                    out[2]++;
                    colFlag = true;
                }
                else
                    col.add(arr[j][i]);
            }

            if(rowFlag && colFlag)
                break;
        }
    }
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 1; i <= t; i++){

            int n = sc.nextInt();

            int[][] arr = new int[n][n];

            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){

                    arr[j][k] = sc.nextInt();
                }
            }

           int[] out = new int[3];
           compute(arr, out, n);

           System.out.println("Case #"+ t+ ":"+ " "+ out[0]+ " "+ out[1]+ " "+ out[2]);
        }
    }
}
