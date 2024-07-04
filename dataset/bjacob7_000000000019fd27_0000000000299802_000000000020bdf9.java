import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        outer:
        for(int i = 0; i < n; i++) {
            int size = in.nextInt();
            int[][] grid = new int[size][2];
            for(int k = 0; k < size; k++) {
                grid[k][0] = in.nextInt();
                grid[k][1] = in.nextInt();
            }
            sort(grid);
            int c_end = -1;
            int j_end = -1;
            String ret = "";
            for(int k = 0; k < size; k++) {
                if(grid[k][0] >= c_end) {
                    c_end = grid[i][1];
                    ret += "C";
                } else if(grid[k][0] >= j_end) {
                    j_end = grid[i][1];
                    ret += "J";
                } else {
                    System.out.println("IMPOSSIBLE");
                    continue outer;
                }
            }
            System.out.println(ret);
        }
    }

    public static void sort(int arr[][])  {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1,
                               final int[] entry2) {
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });
    }
}
