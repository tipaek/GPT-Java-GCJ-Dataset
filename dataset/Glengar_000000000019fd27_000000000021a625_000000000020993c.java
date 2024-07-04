import java.util.HashSet;
import java.util.Scanner;
import java.lang.StringBuffer;
import java.util.Set;

public class Solution {

    public static void main(String [] args){
        Solution c = new Solution();

        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        int move = 1;
        int counter = 1;
        for(int i=0; i<testCases; i++){
            int N = scan.nextInt();
            int [][] matrix =  new int[N][N];
            for(int row = 0; row<N; row++){
                for(int col = 0; col<N; col++)
                    matrix[row][col] = scan.nextInt();
            }
            c.latinSquare(N, matrix, counter++);
            if(i < testCases-1)
                System.out.println();
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
        System.out.print("Case #" + counter + ": " + trace + " " + rowCount + " " + Math.min(colCount, N));
    }

    public static void balanceNumbers(String num){
        StringBuffer str = new StringBuffer();
        int seen = 0;
        for(int i =0; i<num.length(); i++){
            int val = Integer.parseInt(Character.toString(num.charAt(i)));
            if(val > seen) {
                for (int j = seen; j < val; j++) {
                    str.append("(");
                }
                str.append(val);
            }
            else if(val == seen) {
                str.append(val);
            }
        }
    }
}
