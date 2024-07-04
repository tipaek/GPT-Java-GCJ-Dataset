/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author alanl
 */
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static ArrayList<edge>path = new ArrayList<>();
    static boolean flag = false, vis[][];
    static int n;
    static long[][]pascals;
    public static void main(String[] args) throws IOException{
        int t = readInt(), cur = 2;
        pascals = new long[1005][1005];
        pascals[0][0] = 1;
        for(int i = 1; i<1005; i++){
            pascals[i][0] = 1;
            pascals[i][cur-1] = 1;
            for(int j = 1; j<cur-1; j++){
                pascals[i][j] = pascals[i-1][j-1]+pascals[i-1][j];
            }
            cur++;
        }
        for(int z = 1; z<=t; z++){
            System.out.println("Case #"+z+": ");
            flag = false;
            n = readInt();
            vis = new boolean[1005][1005];
            path.clear();
            dfs(0, 0, 1);
        }
    }
    static void dfs(int x, int y, long sum){
        if(flag)return;
        vis[x][y] = true;
        path.add(new edge(x, y));
        if(sum==n&&path.size()<=500&&!flag){
            flag = true;
            for(int i = 0; i<path.size(); i++){
                System.out.println((path.get(i).x+1)+" "+(path.get(i).y+1));
            }
            return;
        }
        if(y+1<1000&&!vis[x][y+1])dfs(x, y+1, sum+pascals[x+1][y+1]);
        if(flag)return;
        if(x+1<1000&&pascals[x+1][y]!=0&&!vis[x+1][y])dfs(x+1, y, sum+pascals[x+1][y]);
        if(flag)return;
        if(x+1<1000&&y+1<1000&&!vis[x+1][y+1])dfs(x+1, y+1, sum+pascals[x+1][y+1]);
        if(flag)return;
        if(n!=501){
            if(x-1>=0&&!vis[x-1][y])dfs(x-1, y, sum+pascals[x-1][y]);
            if(flag)return;
            if(x-1>=0&&y-1>=1&&!vis[x-1][y-1])dfs(x-1, y-1, sum+pascals[x-1][y]);
            if(flag)return;
            if(y-1>=0&&pascals[x][y-1]!=0&&!vis[x][y-1])dfs(x, y-1, sum+pascals[x][y-1]);
            if(flag)return;
        }
        path.remove(path.size()-1);
    }
    static class edge{
        int x, y;
        edge(int x0, int y0){
            x = x0; 
            y = y0;
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(input.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readChar () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return input.readLine().trim();
    }
    //System.out.println(Arrays.toString(e.getStackTrace()));
}

