import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CodeJam {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTest = s.nextInt();
        HashSet setR = new HashSet();
        HashSet setC = new HashSet();

        for(int i = 0; i < numTest; i++) {
            int rows = s.nextInt();
            int cols = rows;
            int trace = 0;
            int repeatR = 0, repeatC = 0;
            int[][]mat = new int[rows][cols];

            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < cols; c++) {
                    mat[r][c] = s.nextInt();
                }
            }

            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < cols; c++) {
                    setR.add(mat[r][c]);
                    if(r == c){
                        trace = trace + mat[r][c];
                    }
                }
                if(setR.size() != cols){
                    repeatR++;
                }
                setR.clear();
            }

            for(int c = 0; c < rows; c++) {
                for(int r = 0; r < cols; r++) {
                    setC.add(mat[r][c]);
                }
                if(setC.size() != rows){
                    repeatC++;
                }
                setC.clear();
            }

            System.out.println("Case #" + (i+1) +": "+trace+" "+repeatR+" "+repeatC);
            setC.clear();
            setR.clear();
        }
    }
}
