package vestigium;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            for(int ny=0; ny<N; ++ny){
                for(int nx=0; nx<N; ++nx){
                    arr[nx][ny] = in.nextInt();
                }
            }
            solution(arr, t);
        }

        in.close();
    }

    public static void printMatrix(int[][] m, int pp){
        for(int x=0; x < m.length; x++){
            System.out.print("\n");
            for(int y=0; y<m[0].length; y++){
                System.out.print(m[x][y] + ",");
            }
        }
    }

    public static void solution(int[][] m, int n){
        int k=0; // diagonal summation
        int r=0, c=0; // repeat counts for each x, y
        int size = m.length;
        for(int x=0; x<size; x++){
            HashSet s = new HashSet<Integer>();
            for(int y=0; y<size; y++){
                int num = m[x][y];
                s.add(num);
                if(x==y){
                    k+=num;
                }
            }
            if(s.size() < size){
                r++;
            }
        }
        for(int x=0; x<size; x++){
            HashSet s = new HashSet<Integer>();
            for(int y=0; y<size; y++){
                int num = m[y][x];
                s.add(num);
            }
            if(s.size() < size){
                c++;
            }
        }
        System.out.println(String.format("Case #%d: %d %d %d", n+1, k, c, r));
    }
}