import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = Integer.parseInt(in.nextLine());
        outer:
        for(int i = 0; i < n; i++) {
            int size = Integer.parseInt(in.nextLine());
            int[][] grid = new int[size][2];
            for(int k = 0; k < size; k++) {
                String[] split = in.nextLine().split(" ");
                grid[k][0] = Integer.parseInt(split[0]);
                grid[k][1] = Integer.parseInt(split[1]);
            }
            sort(grid);
            int c_end = -1;
            int j_end = -1;
            String ret = "";
            for(int k = 0; k < size; k++) {
                if(grid[k][0] >= c_end) {
                    c_end = grid[k][1];
                    ret += "C";
                } else if(grid[k][0] >= j_end) {
                    j_end = grid[k][1];
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
