import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++){
            LatinSquare2(i+1);
        }
    }

    private static void LatinSquare(int x) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int k=0, r=0, c=0;
        int[][] matrix = new int[N+1][N+1];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                matrix[i][j]=scan.nextInt();
            }
            matrix[i][N]=0;
            matrix[N][i]=0;
        }

        for(int index = 0; index<N; index++){


            int slowC = matrix[index][0];
            int fastC = matrix[index][slowC];

            int slowR = matrix[0][index];
            int fastR = matrix[slowR][index];

            while(fastC != slowC) {
                slowC = matrix[index][slowC];
                fastC = matrix[index][matrix[index][fastC]];
            }
            while(fastR != slowR) {
                slowR = matrix[slowR][index];
                fastR = matrix[matrix[fastR][index]][index];
            }

            int addC = 0;
            int addR = 0;
            fastC = fastR = 0;
            for(int i=0; i<=N; i++){

                if(slowC != fastC)
                {
                    slowC = matrix[index][slowC];
                    fastC = matrix[index][fastC];
                }
                else{
                    addC=1;
                }
                if(slowR != fastR)
                {
                    slowR = matrix[slowR][index];
                    fastR = matrix[fastR][index];
                }
                else{
                    addR=1;
                }
                if (addC+addR==2)
                    break;
            }
            k+=matrix[index][index];
            r+=addR;
            c+=addC;
        }
        System.out.println("Case #"+x+": "+k+" "+r+" "+c);
    }

    private static void LatinSquare2(int x) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int k=0, r=0, c=0;
        int[][] matrix = new int[N+1][N+1];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                matrix[i][j]=scan.nextInt();
            }
        }
        for(int index = 0; index<N; index++) {
            HashSet<Integer> hsC = new HashSet<>();
            HashSet<Integer> hsR = new HashSet<>();
            int addC = 0;
            int addR = 0;
            for(int i=0; i<N; i++){
                if(hsR.contains(matrix[index][i])){
                    addR=1;
                }
                else{
                    hsR.add(matrix[index][i]);
                }
                if(hsC.contains(matrix[i][index])){
                    addC=1;
                }
                else{
                    hsC.add(matrix[i][index]);
                }
            }
            k+=matrix[index][index];
            r+=addR;
            c+=addC;
        }
        System.out.println("Case #"+x+": "+k+" "+r+" "+c);
    }
}
