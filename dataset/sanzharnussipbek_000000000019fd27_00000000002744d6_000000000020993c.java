import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;



public class Vestigium {
    public static void main(String[] args){
        new Vestigium().runApp(args);
    }

    private void runApp(String[] args){
        Scanner in = new Scanner(System.in);
        int caseNum = Integer.parseInt(in.nextLine());
        int[][] output = new int[caseNum][3];
        for(int i = 0; i < caseNum; i++){
            int size = in.nextInt();
            String dummy = in.nextLine();
            int[][] matrix = new int[size][size];
            int trace = 0;

            for(int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = in.nextInt();
                    if(r == c)
                        trace += matrix[r][c];
                }
                dummy = in.nextLine();
            }

            int[] duplNum = getDupl(matrix);
            output[i][0] = trace;
            output[i][1] = duplNum[0];
            output[i][2] = duplNum[1];
        }

        output(output);
    }

    private int[] getDupl(int[][]matrix){
        int duplRow = 0, duplCol = 0, size = matrix.length;
        for(int r = 0; r < size; r++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int c = 0; c < size; c++) {
                if(map.get(matrix[r][c]) != null) {
                    duplRow++;
                    break;
                }
                else
                    map.put(matrix[r][c], 1);
            }
        }

        for(int c = 0; c < size; c++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int r = 0; r < size; r++) {
                if (map.get(matrix[r][c]) != null){
                    duplCol++;
                    break;
                }
                else
                    map.put(matrix[r][c], 1);
            }
        }
        int[] duplNum = new int[]{duplRow, duplCol};
        return  duplNum;
    }


    private void output(int[][] output){
        for(int i = 0; i < output.length; i++){
            System.out.print("Case #" + (i+1));
            for(int j = 0; j < output[i].length; j++){
                System.out.print(" " + output[i][j]);
            }
            System.out.println();
        }
    }
}