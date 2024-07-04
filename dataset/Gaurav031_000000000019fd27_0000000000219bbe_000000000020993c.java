import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {


    static int n;
    static int[][] array;

    public static void main(String args[]) {

        try (Scanner scanner = new Scanner(System.in);) {
            int testCount = Integer.parseInt(scanner.nextLine());
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                n = Integer.parseInt(scanner.nextLine());
                array = new int[n][n];
                for (int i = 0; i < n; i++) {
                    String testString = scanner.nextLine();
                    String[] inputParam = testString.split(" ");
                    for (int j = 0; j < n; j++) {
                        array[i][j] = Integer.parseInt(inputParam[j]);
                    }
                }
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace = trace + array[i][i];
                }
                int repeatedRows = 0;
                for (int i = 0; i < n; i++) {
                    Set<Integer> set = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if(set.contains(array[i][j])) {
                            repeatedRows++;
                            break;
                        }
                        set.add(array[i][j]);
                    }
                }
                int repeatedCols = 0;
                for (int i = 0; i < n; i++) {
                    Set<Integer> set = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if(set.contains(array[j][i])) {
                            repeatedCols++;
                            break;
                        }
                        set.add(array[j][i]);
                    }
                }
                System.out.println("Case #"+testNumber+":" + " " + trace + " " + repeatedRows + " " + repeatedCols);
            }
        }
    }
}
