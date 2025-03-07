import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String [] args){
        Solution c = new Solution();
        System.out.println(args[0]);
        String input = args[0];
        String [] list = input.split("\n");
        int move = 1;
        int counter = 1;
        for(int i=0; i<Integer.parseInt(list[0]); i++){
            int N = Integer.parseInt(list[move++]);
            int [][] matrix =  new int[N][N];
            int row = 0;
            for(int j = move + N; move < j; move++){
                String[] numList = list[move].split(" ");
                for(int k=0; k<N; k++)
                    matrix[row][k] = Integer.parseInt(numList[k]);
                row++;
            }
            c.latinSquare(N, matrix, counter++);
        }

        //latinSquare(3, m, 1);
    }
    public void latinSquare(int N, int[][] matrix, int counter){
        Set<Integer> rStore;
        int [][] store = new int[N][N];
        int colCount = 0, rowCount = 0;
        int trace = 0;
        for(int row=0; row<N; row++){
            boolean r= true;
            rStore = new HashSet();
            for(int col=0; col<N; col++){
                int val = matrix[row][col];

                if(r) {
                    if (!rStore.add(val)) {
                        rowCount++;
                        r = false;
                    }
                }

                if(store[val-1][col] != 0){
                    colCount++;
                }
                else{
                    store[val-1][col] = val;
                }

                if(row == col)
                    trace += val;

            }

        }
        System.out.println("Case #" + counter + ": " + trace + " " + rowCount + " " + Math.min(colCount, N));
    }
}
