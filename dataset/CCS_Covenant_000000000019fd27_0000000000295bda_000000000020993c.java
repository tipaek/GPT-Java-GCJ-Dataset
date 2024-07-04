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
    public  int[] output(Scanner sc){
        int N = sc.nextInt();
        int R = 0;
        int C = 0;
        int[][] Matrix = new int[N][N];
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Matrix[i][j] = sc.nextInt();
            }
        }
        int[] Output = {R(Matrix),C(Matrix),D(Matrix)};
        return Output;
    }

    public  int R(int[][] M){
        int C = 0;
        boolean T = false;
        for (int i=0;i<M.length;i++){
            for(int j=0;j<M.length;j++){
                for(int z=0;j<M.length;j++) {
                    if (M[j][i] == M[z][i]&&j!=z) {
                        T = true;
                    }
                }
            }
            if (T){
                C++;
            }
            T = false;
        }
        return C;
    }
    public  int C(int[][] M){
        int C = 0;
        boolean T = false;
        for (int i=0;i<M.length;i++){
            for(int j=0;j<M.length-1;j++){
                for(int z=0;j<M.length;j++) {
                    if (M[i][j] == M[i][z]&&j!=z) {
                        T = true;
                    }
                }
            }
            if (T){
                C++;
            }
            T = false;
        }
        return C;
    }
    public  int D(int[][] M){
        int Sum = 0;
        for(int i = 0;i<M.length;i++){
            Sum += M[i][i];
        }
        return Sum;
    }

}
