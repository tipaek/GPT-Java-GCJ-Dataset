import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        List<Matrix> listMatrix = new ArrayList<>();
        List<Long> heighOfMatrixs = new ArrayList<>();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrix = in.nextInt();
        in.nextLine();
        for(int i = 1; i <= numberOfMatrix; i++){
            Matrix matrix = new Matrix();
            int heighMatrix = in.nextInt();
            in.nextLine();
            matrix.setTamanioMatrix(heighMatrix);
            List<Long> col = new ArrayList<>();
            for(int k = 0; k < heighMatrix; k ++){
                List<Long> row = new ArrayList<>();
                String colString = in.nextLine();
                String[] colStringSplit = colString.split(" ");
                for(int j = 0; j < colStringSplit.length; j ++){
                    row.add(Long.parseLong(colStringSplit[j]));
                    if(k == 0){
                        matrix.getCol().put(j, new ArrayList<Long>());
                    }
                    matrix.getCol().get(j).add(Long.parseLong(colStringSplit[j]));
                }
                matrix.getRow().put(k, row);
            }
            listMatrix.add(matrix);
        }
        int cases = 0;
        for(Matrix matrix: listMatrix){
            int tamanio = matrix.getTamanioMatrix();
            int contador = 0;
            int numberTotal = 0;
            int numberColRepeat = 0;
            int numberRowRepeat = 0;

            for (int i = 0; i < tamanio; i++){
                //NumberTotal
                numberTotal += matrix.getRow().get(i).get(i).intValue();

                //Row
                List<Long> row = matrix.getRow().get(i);
                HashSet<Long> set = new HashSet<>();
                for(Long number: row){
                    if(set.add(number) == false){
                        numberRowRepeat += 1;
                        break;
                    }
                }

                //Col
                List<Long> col = matrix.getCol().get(i);
                HashSet setCol = new HashSet();
                for(Long number: col){
                    if(setCol.add(number) == false){
                        numberColRepeat += 1;
                        break;
                    }
                }
            }
            cases++;
            System.out.println("Case #" + cases + ": " + numberTotal + " " + numberRowRepeat + " " + numberColRepeat);
        }
    }
}
class Matrix {
    public int tamanioMatrix;
    public HashMap<Integer, List<Long>> col = new HashMap<Integer, List<Long>>();
    public HashMap<Integer, List<Long>> row = new HashMap<Integer, List<Long>>();

    public Matrix() {
    }

    public Matrix(int tamanioMatrix, HashMap<Integer, List<Long>> col, HashMap<Integer, List<Long>> row) {
        this.tamanioMatrix = tamanioMatrix;
        this.col = col;
        this.row = row;
    }

    public HashMap<Integer, List<Long>> getCol() {
        return col;
    }

    public void setCol(HashMap<Integer, List<Long>> col) {
        this.col = col;
    }

    public HashMap<Integer, List<Long>> getRow() {
        return row;
    }

    public void setRow(HashMap<Integer, List<Long>> row) {
        this.row = row;
    }

    public int getTamanioMatrix() {
        return tamanioMatrix;
    }

    public void setTamanioMatrix(int tamanioMatrix) {
        this.tamanioMatrix = tamanioMatrix;
    }



}


