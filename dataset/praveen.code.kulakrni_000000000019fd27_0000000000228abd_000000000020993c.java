import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1 ; t <= T ; t++){
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    M[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(i == j)
                        trace += M[i][j];
                }
            }
            int repeatedRowCount = 0;
            for(int i = 0 ; i < N ; i++){
                Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
                for(int j = 0 ; j < N ; j++){
                    if(map.containsKey(M[i][j])){
                        repeatedRowCount++;
                        break;
                    }
                    map.put(M[i][j], true);
                }
            }
            int repeatedColCount = 0;
            for(int col = 0 ; col < N ; col++){
                Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
                for(int row = 0 ; row < N ; row++){
                    if(map.containsKey(M[row][col])){
                        repeatedColCount++;
                        break;
                    }
                    map.put(M[row][col], true);
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + repeatedRowCount + " " + repeatedColCount);
        }
    }
}