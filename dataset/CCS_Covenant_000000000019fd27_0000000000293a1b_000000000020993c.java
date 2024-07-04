import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Input = sc.nextInt();
        for (int i = 0;i<Input;i++){
           int[] Output = output(sc);
           System.out.println("Case #"+i+1+": "+Output[0]+" "+Output[1]+" "+Output[2]);

        }
    }
    public static int[] output(Scanner sc){
        int N = sc.nextInt();
        int R = 0;
        int C = 0;
        int S = (N+1)/2*N;
        int[][] Matrix = new int[N][N];
            for (int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    Matrix[i][j] = sc.nextInt();
                }
            }
        int[] Output = {R(Matrix,S),C(Matrix,S),D(Matrix)};
        return Output;
    }

    public static int R(int[][] M,int S){
        int C = 0;
        int Sum = 0;
        for (int i=0;i<M.length;i++){
            for(int j=0;j<M.length;j++){
                Sum += M[i][j];
            }
            if (Sum!=S){
                C++;
            }
            Sum = 0;
        }
        return C;
    }
    public static int C(int[][] M,int S){
        int C = 0;
        int Sum = 0;
        for (int i=0;i<M.length;i++){
            for(int j=0;j<M.length;j++){
                Sum += M[j][i];
            }
            if (Sum!=S){
                C++;
            }
            Sum = 0;
        }
        return C;
    }
    public static int D(int[][] M){
        int Sum = 0;
        for(int i = 0;i<M.length;i++){
            Sum += M[i][i];
        }
        return Sum;
    }

}
