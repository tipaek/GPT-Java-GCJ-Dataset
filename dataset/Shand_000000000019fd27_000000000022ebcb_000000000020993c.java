import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int tests;
        Scanner s = new Scanner(System.in);
        tests = s.nextInt();
        s.nextLine();
        for(int i =0;i<tests;i++) {
            int n = s.nextInt();
            int trace = 0,rows=0,columns=0;
            s.nextLine();
            int[][] matrix = new int[n][n];
            for(int j=0;j<n;j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = s.nextInt();
                    if(j==k) trace+=matrix[j][k];
                }
            }

            for(int r=0;r<n;r++) {
                int[] numbers = new int[n];
                for(int j=0;j<n;j++) {
                    if(numbers[matrix[r][j]-1]==1) {
                        rows++;
                        break;
                    }
                    numbers[matrix[r][j]-1]=1;
                }
            }

            for(int c=0;c<n;c++) {
                int[] numbers = new int[n];
                for(int j=0;j<n;j++) {
                    if(numbers[matrix[j][c]-1]==1) {
                        columns++;
                        break;
                    }
                    numbers[matrix[j][c]-1]=1;
                }
            }

            System.out.println("Case #"+(i+1)+": "+trace+" "+rows+" "+columns);
        }
    }
}
