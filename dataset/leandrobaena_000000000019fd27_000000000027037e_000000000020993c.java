import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class a {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new BufferedReader(new FileReader("a.in")));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();
        int numCases = Integer.parseInt(line);

        for (int i = 0; i < numCases; i++) {
            int N = Integer.parseInt(in.nextLine());
            int[][] matrix =  new int[N][N];
            
            //Read matrix
            for (int j = 0; j < matrix.length; j++) {
                line = in.nextLine();
                String[] cells = line.split(" ");
                for (int k = 0; k < matrix.length; k++) {
                    matrix[j][k] = Integer.parseInt(cells[k]);
                }
            }
            
            int k = 0, r = 0, c = 0;
            //Calculate trace
            for (int j = 0; j < matrix.length; j++) {
                for (int l = 0; l < matrix.length; l++) {
                    if(j == l){
                        k += matrix[j][l];
                    }
                }
            }
            
            //Calculate rows
            for (int j = 0; j < matrix.length; j++) {
                boolean rowRepeated = false;
                for (int l = 0; l < matrix.length - 1 && !rowRepeated; l++) {
                    for (int m = l + 1; m < matrix.length; m++) {
                        if(matrix[j][l] == matrix[j][m]){
                            rowRepeated = true;
                            break;
                        }
                    }
                }
                if(rowRepeated){
                    r++;
                }
            }

            //Calculate cols
            for (int j = 0; j < matrix.length; j++) {
                boolean colRepeated = false;
                for (int l = 0; l < matrix.length - 1 && !colRepeated; l++) {
                    for (int m = l + 1; m < matrix.length; m++) {
                        if(matrix[l][j] == matrix[m][j]){
                            colRepeated = true;
                            break;
                        }
                    }
                }
                if(colRepeated){
                    c++;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}