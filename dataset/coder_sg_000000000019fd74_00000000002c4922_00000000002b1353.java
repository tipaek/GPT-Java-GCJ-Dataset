import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pair {
    int r;
    int c;
    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}    

class Solution {

    public static int[][] pascalTriangle;
    public static ArrayList<Pair> ans;
    public static boolean flag;

    public static void generatePascalTriangle(int n) {
        pascalTriangle = new int[n][n];
        for (int row = 0; row < n; row++) { 
            for (int col = 0; col <= row; col++) { 
            if (row == col || col == 0) 
                pascalTriangle[row][col] = 1; 
            else
                pascalTriangle[row][col] = pascalTriangle[row-1][col-1] + pascalTriangle[row-1][col]; 
            } 
        } 
    }

    public static void findPascalWalk(int sum, Pair currentCell, ArrayList<Pair> cuurentWalk, int n) {
        if(sum == n) {
            ans = new ArrayList<>();
            for(int p = 0; p < cuurentWalk.size(); p++) {
                Pair cell = cuurentWalk.get(p);
                ans.add(new Pair(cell.r+1, cell.c+1));
            }
            flag = true;
            return;
        }

        if(cuurentWalk.size() == 500)
            return;

        int currR = currentCell.r;
        int currC = currentCell.c;

        //neighbour 1
        if(currR - 1 >= 0 && currC - 1 >= 0) {
            int newR = currR - 1;
            int newC = currC - 1;
            if(pascalTriangle[newR][newC] != 0 && pascalTriangle[newR][newC] != -1) {
                int temp = pascalTriangle[newR][newC];
                pascalTriangle[newR][newC] = -1;
                Pair newCell = new Pair(newR, newC);
                cuurentWalk.add(newCell);
                findPascalWalk(sum + temp, newCell, cuurentWalk, n);
                if(flag)
                    return;
                cuurentWalk.remove(cuurentWalk.size()-1);
                pascalTriangle[newR][newC] = temp;
            }
        }
        //neighbour 2
        if(currR - 1 >= 0) {
            int newR = currR - 1;
            int newC = currC;
            if(pascalTriangle[newR][newC] != 0 && pascalTriangle[newR][newC] != -1) {
                int temp = pascalTriangle[newR][newC];
                pascalTriangle[newR][newC] = -1;
                Pair newCell = new Pair(newR, newC);
                cuurentWalk.add(newCell);
                findPascalWalk(sum + temp, newCell, cuurentWalk, n);
                if(flag)
                    return;
                cuurentWalk.remove(cuurentWalk.size()-1);
                pascalTriangle[newR][newC] = temp;
            }
        }
        //neighbour 3
        if(currC - 1 >= 0) {
            int newR = currR;
            int newC = currC - 1;
            if(pascalTriangle[newR][newC] != 0 && pascalTriangle[newR][newC] != -1) {
                int temp = pascalTriangle[newR][newC];
                pascalTriangle[newR][newC] = -1;
                Pair newCell = new Pair(newR, newC);
                cuurentWalk.add(newCell);
                findPascalWalk(sum + temp, newCell, cuurentWalk, n);
                if(flag)
                    return;
                cuurentWalk.remove(cuurentWalk.size()-1);
                pascalTriangle[newR][newC] = temp;
            }
        }
        //neighbour 4
        if(currC + 1 < n) {
            int newR = currR;
            int newC = currC + 1;
            if(pascalTriangle[newR][newC] != 0 && pascalTriangle[newR][newC] != -1) {
                int temp = pascalTriangle[newR][newC];
                pascalTriangle[newR][newC] = -1;
                Pair newCell = new Pair(newR, newC);
                cuurentWalk.add(newCell);
                findPascalWalk(sum + temp, newCell, cuurentWalk, n);
                if(flag)
                    return;
                cuurentWalk.remove(cuurentWalk.size()-1);
                pascalTriangle[newR][newC] = temp;
            }
        }
        //neighbour 5
        if(currR + 1 < n) {
            int newR = currR + 1;
            int newC = currC;
            if(pascalTriangle[newR][newC] != 0 && pascalTriangle[newR][newC] != -1) {
                int temp = pascalTriangle[newR][newC];
                pascalTriangle[newR][newC] = -1;
                Pair newCell = new Pair(newR, newC);
                cuurentWalk.add(newCell);
                findPascalWalk(sum + temp, newCell, cuurentWalk, n);
                if(flag)
                    return;
                cuurentWalk.remove(cuurentWalk.size()-1);
                pascalTriangle[newR][newC] = temp;
            }
        }
        //neighbour 6
        if(currR + 1 < n && currC + 1 < n) {
            int newR = currR + 1;
            int newC = currC + 1;
            if(pascalTriangle[newR][newC] != 0 && pascalTriangle[newR][newC] != -1) {
                int temp = pascalTriangle[newR][newC];
                pascalTriangle[newR][newC] = -1;
                Pair newCell = new Pair(newR, newC);
                cuurentWalk.add(newCell);
                findPascalWalk(sum + temp, newCell, cuurentWalk, n);
                if(flag)
                    return;
                cuurentWalk.remove(cuurentWalk.size()-1);
                pascalTriangle[newR][newC] = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            generatePascalTriangle(n);
            flag = false;
            ArrayList<Pair> walk = new ArrayList<>();
            Pair start = new Pair(0, 0);
            pascalTriangle[0][0] = -1;
            walk.add(start);
            findPascalWalk(1, start, walk, n);
            System.out.println("Case #"+(i+1)+":");
            for(int p = 0; p < ans.size(); p++) {
                Pair cell = ans.get(p);
                System.out.println(cell.r+" "+cell.c);
            }
        }
    } 
}
