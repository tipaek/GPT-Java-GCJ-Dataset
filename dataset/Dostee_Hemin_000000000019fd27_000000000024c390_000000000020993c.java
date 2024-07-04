import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int cs=1; cs<=T; cs++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            int k = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    int val = input.nextInt();
                    matrix[i][j] = val;
                    if(i == j) {
                        k += val;
                    }
                }
            }

            int r = 0;
            for(int i=0; i<n; i++) {
                int[] foundNumbers = new int[n];
                for(int j=0; j<n; j++) {
                    int val = matrix[i][j];
                    foundNumbers[val - 1]++;
                    if(foundNumbers[val - 1] > 1) {
                        r++;
                        break;
                    }
                }
            }

            int c = 0;
            for(int j=0; j<n; j++) {
                int[] foundNumbers = new int[n];
                for(int i=0; i<n; i++) {
                    int val = matrix[i][j];
                    foundNumbers[val - 1]++;
                    if(foundNumbers[val - 1] > 1) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + cs + ": " + k + " " + r + " " + c);
        }
    }
}