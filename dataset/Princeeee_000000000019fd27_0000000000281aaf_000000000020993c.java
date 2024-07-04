
import java.util.*;
import java.io.*;

public class Solution {
    public static int count=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int f = 1; f <=t; ++f)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int k = 0;
            int row = 0;
            int col = 0;
            //List<Set<Integer>> forRow=new ArrayList();
            for (int i = 0; i < n; i++) {
                Set<Integer> forRow = new HashSet<>();
                //Set<Integer> forRow=new HashSet<>();
                for (int j = 0; j < n; j++) {

                    if (i == j) {
                        k += arr[i][j];
                    }
                    forRow.add(arr[i][j]);

                }
                if(forRow.size()!=n)
                    {
                        row++;
                    }
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> forCol = new HashSet<>();
                //Set<Integer> forRow=new HashSet<>();
                for (int j = 0; j < n; j++) {

                    // if (i == j) {
                    //     k += arr[i][j];
                    // }
                    forCol.add(arr[j][i]);

                }
                if(forCol.size()!=n)
                    {
                        col++;
                    }
            }
            System.out.println("Case #" + f + ":" + " " + k + " " + row + " " + col);

        }
        // write your code here
    }
}
