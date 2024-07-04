import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String M = scanner.next();
            System.out.println("Case #"+t+": "+getAnswer(X,Y,M));
        }
    }

    public static void fillGrid(int value,int x,int y,String M,int[][] grid) {
        if (value > M.length()+5) return;
        if (x<0 || x>= grid.length || y <0 || y >= grid.length) return;
        if (grid[x][y] == -1) {
            grid[x][y] = value;
        } else {
            grid[x][y] = Math.min(value, grid[x][y]);
        }
        fillGrid(value+1,x+1,y,M,grid);
        fillGrid(value+1,x-1,y,M,grid);
        fillGrid(value+1,x,y +1,M,grid);
        fillGrid(value+1,x,y-1,M,grid);
    }

    public static String visit(int X,int Y,String M, int[][] grid) {
        int time = 0;
        int x = X+M.length();
        int y = Y+M.length();
        for (int i=0; i< M.length();i++) {
            switch (M.charAt(i)) {
                case 'S':
                    y = y-1;
                    time++;
                    break;
                case 'N':
                    y = y+1;
                    time++;
                    break;
                case 'E':
                    x = x+1;
                    time++;
                    break;
                case 'W':
                    x = x-1;
                    time++;
                    break;
            }
            if (x>= 0 && x < grid.length && y >=0 && y < grid.length && grid[x][y] <= time) return Integer.toString(time);
        }
        return "IMPOSSIBLE";
    }
    public static String getAnswer(int X, int Y,String M) {
        int[][] grid = new int[2*M.length()+1][2*M.length()+1];
        for (int[] a: grid) Arrays.fill(a,-1);
        fillGrid(0,M.length(),M.length(),M,grid);
        //for (int i=0; i < grid.length;i++) System.out.println(Arrays.toString(grid[i]));

        return visit(X,Y,M,grid);
    }
}
