import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            ArrayList<int[]> arr = new ArrayList<>();
            computeSum(n,0,k,new int[n], arr);
            genMatrix(arr,i);



        }
    }

    public static int checkRows(int[][] arr, int i, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j<n; j++) {
            if (map.containsKey(arr[i][j]))
                return 1;
            else
                map.put(arr[i][j], 0);
        }
        return 0;
    }

    public static int checkCols(int[][] arr, int i, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j<n; j++) {
            if (map.containsKey(arr[j][i]))
                return 1;
            else
                map.put(arr[j][i], 0);
        }
        return 0;
    }

    public static void genMatrix(ArrayList<int[]> arrList, int time) {
        for (int[] arr : arrList) {
            int n = arr.length;
            int[][] re = new int[n][n];
            for (int i = 0; i < n; i++) {
                int val = arr[i];
                for (int j = 0; j < n; j++) {
                    int temp = (val + j) % n;
                    if (temp == 0)
                        temp = n;
                    re[i][(i + j) % n] = temp;
                }
            }

            int error = 0;
            for (int i = 0;i < n;i++) {
                error += checkCols(re,i,n);
                error += checkRows(re,i,n);
            }

            if (error ==0) {
                System.out.println("Case #" + time + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(re[i][j]);
                        if (j != n - 1)
                            System.out.print(" ");
                    }
                    System.out.println("");
                }
                return;
            }
        }
        System.out.println("Case #" + time + ": IMPOSSIBLE");
    }

    public static int[] computeSum(int n, int j, int k, int[] arr,ArrayList<int[]> results) {
        if (k == 0 && j == arr.length) {
            results.add(arr.clone());
        }
        if (j == arr.length)
            return arr;

        for (int i = 1; i <= n; i++) {
            arr[j] = i;
            computeSum(n,j + 1, k - i, arr, results);
        }
        return arr;
    }
}