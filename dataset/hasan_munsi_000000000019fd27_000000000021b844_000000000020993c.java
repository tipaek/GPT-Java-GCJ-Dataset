
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author HASAN
 */
public class Solution {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(b.readLine().trim());
        for(int i=0; i<tc; i++){
            int squareSize = Integer.parseInt(b.readLine().trim());
            int[][] matrix = new int[squareSize][squareSize];
            for(int j=0; j<squareSize; j++){
                String row = b.readLine();
                String[] values = row.split("\\s+");
                for(int k=0; k<squareSize; k++){
                    matrix[j][k] = Integer.parseInt(values[k]);
                }
            }
            System.out.println("Case #"+(i+1)+": "+processOutput(matrix,squareSize));
        }
    }
    
    public static String processOutput(int[][] matrix, int squareSize){
        int[][] fullMatrix = matrix;
        int size = squareSize;
        String diagonal = findDiagonal(fullMatrix, size);
        String rowRepeat = findRowRepeat(fullMatrix, size);
        String columnRepeat = findColumnRepeat(fullMatrix, size);

    return diagonal+" "+rowRepeat+" "+columnRepeat;
    }
    
    public static String findDiagonal(int[][] fullMatrix, int size){
        int diagonal = 0;
        for(int i=0; i<size;i++){
           diagonal += fullMatrix[i][i];
        }
    return String.valueOf(diagonal);
    }
    
    public static String findColumnRepeat(int[][] fullMatrix, int size){
        int columnRepeat = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size-1; j++){
                try{
                for(int k=j+1; k<size; k++){
                    if(fullMatrix[j][i]==fullMatrix[k][i])
                    {
                        columnRepeat++;
                        i++;
                        j=0;
                        k=j+1;
                    }
                }
                }catch(Exception e){}
            }
        }
    return String.valueOf(columnRepeat);
    }
    
    public static String findRowRepeat(int[][] fullMatrix, int size){
        int rowRepeat = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size-1;j++){
                try{
                for(int k=j+1;k<size;k++){
                    if(fullMatrix[i][j]==fullMatrix[i][k])
                    {
                        rowRepeat++;
                        i++;
                        j=0;
                        k=1;
                    }
                }
                }catch(Exception e){}
            }
        }
    return String.valueOf(rowRepeat);
    }
}
