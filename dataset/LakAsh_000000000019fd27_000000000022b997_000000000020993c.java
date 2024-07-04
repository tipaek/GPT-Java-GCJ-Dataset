

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_Vestigium {
    private static String output1 = "Case #%d: %d %d %d";
    public static void main(String[] args) {
        try {
            System.out.println("Working Directory = " +  System.getProperty("user.dir"));

//            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution_Vestigium().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix= new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int k = 0  , r = 0 , c = 0;

        for (int i = 0 ; i < n ; i++) {
            k += matrix[i][i];
            Set<Integer> sets = new HashSet<>();
            for (int j = 0 ; j < n ; j++){
                if (sets.contains(matrix[i][j])) {
                    r++;
                    break;
                }
                sets.add(matrix[i][j]);
            }
            sets.clear();
            for (int j = 0 ; j < n ; j++){
                if (sets.contains(matrix[j][i])) {
                    c++;
                    break;
                }
                sets.add(matrix[j][i]);
            }
        }

        System.out.println(String.format(output1, caseNum, k, r, c));
    }

    public int getDiagonal(int[][] m, int n) {
        // do something
        return 0;
    }


}