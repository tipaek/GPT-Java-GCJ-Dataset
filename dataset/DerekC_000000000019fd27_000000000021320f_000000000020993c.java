import java.util.*;
import java.io.*;

class Solution {

    public static String vestigium(int[][] arr, int N) {
        int sum = N*(N-1)/2+N;
        int k = 0;
        int[] cols = new int[N];
        int r = 0;
        int c = 0;
        for(int i = 0; i < N; i++) {
            boolean[] row = new boolean[N];
            boolean rowRepeat = false;
            for(int j = 0; j < N; j++) {
                if(row[arr[i][j]-1] == true) rowRepeat = true;
                row[arr[i][j]-1] = true;

                if(i == j) {
                    k += arr[i][j];
                }
            }
            boolean colRepeat = false;
            boolean[] col = new boolean[N];
            for(int j = 0; j < N; j++) {
                if(col[arr[j][i]-1] == true) colRepeat = true;
                col[arr[j][i]-1] = true;
            }
            if(colRepeat) c++;
        }

        return k + " " + r + " " + c;
    }
    public static void main(String[] args) throws Exception {
        // File file = new File("./input.txt");
        // Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); //# of testcases

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int arr[][] = new int[N][N];

            for(int j = 0; j < N; j++) {
                int arr2[] = new int[N];
                for(int k = 0; k < N; k++) {
                    arr2[k] = in.nextInt();
                }
                arr[j] = arr2;
            }

            System.out.println("Case #" + i + ": " + vestigium(arr, N));
        }
        in.close();
    }
}