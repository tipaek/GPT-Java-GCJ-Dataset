import java.util.Scanner;
import java.util.Arrays;
public class Solution{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());
        for(int run = 1; run <= runs; run++){
            int size = Integer.parseInt(console.nextLine());
            int[][] matrix = new int[size][size];
            for(int i = 0; i<size; i++){
                String line = console.nextLine() + " ";
                String num = "";
                int j = 0;
                for(int ch = 0; ch<line.length(); ch++){
                    if(line.substring(ch, ch+1).equals(" ")){
                        matrix[i][j] = Integer.parseInt(num);
                        j++;
                        num = "";
                    }
                    else{
                        num+=line.substring(ch, ch+1);
                    }
                }
            }
            int total = 0;
            for(int i = 0; i<matrix.length; i++){
                total += matrix[i][i];
            }
            System.out.print("Case #" + run + ": " + total + " ");
            int rows = 0;
            for(int i = 0; i<matrix.length; i++){
                int[] row = new int[matrix.length];
                for(int k = 0; k<matrix.length; k++){
                    row[k] = matrix[i][k];
                }
                Arrays.sort(row);
                boolean isWrong = false;
                for(int k = 0; k<row.length-1; k++){
                    if(row[k] == row[k+1]){
                        isWrong = true;
                    }
                }
                if(isWrong){
                    rows ++;
                }
            }
            System.out.print(rows + " ");
            int columns = 0;
            for(int i = 0; i<matrix[0].length; i++){
                int[] column = new int[matrix[0].length];
                for(int j = 0; j<column.length; j++) {
                    column[j] = matrix[j][i];
                }
                Arrays.sort(column);
                boolean isWrong = false;
                for(int k = 0; k<column.length-1; k++){
                    if(column[k] == column[k+1]){
                        isWrong = true;
                    }
                }
                if(isWrong){
                    columns ++;
                }
            }
            System.out.println(columns);
        }
    }
}