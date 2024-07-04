import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Vestigium {
//
//    static final String FILENAME = "Vestigium";
//    static final String IN = FILENAME + ".in";
//    static final String OUT = FILENAME + ".out";
//    static Scanner in = new Scanner(Vestigium.class.getResourceAsStream(IN));

    PrintStream out = System.out;
    Scanner     in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private void solve() {
        int sizeMatrix = in.nextInt();
        int i = 0;
        int total = sizeMatrix * sizeMatrix;
        int k = 0, r = 0, c = 0;
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        int[] statusColumn = new int[sizeMatrix];
        int currentIndexRow=-1;
        for (i = 0; i < total; i++) {
            int value = in.nextInt();
            int indexOfColumn = i % sizeMatrix;
            int indexOfRow = (i / sizeMatrix);
            if (indexOfColumn == indexOfRow) {
                k += value;
            }
            matrix[indexOfRow][indexOfColumn] = value;

            if(currentIndexRow != indexOfRow) { //row
                int x;
                for(x = 0; x < indexOfColumn; ++x) {
                    if(value == matrix[indexOfRow][x]) {
                        r +=1;
                        currentIndexRow = indexOfRow;
                        break;
                    }
                }
            }
            if(statusColumn[indexOfColumn] == 0) { //column
                int x;
                for(x = 0; x < indexOfRow; ++x) {
                    if(value == matrix[x][indexOfColumn]) {
                        c +=1;
                        statusColumn[indexOfColumn] = 1;
                        break;
                    }
                }
            }
        }

        out.println(k + " " + r + " " + c);
    }

    void run() {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {

        new Vestigium().run();
    }
}
