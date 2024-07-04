 import java.util .*;
    import java.io .*;

    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            //number of test cases
            int t = in.nextInt(); 
            for(int i = 1; i <= t; i++){
                int n = in.nextInt();
                int trace = in.nextInt();
                int[][] latin = new int[n][n];
                for(int j = 0; j < n; j++){
                    for(int z = 0; z < n; z++){
                        latin[j][z] = (n - j + z) % n + 1;
                    }
                }
                int numRotate = isPossible(trace, n, latin);
                if(numRotate == -1){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
                else{
                    System.out.println("Case #" + i + ": POSSIBLE");
                    printArr(latin);
                }
            }
        }
        
        public static int isPossible(int trace, int n, int[][] matrix){
            for(int i = 0; i < n; i++){
                if(findTrace(matrix) == trace){
                    return i;
                }
                rotate(matrix);
            }
            return -1;
        }
        
        public static void rotate(int[][] matrix){
            for(int i = 0; i < matrix.length; i++){
                int temp = matrix[i][matrix.length - 1];
                for(int j = matrix.length - 1; j > 0; j--){
                    matrix[i][j] = matrix[i][j - 1];
                }
                matrix[i][0] = temp;
            }
        }
        
        public static int findTrace(int [][] matrix){
            int sum = 0;
            for(int i = 0; i < matrix.length; i++){
                sum += matrix[i][i];
            }
            return sum;
        }
        
        public static void printArr(int [][] matrix){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
        