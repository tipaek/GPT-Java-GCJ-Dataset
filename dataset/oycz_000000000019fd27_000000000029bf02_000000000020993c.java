import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int i=0; i<k; ++i) {
            int size = in.nextInt();
            int[][] mat = new int[size][size];
            for(int a=0; a<size; ++a) {
                for(int b=0; b<size; ++b) {
                    mat[a][b] = in.nextInt();
                }
            }
            System.out.println(vestigium(i, mat));
        }
    }

    private static String vestigium(int cse, int[][] mat) {
        int[][] columns = new int[mat.length][101];
        int[][] rows = new int[mat.length][101];
        int k = 0, r = 0, c = 0;
        for(int i=0; i<mat.length; ++i) {
            for(int j=0; j<mat[0].length; ++j) {
                if(i == j) {
                    k += mat[i][j];
                }
                int n = mat[i][j];
                rows[i][mat[i][j]] += 1;
                columns[j][mat[i][j]] += 1;
            }
        }
        for(int col=0; col<columns.length; ++col) {
            for(int i=1; i<=100; ++i) {
                if(columns[col][i] > 1) {
                    ++c;
                    break;
                }
            }
        }
        for(int ro=0; ro<rows.length; ++ro) {
            for(int i=1; i<=100; ++i) {
                if(rows[ro][i] > 1) {
                    ++r;
                    break;
                }
            }
        }
        return "Case #" + cse + ": " + k + " " + r + " " + c;
    }
}
