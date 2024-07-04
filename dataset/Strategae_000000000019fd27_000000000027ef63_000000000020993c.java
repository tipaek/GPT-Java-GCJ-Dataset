import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++){
            LatinSquare2(i+1);
        }
    }

    public static void LatinSquare2(int x) {
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
