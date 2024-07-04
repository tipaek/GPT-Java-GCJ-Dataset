import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCount; i++) {
            int trace = 0;
            int xErrCount = 0;
            int yErrCount = 0;
            int lineCount = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[lineCount][lineCount];
            Set<Integer> hashSet = new HashSet<>();
            for (int y = 0; y < lineCount; y++) {
                hashSet.clear();
                String[] numbers = sc.nextLine().split("\\s+");
                boolean xErr = false;
                for (int x = 0; x < lineCount; x++) {
                    int val = Integer.parseInt(numbers[x]);
                    matrix[x][y] = val;
                    if (!hashSet.add(val)) {
                        xErr = true;
                    }
                    if (y == x) {
                        trace += val;
                    }
                }
                if(xErr){
                    xErrCount++;
                }
            }

            for (int x = 0; x < lineCount; x++) {
                hashSet.clear();
                for (int y = 0; y < lineCount; y++) {
                    if (!hashSet.add(matrix[x][y])) {
                        yErrCount++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + xErrCount + " " + yErrCount);
        }
        sc.close();
    }

    
}
