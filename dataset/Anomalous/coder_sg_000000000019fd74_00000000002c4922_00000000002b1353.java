import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pair {
    int r, c;
    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {

    private static int[][] pascalTriangle;
    private static ArrayList<Pair> ans;
    private static boolean found;

    private static void generatePascalTriangle(int n) {
        pascalTriangle = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                if (row == col || col == 0) {
                    pascalTriangle[row][col] = 1;
                } else {
                    pascalTriangle[row][col] = pascalTriangle[row - 1][col - 1] + pascalTriangle[row - 1][col];
                }
            }
        }
    }

    private static void findPascalWalk(int sum, Pair currentCell, ArrayList<Pair> currentWalk, int targetSum) {
        if (sum == targetSum) {
            ans = new ArrayList<>();
            for (Pair cell : currentWalk) {
                ans.add(new Pair(cell.r + 1, cell.c + 1));
            }
            found = true;
            return;
        }

        if (currentWalk.size() == 500) return;

        int currR = currentCell.r;
        int currC = currentCell.c;

        int[][] directions = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
        for (int[] dir : directions) {
            int newR = currR + dir[0];
            int newC = currC + dir[1];
            if (newR >= 0 && newR < targetSum && newC >= 0 && newC < targetSum && pascalTriangle[newR][newC] > 0) {
                int temp = pascalTriangle[newR][newC];
                pascalTriangle[newR][newC] = -1;
                Pair newCell = new Pair(newR, newC);
                currentWalk.add(newCell);
                findPascalWalk(sum + temp, newCell, currentWalk, targetSum);
                if (found) return;
                currentWalk.remove(currentWalk.size() - 1);
                pascalTriangle[newR][newC] = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            generatePascalTriangle(n);
            found = false;
            ArrayList<Pair> walk = new ArrayList<>();
            Pair start = new Pair(0, 0);
            pascalTriangle[0][0] = -1;
            walk.add(start);
            findPascalWalk(1, start, walk, n);
            System.out.println("Case #" + (i + 1) + ":");
            for (Pair cell : ans) {
                System.out.println(cell.r + " " + cell.c);
            }
        }
    }
}