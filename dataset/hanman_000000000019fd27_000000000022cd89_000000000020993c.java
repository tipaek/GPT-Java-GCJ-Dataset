import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int i = 0; i < T; i++){
            int N = s.nextInt();
            int[][] matrix = new int[N][N];
            Set<Integer> setR = new HashSet<Integer>();
            Set<Integer> setC = new HashSet<Integer>();
            int k = 0, c= 0, r= 0;


            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    matrix[x][y] = s.nextInt();
                    if(x == y){
                        k+=matrix[x][y];
                    }
                    setR.add(matrix[x][y]);
                }
                if(setR.size()<N){
                    r++;
                }
                setR.clear();
            }

            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    setC.add(matrix[y][x]);
                }
                if(setC.size()<N){
                    c++;
                }
                setC.clear();
            }
            System.out.println("Case #" + (i+1) + ": " + k + " " + r + " " + c);
        }
    }
}