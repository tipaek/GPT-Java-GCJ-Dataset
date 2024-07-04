import java.util.Scanner;
import java.util.InputMismatchException;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quizNumber = sc.nextInt(); // quiz number
        //System.out.println(number);
        for(int i=0;i<quizNumber;i++){
            int matrixSize = sc.nextInt();
            //System.out.println("matrixSize:" + matrixSize);
            int[][] matrix = new int[matrixSize][matrixSize];
            for(int j=0;j<matrixSize;j++){
                for(int k=0;k<matrixSize;k++){
                    matrix[j][k] = sc.nextInt();
                }                
            }
            int current = 0;
            int trace = 0;
            int maxR = 0;
            int maxC = 0;
            int rCount = 0;
            int cCount = 0;
            int[] r = new int[matrixSize];
            int[] c = new int[matrixSize];
            for(int j=0;j<matrixSize;j++){
                for(int k=0;k<matrixSize;k++){
                    //System.out.print("matrix["+j + "]["+ k + "] " + matrix[j][k] + ",");
                    if(j == k){
                        //System.out.println("j"+ j);
                        trace += matrix[j][k];
                    }
                    //
                    current =  matrix[j][k];
                    r[current-1]++;
                    current = matrix[k][j];
                    c[current-1]++;
                    //
                }
                boolean rMulti = false;
                boolean cMulti = false;
                for(int m=0;m<matrixSize;m++){
                    if(r[m]>=2){
                        rMulti = true;
                    }
                    if(c[m]>=2){
                        cMulti = true;
                    }
                }
                if(rMulti == true){
                    rCount++;
                }
                if(cMulti == true){
                    cCount++;
                }                
                for(int m=0;m<matrixSize;m++){
                    r[m]=0;c[m]=0;
                }
                
            }
            //c
            System.out.println("Case #"+ (i+1) + ": " + trace + " " + rCount + " " + cCount);

        }
    }
}

