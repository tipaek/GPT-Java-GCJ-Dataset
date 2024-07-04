import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static int[][] matrix;

    static int X;
    static int Y;
    static String M;
    static int MLength;
    static int minSteps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            X = scanner.nextInt();
            Y = scanner.nextInt();
            minSteps=-1;
            if(X==0 && Y==0){
                System.out.println("Case #" + (i + 1) + ": " + minSteps);
                continue;
            }
            M = scanner.next();
            MLength = M.length();
            matrix = new int[Y + 2 * MLength][X + 2 * MLength];

            updateMatrixWithMyChoices();

            updateMatrixWithCat();

            if ((minSteps == -1))
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + (i + 1) + ": " + minSteps);


        }
    }

    private static void updateMatrixWithCat() {
        int catY = MLength;
        int catX = MLength + X;
        for (int i = 0; i <= MLength; i++) {
            if (matrix[catY][catX] <= 0 && i >= Math.abs(matrix[catY][catX])) {
                matrix[catY][catX] = i;
                if (minSteps == -1)
                    minSteps = i;
                else
                    minSteps = Math.min(minSteps, i);
            }

            if(i<MLength) {
                char c = M.charAt(i);
                if (c == 'N')
                    catY--;
                else if (c == 'S')
                    catY++;
                else if (c == 'E')
                    catX++;
                else if (c == 'W')
                    catX--;
            }
        }
    }

    private static void updateMatrixWithMyChoices() {

        for(int i=0 ; i < Y + 2*MLength;i++){
            for(int j=0 ; j < X + 2*MLength;j++){
                matrix[i][j] = -(Math.abs(i-MLength-Y)+Math.abs(j-MLength));
            }
        }

    }
}
