import java.util.HashMap;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++){
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++){
                for (int k = 0; k < matrixSize; k++){
                    matrix[j][k] = sc.nextInt();
                }
            }
            int linesRepeated = 0;
            for (int j = 0; j < matrixSize; j++){
                HashMap<Integer,Integer> hs = new HashMap<>();
                for (int k = 0; k < matrixSize; k++){
                    hs.put(matrix[j][k], hs.getOrDefault(matrix[j][k],0) + 1);
                }
                boolean hasRepeated = false;
                for (int value : hs.values()){
                    if (value > 1) {
                        hasRepeated = true;
                        break;
                    }
                }
                if (hasRepeated){
                    linesRepeated ++;
                }
            }

            int colRepeated = 0;
            for (int j = 0; j < matrixSize; j++){
                HashMap<Integer,Integer> hs = new HashMap<>();
                for (int k = 0; k < matrixSize; k++){
                    hs.put(matrix[k][j], hs.getOrDefault(matrix[k][j],0) + 1);
                }
                boolean hasRepeated = false;
                for (int value : hs.values()){
                    if (value > 1) {
                        hasRepeated = true;
                        break;
                    }
                }
                if (hasRepeated){
                    colRepeated ++;
                }
            }
            int trace = 0;
            for(int j = 0; j < matrixSize; j++){
                trace += matrix[j][j];
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + linesRepeated + " " + colRepeated);
        }




    }
}