import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc = 1; tc <= TC; tc++){
            //init for this test case
            int N = sc.nextInt();
            int matrix[][] = new int[N][N];
            int k = 0;
            int r = 0;
            int c = 0;
            //input
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            //calculate k
            for(int index = 0; index < N; index++){
                k += matrix[index][index];
            }
            //calculate r
            for(int row = 0; row < N; row++){
                ArrayList<Integer> line = new ArrayList<Integer>();
                for(int j = 0; j < N; j++){
                    if(line.contains(matrix[row][j])){
                        r++;
                        break;
                    }else{
                        line.add(matrix[row][j]);
                    }
                }
            }
            //calculate c
            for(int col = 0; col < N; col++){
                ArrayList<Integer> line = new ArrayList<Integer>();
                for(int i = 0; i < N; i++){
                    if(line.contains(matrix[i][col])){
                        c++;
                        break;
                    }else{
                        line.add(matrix[i][col]);
                    }
                }
            }
            //output
            System.out.println("Case #" + tc + ": " + k + " " + r + " " + c);
        }
    }
}