import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int size = in.nextInt();
            int[][] grid = new int[size][size];
            in.nextLine();
            for(int j = 0; j < size; j++) {
                String[] split = in.nextLine().split(" ");
                for(int k = 0; k < size; k++)
                    grid[j][k] = Integer.parseInt(split[k]);
            }
            int rows = 0;
            int cols = 0;
            for(int j = 0; j < size; j++) {
                if(!checkCol(grid, size, j))
                    cols++;
                if(!checkRow(grid, size, j))
                    rows++;
            }
            int trace = trace(grid, size);
            int put = i + 1;
            System.out.println("Case #" + put + " " + trace + " " + rows + " " + cols);
        }
    }

    public static int trace(int[][] grid, int size) {
        int ret = 0;
        for(int i = 0; i < size; i++) {
            ret += grid[i][i];
        }
        return ret;
    }

    public static boolean checkCol(int[][] grid, int size, int col) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < size; i++) {
            set.add(grid[i][col]);
        }
        return set.size() == size;
    }

    public static boolean checkRow(int[][] grid, int size, int row) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < size; i++) {
            set.add(grid[row][i]);
        }
        return set.size() == size;
    }
}
