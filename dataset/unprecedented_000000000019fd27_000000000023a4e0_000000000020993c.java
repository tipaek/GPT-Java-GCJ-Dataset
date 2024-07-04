import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int x = 0;
        while (x++ < T){
            int n = scanner.nextInt();
            int k = 0, r = 0, c = 0;
            int[][] arr = new int[n][n];

            for (int i=0; i<n; i++){
                int[] check = new int[n];
                boolean flag = false;
                for (int j=0; j<n; j++){
                    arr[i][j] = scanner.nextInt();
                    check[arr[i][j]-1]++;
                    if (i == j)
                        k+=arr[i][j];
                    if (check[arr[i][j] -1] > 1 && !flag){
                        r++;
                        flag = true;
                    }
                }
            }

            for (int i=0; i<n; i++){
                int[] check = new int[n];
                for (int j=0; j<n; j++){
                    check[arr[j][i]-1]++;
                    if (check[arr[j][i]-1] > 1){
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #"+ x +": "+ k +" " + r +" "+ c);
        }
    }
}
